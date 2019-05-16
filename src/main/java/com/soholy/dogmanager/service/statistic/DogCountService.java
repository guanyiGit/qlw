package com.soholy.dogmanager.service.statistic;

import com.soholy.dogmanager.pojo.statistic.DogTendency;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface DogCountService {
	/**
	 * 全市犬只区域分布
	 */
	List<HashMap<String, Object>> findDogCountsByDistrict();
	
	/**
	 * 全市犬只性别数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogGenderCounts();
	
	/**
	 * 全市犬龄数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogAgeCounts();
	
	/**
	 * 全市犬品种数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogBreedsCounts();
	
	/**
	 * 全市每月犬只数量统计
	 * @author ZhongZhong
	 * @param pageNumber 页码
	 * @param pageSize 页面大小
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 */
	HashMap<String, Object>findDogCountsByDateAndDistrictMap(Integer pageNumber,Integer pageSize
			
			,Date startDate,Date endDate);

	/**
	 * 全市每月新增犬只数量统计趋势分析
	 * @author ZhongZhong
	 * @param count 月数
	 * @return
	 * @throws ParseException 
	 */
	List<DogTendency>findDogCountsTendency(Integer count) throws ParseException;
	
	/**
	 * 违法次数统计
	 * @param pageNumber
	 * @param pageSize
	 * @param startDate 字符串格式类似于 2018-08-01 00:00:00
	 * @param endDate
	 * @return
	 */
	HashMap<String, Object>findDogIllegalCountsMap(Integer pageNumber,Integer pageSize
			
			,Date startDate,Date endDate);
	
	/**
	 * 违法统计趋势分析
	 * @author ZhongZhong
	 * @param count 年数
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findDogIllegalCountsTendency(Integer count) throws ParseException;
	
	/**
	 * 服务网点统计
	 * @author ZhongZhong
	 * @return
	 */
	HashMap<String, Object> findServeSiteDistribute();
	
	/**
	 * 收容犬只类型分布
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findCollDogType();
	
	/**
	 * 收容犬只性别分布
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findCollDogSex();

	/**
	 * 收容犬只品种分布
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findCollDogBreed();
	
	/**
	 * 收容犬只数量(认领,领养,处理)统计
	 * @author ZhongZhong
	 * @return
	 */
	HashMap<String, Object> findCollDogCounts(Integer pageNumber,Integer pageSize,Date startDate,Date endDate);

	/**
	 * 所有收容犬只数量统计
	 * @author ZhongZhong
	 * @return
	 */
	HashMap<String, Object> findTotalCollDogCounts(Integer pageNumber,Integer pageSize,Date startDate,Date endDate);
	
	
	
	
	/**
	 * 收容犬只趋势分析
	 * @author ZhongZhong
	 * @param count 年数
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findCollDogCountsTendency(Integer count) throws ParseException;
	
	/**
	 * 疫苗使用情况
	 * @author ZhongZhong
	 * @param orgaId 部门id
	 * 			date 日期
	 * @return
	 */
	List<HashMap<String, Object>>findVaccineCounts(Integer orgaId,String date);
	
	/**
	 * 客户数量统计
	 * orgaId机构id count年数
	 * @return
	 * @throws ParseException 
	 */
	List<HashMap<String, Object>>findCustomerCounts(Integer orgaId,Integer count) throws ParseException;
	
	
	/**
	 * 看病次数统计
	 * @author ZhongZhong
	 * @param orgaId机构id count年数
	 * @return
	 * @throws ParseException 
	 */
	List<HashMap<String, Object>>findTherapyCounts(Integer orgaId,Integer count) throws ParseException;
	
	
	/**
	 * 办证次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findCardCounts(Integer orgaId,Integer count) throws ParseException;
	
	/**
	 * 设备激活情况统计
	 * @author ZhongZhong
	 */
	List<HashMap<String, Object>> findDeviceList();
	
	/**
	 * 注册用户趋势
	 * @author ZhongZhong
	 * @param startDate
	 * 			endDate
	 */
	List<HashMap<String, Object>>findRegesiterUserTendency(Date startDate,Date endDate);
	
	/**
	 * 在线用户趋势
	 * @author ZhongZhong
	 */
	List<HashMap<String, Object>>findLogUserTendency(HashMap<String, Object>map);
	
	/**
	 * 查询昨日狗的信息 新增 注销 违法
	 * @author ZhongZhong
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findYesterDayDogMsg() throws ParseException;
	
	/**
	 * 查询昨日狗的信息 收容 认养 违法
	 * @author ZhongZhong
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findYesterDayCollAndLeave() throws ParseException;
	
	/**
	 * 收容中,已认养,已处理的犬
	 * @author ZhongZhong
	 * @return
	 * @throws ParseException 
	 */
	List<HashMap<String, Object>>findCollLeaveHandelDog() throws ParseException;
	
	/**
	 * 查看所有犬主和服务网点
	 */
	HashMap<String, Object>findDogOwnerAndSite();
	
	/**
	 * 今日预约统计
	 * @return
	 * @throws ParseException 
	 */
	List<HashMap<String, Object>>findAppointmentMsg(Long orgId) throws ParseException;
	
	/**
	 * 查看宠物医院昨日统计
	 * @return
	 * @throws ParseException 
	 */
	HashMap<String, Object>findHospitalYesterdayCount(Long orgId) throws ParseException;
	
	/**
	 * 今日在线人数
	 * @return
	 * @throws ParseException 
	 */
	Integer findTodayOnlineCounts() throws ParseException;
	/**
	 * 今日信息发布条数
	 * @return
	 * @throws ParseException 
	 */
	Integer findTodayInformationCount() throws ParseException;

	/**
	 * 查询某天的设备在线总数
	 * @param date 要查的日期
	 * @return
	 */
    Long findDayDeviceActiveCount(Date date);
}
