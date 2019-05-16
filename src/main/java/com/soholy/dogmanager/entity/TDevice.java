package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDevice {
    private Long deviceId;

    private String deviceNumber;

    private Integer deviceStatus;

    private Date startTime;

    private String deviceBrand;

    private Integer deviceModelId;

    private Date productionTime;

    private String deviceRemarks;

    private Integer deviceType;

    private Date creationTime;

    private Integer orgId;

    private Integer deviceWorkPattern;

    private Integer uploadIntervalTime;

    private String imei;

    private String devicePwd;

    private Integer deviceFactoryId;

    private String deviceName;

    private String verifyCode;

    private String psk;

    private String deviceBatch;

    private String deviceIdIot;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber == null ? null : deviceNumber.trim();
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand == null ? null : deviceBrand.trim();
    }

    public Integer getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(Integer deviceModelId) {
        this.deviceModelId = deviceModelId;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getDeviceRemarks() {
        return deviceRemarks;
    }

    public void setDeviceRemarks(String deviceRemarks) {
        this.deviceRemarks = deviceRemarks == null ? null : deviceRemarks.trim();
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getDeviceWorkPattern() {
        return deviceWorkPattern;
    }

    public void setDeviceWorkPattern(Integer deviceWorkPattern) {
        this.deviceWorkPattern = deviceWorkPattern;
    }

    public Integer getUploadIntervalTime() {
        return uploadIntervalTime;
    }

    public void setUploadIntervalTime(Integer uploadIntervalTime) {
        this.uploadIntervalTime = uploadIntervalTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Integer getDeviceFactoryId() {
        return deviceFactoryId;
    }

    public void setDeviceFactoryId(Integer deviceFactoryId) {
        this.deviceFactoryId = deviceFactoryId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    public String getPsk() {
        return psk;
    }

    public void setPsk(String psk) {
        this.psk = psk == null ? null : psk.trim();
    }

    public String getDeviceBatch() {
        return deviceBatch;
    }

    public void setDeviceBatch(String deviceBatch) {
        this.deviceBatch = deviceBatch == null ? null : deviceBatch.trim();
    }

    public String getDeviceIdIot() {
        return deviceIdIot;
    }

    public void setDeviceIdIot(String deviceIdIot) {
        this.deviceIdIot = deviceIdIot == null ? null : deviceIdIot.trim();
    }

    public String getDevicePwd() {
        return devicePwd;
    }

    public void setDevicePwd(String devicePwd) {
        this.devicePwd = devicePwd;
    }
}