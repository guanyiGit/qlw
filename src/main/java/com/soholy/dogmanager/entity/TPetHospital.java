package com.soholy.dogmanager.entity;

import java.util.Date;

public class TPetHospital {
    private Integer petHCardId;

    private Integer organizationId;

    private Integer petHCardType;

    private String petHCardNum;

    private Date startTime;

    private Date endTime;

    private Date creationTime;

    public Integer getPetHCardId() {
        return petHCardId;
    }

    public void setPetHCardId(Integer petHCardId) {
        this.petHCardId = petHCardId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPetHCardType() {
        return petHCardType;
    }

    public void setPetHCardType(Integer petHCardType) {
        this.petHCardType = petHCardType;
    }

    public String getPetHCardNum() {
        return petHCardNum;
    }

    public void setPetHCardNum(String petHCardNum) {
        this.petHCardNum = petHCardNum == null ? null : petHCardNum.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}