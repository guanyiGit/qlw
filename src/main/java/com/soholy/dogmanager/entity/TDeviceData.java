package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDeviceData {
    private String deviceDateId;

    private Long deviceId;

    private Float longitude;

    private Float latitude;

    private Double electricityVolume;

    private Date dataTime;

    private Integer dataType;

    private Date creationTime;

    public String getDeviceDateId() {
        return deviceDateId;
    }

    public void setDeviceDateId(String deviceDateId) {
        this.deviceDateId = deviceDateId == null ? null : deviceDateId.trim();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Double getElectricityVolume() {
        return electricityVolume;
    }

    public void setElectricityVolume(Double electricityVolume) {
        this.electricityVolume = electricityVolume;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}