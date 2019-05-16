package com.soholy.dogmanager.service.statistic.impl;

import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.utils.DateUtils;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.mapper.TDeviceDataMapper;
import com.soholy.dogmanager.mapper.statistic.DogCountMapper;
import com.soholy.dogmanager.pojo.statistic.DogTendency;
import com.soholy.dogmanager.service.statistic.DogCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DogCountServiceImpl implements DogCountService {

	@Autowired
	private DogCountMapper dogMsgMapper;

	@Autowired
	private TDeviceDataMapper tDeviceDataMapper;

	//根据区域统计犬只数量
	@Override
	public List<HashMap<String, Object>> findDogCountsByDistrict() {
		return dogMsgMapper.findDogCountsByDistrict();
	}
	
	//全市犬只性别数量统计
	@Override
	public List<HashMap<String, Object>> findDogGenderCounts() {
		List<HashMap<String,Object>> list = dogMsgMapper.findDogGenderCounts();
		for(HashMap<String,Object> map:list) {
			if(0==(Integer) map.get("name")) {
				map.replace("name", "雄");
			}else {
				map.replace("name", "雌");
			}
			
		}
		return list;
	}

	//全市犬龄数量统计
	@Override
	public List<HashMap<String, Object>> findDogAgeCounts() {
		return dogMsgMapper.findDogAgeCounts();
	}
	
	//全市犬品种数量统计
	@Override
	public List<HashMap<String, Object>> findDogBreedsCounts() {
		return dogMsgMapper.findDogBreedsCounts();
	}

	//全市犬只数量统计
	@Override
	public HashMap<String, Object> findDogCountsByDateAndDistrictMap(Integer pageNumber, Integer pageSize, Date startDate,
			Date endDate) {
		HashMap<String, Object> map1=new HashMap<String, Object>();
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map1.put("startDate", startDate);
		map1.put("endDate", endDate);
		//统计总记录数
		Integer totalRecord=dogMsgMapper.calTotalRecord(map1);
			Page page=new Page();
				page.setPageNumber(pageNumber);
				page.setPageSize(pageSize);
				page.setTotalRecord(totalRecord);
			Integer index=page.getIndex();
				if(index>=0) {
					map1.put("index",index);
					map1.put("pageSize", pageSize);
					List<HashMap<String, Object>> dogCountsByDateAndDistrict = dogMsgMapper.findDogCountsByDateAndDistrict(map1);
							map.put("dogCountsByDateAndDistrict", dogCountsByDateAndDistrict);
							map.put("page", page);
				}
		
		return map;
	}

	//全市犬只数量趋势分析
//	@Override
//	public HashMap<String, Object> findDogCountsTendency(Integer count) throws ParseException {
//		//map获取日期
//		HashMap<String,Object> map = DateUtils.getStartDateAndEndDate(count);
//		//map2用来返回参数
//		HashMap<String,Object> map2 = new HashMap<String,Object>();
//				//每个区域每月新增犬只
//		List<HashMap<String, Object>>monthAdd=dogMsgMapper.findDogCountsTendency(map);
//				//全市每月新增犬只
//		List<HashMap<String, Object>>totalMonthAdd=dogMsgMapper.findTotalDogCountsTendency(map);
//			map2.put("monthAdd", monthAdd);
//			map2.put("totalMonthAdd", totalMonthAdd);
//		return map2;
//	}

	//全市犬只数量趋势分析
	@Override
	public List<DogTendency> findDogCountsTendency(Integer count) throws ParseException {
		//统计最近count年的年月份
		List<DogTendency> dateList = DateUtils.getYearMonthInCountYear(count);

		//所有犬只信息
		List<TDogInfo> allDog = dogMsgMapper.allDog();

		for(DogTendency d:dateList)
		{
			int dogCount=0;//犬只数量
			int cancelCount=0;//犬只注销数量
			for(TDogInfo ad:allDog){
				//犬只创建时间小于某个日期
				if(ad.getCreationTime().getTime() <= d.getDate().getTime()){
					dogCount++;
				}
				if(ad.getCancellationTime()!=null){
					//犬只注销时间小于某日期
					if(ad.getCancellationTime().getTime()<=d.getDate().getTime()){
						cancelCount++;
					}
				}

			}
			dogCount=dogCount-cancelCount;
			d.setDogCount(dogCount);
		}
		return dateList;
	}



	//违法次数统计
	@Override
	public HashMap<String, Object> findDogIllegalCountsMap(Integer pageNumber, Integer pageSize,
			Date startDate, Date endDate) {
		HashMap<String, Object> map1=new HashMap<String, Object>();
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map1.put("startDate", startDate);
		map1.put("endDate", endDate);
		//统计总记录数(用于分页)
		Integer totalRecord=dogMsgMapper.calIllegalRecord(map1);
			Page page=new Page();
				page.setPageNumber(pageNumber);
				page.setPageSize(pageSize);
				page.setTotalRecord(totalRecord);
			Integer index=page.getIndex();
				if(index>=0) {
					map1.put("index",index);
					map1.put("pageSize", pageSize);
					List<HashMap<String, Object>> dogIllegalCounts = dogMsgMapper.findDogIllegalCounts(map1);
							map.put("dogIllegalCounts", dogIllegalCounts);
							map.put("page", page);
				}
		
		return map;
	}

	//违法统计趋势分析
	@Override
	public HashMap<String, Object> findDogIllegalCountsTendency(Integer count) throws ParseException {
		HashMap<String,Object> map = DateUtils.getStartDateAndEndDate(count);
		//map2用来返回参数
		HashMap<String, Object>map2=new HashMap<String, Object>();
			//总共违法次数
		List<HashMap<String,Object>> totalIllegalCountsTendency = dogMsgMapper.findTotalDogIllegalCountsTendency(map);
			//各个区域违法次数
		List<HashMap<String,Object>> illegalCountsTendency =dogMsgMapper.findDogIllegalCountsTendency(map);
			map2.put("totalIllegalCountsTendency", totalIllegalCountsTendency);
			map2.put("illegalCountsTendency", illegalCountsTendency);
		return map2;
	}

	//服务网点统计
	@Override
	public HashMap<String, Object> findServeSiteDistribute() {
		return dogMsgMapper.findServeSiteDistribute();
	}

	//收容犬只类型分布
	@Override
	public List<HashMap<String, Object>> findCollDogType() {
		return dogMsgMapper.findCollDogType();
	}
	
	//收容犬只性别分布
	@Override
	public List<HashMap<String, Object>> findCollDogSex() {
		List<HashMap<String,Object>> list = dogMsgMapper.findCollDogSex();
		for(HashMap<String,Object> map:list) {
			if(0==(Integer) map.get("name")) {
				map.replace("name", "雄");
			}else {
				map.replace("name", "雌");
			}
			
		}
		return list;
	}
	
	//收容犬只品种分布
	@Override
	public List<HashMap<String, Object>> findCollDogBreed() {
		return dogMsgMapper.findCollDogBreed();
	}

	//收容犬只数量统计
	@Override
	public HashMap<String, Object> findCollDogCounts(Integer pageNumber,Integer pageSize,Date startDate,Date endDate) {
		//map用来返回统计信息
		HashMap<String, Object>map=new HashMap<String, Object>();
		
		//map1用来添加参数
		HashMap<String, Object>map1=new HashMap<String, Object>();
			map1.put("startDate", startDate);
			map1.put("endDate", endDate);
			//页面记录数
			Integer totalRecord=dogMsgMapper.findCollDogRecord(map1);
			Page page=new Page();
				page.setPageNumber(pageNumber);
				page.setPageSize(pageSize);
				page.setTotalRecord(totalRecord);
			Integer index=page.getIndex();
		
		if(index>=0) {
			map1.put("index", index);
			map1.put("pageSize", pageSize);
			//收容犬只中的认领犬只,领养犬只,处理犬只
			List<HashMap<String,Object>> collDogCounts = dogMsgMapper.findCollDogCounts(map1);
				map.put("collDogCounts", collDogCounts);
				map.put("page", page);
		}
		
		return map;
	}

	//设备激活情况统计
	@Override
	public List<HashMap<String, Object>> findDeviceList() {
		List<HashMap<String,Object>> list1=new ArrayList<HashMap<String,Object>>();
			HashMap<String, Object>map1=new HashMap<String, Object>();
			HashMap<String, Object>map2=new HashMap<String, Object>();
		List<HashMap<String,Object>> list = dogMsgMapper.findDeviceList();
				Long a0=(long)0;
				Long a1=(long)0;
				Long a2=(long)0;
			for(HashMap<String,Object> map:list) {
				Integer a= (Integer) map.get("device_status");
				if(a==0) {
					 a0= (Long) map.get("deviceCount");
				}
				if(a==1) {
					 a1=(Long) map.get("deviceCount");
				}
				if(a==2) {
					 a2=(Long) map.get("deviceCount");
				}
			}
			Long a02=a0+a2;
				map1.put("value", a1);
				map1.put("name", "已激活");
				map2.put("value", a02);
				map2.put("name", "未激活");
				list1.add(map1);
				list1.add(map2);
		return list1;
	}

	//用户注册趋势
	@Override
	public List<HashMap<String, Object>> findRegesiterUserTendency(Date startDate, Date endDate) {
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
		return dogMsgMapper.findRegesiterUserTendency(map);
	}

	//疫苗使用情况
	@Override
	public List<HashMap<String, Object>> findVaccineCounts(Integer orgaId, String date) {
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("orgaId", orgaId);
			map.put("date", date);
		return dogMsgMapper.findVaccineCounts(map);
	}

	//看病次数统计
	@Override
	public List<HashMap<String, Object>> findTherapyCounts(Integer orgaId,Integer count) throws ParseException {
		HashMap<String,Object> map = DateUtils.getStartDateAndEndDate(count);
			map.put("orgaId", orgaId);
		return dogMsgMapper.findTherapyCounts(map);
	}

	//办证次数统计
	@Override
	public HashMap<String, Object> findCardCounts(Integer orgaId, Integer count) throws ParseException {
		HashMap<String,Object> map = DateUtils.getStartDateAndEndDate(count);
			map.put("orgaId", orgaId);
			List<HashMap<String,Object>> immuneCardCounts = dogMsgMapper.findImmuneCardCounts(map);
			List<HashMap<String,Object>> dogCardCounts = dogMsgMapper.findDogCardCounts(map);
		HashMap<String,Object> map1=new HashMap<String, Object>();
			map1.put("immuneCardCounts", immuneCardCounts);
			map1.put("dogCardCounts", dogCardCounts);
		return map1;
	}

	//在线用户趋势
	@Override
	public List<HashMap<String, Object>> findLogUserTendency(HashMap<String, Object>map) {
		return dogMsgMapper.findLogUserTendency(map);
	}

	//客户数量统计
	@Override
	public List<HashMap<String, Object>> findCustomerCounts(Integer orgaId, Integer count) throws ParseException {
		HashMap<String,Object> dateMap = DateUtils.getStartDateAndEndDate(count);
			dateMap.put("orgaId", orgaId);
		return dogMsgMapper.findCustomerCounts(dateMap);
	}

	//所有犬只统计
	@Override
	public HashMap<String, Object> findTotalCollDogCounts(Integer pageNumber, Integer pageSize, Date startDate,
			Date endDate) {
		//map用来返回统计信息
				HashMap<String, Object>map=new HashMap<String, Object>();
				
				//map1用来添加参数
				HashMap<String, Object>map1=new HashMap<String, Object>();
					map1.put("startDate", startDate);
					map1.put("endDate", endDate);
					
					//页面记录数
					Integer totalRecord=dogMsgMapper.findTotalCollDogRecords(map1);
					Page page=new Page();
						page.setPageNumber(pageNumber);
						page.setPageSize(pageSize);
						page.setTotalRecord(totalRecord);
					Integer index=page.getIndex();
				
				if(index>=0) {
					map1.put("index", index);
					map1.put("pageSize", pageSize);
					//每月收容犬只
					List<HashMap<String,Object>> totalCollDogCounts = dogMsgMapper.findTotalCollDogCounts(map1);
						map.put("totalCollDogCounts", totalCollDogCounts);
						map.put("page", page);
				}
				
				return map;
	}

	//收容犬只趋势分析
	@Override
	public HashMap<String, Object> findCollDogCountsTendency(Integer count) throws ParseException {
		HashMap<String, Object>map1=new HashMap<String, Object>();
			HashMap<String, Object> dateMap = DateUtils.getStartDateAndEndDate(count);
				List<HashMap<String,Object>> collDogCountsTendency = dogMsgMapper.findCollDogCountsTendency(dateMap);
				List<HashMap<String, Object>> totalCollDogCountsTendency = dogMsgMapper.findTotalCollDogCountsTendency(dateMap);
			map1.put("collDogCountsTendency", collDogCountsTendency);
			map1.put("totalCollDogCountsTendency", totalCollDogCountsTendency);
		return map1;
	}

	//查询昨日狗的信息 新增 注销 违法
	@Override
	public HashMap<String, Object> findYesterDayDogMsg() throws ParseException {
		String date = DateUtils.getYesterdayDate();
	HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("yesterdayAddDog", dogMsgMapper.findYesterdayAddDog(date));
		map.put("yesterdayCancelDog", dogMsgMapper.findYesterdayCancelDog(date));
		map.put("yesterdayIllegalCounts", dogMsgMapper.findYesterdayIllegalCounts(date));
		return map;
	}
	
	//查询昨日狗的信息 收容 认养 违法
	@Override
	public HashMap<String, Object> findYesterDayCollAndLeave() throws ParseException {
		String date = DateUtils.getYesterdayDate();
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("yesterdayCollDog", dogMsgMapper.findYesterdayCollDog(date));
			map.put("yesterdayLeaveDog", dogMsgMapper.findYesterdayLeaveDog(date));
			map.put("yesterdayIllegalCounts", dogMsgMapper.findYesterdayIllegalCounts(date));
			return map;
	}

	
	//收容中,已认养,已处理的犬
	@Override
	public List<HashMap<String, Object>> findCollLeaveHandelDog() throws ParseException {
		return dogMsgMapper.findCollLeaveHandelDog(DateUtils.getYesterdayDate());
	}
	
	//查看所有犬主和服务网点
	@Override
	public HashMap<String, Object> findDogOwnerAndSite() {
		HashMap<String, Object>map=new HashMap<String, Object>();
		Integer serveSite = dogMsgMapper.findAllServeSite();
		Integer dogOwner = dogMsgMapper.findAllDogOwner();
		Integer dog =dogMsgMapper.findAllDog();
		map.put("serveSite", serveSite);
		map.put("dogOwner", dogOwner);
		map.put("dog", dog);
		return map;
	}
	
	//今日预约统计
	@Override
	public List<HashMap<String, Object>> findAppointmentMsg(Long orgId) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("orgId", orgId);
			map.put("date", sdf.format(new Date()));
		return dogMsgMapper.findAppointmentMsg(map);
	}
	
	//查看宠物医院昨日统计
	@Override
	public HashMap<String, Object> findHospitalYesterdayCount(Long orgId) throws ParseException {
		HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("date",DateUtils.getYesterdayDate());
		Integer yesterdayTherapy= dogMsgMapper.findYesterdayTherapy(map);
		Integer yesterdayImmune=dogMsgMapper.findYesterdayImmune(map);
		Integer yesterdayDogCard=dogMsgMapper.findYesterdayDogCard(map);
		Integer yesterdayInjection=dogMsgMapper.findYesterdayInjection(map);
		Integer yesterdayInspection=dogMsgMapper.findYesterdayInspection(map);
		HashMap<String, Object>map2=new HashMap<String, Object>();
			map2.put("yesterdayTherapy", yesterdayTherapy);
			map2.put("yesterdayCard", yesterdayDogCard+yesterdayImmune);
			map2.put("yesterdayImmune",yesterdayInjection);
			map2.put("yesterdayInspection", yesterdayInspection);
		return map2;
	}

	//今日在线人数
	@Override
	public Integer findTodayOnlineCounts() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("date", sdf.format(new Date()));
		return dogMsgMapper.findTodayOnlineCounts(map);
	}
	
	//今日信息发布条数
	@Override
	public Integer findTodayInformationCount() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("date", sdf.format(new Date()));
		return dogMsgMapper.findTodayInformationCount(map);
	}

	@Override
	public Long findDayDeviceActiveCount(Date date) {
		return tDeviceDataMapper.findDayDeviceActiveCount(date);
	}


}
