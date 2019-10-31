package com.soholy.dogmanager.controller.statistic;

import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.common.utils.DateUtils;
import com.soholy.dogmanager.pojo.statistic.DogTendency;
import com.soholy.dogmanager.service.statistic.DogCountService;
import freemarker.template.SimpleDate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/biz/statistic")
public class StatisticController {
	private static Logger logger = LoggerFactory.getLogger(StatisticController.class);
	@Autowired
	private DogCountService dogCountService;

	/**
	 * 全市犬只区域分布
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogCountsByDistrict")
	@RequestMapping("/findDogCountsByDistrict")
	@ResponseBody
	public String findDogCountsByDistrict(){
		List<HashMap<String,Object>> list=null;
		try {
			list = dogCountService.findDogCountsByDistrict();
		} catch (Exception e) {
			logger.warn("统计全市犬只区域分布失败",e);
		}
		return new GlobalResult().successJSON(list);

	}

	/**
	 * 全市犬只性别数量统计
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogGenderCounts")
	@RequestMapping("/findDogGenderCounts")
	@ResponseBody
	public String findDogGenderCounts(){
		List<HashMap<String,Object>> list=null;
		try {
			list = dogCountService.findDogGenderCounts();
		} catch (Exception e) {
			logger.warn("统计全市犬只性别数量统计失败",e);
		}
		return new GlobalResult().successJSON(list);

	}



	/**
	 * 全市犬龄数量统计
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogAgeCounts")
	@RequestMapping("/findDogAgeCounts")
	@ResponseBody
	public String findDogAgeCounts(){
		List<HashMap<String,Object>> list=null;
		try {
			list = dogCountService.findDogAgeCounts();
		} catch (Exception e) {
			logger.warn("统计全市犬只性别数量统计失败",e);
		}
		return new GlobalResult().successJSON(list);

	}


	/**
	 * 全市犬品种数量统计
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogBreedsCounts")
	@RequestMapping("/findDogBreedsCounts")
	@ResponseBody
	public String findDogBreedsCounts(){
		List<HashMap<String,Object>> list=null;
		try {
			list = dogCountService.findDogBreedsCounts();
		} catch (Exception e) {
			logger.warn("统计全市犬品种数量统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}


	/**
	 * 全市每月新增犬只数量统计
	 * @author ZhongZhong
	 * @param pageNumber 页码
	 * @param pageSize 页面大小
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogCountsByDateAndDistrictMap")
	@RequestMapping("/findDogCountsByDateAndDistrictMap")
	@ResponseBody
	public String findDogCountsByDateAndDistrictMap(Integer pageNumber,Integer pageSize
			,Date startDate,Date endDate){
		HashMap<String,Object> map =null;
		try {
			map = dogCountService.findDogCountsByDateAndDistrictMap(pageNumber, pageSize, startDate, endDate);
		} catch (Exception e) {
			logger.warn("全市每月新增犬只数量统计失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 全市每月新增犬只数量统计趋势分析
	 * @author ZhongZhong
	 * @param count 月
	 * @return
	 * @throws ParseException
	 */
//	@RequiresPermissions("/statistic/findDogCountsTendency")
////	@RequestMapping("/findDogCountsTendency")
////	@ResponseBody
////	String findDogCountsTendency(Integer count){
////		HashMap<String,Object> map =null;
////		try {
////			map = dogCountService.findDogCountsTendency(count);
////		} catch (Exception e) {
////			logger.warn("全市每月新增犬只数量统计趋势分析失败",e);
////		}
////		return new GlobalResult().successJSON(map);
////	}


	/**
	 * 全市每月犬只数量统计趋势分析
	 * @author ZhongZhong
	 * @param count 月
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findDogCountsTendency")
	@RequestMapping("/findDogCountsTendency")
	@ResponseBody
	String findDogCountsTendency(Integer count){
		List<DogTendency> tendency = null;
		try {
			tendency = dogCountService.findDogCountsTendency(count);
		} catch (Exception e) {
			logger.warn("全市每月新增犬只数量统计趋势分析失败",e);
		}
		return new GlobalResult().successJSON(tendency);
	}


	/**
	 * 违法次数统计
	 * @param pageNumber
	 * @param pageSize
	 * @param startDate 字符串格式类似于 2018-08-01 00:00:00
	 * @param endDate
	 * @return
	 */
	@RequiresPermissions("/statistic/findDogIllegalCountsMap")
	@RequestMapping("/findDogIllegalCountsMap")
	@ResponseBody
	String findDogIllegalCountsMap(Integer pageNumber,Integer pageSize

			,Date startDate,Date endDate){
		HashMap<String,Object> map =null;
		try {
			 map = dogCountService.findDogIllegalCountsMap(pageNumber, pageSize, startDate, endDate);
		} catch (Exception e) {
			logger.warn("违法次数统计失败",e);
		}
		return new GlobalResult().successJSON(map);

	}


	/**
	 * 违法统计趋势分析
	 * @author ZhongZhong
	 * @param count 月数
	 * @return
	 * @throws ParseException
	 */
	//@RequiresPermissions("/statistic/findDogIllegalCountsTendency")
	@RequestMapping("/findDogIllegalCountsTendency")
	@ResponseBody
	String findDogIllegalCountsTendency(Integer count){
		HashMap<String,Object> map =null;
		try {
			map = dogCountService.findDogIllegalCountsTendency(count);
		} catch (Exception e) {
			logger.warn("违法统计趋势分析失败",e);
		}
		return new GlobalResult().successJSON(map);
	}

	/**
	 * 服务网点统计
	 * @author ZhongZhong
	 * @return
	 */
	@RequiresPermissions("/statistic/findServeSiteDistribute")
	@RequestMapping("/findServeSiteDistribute")
	@ResponseBody
	public String findServeSiteDistribute(){
		HashMap<String,Object> map =null;
		try {
			 map = dogCountService.findServeSiteDistribute();
		} catch (Exception e) {
			logger.warn("服务网点统计失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 收容犬只类型分布
	 * @author ZhongZhong
	 * @return
	 */
	@RequiresPermissions("/statistic/findCollDogType")
	@RequestMapping("/findCollDogType")
	@ResponseBody
	String findCollDogType(){
		List<HashMap<String, Object>> list =null;
		try {
			 list = dogCountService.findCollDogType();
		} catch (Exception e) {
			logger.warn("服务网点统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}



	/**
	 * 收容犬只性别分布
	 * @author ZhongZhong
	 * @return
	 */
	@RequiresPermissions("/statistic/findCollDogSex")
	@RequestMapping("/findCollDogSex")
	@ResponseBody
	String findCollDogSex(){
		List<HashMap<String, Object>> list =null;
		try {
			 list = dogCountService.findCollDogSex();
		} catch (Exception e) {
			logger.warn("收容犬只性别分布统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}



	/**
	 * 收容犬只品种分布
	 * @author ZhongZhong
	 * @return
	 */
	@RequiresPermissions("/statistic/findCollDogBreed")
	@RequestMapping("/findCollDogBreed")
	@ResponseBody
	String findCollDogBreed(){
		List<HashMap<String, Object>> list =null;
		try {
			 list = dogCountService.findCollDogBreed();
		} catch (Exception e) {
			logger.warn("收容犬只品种分布统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * (统计信息权限待完善)
	 * 收容犬只数量(认领,领养,处理)
	 * @author ZhongZhong
	 * @return
	 */
	//@RequiresPermissions("/statistic/findCollDogCounts")
	@RequestMapping("/findCollDogCounts")
	@ResponseBody
	String findCollDogCounts(Integer pageNumber,Integer pageSize,Date startDate,Date endDate){
		HashMap<String,Object> map =null;
		try {
			map = dogCountService.findCollDogCounts(pageNumber, pageSize, startDate, endDate);
		} catch (Exception e) {
			logger.warn("收容犬只数量(认领,领养,处理)统计失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 所有收容犬只数量统计(统计信息js和权限待完善)
	 * @author ZhongZhong
	 * @return
	 */
	//@RequiresPermissions("/statistic/findTotalCollDogCounts")
	@RequestMapping("/findTotalCollDogCounts")
	@ResponseBody
	String findTotalCollDogCounts(Integer pageNumber,Integer pageSize,Date startDate,Date endDate){
		HashMap<String,Object> map =null;
		try {
			map = dogCountService.findTotalCollDogCounts(pageNumber, pageSize, startDate, endDate);
		} catch (Exception e) {
			logger.warn("所有收容犬只数量统计失败",e);
		}
		return new GlobalResult().successJSON(map);
	}



	/**
	 * 收容犬只趋势分析
	 * @author ZhongZhong
	 * @param count 年数
	 * @return
	 * @throws ParseException
	 */
	//@RequiresPermissions("/statistic/findCollDogCountsTendency")
	@RequestMapping("/findCollDogCountsTendency")
	@ResponseBody
	String findCollDogCountsTendency(Integer count){
		HashMap<String,Object> map =null;
		try {
			map = dogCountService.findCollDogCountsTendency(count);
		} catch (Exception e) {
			logger.warn("收容犬只趋势分析失败",e);
		}
		return new GlobalResult().successJSON(map);
	}

	/**
	 * 疫苗使用情况
	 * @author ZhongZhong
	 * @param orgaId 部门id
	 * 			date 日期
	 * @return
	 */
	@RequiresPermissions("/statistic/findVaccineCounts")
	@RequestMapping("/findVaccineCounts")
	@ResponseBody
	String findVaccineCounts(Integer orgaId,String date){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findVaccineCounts(orgaId, date);
		} catch (Exception e) {
			logger.warn("疫苗使用情况统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}


	/**
	 * 客户数量统计
	 * orgaId机构id count月数
	 * @return
	 */
	@RequiresPermissions("/statistic/findCustomerCounts")
	@RequestMapping("/findCustomerCounts")
	@ResponseBody
	String findCustomerCounts(Integer orgId,Integer count){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findCustomerCounts(orgId, count);
		} catch (Exception e) {
			logger.warn("客户数量统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 看病次数统计
	 * @author ZhongZhong
	 * @param orgaId机构id count年数
	 * @return
	 */
	@RequiresPermissions("/statistic/findTherapyCounts")
	@RequestMapping("/findTherapyCounts")
	@ResponseBody
	String findTherapyCounts(Integer orgaId,Integer count){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findTherapyCounts(orgaId, count);
		} catch (Exception e) {
			logger.warn("看病次数统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}


	/**
	 * 办证次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findCardCounts")
	@RequestMapping("/findCardCounts")
	@ResponseBody
	String findCardCounts(Integer orgaId,Integer count){
		HashMap<String, Object>map=null;
		try {
			map=dogCountService.findCardCounts(orgaId, count);
		} catch (Exception e) {
			logger.warn("办证次数统计失败",e);
		}
		return new GlobalResult().successJSON(map);
	}

	/**
	 * 设备激活情况统计
	 * @author ZhongZhong
	 */
	@RequiresPermissions("/statistic/findDeviceList")
	@RequestMapping("/findDeviceList")
	@ResponseBody
	String findDeviceList(){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findDeviceList();
		} catch (Exception e) {
			logger.warn("设备激活情况统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 注册用户趋势
	 * @author ZhongZhong
	 * @param startDate
	 * 			endDate
	 */
	@RequiresPermissions("/statistic/findRegesiterUserTendency")
	@RequestMapping("/findRegesiterUserTendency")
	@ResponseBody
	String findRegesiterUserTendency(Date startDate,Date endDate){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findRegesiterUserTendency(startDate,endDate);
		} catch (Exception e) {
			logger.warn("注册用户趋势统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 统计信息在线用户趋势(年/月/日)
	 * @author ZhongZhong
	 */
	@RequiresPermissions("/statistic/findLogUserTendency")
	@RequestMapping("/findLogUserTendency")
	@ResponseBody
	String findLogUserTendency(Date startDate,Date endDate){
		List<HashMap<String, Object>>list=null;
		try {
			HashMap<String, Object>map=new HashMap<String, Object>();
				map.put("startDate", startDate);
				map.put("endDate", endDate);
			list=dogCountService.findLogUserTendency(map);
		} catch (Exception e) {
			logger.warn("在线用户趋势统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 首页在线用户趋势(年/月/日)
	 * @author ZhongZhong
	 */
	@RequiresPermissions("/statistic/findStatisticLogUserTendency")
	@RequestMapping("/findStatisticLogUserTendency")
	@ResponseBody
	String findStatisticLogUserTendency(){
		List<HashMap<String, Object>>list=null;
		try {
			HashMap<String,Object> map = DateUtils.getMonthDate(12);

			list=dogCountService.findLogUserTendency(map);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("在线用户趋势统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 查询昨日狗的信息 新增 注销 违法
	 * @author ZhongZhong
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findYesterDayDogMsg")
	@RequestMapping("/findYesterDayDogMsg")
	@ResponseBody
	String findYesterDayDogMsg(){
		HashMap<String,Object> map = null;
		try {
			 map = dogCountService.findYesterDayDogMsg();
		} catch (Exception e) {
			logger.warn("查询昨日狗的信息 新增 注销 违法 失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 查询昨日狗的信息 收容 认养 违法
	 * @author ZhongZhong
	 * @return
	 * @throws ParseException
	 */
	//@RequiresPermissions("/statistic/findYesterDayCollAndLeave")
	@RequestMapping("/findYesterDayCollAndLeave")
	@ResponseBody
	String findYesterDayCollAndLeave(){
		HashMap<String,Object> map = null;
		try {
			 map = dogCountService.findYesterDayCollAndLeave();
		} catch (Exception e) {
			logger.warn("查询昨日狗的信息  收容 认养 违法 失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 收容中,已认养,已处理的犬
	 * @author ZhongZhong
	 * @return list
	 */
	//@RequiresPermissions("/statistic/findCollLeaveHandelDog")
	@RequestMapping("/findCollLeaveHandelDog")
	@ResponseBody
	String findCollLeaveHandelDog(){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findCollLeaveHandelDog();
		} catch (Exception e) {
			logger.warn("收容中,已认养,已处理的犬统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}


	/**
	 * 查看所有犬主和服务网点
	 */
	@RequiresPermissions("/statistic/findDogOwnerAndSite")
	@RequestMapping("/findDogOwnerAndSite")
	@ResponseBody
	String findDogOwnerAndSite(){
		HashMap<String,Object> map = null;
		try {
			 map = dogCountService.findDogOwnerAndSite();
		} catch (Exception e) {
			logger.warn("查看所有犬主和服务网点 失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 今日预约统计
	 * @author ZhongZhong
	 * @return
	 */
	@RequiresPermissions("/statistic/findAppointmentMsg")
	@RequestMapping("/findAppointmentMsg")
	@ResponseBody
	String findAppointmentMsg(Long orgId){
		List<HashMap<String, Object>>list=null;
		try {
			list=dogCountService.findAppointmentMsg(orgId);
		} catch (Exception e) {
			logger.warn("今日预约统计统计失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 查看宠物医院昨日统计(看病,办证,免疫,年检)
	 * @return
	 */
	@RequiresPermissions("/statistic/findHospitalYesterdayCount")
	@RequestMapping("/findHospitalYesterdayCount")
	@ResponseBody
	String findHospitalYesterdayCount(Long orgId){
		HashMap<String,Object> map = null;
		try {
			 map = dogCountService.findHospitalYesterdayCount(orgId);
		} catch (Exception e) {
			logger.warn("查看宠物医院昨日统计 失败",e);
		}
		return new GlobalResult().successJSON(map);
	}


	/**
	 * 今日在线人数
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findTodayOnlineCounts")
	@RequestMapping("/findTodayOnlineCounts")
	@ResponseBody
	String findTodayOnlineCounts() {
		Integer counts=null;
		try {
			counts = dogCountService.findTodayOnlineCounts();
		} catch (ParseException e) {
			logger.warn("今日在线人数统计失败",e);
		}
		return new GlobalResult().successJSON(counts);
	}


	/**
	 * 今日信息发布条数
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findTodayInformationCount")
	@RequestMapping("/findTodayInformationCount")
	@ResponseBody
	String findTodayInformationCount() {
		Integer counts=null;
		try {
			counts = dogCountService.findTodayInformationCount();
		} catch (ParseException e) {
			logger.warn("今日信息发布条数统计失败",e);
		}
		return new GlobalResult().successJSON(counts);
	}

	/**
	 * 统计上月疫苗使用情况
	 * @return
	 * @throws ParseException
	 */
	@RequiresPermissions("/statistic/findLastMonthVaccine")
	@RequestMapping("/findLastMonthVaccine")
	@ResponseBody
	String findLastMonthVaccine(Integer orgId) {
		List<HashMap<String,Object>> list = null;
		try {
			String date = DateUtils.getLastStringMonth();
			list = dogCountService.findVaccineCounts(orgId, date);
		} catch (Exception e) {
			logger.warn("统计上月疫苗使用情况失败",e);
		}
		return new GlobalResult().successJSON(list);
	}

	/**
	 * 查询某天的设备在线总数
	 * @param date 要查的日期
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dayDeviceActiveSum")
	public String dayDeviceActiveSum(@RequestParam Date date){
		return new GlobalResult().objResultJSON(dogCountService.findDayDeviceActiveCount(date));
	}

}
