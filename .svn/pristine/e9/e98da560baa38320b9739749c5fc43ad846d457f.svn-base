package com.soholy.dogmanager.service.fence.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soholy.dogmanager.common.map.Converter;
import com.soholy.dogmanager.common.pojo.Point;
import com.soholy.dogmanager.common.utils.MathUtils;
import com.soholy.dogmanager.entity.TDeviceData;
import com.soholy.dogmanager.mapper.TDeviceDataMapper;
import com.soholy.dogmanager.mapper.fence.DeviceRefDogMapper;
import com.soholy.dogmanager.pojo.fence.ActivityRoute;
import com.soholy.dogmanager.pojo.fence.DeviceRefDog;
import com.soholy.dogmanager.service.fence.PathService;
import com.soholy.dogmanager.utils.DateUtils;
import com.soholy.dogmanager.utils.fence.FenceUtils;

@Service
public class PathServiceImpl implements PathService {

	private static Logger logger = LoggerFactory.getLogger(FenceServiceImpl.class);

	@Autowired
	private TDeviceDataMapper dataMapper;

	@Autowired
	private DeviceRefDogMapper deviceRefDogMapper;
	
	@Value("${Maximum_time}")
	private String Maximum_time;
	
	@Value("${Maximum_distance}")
	private String Maximum_distance;
	
	@Value("${Fence_distance}")
	private String Fence_distance;
	
	
	@Override
	public List<TDeviceData> getPathByDate(Long deviceId, String date) throws Exception {
		try {
			List<TDeviceData> list = dataMapper.selectDeviceDatasByDate(deviceId, date);
			//经纬度转高德坐标
			List<TDeviceData> GD_List = new ArrayList<>();
			for (TDeviceData tDeviceData : list) {
				tDeviceData = this.toGCJ_02(tDeviceData);
				GD_List.add(tDeviceData);
			}
			return GD_List;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<TDeviceData> getPathByTimes(Long deviceId,String date, String startTime, String endTime) {
		try {
			if (date == null) {
				// 将时间转换成yyyy-MM-dd格式
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				date = dateFormat.format(new Date());
			}
			if (startTime == null || endTime.equals("")) {
				// 默认从8点开始查询
				startTime = date+" 08:00";
			}else {
				startTime = date+" "+startTime;
			}
			if (endTime == null || endTime.equals("")) {
				//默认从23点59分位置
				endTime = date+" 23:59";
			}else {
				endTime = date+" "+endTime;
			}
			List<TDeviceData> list = dataMapper.selectDeviceDatasByTimes(deviceId, startTime, endTime);
			//转换坐标后的list
			List<TDeviceData> newDevicedataList = new ArrayList<>();
			for (TDeviceData tDeviceData : list) {
				if(tDeviceData.getLatitude()== null || tDeviceData.getLatitude() ==0 || tDeviceData.getLongitude()== null || tDeviceData.getLongitude() ==0 ){
					continue;
				}
				TDeviceData newDevicedata = this.toGCJ_02(tDeviceData);
				newDevicedataList.add(newDevicedata);
			}
			return newDevicedataList;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}
	
	
	
	@Override
	public TDeviceData selectNearDateByDate(Long deviceId, Date date) {
		try {
			String nowString= null;
			// 将时间转换成yyyy-MM-dd格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(date != null){
				// 将当前时间转换成yyyy-MM-dd格式
				 nowString = dateFormat.format(date);
			}
			// 根据nowString查询数据列表
			List<TDeviceData> datas = dataMapper.selectDeviceDatasByDate(deviceId, nowString);
			//如果当前时间没有数据，获取前一天数据
			if(datas==null||datas.size()==0){
				Date beforeDate = DateUtils.getBeforeDate(date);
				String yesterdayes = dateFormat.format(beforeDate);
				datas = dataMapper.selectDeviceDatasByDate(deviceId, yesterdayes);
			}
			
			//获取最近时间，即list最后的一个数据
			TDeviceData minData = datas.get(datas.size()-1);// 最近时间的数据
			
//			// 初始化最近时间，默认为datas第一个元素
//			Long minDate = date.getTime() - datas.get(0).getCreationTime().getTime();
//			int min = 0;
//			for (int i = 0; i < datas.size(); i++) {
//				Long diff = date.getTime() - datas.get(i).getCreationTime().getTime();
//				if (diff <= minDate) {
//					minDate = diff;
//					min = i;
//				}
//			}
//			TDeviceData minData = datas.get(min);// 最近时间的数据
			//将坐标转成GCJ-02坐标
			TDeviceData newDevicedata = this.toGCJ_02(minData);
			return newDevicedata;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ActivityRoute getDistanceAndTime(Long deviceId, String date, String startTime, String endTime) {
		try {
			if (date == null) {
				// 将时间转换成yyyy-MM-dd格式
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				date = dateFormat.format(new Date());
			}
			if (startTime == null || endTime.equals("")) {
				// 默认从8点开始查询
				startTime = date+" 08:00";
			}
			if (endTime == null || endTime.equals("")) {
				//默认从23点59分位置
				endTime = date+" 23:59";
			}
			// 通过deviceId和时间获取当天所有设备上传数据(按设备产生时间排序)
			List<TDeviceData> deviceDatas = this.getPathByTimes(deviceId, date, startTime, endTime);
			if (deviceDatas == null || deviceDatas.size() == 0) {
				throw new Exception();
			}
			ActivityRoute activityRoute = new ActivityRoute();
			// 距离(千米)
			Double distance = 0.0;
			// 时间(分钟)
			Double time = 0.0;

			for (int i = 0; i < deviceDatas.size(); i++) {
				if (i == deviceDatas.size() - 1) {
					break;
				}
				// 第一个点坐标
				TDeviceData deviceData1 = deviceDatas.get(i);
				// 第二个点坐标
				TDeviceData deviceData2 = deviceDatas.get(i + 1);
				// 获取两个坐标相隔时间(毫秒)
				Double dateDiff = FenceUtils.dateDiff(deviceData1.getDataTime(), deviceData2.getDataTime());
				
				if (dateDiff < (Double.parseDouble(Maximum_time))*60*1000) {
					// 获取两点之间距离(单位：米)
					Double getDistance = FenceUtils.getDistance(deviceData1.getLatitude().doubleValue(),
							deviceData1.getLongitude().doubleValue(), deviceData2.getLatitude().doubleValue(),
							deviceData2.getLongitude().doubleValue());
					// 如果两个点之间距离小于最大间隔距离
					if (getDistance <= Double.parseDouble(Maximum_distance)) {
						distance += getDistance/1000;
						time += dateDiff/1000/60/60;
					}
				}
			}
			activityRoute.setDistance(MathUtils.getRound(distance));
			activityRoute.setTime(MathUtils.getRound(time));
			activityRoute.setStartDate(startTime);
			activityRoute.setEndDate(endTime);
			return activityRoute;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<DeviceRefDog> getDogsPosition(Double ALon, Double ALat, String nowDate) {
		ArrayList<DeviceRefDog> deviceRefDogs = new ArrayList<DeviceRefDog>();
		try {
			// 将时间转换成yyyy-MM-dd hh:mm:ss格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date now = dateFormat.parse(nowDate);
			// 将时间转换成yyyy-MM-dd格式
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			// 将当前时间转换成yyyy-MM-dd格式
			String nowString = dateFormat2.format(now);

			Map<Long, List<TDeviceData>> daviceMap = new HashMap<Long, List<TDeviceData>>();

			List<TDeviceData> datasByDates = dataMapper.getDeviceDatasByDate(nowString);
			// 根据设备id对数据进行分组
			for (TDeviceData tDeviceData : datasByDates) {
				List<TDeviceData> datalist = daviceMap.get(tDeviceData.getDeviceId());
				if (datalist == null || datalist.size() == 0) {
					datalist = new ArrayList<>();
					datalist.add(tDeviceData);
					daviceMap.put(tDeviceData.getDeviceId(), datalist);
				} else {
					datalist.add(tDeviceData);
				}
			}
			// 遍历map
			for (Long deviceId : daviceMap.keySet()) {
				List<TDeviceData> datalist = daviceMap.get(deviceId);
				// 获取距离now时间最近的数据
				// 初始化最近时间，默认为datas第一个元素
				Long minDate = now.getTime() - datalist.get(0).getCreationTime().getTime();
				Integer min = 0;
				for (Integer i = 0; i < datalist.size(); i++) {
					Long diff = now.getTime() - datalist.get(i).getCreationTime().getTime();
					if (diff <= minDate) {
						minDate = diff;
						min = i;
					}
				}
				
				if (StringUtils.isNotBlank(Maximum_time)) {
					Double temp = Double.parseDouble(Maximum_time) * 60 * 1000;
					// 判断当前时间是否大于十五分钟
					if (minDate < temp) {
						TDeviceData deviceData = datalist.get(min);// 最近时间的数据
						//将坐标转为高德坐标
						deviceData = this.toGCJ_02(deviceData);
						DeviceRefDog deviceRefDog = deviceRefDogMapper.selectDogInfoByDeviceId(deviceData.getDeviceId());
						deviceRefDog.setLongitude(deviceData.getLongitude().doubleValue());
						deviceRefDog.setLatitude(deviceData.getLatitude().doubleValue());
						deviceRefDogs.add(deviceRefDog);
					}
				}
			}
			return deviceRefDogs;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}
	
	private TDeviceData toGCJ_02(TDeviceData deviceData){
		try {
			//将坐标转成GCJ-02坐标
			List<Point> points = new ArrayList<Point>();
			//获取point坐标
			Point point = new Point(deviceData.getLongitude().doubleValue(),deviceData.getLatitude().doubleValue());
			points.add(point);
			List<Point> gcj_02_points = Converter.WGS_84GCJ_02(points);
			for (Point point2 : gcj_02_points) {
				deviceData.setLongitude(point2.getLongitude().floatValue());
				deviceData.setLatitude(point2.getLatitude().floatValue());
			}
			return deviceData;
		} catch (Exception e) {
			return null;
		}
	}
	
}
