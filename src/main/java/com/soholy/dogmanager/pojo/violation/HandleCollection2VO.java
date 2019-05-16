package com.soholy.dogmanager.pojo.violation;

import java.util.Date;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：HandleCollection2VO 
* 类描述： 认领处理vo
* 创建人：YL
* 创建时间：2018年8月30日 下午3:52:59 
* 修改人：Administrator 
* 修改时间：2018年8月30日 下午3:52:59 
* 修改备注： 
* 
*/
public class HandleCollection2VO extends CollectionVO {
	
		//处理id
		private Long handleId;
	
		//认领人
	    private String claimName;
	    
	    //电话
	    private String phone;
	   
	    //证件编码
	    private String cardNum;

	    //处理原因
	    private String handleReason;

	    //处理时间
	    private Date handleTime;

	    //证件类型
	    private Integer cardType;

	    //认领备注
	    private String remark;

	   //养犬地址
	    private String adress;

	    //处理方式
	    private String handleWay;
	    
	    
		public Long getHandleId() {
			return handleId;
		}

		public void setHandleId(Long handleId) {
			this.handleId = handleId;
		}

		public String getClaimName() {
			return claimName;
		}

		public void setClaimName(String claimName) {
			this.claimName = claimName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCardNum() {
			return cardNum;
		}

		public void setCardNum(String cardNum) {
			this.cardNum = cardNum;
		}

		public String getHandleReason() {
			return handleReason;
		}

		public void setHandleReason(String handleReason) {
			this.handleReason = handleReason;
		}

		public Date getHandleTime() {
			return handleTime;
		}

		public void setHandleTime(Date handleTime) {
			this.handleTime = handleTime;
		}

		public Integer getCardType() {
			return cardType;
		}

		public void setCardType(Integer cardType) {
			this.cardType = cardType;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}

		public String getHandleWay() {
			return handleWay;
		}

		public void setHandleWay(String handleWay) {
			this.handleWay = handleWay;
		}
	    
	    
	    
	    
}
