package com.soholy.dogmanager.pojo.violation;

/** 
* 
* 项目名称：manager-dogs 
* 类名称：PublishVO 
* 类描述： 
* 创建人：YL
* 创建时间：2018年9月18日 上午10:26:54 
* 修改人：Administrator 
* 修改时间：2018年9月18日 上午10:26:54 
* 修改备注： 
* 
*/
public class PublishVO {
	private Long collectionId;
	private Long adoptionPublicityId;
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	public Long getAdoptionPublicityId() {
		return adoptionPublicityId;
	}
	public void setAdoptionPublicityId(Long adoptionPublicityId) {
		this.adoptionPublicityId = adoptionPublicityId;
	}
	@Override
	public String toString() {
		return "PublishVO [collectionId=" + collectionId + ", adoptionPublicityId=" + adoptionPublicityId + "]";
	}
	
	
	
	

}
