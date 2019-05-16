package com.soholy.dogmanager.controller.information;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.TInformation;
import com.soholy.dogmanager.entity.dogCard.Iinformation;
import com.soholy.dogmanager.pojo.Information.Information;
import com.soholy.dogmanager.service.information.InformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/biz/information")
public class InformationController {

	@Value("${pageSize}")
	private String pageSize;

	@Autowired
	private InformationService informationService;

	/**
	 * @Description:添加资讯
	 * @param iinformation
	 * @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/information/add")
	@RequestMapping(value = "/add")
	@ResponseBody
	public DogResult addInformation(@RequestBody Iinformation iinformation) {
		//获取infomation对象
		TInformation tInformation = JSON.parseObject(iinformation.getInformation(), TInformation.class);
		//
		List<Long> imageIdList = JSON.parseArray(iinformation.getImageIds(), Long.class);
		DogResult dogResult = informationService.addInformation(tInformation,imageIdList);
		return dogResult;
	}

	/**
	 * @Description:添加资讯
	 * @param information
	 * @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/information/save")
	@RequestMapping(value = "/save")
	@ResponseBody
	public DogResult save(@RequestBody TInformation information) {
		DogResult dogResult = informationService.addInformation(information,null);
		return dogResult;
	}

	/**
	 * @Description:查询资讯
	 * @param
	 * @return（展示方法参数和返回值）
	 */
	//@RequiresPermissions("/information/getInformation")
	@RequestMapping(value = "/getInformation", method = RequestMethod.POST)
	@ResponseBody
	public DogResult selectInformation(Long informationId) {
		Information information = informationService.selectInformation(informationId);
		return DogResult.ok(information);
	}

	/**
	 *  获取资讯列表
	 * @param TypeNumber [information_type] 资讯类型
	 *                   0政策法规
	 *                   1动态资讯
	 *                   2养犬宣传
	 *                   3服务指南
	 * @param status  0审核中，1上架，2下架
	 * @param pageNum  页码
	 * @param pageSize  页面大小
	 * @param query 关键字searchkey
	 * @param mark 审核状态 ：0待审核，1审核通过，2审核不通过
	 * @return（展示方法参数和返回值）
	 */
	//@RequiresPermissions("/information/getInformations")
	@RequestMapping(value = "/getInformations")
	@ResponseBody
	public DogResult getInformations(Integer TypeNumber, Integer status, Integer pageNum, Integer pageSize, String query, Integer mark, HttpServletRequest request) {
		try {
			if (pageNum == null) {
				pageNum = 1;
			};
			// 如果status为空，默认查询status = 1(发布中)
//			if (status == null) {
//				status = 1;
//			};
			if (pageSize == null) {
				pageSize = Integer.parseInt(this.pageSize);
			}
//			if (query != null) {
//				query = new String(request.getParameter("query").getBytes("ISO-8859-1"), "UTF-8");
//			}
			Page sqlpage = PageHelper.startPage(pageNum, pageSize);
			List<Information> informations = informationService.selectInformations(TypeNumber,status,query,mark);
			PageInfo<Information> pageInfo = new PageInfo<>(informations);
			pageInfo.setTotal(sqlpage.getTotal());
			return DogResult.ok(pageInfo);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}

	/**
	 * @Description:删除
	 * @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/information/delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DogResult deleteInformation(Long informationId) {
		return informationService.deleteInformation(informationId);
	}

	/**
	 * @Description:编辑资讯
	 * @param information
	 * @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/information/update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public DogResult updateInformation(TInformation information) {
		return informationService.updateInformation(information);
	}

	/**
	 * @Description:审核
	 * @param
	 * @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/information/examine")
	@RequestMapping(value = "/examine", method = RequestMethod.POST)
	@ResponseBody
	public DogResult examineInformation(Integer status, Long informationId,Long notifReceiverId,String infoTitile, String failReason) {
		try {
			if (status == 1) {
				DogResult dogResult = informationService.updateInformationForYes(informationId,notifReceiverId,infoTitile);
				return dogResult;
			} else {
				DogResult dogResult = informationService.updateInformationForNo(informationId,notifReceiverId, infoTitile, failReason);
				return dogResult;
			}
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}

	}

    /**
     *查资讯列表
     * @param type       资讯类型
     *                   0政策法规
     *                   1动态资讯
     *                   2养犬宣传
     *                   3服务指南
     * @param searchkey titile搜索
     * @param mark 0审核中，1上架，2下架
     * @param pageNum
     * @param pageSize
     * @return
     */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
	public String list(Integer type,
                         String searchkey,
                         Integer mark,
                         @RequestParam(defaultValue = "1") Integer pageNum,
                         @RequestParam(defaultValue = "50") Integer pageSize){

       return new GlobalResult().resultJSON(informationService.findList(type,searchkey,mark,pageNum,pageSize));
    }

    /**
     * 查看资讯详情
     * @param informationId
     * @return
     */
    @RequestMapping(value = "/detail/{informationId}",method = RequestMethod.GET)
    @ResponseBody
    public String viewInformation(@PathVariable long informationId){
        return new GlobalResult().objResultJSON(informationService.viewinformationbyid(informationId));
    }


}
