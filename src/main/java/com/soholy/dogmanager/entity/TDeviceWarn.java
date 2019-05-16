package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDeviceWarn {
    private Long deviceWarnId;

    private Long deviceId;

    private Date warnTime;

    private Double electricityVolume;

    private Date uploadTime;

    private Date creationTime;

    private Integer warnType;

    public Long getDeviceWarnId() {
        return deviceWarnId;
    }

    public void setDeviceWarnId(Long deviceWarnId) {
        this.deviceWarnId = deviceWarnId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Double getElectricityVolume() {
        return electricityVolume;
    }

    public void setElectricityVolume(Double electricityVolume) {
        this.electricityVolume = electricityVolume;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getWarnType() {
        return warnType;
    }

    public void setWarnType(Integer warnType) {
        this.warnType = warnType;
    }
}