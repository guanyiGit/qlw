package com.soholy.dogmanager.service.fence;

import java.util.Date;
import java.util.List;

import com.soholy.dogmanager.entity.TDeviceData;
import com.soholy.dogmanager.pojo.fence.ActivityRoute;
import com.soholy.dogmanager.pojo.fence.DeviceRefDog;

/**
* @ClassName: PathService
* @Description:犬只轨迹
* @author py
* @date 2018年8月23日
*
 */
public interface PathService {
	
	 /**
		 * @Description: 根据时间获取当天活动轨迹
		 * @Title: getPathByDate  
		 * @param date 格式:yyyy-MM-dd
		 * @param @return
		 * @param @throws Exception    
		 * @return List<Map<String,BigDecimal>>     
		 * @throws
		  */
		 List<TDeviceData> getPathByDate(Long deviceId,String date)throws Exception;
		 
		 /**
		 * @Description: 根据时间段获取活动轨迹
		 * @Title: getPathByTimes  
		 * @param startTime 格式:yyyy-MM-dd
		 * @param endTime   格式:yyyy-MM-dd
		 * @param @return
		 * @param @throws Exception    
		 * @return List<Map<String,BigDecimal>>     
		 * @throws
		  */
		 List<TDeviceData> getPathByTimes(Long deviceId,String date,String startTime,String endTime)throws Exception;
		 
		 /**
		 * @Description: 根据当前时间获取离当前时间最近的数据(犬主获取犬只位置)
		 * @param deviceId
		 * @param nowDate
		 * @return（展示方法参数和返回值）
		  */
		 TDeviceData selectNearDateByDate(Long deviceId,Date date)throws Exception;
		 
		 /**
		  * 
		 * @Description 获取犬只当天的活动时间和活动里程
		 * @Title getDistanceAndTime  
		 * @param  deviceId
		 * @param  date  <格式 yyyy-MM-dd>
		 * @return ActivityRoute     
		 * @throws Exception
		  */
		 ActivityRoute getDistanceAndTime(Long deviceId,String date,String startTime,String endTime)throws Exception;
		 
		 /**
		  * 
		 * @Description: 执法人员获取附近所有犬只位置(距离自定)
		 * @param ALon	经度
		 * @param ALat	纬度
		 * @param date  <格式> yyyy-MM-dd HH:mm:ss
		 * @return（展示方法参数和返回值）
		  */
		 List<DeviceRefDog> getDogsPosition(Double ALon, Double ALat,String nowDate)throws Exception;
		
		 
		 
		 
}
