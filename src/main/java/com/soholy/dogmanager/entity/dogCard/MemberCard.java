package com.soholy.dogmanager.entity.dogCard;

import com.soholy.dogmanager.entity.TMemberCard;

import java.io.Serializable;

//会员证详情
public class MemberCard extends TMemberCard implements Serializable {
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "MemberCard{" +
                "orgName='" + orgName + '\'' +
                '}';
    }
}
