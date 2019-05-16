package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDistrict {
    private Integer districtId;

    private Integer districtType;

    private String districtName;

    private Integer parentId;

    private String districtLevStatus;

    private Date creationTime;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictType() {
        return districtType;
    }

    public void setDistrictType(Integer districtType) {
        this.districtType = districtType;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDistrictLevStatus() {
        return districtLevStatus;
    }

    public void setDistrictLevStatus(String districtLevStatus) {
        this.districtLevStatus = districtLevStatus == null ? null : districtLevStatus.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}