package com.soholy.dogmanager.entity;

import java.util.Date;

public class TVaccineInjection {
    private Long vaccineInjectionId;

    private Long vaccineRegisterId;

    private Long dogId;

    private Integer vaccineInjectionCount;

    private Date injectionDate;

    private Date factInjectionDate;

    private Date nextInjectionDate;

    private Long injectionStatus;

    private Long operatorId;

    private Integer vacOrg;

    private Date createDate;

    private String remarks;

    private String vaccineName;

    private String vaccineProducer;

    private String vaccineNum;

    private Integer send;


    public Integer getVacOrg() {
        return vacOrg;
    }

    public void setVacOrg(Integer vacOrg) {
        this.vacOrg = vacOrg;
    }

    public Long getVaccineInjectionId() {
        return vaccineInjectionId;
    }

    public void setVaccineInjectionId(Long vaccineInjectionId) {
        this.vaccineInjectionId = vaccineInjectionId;
    }

    public Long getVaccineRegisterId() {
        return vaccineRegisterId;
    }

    public void setVaccineRegisterId(Long vaccineRegisterId) {
        this.vaccineRegisterId = vaccineRegisterId;
    }

    public Integer getVaccineInjectionCount() {
        return vaccineInjectionCount;
    }

    public void setVaccineInjectionCount(Integer vaccineInjectionCount) {
        this.vaccineInjectionCount = vaccineInjectionCount;
    }

    public Date getInjectionDate() {
        return injectionDate;
    }

    public void setInjectionDate(Date injectionDate) {
        this.injectionDate = injectionDate;
    }

    public Date getFactInjectionDate() {
        return factInjectionDate;
    }

    public void setFactInjectionDate(Date factInjectionDate) {
        this.factInjectionDate = factInjectionDate;
    }

    public Date getNextInjectionDate() {
        return nextInjectionDate;
    }

    public void setNextInjectionDate(Date nextInjectionDate) {
        this.nextInjectionDate = nextInjectionDate;
    }

    public Long getInjectionStatus() {
        return injectionStatus;
    }

    public void setInjectionStatus(Long injectionStatus) {
        this.injectionStatus = injectionStatus;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName == null ? null : vaccineName.trim();
    }

    public String getVaccineProducer() {
        return vaccineProducer;
    }

    public void setVaccineProducer(String vaccineProducer) {
        this.vaccineProducer = vaccineProducer == null ? null : vaccineProducer.trim();
    }

    public String getVaccineNum() {
        return vaccineNum;
    }

    public void setVaccineNum(String vaccineNum) {
        this.vaccineNum = vaccineNum == null ? null : vaccineNum.trim();
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }
}