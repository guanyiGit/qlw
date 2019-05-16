package com.soholy.dogmanager.pojo.fence;

import java.util.Date;

/**
* @ClassName: ActivityRoute
* @Description: 犬只活动行程
* @author py
* @date 2018年8月28日
*
 */
public class ActivityRoute {
	
	//活动距离
	private Double distance;
	//活动时间
	private Double time;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public ActivityRoute(Double distance, Double time, String startDate,String endDate) {
		super();
		this.distance = distance;
		this.time = time;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public ActivityRoute() {
		super();
	}
	
}
