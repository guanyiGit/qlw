package com.soholy.dogmanager.entity.statistic;

import java.util.List;

import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.entity.TDogCard;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.TImages;
import com.soholy.dogmanager.entity.TTherapy;

public class DogInfo extends TDogInfo{
	
	private List<TTherapy> tTherapyList;//1对n病历记录
	private DogOwner dogOwner;//1对1犬主
	private DogImmune dogImmune;//一对一关联免疫证
	private TDogCard tDogCard;//一对一关联犬证
	private TDictionary dogBreedDictionary;//1对1关联字典表
	private TDictionary dogColorDictionary;//1对1关联字典表
	private List<TImages>imageList;//1对n关联图片
	private Integer ownerOrgId;//犬主登记机构id
	
	
	public List<TImages> getImageList() {
		return imageList;
	}
	public void setImageList(List<TImages> imageList) {
		this.imageList = imageList;
	}
	public TDictionary getDogBreedDictionary() {
		return dogBreedDictionary;
	}
	public void setDogBreedDictionary(TDictionary dogBreedDictionary) {
		this.dogBreedDictionary = dogBreedDictionary;
	}
	public TDictionary getDogColorDictionary() {
		return dogColorDictionary;
	}
	public void setDogColorDictionary(TDictionary dogColorDictionary) {
		this.dogColorDictionary = dogColorDictionary;
	}
	public TDogCard gettDogCard() {
		return tDogCard;
	}
	public void settDogCard(TDogCard tDogCard) {
		this.tDogCard = tDogCard;
	}
	public List<TTherapy> gettTherapyList() {
		return tTherapyList;
	}
	public void settTherapyList(List<TTherapy> tTherapyList) {
		this.tTherapyList = tTherapyList;
	}
	public DogImmune getDogImmune() {
		return dogImmune;
	}
	public void setDogImmune(DogImmune dogImmune) {
		this.dogImmune = dogImmune;
	}
	public DogOwner getDogOwner() {
		return dogOwner;
	}
	public void setDogOwner(DogOwner dogOwner) {
		this.dogOwner = dogOwner;
	}

	public Integer getOwnerOrgId() {
		return ownerOrgId;
	}

	public void setOwnerOrgId(Integer ownerOrgId) {
		this.ownerOrgId = ownerOrgId;
	}
}
