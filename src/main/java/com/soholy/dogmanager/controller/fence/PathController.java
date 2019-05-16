package com.soholy.dogmanager.controller.fence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TDeviceData;
import com.soholy.dogmanager.pojo.fence.ActivityRoute;
import com.soholy.dogmanager.pojo.fence.DeviceRefDog;
import com.soholy.dogmanager.service.fence.PathService;

@Controller
@RequestMapping("/biz/path")
public class PathController {
	
	@Autowired
	private PathService pathService;
	
	/**
	* @Description: 获取轨迹坐标集合
	* @param deviceId
	* @param startTime
	* @param endTime
	* @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/path/getPath")
	@RequestMapping(value = "/getPath", method = RequestMethod.POST)
	@ResponseBody
	public DogResult getPath(Long deviceId,String date, String startTime,String endTime){
		try {
			List<TDeviceData> pathByTimes = pathService.getPathByTimes(deviceId, date, startTime, endTime);
			return DogResult.ok(pathByTimes);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
	
	/**
	* @Description: 获取当天犬只获取时间以及里程
	* @param deviceId
	* @param startTime
	* @param endTime
	* @return（展示方法参数和返回值）
	 */
	/*@RequiresPermissions("/path/getDistanceAndTime")*/
	@RequestMapping(value = "/getDistanceAndTime", method = RequestMethod.POST)
	@ResponseBody
	public DogResult getDistanceAndTime(Long deviceId,String date, String startTime,String endTime){
		try {
			ActivityRoute activityRoute = pathService.getDistanceAndTime(deviceId, date, startTime, endTime);
			return DogResult.ok(activityRoute);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
	/**
	* @Description:执法人员获取附近所有犬只坐标
	* @param ALon
	* @param ALat
	* @param nowDate
	* @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/path/getDogsPosition")
	@RequestMapping(value = "/getDogsPosition", method = RequestMethod.POST)
	@ResponseBody
	public DogResult getDogsPosition(Double ALon, Double ALat,String nowDate){
		try {
			List<DeviceRefDog> dogsPosition = pathService.getDogsPosition(ALon, ALat, nowDate);
			return DogResult.ok(dogsPosition);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
	/**
	* @Description:获取犬只当前位置
	* @param deviceId
	* @return（展示方法参数和返回值）
	 */
	@RequiresPermissions("/path/getDogLocation")
	@RequestMapping(value = "/getDogLocation", method = RequestMethod.POST)
	@ResponseBody
	public DogResult getDogLocation(Long deviceId){
		try {
			//TDeviceData deviceData = pathService.selectNearDateByDate(deviceId,dateFormat.parse(nowdate));
			TDeviceData deviceData = pathService.selectNearDateByDate(deviceId, null);
			return DogResult.ok(deviceData);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
}
