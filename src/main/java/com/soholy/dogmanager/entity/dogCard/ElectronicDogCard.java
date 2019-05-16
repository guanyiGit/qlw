package com.soholy.dogmanager.entity.dogCard;

import java.io.Serializable;
import java.util.Date;

public class ElectronicDogCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dogCardNum;//犬证号
    private String markNum;//标示号/设备编号
    private String dogVarieties;//品种
    private Integer gender;//性别
    private String color;//毛色
    private Date yearCheckDate;//年检时间
    private String dogOwnersName;//犬主姓名
    private String phone;//
    private String address;//养犬地址
    private String issuanceUnit;//签发单位
    private Date startDate;//初始签发日期
    private String dogUrl;//犬图
    private Integer dogCradStatus;//犬证状态 0已禁用，1启用/审核通过，2,已过期，3注销，4待审核，5审核不通过

    public String getDogCardNum() {
        return dogCardNum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDogCradStatus() {
        return dogCradStatus;
    }

    public void setDogCradStatus(Integer dogCradStatus) {
        this.dogCradStatus = dogCradStatus;
    }

    public void setDogCardNum(String dogCardNum) {
        this.dogCardNum = dogCardNum;
    }

    public String getMarkNum() {
        return markNum;
    }

    public void setMarkNum(String markNum) {
        this.markNum = markNum;
    }

    public String getDogVarieties() {
        return dogVarieties;
    }

    public void setDogVarieties(String dogVarieties) {
        this.dogVarieties = dogVarieties;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYearCheckDate() {
        return yearCheckDate;
    }

    public void setYearCheckDate(Date yearCheckDate) {
        this.yearCheckDate = yearCheckDate;
    }

    public String getDogOwnersName() {
        return dogOwnersName;
    }

    public void setDogOwnersName(String dogOwnersName) {
        this.dogOwnersName = dogOwnersName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIssuanceUnit() {
        return issuanceUnit;
    }

    public void setIssuanceUnit(String issuanceUnit) {
        this.issuanceUnit = issuanceUnit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDogUrl() {
        return dogUrl;
    }

    public void setDogUrl(String dogUrl) {
        this.dogUrl = dogUrl;
    }

    @Override
    public String toString() {
        return "ElectronicDogCard{" +
                "dogCardNum='" + dogCardNum + '\'' +
                ", markNum='" + markNum + '\'' +
                ", dogVarieties='" + dogVarieties + '\'' +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                ", yearCheckDate=" + yearCheckDate +
                ", dogOwnersName='" + dogOwnersName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", issuanceUnit='" + issuanceUnit + '\'' +
                ", startDate=" + startDate +
                ", dogUrl='" + dogUrl + '\'' +
                '}';
    }
}
