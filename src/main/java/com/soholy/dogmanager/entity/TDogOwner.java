package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDogOwner {
    private Long dogOwnerId;

    private Long districtId;

    private String community;

    private Integer dogOwnerType;

    private String dogOwnerName;

    private String dogOwnerPhone;

    private String address;

    private Integer sex;

    private String eMail;

    private String postalCode;

    private Integer status;

    private Date creationTime;

    private Date birthDate;

    private String ethnic;

    private Integer orgId; //操作人机构id

    private Long userId; //操作人id

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDogOwnerId() {
        return dogOwnerId;
    }

    public void setDogOwnerId(Long dogOwnerId) {
        this.dogOwnerId = dogOwnerId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public Integer getDogOwnerType() {
        return dogOwnerType;
    }

    public void setDogOwnerType(Integer dogOwnerType) {
        this.dogOwnerType = dogOwnerType;
    }

    public String getDogOwnerName() {
        return dogOwnerName;
    }

    public void setDogOwnerName(String dogOwnerName) {
        this.dogOwnerName = dogOwnerName == null ? null : dogOwnerName.trim();
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getDogOwnerPhone() {
        return dogOwnerPhone;
    }

    public void setDogOwnerPhone(String dogOwnerPhone) {
        this.dogOwnerPhone = dogOwnerPhone == null ? null : dogOwnerPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}