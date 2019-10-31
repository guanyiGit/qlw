package com.soholy.dogmanager.controller.violation;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.entity.TCollection;
import com.soholy.dogmanager.pojo.violation.CollectionVO;
import com.soholy.dogmanager.pojo.violation.HandleCollection2VO;
import com.soholy.dogmanager.pojo.violation.HandleCollectionVO;
import com.soholy.dogmanager.service.violation.CollectionService;



/** 
* 
* 项目名称：dogmanager-web 
* 类名称：CollectionController 
* 类描述： 收容controller
* 创建人：YL
* 创建时间：2018年8月27日 上午10:39:19 
* 修改人：Administrator 
* 修改时间：2018年8月27日 上午10:39:19 
* 修改备注： 
* 
*/
@Controller
@RequestMapping("/biz/collection")
public class CollectionController {
	
	@Autowired
	private CollectionService collectionService;
	
	
	//检查犬只编号是否存在
	@RequestMapping("/checkDogCode")
	@ResponseBody
	public DogResult checkDogCode(String dogCode){
		DogResult result = collectionService.checkDogCode(dogCode);
		return result;
	}
	
	//收容登记
	@RequiresPermissions("/collection/save")
	@RequestMapping("/save")
	@ResponseBody
	public DogResult save(TCollection collection){
		DogResult result = collectionService.save(collection);
		return result;
	}
	
	//查收容中列表
//	@RequiresPermissions("/collection/findCollectionList")
	@RequestMapping("/findCollectionList")
	@ResponseBody
	public DogResult findCollectionList(Integer pn,Integer pageSize,String string,Integer status){
		try {
			if(!StringUtils.isEmpty(string)){
//				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
			}
			Page<CollectionVO> collectionVOList = collectionService.findCollectionList(pn, pageSize, string, status);
			return DogResult.ok(collectionVOList);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	
		//领养平台列表
		//@RequiresPermissions("/collection/findCollectionList")
		@RequestMapping("/findAdoptionsList")
		@ResponseBody
		public Map<String, Object> findAdoptionsList(@RequestParam("page") Integer pn,@RequestParam("rows") Integer pageSize,String string){
			HashMap<String,Object> map = new HashMap<>();
			try {
				if(!StringUtils.isEmpty(string)){
//					string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
				}
				Page<CollectionVO> collectionVOList = collectionService.findAdoptionCollectionVOs(pn, pageSize, string, 1);
				map.put("rows", collectionVOList.getLists());
				map.put("records", collectionVOList.getTotalRecord());
				map.put("page", collectionVOList.getPageNumber());
				map.put("message", null);
				return map;
			} catch (Exception e) {
				e.printStackTrace();
				map.put("message", "当前无数据");
				return map;
			}
		}
	
	
	//查详情
	//@RequiresPermissions("/collection/findOne")
	@RequestMapping("/findOne")
	@ResponseBody
	public DogResult findOne(Long collectionId){
		try {
			CollectionVO collectionVO = collectionService.findCollectionByCollectionId(collectionId);
			return DogResult.ok(collectionVO);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400, "请求数据有误");
		}
	}
	
	//认领登记
	@RequiresPermissions("/collection/claim")
	@RequestMapping("/claim")
	@ResponseBody
	public DogResult claim(HandleCollectionVO handleCollectionVO){
		try {
			DogResult result = collectionService.claimMyDog(handleCollectionVO);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}

	//领养登记
	@RequiresPermissions("/collection/adoption")
	@RequestMapping("/adoption")
	@ResponseBody
	public DogResult adoption(TAdoptionRecords tAdoptionRecords){
		try {
			DogResult result = collectionService.AdoptionPubDog(tAdoptionRecords);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}
	
	//处理登记
	@RequiresPermissions("/collection/handle")
	@RequestMapping("/handle")
	@ResponseBody
	public DogResult handle(HandleCollectionVO handleCollectionVO){
		try {
			DogResult result = collectionService.handleDog(handleCollectionVO);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}
	
	//查认领处理列表
//	@RequiresPermissions("/collection/findHandleCollectionList")
	@RequestMapping("/findHandleCollectionList")
	@ResponseBody
	public DogResult findHandleCollectionVOList(Integer pn,Integer pageSize,String string,Integer type){
		try {
			if(!StringUtils.isEmpty(string)){
//				string = new String(string.getBytes("ISO-8859-1"), "UTF-8");
			}
			Page<HandleCollection2VO> handleCollectionVO2List = collectionService.findHandleCollectionVOList(pn, pageSize, string, type);
			return DogResult.ok(handleCollectionVO2List);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"请求数据有误");
		}
	}
	
	//查认领处理详情
	@RequiresPermissions("/collection/findHandleCollectionById")
	@RequestMapping("/findHandleCollectionById")
	@ResponseBody
	public DogResult findHandleCollectionByHandleId(Long handleId){	
		try {
			HandleCollection2VO handleCollection2VO = collectionService.findHandleCollectionByHandleId(handleId);
			return DogResult.ok(handleCollection2VO);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"请求数据有误");
		}
	}
	
	
	
}
