package com.soholy.dogmanager.pojo.violation;

import java.util.Date;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：ViolationPunish3VO 
* 类描述： 最近扣分
* 创建人：YL
* 创建时间：2018年8月29日 下午7:21:20 
* 修改人：Administrator 
* 修改时间：2018年8月29日 下午7:21:20 
* 修改备注： 
* 
*/
public class ViolationPunish4VO {
	
	private Integer points;
	private Date punishTime;
	private String dogName;
	private String violationType;
	
	
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Date getPunishTime() {
		return punishTime;
	}
	public void setPunishTime(Date punishTime) {
		this.punishTime = punishTime;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getViolationType() {
		return violationType;
	}
	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}
	
	
	
	    
	    
	    
	    

}
