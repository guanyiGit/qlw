package com.soholy.dogmanager.entity.dogCard;


import java.io.Serializable;
import java.util.Date;

//犬证列表每条的信息
public class DogCardRelatedInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long seqNum;//犬证id

    private String dogCardNum;//犬证编号

    private String immuneCardId;//免疫id

    private String immuneCardNum;//免疫证号

    private String address;//地址

    private Integer dogAge;//犬龄

    private Integer gender;//犬性别

    private String color;//毛色

    private Long dogId;//犬id

    private String dogName;//犬名

    private String dogVarieties;//犬只品种

    private Long dogOwnerId;//犬主id

    private String dogOwnerName;//犬主姓名

    private String dogOwnerPhone;//犬主电话

    private Date applyTime;//犬证申请时间

    private Date lssueTime;//犬证签发时间

    private Integer lssueOrgId;//发证机构id

    private String lssueOrgName;//发证机构名称

    private Long lssuerId;//签发人，办理人id

    private String lssuerName;//签发人，办理人名字

    private Integer status;//犬证状态

    private Date yearsCheckDate;//年检时间

    private Integer yearsCheckResult;//年检结果

    private Date nextYearsCheckDate;//下次年检时间

    private String note;//年检备注

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public String getDogCardNum() {
        return dogCardNum;
    }

    public void setDogCardNum(String dogCardNum) {
        this.dogCardNum = dogCardNum;
    }

    public String getImmuneCardId() {
        return immuneCardId;
    }

    public void setImmuneCardId(String immuneCardId) {
        this.immuneCardId = immuneCardId;
    }

    public String getImmuneCardNum() {
        return immuneCardNum;
    }

    public void setImmuneCardNum(String immuneCardNum) {
        this.immuneCardNum = immuneCardNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
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

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogVarieties() {
        return dogVarieties;
    }

    public void setDogVarieties(String dogVarieties) {
        this.dogVarieties = dogVarieties;
    }

    public Long getDogOwnerId() {
        return dogOwnerId;
    }

    public void setDogOwnerId(Long dogOwnerId) {
        this.dogOwnerId = dogOwnerId;
    }

    public String getDogOwnerName() {
        return dogOwnerName;
    }

    public void setDogOwnerName(String dogOwnerName) {
        this.dogOwnerName = dogOwnerName;
    }

    public String getDogOwnerPhone() {
        return dogOwnerPhone;
    }

    public void setDogOwnerPhone(String dogOwnerPhone) {
        this.dogOwnerPhone = dogOwnerPhone;
    }

    public Date getLssueTime() {
        return lssueTime;
    }

    public void setLssueTime(Date lssueTime) {
        this.lssueTime = lssueTime;
    }

    public Integer getLssueOrgId() {
        return lssueOrgId;
    }

    public void setLssueOrgId(Integer lssueOrgId) {
        this.lssueOrgId = lssueOrgId;
    }

    public String getLssueOrgName() {
        return lssueOrgName;
    }

    public void setLssueOrgName(String lssueOrgName) {
        this.lssueOrgName = lssueOrgName;
    }

    public Long getLssuerId() {
        return lssuerId;
    }

    public void setLssuerId(Long lssuerId) {
        this.lssuerId = lssuerId;
    }

    public String getLssuerName() {
        return lssuerName;
    }

    public void setLssuerName(String lssuerName) {
        this.lssuerName = lssuerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getYearsCheckDate() {
        return yearsCheckDate;
    }

    public void setYearsCheckDate(Date yearsCheckDate) {
        this.yearsCheckDate = yearsCheckDate;
    }

    public Integer getYearsCheckResult() {
        return yearsCheckResult;
    }

    public void setYearsCheckResult(Integer yearsCheckResult) {
        this.yearsCheckResult = yearsCheckResult;
    }

    public Date getNextYearsCheckDate() {
        return nextYearsCheckDate;
    }

    public void setNextYearsCheckDate(Date nextYearsCheckDate) {
        this.nextYearsCheckDate = nextYearsCheckDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "DogCardRelatedInfo{" +
                "seqNum=" + seqNum +
                ", dogCardNum='" + dogCardNum + '\'' +
                ", immuneCardId='" + immuneCardId + '\'' +
                ", immuneCardNum='" + immuneCardNum + '\'' +
                ", address='" + address + '\'' +
                ", dogAge=" + dogAge +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                ", dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                ", dogVarieties='" + dogVarieties + '\'' +
                ", dogOwnerId=" + dogOwnerId +
                ", dogOwnerName='" + dogOwnerName + '\'' +
                ", dogOwnerPhone='" + dogOwnerPhone + '\'' +
                ", applyTime=" + applyTime +
                ", lssueTime=" + lssueTime +
                ", lssueOrgId=" + lssueOrgId +
                ", lssueOrgName='" + lssueOrgName + '\'' +
                ", lssuerId=" + lssuerId +
                ", lssuerName='" + lssuerName + '\'' +
                ", status=" + status +
                ", yearsCheckDate=" + yearsCheckDate +
                ", yearsCheckResult=" + yearsCheckResult +
                ", nextYearsCheckDate=" + nextYearsCheckDate +
                ", note='" + note + '\'' +
                '}';
    }
}
