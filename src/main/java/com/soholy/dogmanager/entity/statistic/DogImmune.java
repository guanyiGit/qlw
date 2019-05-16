package com.soholy.dogmanager.entity.statistic;

import com.soholy.dogmanager.entity.TImmuneCard;
import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TUsers;

public class DogImmune extends TImmuneCard {
	private TOrganization tOrganization;//一对一关联机构
	private TUsers tTUsers;//一对一用户
	public TOrganization gettOrganization() {
		return tOrganization;
	}
	public void settOrganization(TOrganization tOrganization) {
		this.tOrganization = tOrganization;
	}
	public TUsers gettTUsers() {
		return tTUsers;
	}
	public void settTUsers(TUsers tTUsers) {
		this.tTUsers = tTUsers;
	}
	
}
