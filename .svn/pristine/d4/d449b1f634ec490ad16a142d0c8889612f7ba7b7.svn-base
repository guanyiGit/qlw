package com.soholy.dogmanager.mapper.statistic;

import com.soholy.dogmanager.entity.TDogInfo;

import java.util.HashMap;
import java.util.List;

public interface DogCountMapper {
	/**
	 * @author ZhongZhong
	 * 全市犬只区域分布
	 * @return
	 */
	List<HashMap<String, Object>> findDogCountsByDistrict();
	
	/**
	 * @author ZhongZhong
	 * 全市犬只性别数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogGenderCounts();
	
	/**
	 * @author ZhongZhong
	 * 全市犬龄数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogAgeCounts();
	
	/**
	 * @author ZhongZhong
	 * 全市犬品种数量统计
	 * @return
	 */
	List<HashMap<String, Object>> findDogBreedsCounts();
	
	/**
	 * 全市犬只数量统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findDogCountsByDateAndDistrict(HashMap<String, Object> map);

	/**
	 * 犬只页面统计总记录
	 * @author ZhongZhong
	 * @param map1
	 * @return
	 */
	Integer calTotalRecord(HashMap<String, Object> map1);

	/**
	 * 全市犬只数量统计分析(根据区域和时间)
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findDogCountsTendency(HashMap<String, Object> map);
	
	/**
	 * 全市犬只数量统计分析(根据时间)
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findTotalDogCountsTendency(HashMap<String, Object> map);
	
	/**
	 * 统计违规次数总记录数(用于分页)
	 * @author ZhongZhong
	 * @param map1
	 * @return
	 */
	Integer calIllegalRecord(HashMap<String, Object> map1);

	/**
	 * 犬只违规次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findDogIllegalCounts(HashMap<String, Object> map1);

	/**
	 * 犬只违规次数统计趋势分析(根据时间和区域)
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findDogIllegalCountsTendency(HashMap<String, Object> map);
	
	
	/**
	 * 犬只违规次数统计趋势分析(根据时间)
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findTotalDogIllegalCountsTendency(HashMap<String, Object> map);
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
	 * 收容犬只数量分布(认领,领养，处理) 待完成
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findCollDogCounts(HashMap<String, Object>map);
	
	
	/**
	 * 所有收容犬只统计 
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findTotalCollDogCounts(HashMap<String, Object>map);
	
	/**
	 * 统计收容犬只(认领,领养,处理)页面总记录数 便于分页
	 * @author ZhongZhong
	 * @param map1
	 * @return
	 */
	Integer findCollDogRecord(HashMap<String, Object> map1);
	
	/**
	 * 所有收容犬只统计  页面总记录数 便于分页
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	Integer findTotalCollDogRecords(HashMap<String, Object> map);
	
	
	/**
	 * 收容犬只(认领,领养,处理)犬只趋势分析
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findCollDogCountsTendency(HashMap<String, Object> map);
	
	
	/**
	 * 所有收容犬只犬只趋势分析
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>> findTotalCollDogCountsTendency(HashMap<String, Object> map);
	
	
	/**
	 * 疫苗使用情况
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>>findVaccineCounts(HashMap<String, Object>map);
	
	/**
	 * 客户数量统计
	 * @author ZhongZhong
	 * @return
	 */
	List<HashMap<String, Object>>findCustomerCounts(HashMap<String, Object>map);
	
	/**
	 * 看病次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>>findTherapyCounts(HashMap<String, Object>map);
	
	/**
	 * 犬证次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>>findDogCardCounts(HashMap<String, Object>map);
	
	
	/**
	 * 免疫证次数统计
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<HashMap<String, Object>>findImmuneCardCounts(HashMap<String, Object>map);
	
	/**
	 * 设备激活情况统计
	 * @author ZhongZhong
	 */
	List<HashMap<String, Object>> findDeviceList();
	
	/**
	 * 设备在线趋势
	 * @author ZhongZhong待完成（业务不清楚）
	 */
	
	/**
	 * 注册用户趋势
	 * @author ZhongZhong
	 */
	List<HashMap<String, Object>>findRegesiterUserTendency(HashMap<String, Object>map);
	
	/**
	 * 在线用户趋势
	 * @author ZhongZhong
	 */
	List<HashMap<String, Object>>findLogUserTendency(HashMap<String, Object>map);
	
	
	/**
	 * 昨日新增犬只
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	Integer findYesterdayAddDog(String date);
	
	/**
	 * 昨日注销犬只
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	Integer findYesterdayCancelDog(String date);
	
	/**
	 * 昨日违法次数
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	Integer findYesterdayIllegalCounts(String date);
	
	
	/**
	 * 昨日注销犬只
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	Integer findYesterdayCollDog(String date);
	
	/**
	 * 昨日违法次数
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	Integer findYesterdayLeaveDog(String date);
	
	/**
	 * 收容中,已认养,已处理的犬
	 * @author ZhongZhong
	 * @param date
	 * @return
	 */
	List<HashMap<String, Object>>findCollLeaveHandelDog(String date);
	
	//-----------------------首页-------------------------------
	/**
	 * 查看所有犬主
	 * @return
	 */
	Integer findAllDogOwner();
	
	/**
	 * 查看全市所有服务网点
	 * @return
	 */
	Integer findAllServeSite();
	/**
	 * 查看所有犬只数量
	 * @return
	 */
	Integer findAllDog();
	
	/**
	 * 今日预约统计
	 * @return
	 */
	List<HashMap<String, Object>>findAppointmentMsg(HashMap<String, Object>map);
	
	/**
	 * 昨日看病次数
	 * @param map
	 * @return
	 */
	Integer findYesterdayTherapy(HashMap<String, Object> map);

	/**
	 * 昨日办理免疫证次数
	 * @param map
	 * @return
	 */
	Integer findYesterdayImmune(HashMap<String, Object> map);

	/**
	 * 昨日免疫次数
	 * 
	 * @param map
	 * @return
	 */
	Integer findYesterdayInjection(HashMap<String, Object> map);

	/**
	 * 昨日办理免犬证次数
	 * @param map
	 * @return
	 */
	Integer findYesterdayDogCard(HashMap<String, Object> map);

	/**
	 * 昨日年检次数
	 * @param map
	 * @return
	 */
	Integer findYesterdayInspection(HashMap<String, Object> map);
	
	/**
	 * 今日在线人数
	 * @return
	 */
	Integer findTodayOnlineCounts(HashMap<String, Object> map);
	
	/**
	 * 今日信息发布条数
	 * @param map
	 * @return
	 */
	Integer findTodayInformationCount(HashMap<String, Object> map);


	/**
	 * 统计所有犬只信息
	 */
	List<TDogInfo>allDog();



}
