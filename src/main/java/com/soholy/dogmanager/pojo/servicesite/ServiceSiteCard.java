package com.soholy.dogmanager.pojo.servicesite;

import java.util.Date;
import java.util.List;

import com.soholy.dogmanager.entity.TImages;

/**
* @ClassName: ServiceSiteCard
* @Description: 服务网点注册资质实体
* @author py
* @date 2018年8月27日
*
 */
public class ServiceSiteCard {
	
	 	private Integer petHCardId;

	    private Integer organizationId;
	    
	    private Integer cardType;
	    
	    private String cardTypeName;

	    private String petHCardNum;
	    
	    private Date startTime;

	    private Date endTime;

	    private Date creationTime;
	    
	    private List<TypeRefImages> images;
	    
		public Integer getPetHCardId() {
			return petHCardId;
		}

		public void setPetHCardId(Integer petHCardId) {
			this.petHCardId = petHCardId;
		}

		public Integer getOrganizationId() {
			return organizationId;
		}

		public void setOrganizationId(Integer organizationId) {
			this.organizationId = organizationId;
		}

		public String getCardTypeName() {
			return cardTypeName;
		}

		public void setCardTypeName(String cardTypeName) {
			this.cardTypeName = cardTypeName;
		}

		public String getPetHCardNum() {
			return petHCardNum;
		}

		public void setPetHCardNum(String petHCardNum) {
			this.petHCardNum = petHCardNum;
		}
		
		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}

		public Date getCreationTime() {
			return creationTime;
		}

		public void setCreationTime(Date creationTime) {
			this.creationTime = creationTime;
		}

		public List<TypeRefImages> getImages() {
			return images;
		}

		public void setImages(List<TypeRefImages> images) {
			this.images = images;
		}

		public Integer getCardType() {
			return cardType;
		}

		public void setCardType(Integer cardType) {
			this.cardType = cardType;
		}
		
}
