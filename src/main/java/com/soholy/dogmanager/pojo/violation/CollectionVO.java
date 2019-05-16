package com.soholy.dogmanager.pojo.violation;

import java.io.Serializable;
import java.util.Date;


/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：CollectionVO 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月24日 上午10:37:01 
* 修改人：Administrator 
* 修改时间：2018年8月24日 上午10:37:01 
* 修改备注： 
* 
*/
public class CollectionVO{
	
	//收容id
	private Long collectionId;

	//狗id
    private Long dogId;
	 
    //犬只编号
	 private String dogCode;
	 
	 //犬舍编号
	 private String doghouseNum;
	 
	 //标识牌号
	 private String signboardCode;
	 
	 //犬只名称
	 private String dogName;
	 
	 //品种
	 private String dogBreed;
	 
	 //性别
	 private Integer dogGender;
	 
	 //犬龄
	 private Integer dogAge;
	 
	 //毛色
	 private String dogColor;
	 
	 //体重
	 private Double weight;
	 
	 //特点
	 private String dogCharacter;
	 
	 //健康状况
	 private Integer healthStatus;
	 
	 //收容原因
	 private String collDogReason;
	 
	 //收容时间
	 private Date collectionTime;
	 
	 //收容备注
	 private String remarks;
	 
	 //图片
	 private String thumbnailUrl;
	 
	 //公示id
	 private Long adoptionPublicityId;
	 
	 

	public Long getAdoptionPublicityId() {
		return adoptionPublicityId;
	}

	public void setAdoptionPublicityId(Long adoptionPublicityId) {
		this.adoptionPublicityId = adoptionPublicityId;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}

	public String getDogCode() {
		return dogCode;
	}

	public void setDogCode(String dogCode) {
		this.dogCode = dogCode;
	}

	public String getDoghouseNum() {
		return doghouseNum;
	}

	public void setDoghouseNum(String doghouseNum) {
		this.doghouseNum = doghouseNum;
	}

	public String getSignboardCode() {
		return signboardCode;
	}

	public void setSignboardCode(String signboardCode) {
		this.signboardCode = signboardCode;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	public Integer getDogGender() {
		return dogGender;
	}

	public void setDogGender(Integer dogGender) {
		this.dogGender = dogGender;
	}

	public Integer getDogAge() {
		return dogAge;
	}

	public void setDogAge(Integer dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogColor() {
		return dogColor;
	}

	public void setDogColor(String dogColor) {
		this.dogColor = dogColor;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDogCharacter() {
		return dogCharacter;
	}

	public void setDogCharacter(String dogCharacter) {
		this.dogCharacter = dogCharacter;
	}

	public Integer getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getCollDogReason() {
		return collDogReason;
	}

	public void setCollDogReason(String collDogReason) {
		this.collDogReason = collDogReason;
	}

	public Date getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public String toString() {
		return "CollectionVO [collectionId=" + collectionId + ", dogId=" + dogId + ", dogCode=" + dogCode
				+ ", doghouseNum=" + doghouseNum + ", signboardCode=" + signboardCode + ", dogName=" + dogName
				+ ", dogBreed=" + dogBreed + ", dogGender=" + dogGender + ", dogAge=" + dogAge + ", dogColor="
				+ dogColor + ", weight=" + weight + ", dogCharacter=" + dogCharacter + ", healthStatus=" + healthStatus
				+ ", collDogReason=" + collDogReason + ", collectionTime=" + collectionTime + ", remarks=" + remarks
				+ ", thumbnailUrl=" + thumbnailUrl + ", adoptionPublicityId=" + adoptionPublicityId + "]";
	}



	
	
	
	
}
