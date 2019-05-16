package com.soholy.dogmanager.pojo.violation;

import java.util.Date;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：ViolationPunish2VO 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月29日 下午4:39:46 
* 修改人：Administrator 
* 修改时间：2018年8月29日 下午4:39:46 
* 修改备注： 
* 
*/
public class ViolationPunish2VO{
	
		//组织机构id
	 	private Long orgId;

	 	//犬id
	    private Long dogId;

	    //犬主id
	    private Long dogOwnerId;

	    //区域id
	    private Integer districtId;

	    //操作者id
	    private Long operatorId;
	    
		//违规时间
		//@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
		private Date violationDate;
		
		//违规地点
		private String violationPlace;
		
		//违规行为
		private Integer violationType;
		
		//扣分
		private int points;
		
		//是否收容
		private Integer isCollection;
		
		//处罚时间
		//@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
		private Date punishTime;
		
		//处罚记录
		private String remarks;

		public Long getOrgId() {
			return orgId;
		}

		public void setOrgId(Long orgId) {
			this.orgId = orgId;
		}

		public Long getDogId() {
			return dogId;
		}

		public void setDogId(Long dogId) {
			this.dogId = dogId;
		}

		public Long getDogOwnerId() {
			return dogOwnerId;
		}

		public void setDogOwnerId(Long dogOwnerId) {
			this.dogOwnerId = dogOwnerId;
		}

		public Integer getDistrictId() {
			return districtId;
		}

		public void setDistrictId(Integer districtId) {
			this.districtId = districtId;
		}

		public Long getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(Long operatorId) {
			this.operatorId = operatorId;
		}

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

		public Integer getViolationType() {
			return violationType;
		}

		public void setViolationType(Integer violationType) {
			this.violationType = violationType;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}

		public Integer getIsCollection() {
			return isCollection;
		}

		public void setIsCollection(Integer isCollection) {
			this.isCollection = isCollection;
		}

		
		public Date getPunishTime() {
			return punishTime;
		}

		public void setPunishTime(Date punishTime) {
			this.punishTime = punishTime;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		@Override
		public String toString() {
			return "ViolationPunish2VO [orgId=" + orgId + ", dogId=" + dogId + ", dogOwnerId=" + dogOwnerId
					+ ", districtId=" + districtId + ", operatorId=" + operatorId + ", violationDate=" + violationDate
					+ ", violationPlace=" + violationPlace + ", violationType=" + violationType + ", points=" + points
					+ ", isCollection=" + isCollection + ", punishTime=" + punishTime + ", remarks=" + remarks + "]";
		}

		

		

		
	    
	    
}
