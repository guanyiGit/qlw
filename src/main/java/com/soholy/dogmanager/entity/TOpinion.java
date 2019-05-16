package com.soholy.dogmanager.entity;

import java.util.Date;

public class TOpinion {
    private Long opinionId;

    private Integer opinionType;

    private Integer violationType;

    private String violationPlace;

    private Integer resStatus;

    private Long resUserId;

    private String applicantName;

    private String applicantPhone;

    private Date applicantDate;

    private Date creationTime;

    public Long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Long opinionId) {
        this.opinionId = opinionId;
    }

    public Integer getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(Integer opinionType) {
        this.opinionType = opinionType;
    }

    public Integer getViolationType() {
        return violationType;
    }

    public void setViolationType(Integer violationType) {
        this.violationType = violationType;
    }

    public String getViolationPlace() {
        return violationPlace;
    }

    public void setViolationPlace(String violationPlace) {
        this.violationPlace = violationPlace == null ? null : violationPlace.trim();
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    public Long getResUserId() {
        return resUserId;
    }

    public void setResUserId(Long resUserId) {
        this.resUserId = resUserId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName == null ? null : applicantName.trim();
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone == null ? null : applicantPhone.trim();
    }

    public Date getApplicantDate() {
        return applicantDate;
    }

    public void setApplicantDate(Date applicantDate) {
        this.applicantDate = applicantDate;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}