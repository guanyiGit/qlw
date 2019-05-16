package com.soholy.dogmanager.entity.statistic;

import com.soholy.dogmanager.entity.TDistrict;
import com.soholy.dogmanager.entity.TDogOwner;
import com.soholy.dogmanager.entity.TDogOwnerCard;

public class DogOwner extends TDogOwner {
	private TDistrict tDistrict;//区域
	private TDogOwnerCard tDogOwnerCard;//犬主证
	
	public TDistrict gettDistrict() {
		return tDistrict;
	}
	public void settDistrict(TDistrict tDistrict) {
		this.tDistrict = tDistrict;
	}
	public TDogOwnerCard gettDogOwnerCard() {
		return tDogOwnerCard;
	}
	public void settDogOwnerCard(TDogOwnerCard tDogOwnerCard) {
		this.tDogOwnerCard = tDogOwnerCard;
	}
}
