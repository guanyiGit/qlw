package com.soholy.dogmanager.pojo.violation;

import com.soholy.dogmanager.entity.TImages;
import com.soholy.dogmanager.entity.TPunish;
import com.soholy.dogmanager.entity.TViolation;

public class ViolationInfoVO extends TViolation{
	
	private TPunish punish;//处罚记录
	private TImages images;
	private DogInfoVO dogInfoVO;//犬信息
	
	public TImages getImages() {
		return images;
	}
	public void setImages(TImages images) {
		this.images = images;
	}
	public TPunish getPunish() {
		return punish;
	}
	public void setPunish(TPunish punish) {
		this.punish = punish;
	}
	public DogInfoVO getDogInfoVO() {
		return dogInfoVO;
	}
	public void setDogInfoVO(DogInfoVO dogInfoVO) {
		this.dogInfoVO = dogInfoVO;
	}
	
	
	
	
	
	
}
