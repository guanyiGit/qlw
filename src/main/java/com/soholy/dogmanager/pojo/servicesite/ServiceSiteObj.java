package com.soholy.dogmanager.pojo.servicesite;

import java.util.List;

import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TPetHospital;

public class ServiceSiteObj extends TOrganization{

	private	List<TPetHospital> petHospitals;
	
	public List<TPetHospital> getPetHospitals() {
		return petHospitals;
	}

	public void setPetHospitals(List<TPetHospital> petHospitals) {
		this.petHospitals = petHospitals;
	}

}
