package com.soholy.dogmanager.controller.statistic;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.pojo.TableSplitResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.TDogOwner;
import com.soholy.dogmanager.entity.TTherapy;
import com.soholy.dogmanager.entity.dogCard.DogIdAndOwnerId;
import com.soholy.dogmanager.entity.dogCard.DogOwners;
import com.soholy.dogmanager.entity.dogCard.ResponseEntity;
import com.soholy.dogmanager.entity.statistic.DogInfo;
import com.soholy.dogmanager.entity.statistic.DogInspection;
import com.soholy.dogmanager.pojo.servicesite.ServiceSite;
import com.soholy.dogmanager.pojo.statistic.DogInfoVO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerDTO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerVO2;
import com.soholy.dogmanager.pojo.statistic.ImmuneRegister;
import com.soholy.dogmanager.service.fileManager.FileManagerService;
import com.soholy.dogmanager.service.servicesite.ServiceSiteService;
import com.soholy.dogmanager.service.statistic.DogInfoService;
import com.soholy.dogmanager.service.statistic.TVaccineService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/biz/dogInfo")
public class DogInfoController {
	
	private static Logger logger = LoggerFactory.getLogger(DogInfoController.class);
	
	@Autowired
	private DogInfoService dogInfoService;
	@Autowired
	FileManagerService fileManagerService;
	@Resource
	TVaccineService tVaccineService;
	@Autowired
    private ServiceSiteService serviceSiteService;
	/**
	 * 病历列表
	 * @param pageNumber
	 * @param pageSize
	 * @param searchKey
	 * @param orgId
	 * @return
	 */
	//@RequiresPermissions("/dogInfo/findTherapyList")
	@RequestMapping("/findTherapyList")
	@ResponseBody
	public Object findTherapyList(Integer num,Integer size,Integer org_id){
		System.out.println("++++++++病历列表findTherapyList");
		try {
			return tVaccineService.getTherapyList(num, size,org_id);
		} catch (Exception e) {
			logger.warn("病历列表失败",e);
			return new HashMap<>().put("code",500);
		}

	}
	
	/**
	 * 查看病历详情（根据狗id和机构id得到狗信息和病历记录）
	 * @param dog_id
	 * @param org_id
	 * @return
	 */
	//@RequiresPermissions("/dogInfo/findTherapyDetail")
	@RequestMapping("/getTherapyDetails")
	@ResponseBody
	public Object getTherapyDetails(Integer org_id,Integer dog_id,Integer num,Integer size) {
		System.out.println("查看病历详情（根据狗id和机构id得到狗信息和病历记录）");
		try {
			return tVaccineService.getTherapyDetails(dog_id, org_id, num, size);
		} catch (Exception e) {
			logger.warn("根据犬只id查找病历详情失败",e);
		}
		return new HashMap<>().put("code",500);
	}
	/**
	 * 查看病历记录详情（根据病历记录id查询病历记录）
	 * @param dogId
	 * @param orgId
	 * @return
	 */
	//@RequiresPermissions("/dogInfo/findTherapyDetail")
	@RequestMapping("/getDogTherapeLists")
	@ResponseBody
	public Object getDogTherapeLists(Integer dogId) {
		System.out.println("查看病历详情（根据犬只id和机构id得到犬信息和病历记录集合）");
		try {
			return tVaccineService.getTherapes(dogId);
		} catch (Exception e) {
			logger.warn("根据犬只id查找病历详情失败",e);
			return null;
		}
	}
	
	
	/**
	 * 插入病历记录
	 * @param tTherapy
	 * @return
	 */
	@RequiresPermissions("/dogInfo/insertTherapyRecord")
	@RequestMapping("/insertTherapyRecord")
	@ResponseBody
	int insertTherapyRecord(TTherapy tTherapy) {
		int record=0;
		try {
			tTherapy.setCreationTime(new Date());
			record=dogInfoService.insertTherapyRecord(tTherapy);
		} catch (Exception e) {
			logger.warn("插入病历记录失败",e);
		}
		return record;
	}
	/**
	 * 添加病历记录
	 * @param tTherapy
	 * @return
	 */
	@RequestMapping("/addTherapy")
	@ResponseBody
	Object addTherapy(@RequestParam(value="therapy",required=false)String therapy) {
		try {
			if(!therapy.equals("")&&therapy!=null) {
				Map map=JSON.parseObject(therapy);
				return tVaccineService.addTherapy(map);
			}
		} catch (Exception e) {
			logger.warn("插入病历记录失败",e);
			return 0;
		}
		return 0;
	}
	
	
	/**
	 * 免疫证列表
	 * @author ZhongZhong
	 * @param pageNumber
	 * @param pageSize
	 * @param searchKey
	 * @param orgId
	 * @return
	 */
	@RequiresPermissions("/dogInfo/findImmuneCardList")
	@RequestMapping("/findImmuneCardList")
	@ResponseBody
	TableSplitResult<List<DogInfo>> findImmuneCardList(HttpServletRequest request,Integer index,Integer pageSize,Integer orgId,String searchKey){
		TableSplitResult<List<DogInfo>> result=null;
		try {
			if (StringUtil.isEmpty(searchKey)){
				searchKey=null;
			}else {
//				searchKey = new String(request.getParameter("searchKey").getBytes("ISO-8859-1"), "UTF-8");
			}
			result = dogInfoService.findImmuneCardList(index, pageSize,orgId, searchKey);
		} catch (Exception e) {
			logger.warn("查询免疫证列表失败",e);
		}
		return result;
	}
	//查询所有免疫证号
    //@RequiresPermissions("/dogCard/selectImmuneCardNums")
    @RequestMapping("/selectImmuneCardNums")
    @ResponseBody
    public ResponseEntity<List<String>> selectImmuneCardNums(String input){
        List<String> list = new ArrayList<String>();
        try {
            list=dogInfoService.getImmuneCardNumsList(input);
        } catch (ServerException e) {
            return new  ResponseEntity<>("000117","根据设备编号查犬id失败！");
        }
        return new ResponseEntity<List<String>>(list);
    }
	
	
	/**
	 * 查看免疫证详情
	 * @author ZhongZhong
	 * @param dogId
	 * @return
	 */
	@RequiresPermissions("/dogInfo/findImmuneDetail")
	@RequestMapping("/findImmuneDetail")
	@ResponseBody
	public String findImmuneDetail(Long dogId) {
		DogInfo info=null;
		try {
			info = dogInfoService.findImmuneDetail(dogId);
		} catch (Exception e) {
			logger.warn("查看免疫证详情失败",e);
		}
		return new GlobalResult().successJSON(info);
	}
	
	

	/**
	 * 免疫登记插入信息
	 * @param dogInfo
	 * @return
	 */
	@RequiresPermissions("/dogInfo/insertImmuneMsg")
	@RequestMapping("/insertImmuneMs" +
			"" +
			"g")
	@ResponseBody
	ResponseEntity<DogIdAndOwnerId> insertImmuneMsg(@RequestBody DogInfo dogInfo) {
		DogIdAndOwnerId dogIdAndOwnerId = new DogIdAndOwnerId();
		try {
			dogIdAndOwnerId = dogInfoService.insertImmuneMsg(dogInfo);
		} catch (Exception e) {
			logger.warn("免疫证办理插入信息失败",e);
			return new  ResponseEntity<>("000777","免疫证办理插入信息失败！");
		}
		return new ResponseEntity<DogIdAndOwnerId>(dogIdAndOwnerId);
	}
	/**
	 * 根据免疫证号查询犬只信息,犬主信息,犬证号
	 * @author ZhongZhong
	 * @param immuneCardNum
	 * @return
	 */
	//@RequiresPermissions("/dogInfo/findDogInspectionByImmuneCode")
	@RequestMapping("/findDogInspectionByImmuneCode")
	@ResponseBody
	DogInspection findDogInspectionByImmuneCode(String immuneCardNum) {
		DogInspection dog=null;
		try {
			if(immuneCardNum!=null&&!immuneCardNum.equals("")) {
				dog = dogInfoService.findDogInspectionByImmuneCode(immuneCardNum);
			}
		} catch (Exception e) {
			logger.warn("根据免疫证号查询犬只信息,犬主信息,犬证号失败",e);
		}
		return dog;
	}
	
	
	/**
	 * 查看年检记录详情 
	 * @author ZhongZhong
	 * @param inspectionsId
	 * @return
	 */
	@RequiresPermissions("/dogInfo/findDogInspectionDetail")
	@RequestMapping("/findDogInspectionDetail")
	@ResponseBody
	String findDogInspectionDetail(Integer inspectionsId) {
		DogInspection dog=null;
		try {
			dog = dogInfoService.findDogInspectionDetail(inspectionsId);
		} catch (Exception e) {
			logger.warn("查看年检记录详情 失败",e);
		}
		return 	 new GlobalResult().successJSON(dog);
	}
	
	/**
	 * 查看年检列表
	 * @param pageNumber 页码
	 * @param pageSize 页面大小
	 * @param searchKey 搜索关键字
	 * @param orgId 部门id
	 * @param orgType 部门类型
	 * @return
	 */
	@RequiresPermissions("/dogInfo/findDogInspectionList")
	@RequestMapping("/findDogInspectionList")
	@ResponseBody
	HashMap<String, Object>findDogInspectionList(Integer pageNumber,Integer pageSize,String searchKey,Integer orgId,Integer orgType){
		HashMap<String, Object>map=null;
		try {
			map = dogInfoService.findDogInspectionList(pageNumber, pageSize, searchKey,orgId,orgType);
		} catch (Exception e) {
			logger.warn("查看年检列表 失败",e);
		}
		return map;
	}
	
	/**
	 * 插入年检信息
	 * @author ZhongZhong
	 * @param dogInspection
	 */
	@RequiresPermissions("/dogInfo/insertInspection")
	@RequestMapping("/insertInspection")
	@ResponseBody
	int insertInspection(DogInspection dogInspection) {
		int record=0;
		try {
			record=dogInfoService.insertInspection(dogInspection);
		} catch (Exception e) {
			logger.warn("插入年检信息失败",e);
		}
		return record;
	}
	
	/**
	 * @author ZhongZhong
	 * 查看犬只品种，犬只颜色，和犬主区域
	 * @return
	 */
	//@RequiresPermissions("/dogInfo/findBreedColorDistrict")
	@RequestMapping("/findBreedColorDistrict")
	@ResponseBody
	public String findBreedColorDistrict(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			map=dogInfoService.findBreedColorDistrict();
		} catch (Exception e) {
			logger.warn("查看字典表信息失败",e);
		}
		return new GlobalResult().successJSON(map);
	}
	
	
	/**
	 * @author ZhongZhong
	 * 查看详情中的病历列表
	 * @return
	 */
	@RequestMapping("/findDetailTherapyList")
	@ResponseBody
	public List<TTherapy> findDetailTherapyList(Integer dogId,Integer orgId
			,@RequestParam(value="num",required=false)Integer num
			,@RequestParam(value="size",required=false)Integer size){
		logger.debug(dogId+"++++"+orgId);
		List<TTherapy> therapyList=null;
		try {
			therapyList=dogInfoService.findDetailTherapyList(dogId,orgId);
		} catch (Exception e) {
			logger.warn("查看详情中的病历列表失败",e);
		}
		return therapyList;
	}
	/**
	 * @author tangxiyin
	 * 查看详情中的病历列表
	 * @return
	 */
	@RequestMapping("/getTherapyList")
	@ResponseBody
	public Map<String, Object> getTherapyList(Integer dogId,Integer orgId
			,@RequestParam(value="num",required=false)Integer num
			,@RequestParam(value="size",required=false)Integer size){
		logger.debug(dogId+"++++"+orgId);
		
		try {
			//therapyList=dogInfoService.findDetailTherapyList(dogId,orgId);
		} catch (Exception e) {
			logger.warn("查看详情中的病历列表失败",e);
		}
		return null;
	}
	/**
	 * @author ZhongZhong
	 * 查看免疫登记列表
	 * @return
	 */
	@RequestMapping("/tVaccineList")
	@ResponseBody
	public Object tVaccineList(Integer num,Integer size,String input,Integer org_id) {
		//logger.debug("++++tVaccineList");
		Object tVaccineList=tVaccineService.tVaccineList(num,size,input,org_id);
		return tVaccineList;
	}
	/**
	 * @author ZhongZhong
	 * 查看喂药列表
	 * @return
	 */
	@RequestMapping("/tVaccineListWY")
	@ResponseBody
	public Object tVaccineListWY(Integer num,Integer size,String input,Integer org_id) {
		//logger.debug("++++tVaccineList");
		Object tVaccineList=tVaccineService.tVaccineListWY(num,size,input,org_id);
		return tVaccineList;
	}
	/**
	 * 根据免疫登记id查看免疫登记详情
	 * @return
	 */
	@RequestMapping("/getTVaccineId")
	@ResponseBody
	public Object getTVaccineId(@RequestParam(value="id",required=false)Integer id
			,@RequestParam(value="num",required=false)Integer num
			,@RequestParam(value="size",required=false)Integer size){
		logger.debug("++++getTVaccineId");
		Object getTVaccineId=tVaccineService.getTVaccineId(id,num,size);
		return getTVaccineId;
	}
	/**
	 * @author ZhongZhong
	 * 根据狗id得到狗信息和喂药记录信息
	 * @return
	 */
	@RequestMapping("/getDrugRecords")
	@ResponseBody
	public Object getDrugRecords(Integer id
			,@RequestParam(value="num",required=false)Integer num
			,@RequestParam(value="size",required=false)Integer size
			,@RequestParam(value="org_id",required=false)Integer org_id){
		System.out.println("+++getDrugRecords");
		Object getDogInfo=tVaccineService.getDrugRecords(id,num,size,org_id);
		return getDogInfo;
	}
	/**
	 * 根据狗id得到狗信息和喂药记录（查看喂药详情）
	 * @return
	 */
	@RequestMapping("/getDrugRecord")
	@ResponseBody
	public Object getDrugRecord(Integer org_id,Integer dog_id,Integer num,Integer size){
		logger.debug("++++getDrugRecord");
		Object getDrugRecord=tVaccineService.getDrugRecord(org_id,dog_id,num,size);
		return getDrugRecord;
	}
	/**
	 * 新增喂药登记
	 */
	@RequestMapping("/addDrugRecords")
	@ResponseBody
	public Object addDrugRecords(@RequestParam(value="drugRecord")String drugRecord) {
		
		try {
			if(drugRecord!=null&&!drugRecord.equals("")) {
				Map map=JSON.parseObject(drugRecord);
				SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
				map.put("first_injection_date", date.parse((String)map.get("first_injection_date")));//第一次喂药时间
				map.put("drug_date", date.parse((String)map.get("drug_date")));//实际喂药时间
				if(map.get("next_injection_date")!=null&&!map.get("next_injection_date").equals("")) {
					map.put("next_drug_date", date.parse((String)map.get("next_injection_date")));//下次喂药时间
				}else {
					map.put("next_drug_date", null);
				}
				return tVaccineService.addDrugRecords(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	/**
	 * 添加喂药记录
	 * @return
	 */
	@RequestMapping("/addDrugRecord")
	@ResponseBody
	public Object addDrugRecord(@Param(value="drugRecord")String drugRecord){
		logger.debug("++++addDrugRecord");
		try {
			SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
			if(drugRecord!=null&&!drugRecord.equals("")) {
				Map map=JSON.parseObject(drugRecord);
				map.put("drug_date", data.parse((String)map.get("drug_date")));//喂药时间
				String next_drug_date=(String)map.get("next_drug_date");//下次喂药时间
				if(next_drug_date!=null&&!next_drug_date.equals("")) {
					map.put("next_drug_date", data.parse(next_drug_date));
				}else {
					map.put("next_drug_date", null);
				}
				int i=tVaccineService.addDrugRecord(map);
					if(i>0) {
						return true;
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 添加无证喂药
	 * @return
	 */
	@RequestMapping("/addWZDrugRecord")
	@ResponseBody
	public Object addWZDrugRecord(@RequestParam(value="vaccine",required=false)String vaccine) {
		
		Map map=JSON.parseObject(vaccine);
		SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
		try {//免疫登记表第一次注射时间
			map.put("first_injection_date", a.parse((String)map.get("first_injection_date")));
			map.put("drug_date", a.parse((String)map.get("drug_date")));//喂药时间
			
			if(map.get("next_drug_date")!=null&&!map.get("next_drug_date").equals("")) {
				map.put("next_drug_date", a.parse((String)map.get("next_drug_date")));
			}else {
				map.put("next_drug_date", null);//下次喂药时间
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(map!=null&&!map.equals("")) {
			//添加喂药登记,if成功返回true
			return tVaccineService.addWZDrugRecord(map);
		}
		return false;
		
	}
	/**
	 * 添加犬只（微信小程序）
	 * @return
	 */
	@RequestMapping("/addDogInfoWX")
	@ResponseBody
	public Object addDogInfo(@RequestParam Map<String,Object> map) {

		return tVaccineService.addDogInfo(map);

	}
	/**
	 * @author ZhongZhong
	 * 根据狗id得到狗信息和免疫记录信息
	 * @return
	 */
	@RequestMapping("/getDogInfoImm")
	@ResponseBody
	public Object getDogInfo(Integer id,Integer pageNum,Integer pageSize,Integer org_id){
		System.out.println("+++getDogInfoImm");
		Object getDogInfo=tVaccineService.getDogInfoImm(id,pageNum,pageSize,org_id);
		return getDogInfo;
	}
	/**
	 * 新增免疫登记
	 */
	@RequestMapping("/addTVaccine")
	@ResponseBody
	public Object addTVaccine(@RequestParam(value="tVaccine")String tVaccine) {
		//String ref_id=" abcd ";
		//System.out.println("去空格前="+ref_id+"=");
		//String str2 = ref_id.replaceAll(" ", "");
		//System.out.println("去空格后="+str2+"=");
		
		//dog_id狗id
		//org_id机构id
		//first_injection_date第一次注射时间
		
		//vaccine_register_id免疫登记id
		//operator_id,create_date注射人id
		//fact_injection_date实际注射时间
		//next_injection_date下次注射时间
		//remarks//备注
		//vaccine_name//疫苗名称
		//vaccine_producer//疫苗厂家
		try {
			if(tVaccine!=null&&!tVaccine.equals("")) {
				Map map=JSON.parseObject(tVaccine);
				SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
				map.put("first_injection_date", date.parse((String)map.get("first_injection_date")));//第一次注射时间
				map.put("fact_injection_date", date.parse((String)map.get("fact_injection_date")));//实际注射时间
				if(map.get("next_injection_date")!=null&&!map.get("next_injection_date").equals("")) {
					map.put("next_injection_date", date.parse((String)map.get("next_injection_date")));//下次注射时间
				}else {
					map.put("next_injection_date", null);
				}
				return tVaccineService.addTVaccine(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	/**
	 * 新增免疫记录
	 */
	@RequestMapping("/addVaccineInjection")
	@ResponseBody
	public Object addVaccineInjection(@RequestParam(value="injecttion")String injecttion) {
		//vaccine_register_id//免疫登记id
		//operator_id,create_date//注射人id
		//remarks//备注
		//vaccine_name//疫苗名称
		//vaccine_producer//疫苗厂家
		try {
			System.out.println("===addVaccineInjection");
			if(injecttion!=null&&!injecttion.equals("")) {
				Map map=JSON.parseObject(injecttion);
				SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
				map.put("fact_injection_date", date.parse((String)map.get("fact_injection_date")));//实际注射时间
				if(map.get("next_injection_date")!=null&&!map.get("next_injection_date").equals("")) {
					map.put("next_injection_date", date.parse((String)map.get("next_injection_date")));//下次注射时间
				}else {
					map.put("next_injection_date", null);
				}
				if(tVaccineService.addVaccineInjection(map)>0)return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 无证免疫登记
	 * @return
	 */
	@RequestMapping("/addWZT_vaccine")
	@ResponseBody
	public Object addWZVaccine(@RequestParam(value="vaccine",required=false)String vaccine) {
		
		Map map=JSON.parseObject(vaccine);
		System.out.println((String)map.get("first_injection_date"));
		SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=a.parse((String)map.get("first_injection_date"));
			map.put("first_injection_date", date);
		    map.put("fact_injection_date", date);
			
			if(map.get("next_injection_date")!=null&&!map.get("next_injection_date").equals("")) {
				map.put("next_injection_date", a.parse((String)map.get("next_injection_date")));
			}else {
				map.put("next_injection_date", null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(map!=null&&!map.equals("")) {
			//添加免疫登记,if成功返回true
			return tVaccineService.addWZVaccine(map);
		}
		return false;
		
	}
	/**
	 * 添加无证病历记录
	 * @return
	 */
	@RequestMapping("/addWZTherapy")
	@ResponseBody
	public int addWZTherapy(@RequestParam(value="therapy",required=false)String therapy) {
		Map map=JSON.parseObject(therapy);
		if(map!=null&&!map.equals("")) {
			return tVaccineService.addWZTherapy(map);
		}
		return 0;
	}
	/**
	 * 根据犬主姓名或者电话查找狗集合
	 * @return
	 */
	@RequestMapping("/getDogInfoPhone")
	@ResponseBody
	public Object getDogInfoPhone(@RequestParam(value="input",required=false)String input
			,@RequestParam(value="pageNum",required=false)Integer pageNum
			,@RequestParam(value="pageSize",required=false)Integer pageSize) {
		return tVaccineService.getDogInfoPhone(input,pageNum,pageSize);
	}
	/**
	 * 根据犬主手机得到犬主
	 * @return
	 */
	@RequestMapping("/getDogOwner")
	@ResponseBody
	public Object getDogOwner(@RequestParam(value="dog_owner_phone",required=false)String dog_owner_phone) {
		try {
			if(dog_owner_phone!=null&&!dog_owner_phone.equals("")) {
				return tVaccineService.getDogOwner(dog_owner_phone);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据犬名和犬主id得到犬
	 * @return
	 */
	@RequestMapping("/getDog")
	@ResponseBody
	public Object getDogOwner(@RequestParam(value="id",required=false)Integer id
			,@RequestParam(value="dogName",required=false)String dogName) {
		try {
			if(id!=null&&!id.equals("")&&dogName!=null&&!dogName.equals("")) {
				return tVaccineService.getDog(id,dogName);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	//修改密码
	@RequestMapping("/updPwd")
	@ResponseBody
	public Object updPwd(@RequestParam(value="updPwd",required=false)String updPwd) {
		System.out.println("updPwd");
		if(updPwd!=null&&!updPwd.equals("")) {
			Map map=JSON.parseObject(updPwd);
			int i=tVaccineService.updPwd(map);//0原密码与旧密码一样1成功-1原密码不正确-2修改失败
			return i;
		}
		return -2;
		
	}
	/**
	 * 根据服务网点id得到服务网点详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getHospital",method = RequestMethod.POST)
	@ResponseBody
	public Object getHospital(Integer id) {
		try {
			ServiceSite serviceSite = serviceSiteService.selectServiceSite(id);
			Map<String,Object>map=new HashMap<>();
			map.put("hospital", serviceSite);
			List<Map>list=tVaccineService.getHospitalList(id);
			map.put("list", list);
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 根据犬id得到犬，犬主信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getDogDogOwner",method = RequestMethod.POST)
	@ResponseBody
	public Object getDogDogOwner(Integer id) {
		try {
			Map map=tVaccineService.getDogDogOwner(id);
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping("/hello")
	@ResponseBody
	public Object hello(@RequestParam(value="num",required=false)String num) {
		if(num!=null&&!num.equals("")) {
			System.out.println("---"+num);
			Map maps=JSON.parseObject(num);
			try {
				System.out.println(maps);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("++++");
		return "hello";
		
	}

    /**
     * 修改免疫登记
     * @param dogInfo
     * @return
     */
	@RequestMapping("/updateDogImmune")
	@ResponseBody
	public DogResult updateDogImmune(@RequestBody DogInfo dogInfo) {
		try {
			DogResult dogResult = dogInfoService.updateDogImmune(dogInfo);
			return dogResult;
		} catch (Exception e) {
			return DogResult.build(500, "服务器异常");
		}
	}




	/**
	 * 免疫登记
	 * 添加犬只犬主
	 * 生成免疫证
	 * */
	@RequestMapping("/immuneRegister")
	@ResponseBody
	public DogResult immuneRegister(@RequestBody ImmuneRegister immuneRegister) {
		DogResult result = null;
		try {
			result = dogInfoService.saveImmuneRegister(immuneRegister);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}

	/**
	 * 免疫登记
	 * 添加犬只健康状况
	 * */
	@RequestMapping("/saveHealthCondition")
	@ResponseBody
	public DogResult saveHealthCondition(@RequestBody HealthConditionDO healthConditionDO) {
		DogResult result = null;
		try {
			result = dogInfoService.saveHealthCondition(healthConditionDO);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}


	/**
	 * 免疫登记
	 * 添加免疫记录
	 * */
	@RequestMapping("/saveImmuneRecord")
	@ResponseBody
	public DogResult saveImmuneRecord(@RequestBody ImmuneRegister immuneRegister) {
		DogResult result = null;
		try {
			result = dogInfoService.saveImmuneRecord(immuneRegister);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}

	/**
	 * 根据电话号码
     * 查找犬主信息
	 *
	 * */
	@RequestMapping("/findDogOwnerByPhone")
	@ResponseBody
	public DogResult findDogOwnerByPhone(String phone) {
		DogResult result = null;
		try {
            DogOwners dogOwners = dogInfoService.findDogOwnerByPhone(phone);
            return DogResult.ok(dogOwners);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}
	@RequestMapping("/getHealthCondition")
	@ResponseBody
	public Object getHealthCondition(@RequestParam(value = "dogId",required = false)Integer dogId){
		Map map=new HashMap();
		try {
			List<Map>list=tVaccineService.getHealthConditionList(dogId);
			map.put("code",200);
			map.put("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code",500);
		}
		return map;
	}

	/**
	 * 添加犬主
	 * 生成用户
	 * */
	@RequestMapping("/saveDogOwner")
	@ResponseBody
	public DogResult saveDogOwner(@RequestBody DogOwnerDTO  dogOwnerDTO) {
		try {
			DogResult result = dogInfoService.saveDogOwner(dogOwnerDTO);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}
	/**
	 * 添加犬主（微信小程序）
	 * 生成用户
	 * */
	@RequestMapping("/addDogOwnerWX")
	@ResponseBody
	public DogResult addDogOwnerWX(DogOwnerDTO dogOwnerDTO) {
		Map<String,Object>map = new HashMap<>();
		map.put("phone", dogOwnerDTO.getDogOwnerPhone());
		map.put("randCode", dogOwnerDTO.getYzm());
		String url="http://192.168.0.69:8888/dogmanager-sms/sms/CheckRandCode";
		String urls="http://192.168.1.162:8888/sms/CheckRandCode";
		try {
			HttpResult resp = HttpClientUtil.executeHttpParams(url +
					"", "POST", null, null, map, null);
			if(null==resp){
				return DogResult.build(400,"验证码错误");
			}
			map=JSONObject.parseObject(resp.getContent());
			if(Integer.parseInt(map.get("status").toString())!=200){
				return DogResult.build(400,"验证码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"出现错误");
		}
		return dogInfoService.addDogOwner(dogOwnerDTO);
	}
	/**
	 * 修改密码（微信小程序）
	 * */
	@RequestMapping("/updPasswordWX")
	@ResponseBody
	public DogResult updPasswordWX(DogOwnerDTO dogOwnerDTO) {
		Map<String,Object>map = new HashMap<>();
		map.put("phone", dogOwnerDTO.getDogOwnerPhone());
		map.put("randCode", dogOwnerDTO.getYzm());
		String url="http://192.168.0.69:8888/dogmanager-sms/sms/CheckRandCode";
		String urls="http://192.168.1.162:8888/sms/CheckRandCode";
		try {
			HttpResult resp = HttpClientUtil.executeHttpParams(url +
					"", "POST", null, null, map, null);
			if(null==resp){
				return DogResult.build(400,"验证码错误");
			}
			map=JSONObject.parseObject(resp.getContent());
			if(Integer.parseInt(map.get("status").toString())!=200){
				return DogResult.build(400,"验证码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"出现错误");
		}
		return dogInfoService.updPassword(dogOwnerDTO);
	}
	/**
	 *犬主列表
	 * */
	@RequestMapping("/findDogOwnerList")
	@ResponseBody
	public DogResult findDogOwnerList(@RequestParam HashMap<String,Object> map) {
		try {
            Page<DogOwnerDTO> list = dogInfoService.findDogOwnerList(map);
            return DogResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}

    /**
     *犬主详情
     * */
    @RequestMapping("/findDogOwnerById")
    @ResponseBody
    public DogResult findDogOwnerById(Long dogOwnerId) {
        try {
            DogOwnerDTO dogOwnerDTO = dogInfoService.findDogOwnerById(dogOwnerId);
            return DogResult.ok(dogOwnerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400,"操作失败");
        }
    }


    /**
     *修改犬主
     * */
    @RequestMapping("/updateDogOwner")
    @ResponseBody
    public DogResult updateDogOwner(@RequestBody  DogOwnerVO2 dogOwnerVO2) {
        try {
			DogResult result = dogInfoService.updateDogOwner(dogOwnerVO2);
			return result;
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400,"操作失败");
        }
    }
    /**
     *犬只详情
     * */
    @RequestMapping("/findDogInfoVOById")
    @ResponseBody
    public DogResult findDogInfoVOById(Long dogId) {
        try {
            DogInfoVO dogInfoVO = dogInfoService.findDogInfoVOById(dogId);
            return DogResult.ok(dogInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400,"操作失败");
        }
    }

    /**
     *新增犬只
     * */
    @RequestMapping("/saveDogInfo")
    @ResponseBody
    public DogResult saveDog(@RequestBody  TDogInfo dogInfo) {
        try {
             dogInfoService.saveDog(dogInfo);
            return DogResult.ok(dogInfo.getDogId());
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400,"操作失败");
        }
    }

    /**
     *修改犬只
     * */
    @RequestMapping("/updateDogInfo")
    @ResponseBody
    public DogResult updateDogInfo(@RequestBody  TDogInfo dogInfo) {
        try {
            dogInfoService.updateDog(dogInfo);
            return DogResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400,"操作失败");
        }
    }

	//根据搜索得到犬列表
	@RequestMapping("/getDogList")
	@ResponseBody
	public Object getDogList(@RequestParam(value="input")String input
			,@RequestParam(value="num")Integer num,@RequestParam(value="size")Integer size){
		try {
			return tVaccineService.getDogList(input,num,size);
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<>().put("code",500);
		}
	}
	//得到免疫列表打印
	@RequestMapping("/getTVaccineIdPrint")
	@ResponseBody
	public Object getTVaccineIdPrint(@RequestParam(value="dogId",required = false)Integer dogId){
    	Map<String,Object> map=new HashMap();
		try {
			DogInfo dogInfo=dogInfoService.findImmuneDetail(dogId.longValue());
			Object printImms=tVaccineService.getTVaccineId(dogId,null,null);
			map.put("dogInfo",dogInfo);
			map.put("printValue",printImms);
			map.put("code",200);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return map.put("code",500);
		}
	}

	//删除图片
	@RequestMapping("/deletePic")
	@ResponseBody
	public DogResult deletePic(Long fid) {
		try {
			dogInfoService.deletePic(fid);
			return DogResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"操作失败");
		}
	}
}
