package com.soholy.dogmanager.controller.violation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soholy.dogmanager.common.result.GlobalResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.utils.JsonUtils;
import com.soholy.dogmanager.pojo.violation.DeviceDogVo;
import com.soholy.dogmanager.pojo.violation.DogInfo2VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish2VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish3VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish4VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunishVO;
import com.soholy.dogmanager.service.violation.PunishService;

/** 
* 
* 项目名称：dogmanager-web 
* 类名称：PunishController 
* 类描述： 执法处罚controller
* 创建人：YL
* 创建时间：2018年8月27日 上午10:12:19 
* 修改人：Administrator 
* 修改时间：2018年8月27日 上午10:12:19 
* 修改备注： 
* 
*/
@Controller
@RequestMapping("/biz/violationPunish")
public class PunishController {

	@Autowired
	private PunishService punishService;
	@Value("${SMS_BASE_URL}")
	private String SMS_BASE_URL;
	
	//违法登记
	@RequiresPermissions("/violationPunish/save")
	@RequestMapping("/save")
	@ResponseBody
	public DogResult saveViolationPunish(@RequestBody ViolationPunish2VO violationPunish2VO){
		try {
			DogResult dogResult = punishService.save(violationPunish2VO);
			return dogResult;
		} catch (Exception e) {
			return DogResult.build(400,"服务器异常，请稍后再试");
		}
	}


	//查列表
//	@RequiresPermissions("/violationPunish/findAll")
	@RequestMapping("/findAll")
	@ResponseBody
	public DogResult findAll(int pn,int pageSize,String string){
		try {
			if(!StringUtils.isEmpty(string)){
//				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
			}
			Page<ViolationPunish3VO> violationInfo3VOList = punishService.findAll(pn, pageSize, string);
			return DogResult.ok(violationInfo3VOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//查详情
	//@RequiresPermissions("/violationPunish/findOne")请教
	@RequestMapping("/findOne")
	@ResponseBody
	public DogResult findOne(Long violationId){
		try {
			ViolationPunish3VO violationPunish3VO = punishService.findOne(violationId);
			return DogResult.ok(violationPunish3VO);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//根据项圈编码查犬的相关详细
	@RequestMapping("/findDeviceDogVoByDeviceCode")
	@ResponseBody
	public DogResult findDeviceDogVoByDeviceCode(String deviceNumber){
		try {
			DeviceDogVo deviceDogVo = punishService.findDeviceDogVoByDeviceCode(deviceNumber);
			return DogResult.ok(deviceDogVo);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//根据犬id查历史违法记录
	//@RequiresPermissions("/violationPunish/findOne")请教
	@RequestMapping("/findViolationPunishListByDogId")
	@ResponseBody
	public DogResult findViolationPunishListByDogId(Long dogId){
		try {
			 List<ViolationPunishVO> ViolationPunishVOList = punishService.findViolationPunishListByDogId(dogId);
			return DogResult.ok(ViolationPunishVOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//根据犬主id查犬只最近扣分列表(犬主首页)
	@RequiresPermissions("/violationPunish/findCountListBydogOwnerId")
	@RequestMapping("/findCountListBydogOwnerId")
	@ResponseBody
	public DogResult findCountListBydogOwnerId(Long dogOwnerId){
		try {
			 List<ViolationPunish4VO> violationPunish4VOList = punishService.findViolationPunish4VOListBydogOwnerId(dogOwnerId);
			return DogResult.ok(violationPunish4VOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	
	//根据犬主id查年度扣分
	@RequiresPermissions("/violationPunish/findtotalCountBydogOwnerId")
	@RequestMapping("/findtotalCountBydogOwnerId")
	@ResponseBody
	public DogResult findtotalCountBydogOwnerId(Long dogOwnerId){
		try {
			List<DogInfo2VO> DogInfo2VOList = punishService.findtotalCountBydogOwnerId(dogOwnerId);
			return DogResult.ok(DogInfo2VOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	
	//处罚短信
	@RequestMapping("/sendMessage")
	@ResponseBody
	public DogResult sendMessage(String phone){
		String url=SMS_BASE_URL+"ViolationSMS";
		Map<String, Object> template_param = new HashMap<String, Object>();
		Map<String, Object> Map = new HashMap<>();
		Map.put("phone", phone);
		Map.put("template_param", JsonUtils.objectToJson(template_param));
		try {
			HttpClientUtil.executeHttpParams(url, "post", Map);
			return DogResult.ok();
		} catch (Exception e) {
			return DogResult.build(400, "发送失败");
		}
	}

	/**
	 * 违法行为列表
	 * @return
	 */
	@RequestMapping(value="/types",method = RequestMethod.GET)
	public @ResponseBody
	String types(){
		return new GlobalResult().successJSON( punishService.findTypes());
	}
	
}
