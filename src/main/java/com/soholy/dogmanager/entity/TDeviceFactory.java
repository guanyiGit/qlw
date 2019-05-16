package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDeviceFactory {
    private Integer deviceFactoryId;

    private String deviceFactoryName;

    private String deviceFactoryNum;

    private Date creationTime;

    public Integer getDeviceFactoryId() {
        return deviceFactoryId;
    }

    public void setDeviceFactoryId(Integer deviceFactoryId) {
        this.deviceFactoryId = deviceFactoryId;
    }

    public String getDeviceFactoryName() {
        return deviceFactoryName;
    }

    public void setDeviceFactoryName(String deviceFactoryName) {
        this.deviceFactoryName = deviceFactoryName == null ? null : deviceFactoryName.trim();
    }

    public String getDeviceFactoryNum() {
        return deviceFactoryNum;
    }

    public void setDeviceFactoryNum(String deviceFactoryNum) {
        this.deviceFactoryNum = deviceFactoryNum;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}