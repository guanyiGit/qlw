package com.soholy.dogmanager.pojo.violation;

import java.util.Date;

public class ViolationPunishVO {
	
	//违规时间
	private Date violationDate; 
	
	//违规地点
	private String violationPlace;
	
	//违规行为
	private String dictionaryDescribe;
	
	//扣分
	private Integer points;
	
	//是否收容
	private Integer isCollection;

	public Date getViolationDate() {
		return violationDate;
	}

	public void setViolationDate(Date violationDate) {
		this.violationDate = violationDate;
	}

	public String getViolationPlace() {
		return violationPlace;
	}

	public void setViolationPlace(String violationPlace) {
		this.violationPlace = violationPlace;
	}

	public String getDictionaryDescribe() {
		return dictionaryDescribe;
	}

	public void setDictionaryDescribe(String dictionaryDescribe) {
		this.dictionaryDescribe = dictionaryDescribe;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Integer isCollection) {
		this.isCollection = isCollection;
	}

	@Override
	public String toString() {
		return "ViolationPunishVO [violationDate=" + violationDate + ", violationPlace=" + violationPlace
				+ ", dictionaryDescribe=" + dictionaryDescribe + ", points=" + points + ", isCollection=" + isCollection
				+ "]";
	} 
	
	
	

	

	

	
	
	
	
}
