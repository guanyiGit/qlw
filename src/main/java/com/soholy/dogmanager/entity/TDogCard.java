package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDogCard {
    private Long seqNum;

    private Long dogId;

    private Long dogOwnerId;

    private Long memberCardId;

    private String dogCardNum;

    private Date startTime;

    private Date endTime;

    private Date lssueTime;

    private Integer lssueOrgId;

    private Long lssuerId;

    private Integer status;

    private Date creationTime;

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
        this.dogCardNum = dogCardNum == null ? null : dogCardNum.trim();
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}