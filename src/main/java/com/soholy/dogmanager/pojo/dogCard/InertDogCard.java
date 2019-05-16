package com.soholy.dogmanager.pojo.dogCard;

import java.io.Serializable;
import java.util.Date;

//办犬证的参数对象
public class InertDogCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long seqNum;//犬证id

    private Long dogId;//犬id

    private Long dogOwnerId;//犬主id

    private Long memberCardId;//会员证id

    private String dogCardNum;//证书编号

    private Date startTime;//犬证有效期开始时间

    private Date endTime;//犬证有效期结束时间

    private Date lssueTime;//犬证签发时间

    private Integer lssueOrgId;//发证机构id

    private Long lssuerId;//签发人，办理人

    private Integer status;//犬证状态

    private String deviceId;//设备id

    private Integer useStatus;//使用状态

    private Date creationTime;//设备创建时间/有效起始时间

    private Date expireTime;//设备过期时间

    private String phone;//电话

    private String name;//姓名

    private Integer gender;//性别

    private String email;//邮箱

    private Integer orgType;//机构类型

    private String ethnic;//名族

    private Date birthday;//生日

    private Integer cardType;//证件类型

    private String cardNum;//证件号码

    private Long dogOwnerCardId;//证件id

    private Long districtId;//现住区县id

    private String street;//所属街道

    private String addrees;//详细地址

    private String reason;//审核不通过原因

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public Long getDogOwnerId() {
        return dogOwnerId;
    }

    public void setDogOwnerId(Long dogOwnerId) {
        this.dogOwnerId = dogOwnerId;
    }

    public Long getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(Long memberCardId) {
        this.memberCardId = memberCardId;
    }

    public String getDogCardNum() {
        return dogCardNum;
    }

    public void setDogCardNum(String dogCardNum) {
        this.dogCardNum = dogCardNum;
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

    public Long getLssuerId() {
        return lssuerId;
    }

    public void setLssuerId(Long lssuerId) {
        this.lssuerId = lssuerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Long getDogOwnerCardId() {
        return dogOwnerCardId;
    }

    public void setDogOwnerCardId(Long dogOwnerCardId) {
        this.dogOwnerCardId = dogOwnerCardId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddrees() {
        return addrees;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "InertDogCard{" +
                "seqNum=" + seqNum +
                ", dogId=" + dogId +
                ", dogOwnerId=" + dogOwnerId +
                ", memberCardId=" + memberCardId +
                ", dogCardNum='" + dogCardNum + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", lssueTime=" + lssueTime +
                ", lssueOrgId=" + lssueOrgId +
                ", lssuerId=" + lssuerId +
                ", status=" + status +
                ", deviceId='" + deviceId + '\'' +
                ", useStatus=" + useStatus +
                ", creationTime=" + creationTime +
                ", expireTime=" + expireTime +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", orgType=" + orgType +
                ", ethnic='" + ethnic + '\'' +
                ", birthday=" + birthday +
                ", cardType=" + cardType +
                ", cardNum='" + cardNum + '\'' +
                ", dogOwnerCardId=" + dogOwnerCardId +
                ", districtId=" + districtId +
                ", street='" + street + '\'' +
                ", addrees='" + addrees + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
