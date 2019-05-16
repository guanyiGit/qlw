package com.soholy.dogmanager.controller.violation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.utils.JsonUtils;
import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.entity.dogCard.Conditions;
import com.soholy.dogmanager.pojo.violation.AdoptionCollectionVO;
import com.soholy.dogmanager.pojo.violation.AdoptionVO;
import com.soholy.dogmanager.pojo.violation.PublishVO;
import com.soholy.dogmanager.service.dogCard.DogCardService;
import com.soholy.dogmanager.service.violation.AdoptionService;
import com.soholy.dogmanager.utils.shiro.GetClientIpAddress;


/** 
* 
* 项目名称：dogmanager-web 
* 类名称：AdoptionController 
* 类描述： 领养平台管理controller
* 创建人：YL
* 创建时间：2018年8月27日 上午10:53:27 
* 修改人：Administrator 
* 修改时间：2018年8月27日 上午10:53:27 
* 修改备注： 
* 
*/
@Controller
@RequestMapping("/biz/adoption")
public class AdoptionController {
	
	@Autowired
	private AdoptionService adoptionService;
	@Autowired
	private DogCardService dogCardService;
	
	@Value("${SEND_MESSAGE}")
	private String SEND_MESSAGE;
	
	//批量发布到领养平台
	@RequiresPermissions("/adoption/publishBatch")
	@RequestMapping("/publishBatch")
	@ResponseBody
	public DogResult saveAdoptionPublicityBatch(@RequestBody Long[] collectionIdList){
		try {
			DogResult result = adoptionService.saveAdoptionPublicityBatch(Arrays.asList(collectionIdList));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "添加失败");
		}
	}
	
	//查发布中列表
	@RequiresPermissions("/adoption/findPublishingList")
	@RequestMapping("/findPublishingList")
	@ResponseBody
	public DogResult findAdoptableList(int pn,int pageSize,String string){
		try {
			if(!StringUtils.isEmpty(string)){
//				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
			}
			Page<AdoptionCollectionVO> AdoptionCollectionVOList = adoptionService.findAdoptablList(pn, pageSize, string);
			return DogResult.ok(AdoptionCollectionVOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据失败");
		}
	}
	
	//查(申请中)已领养列表
//	@RequiresPermissions("/adoption/findAdoptabledList")
	@RequestMapping("/findAdoptabledList")
	@ResponseBody
	public DogResult findAdoptabledList(int pn,int pageSize,String string,int status, int type){
		try {
			if(!StringUtils.isEmpty(string)){
//				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
			}
			Page<AdoptionVO> adoptabledList = adoptionService.findAdoptabledList(pn, pageSize, string,status,type);
			return DogResult.ok(adoptabledList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据失败");
		}
	}
	
	//查询(申请中)已领养详情
	@RequiresPermissions("/adoption/findOne")
	@RequestMapping("/findOne")
	@ResponseBody
	public DogResult findOne(Long adoptionRecordId){
		try {
			AdoptionVO adoptionVO = adoptionService.findOne(adoptionRecordId);
			return DogResult.ok(adoptionVO);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据失败");
		}
	}
	
	//批量撤回到收容库
	@RequiresPermissions("/adoption/revocation")
	@RequestMapping("/revocation")
	@ResponseBody
	public DogResult revocationToCollectionBatch(@RequestBody List<PublishVO> PublishVOList){//String AdoptionCollectionStr
		try {
//			List<PublishVO> PublishVOList = JsonUtils.jsonToList(AdoptionCollectionStr, PublishVO.class);
			
			DogResult result = adoptionService.updateAdoptionCollectionBatch(PublishVOList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "操作失败");
		}
	}
	
	//领养申请
	//@RequiresPermissions("/adoption/apply")(请教)
	@RequestMapping("/apply")
	@ResponseBody
	public DogResult AdoptionApply(TAdoptionRecords tAdoptionRecords){
		try {
			DogResult result = adoptionService.AdoptionApplyDog(tAdoptionRecords);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "操作失败");
		}
	}

	//领养申请人列表
	//@RequiresPermissions("/adoption/findTAdoptionApply")
	@RequestMapping("/findTAdoptionApply")
	@ResponseBody
	public DogResult findTAdoptionRecordsList(Long adoptionPublicityId){
		try {
			List<TAdoptionRecords> adoptionRecordsList = adoptionService.findTAdoptionRecordsList(adoptionPublicityId);
			return DogResult.ok(adoptionRecordsList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//领养确认
	@RequiresPermissions("/adoption/applySuer")
	@RequestMapping("/applySuer")
	@ResponseBody
	public DogResult AdoptionApplySuer(TAdoptionRecords tAdoptionRecords){
		try {
			DogResult result = adoptionService.AdoptionApplySuer(tAdoptionRecords);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "操作失败");
		}
	}
	
	//重新发布
	@RequiresPermissions("/adoption/againPublish")
	@RequestMapping("/againPublish")
	@ResponseBody
	public DogResult againPublish(@RequestBody List<TAdoptionRecords> AdoptionRecordList){//String AdoptionRecordListStr
		try {
//			List<TAdoptionRecords> AdoptionRecordList = JsonUtils.jsonToList(AdoptionRecordListStr, TAdoptionRecords.class);
			DogResult result = adoptionService.againPublish(AdoptionRecordList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "操作失败");
		}
	}
	
	
	//查犬种类 毛色
	@RequestMapping("/selectdogPro")
	@ResponseBody
	public List<Conditions> selectdogPro(Integer logg) throws Exception{
		 List<Conditions> list = dogCardService.selectConditions(logg);
		 return list;
	}
	
	
	//获取验证码
	@RequestMapping("/getCode")
	@ResponseBody
	public HttpResult getCode(HttpServletRequest request,String phone) throws Exception{
		String ipAddress = GetClientIpAddress.getClientIpAddress(request);
		HashMap<String, Object> map = new HashMap<>();
		map.put("phone", phone);
		map.put("clientIpAddress", ipAddress);
		String url=SEND_MESSAGE+"";
		HttpResult result = HttpClientUtil.executeHttpParams(url, "post", map);
		return result;
	}
	
	
	//验证验证码
	@RequestMapping("/checkCode")
	@ResponseBody
	public HttpResult checkCode(HttpServletRequest request,String phone,String randCode) throws Exception{
		String ipAddress = GetClientIpAddress.getClientIpAddress(request);
		HashMap<String, Object> map = new HashMap<>();
		map.put("phone", phone);
		map.put("clientIpAddress", ipAddress);
		map.put("randCode", randCode);
		String url=SEND_MESSAGE+"";
		HttpResult result = HttpClientUtil.executeHttpParams(url, "post", map);
		return result;
	}
	
	
	
}
