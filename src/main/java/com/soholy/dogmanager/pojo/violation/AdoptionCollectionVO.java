package com.soholy.dogmanager.pojo.violation;

import java.io.Serializable;
import java.util.Date;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：AdoptionCollectionVO 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月24日 下午5:54:47 
* 修改人：Administrator 
* 修改时间：2018年8月24日 下午5:54:47 
* 修改备注： 
* 
*/
public class AdoptionCollectionVO extends CollectionVO{
	
	//领养公示id
	private Long adoptionPublicityId;
	 
	//发布时间
	private Date publishDate;
	
	//发布时长
	 private Integer days;

	public Long getAdoptionPublicityId() {
		return adoptionPublicityId;
	}

	public void setAdoptionPublicityId(Long adoptionPublicityId) {
		this.adoptionPublicityId = adoptionPublicityId;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "AdoptionCollectionVO [adoptionPublicityId=" + adoptionPublicityId + ", publishDate=" + publishDate
				+ ", days=" + days + "]";
	}

	
	 
	 
	
}
