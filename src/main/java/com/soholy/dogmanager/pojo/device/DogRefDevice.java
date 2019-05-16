package com.soholy.dogmanager.pojo.device;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDogInfo;

public class DogRefDevice extends TDogInfo{
	
	private	TDevice device;

	public TDevice getDevice() {
		return device;
	}

	public void setDevice(TDevice device) {
		this.device = device;
	}
	
	
	
}
