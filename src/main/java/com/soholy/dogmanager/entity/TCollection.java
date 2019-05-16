package com.soholy.dogmanager.entity;

import java.util.Date;

public class TCollection {
    private Long collectionId;

    private String dogCode;

    private Integer orgId;

    private Long dogId;

    private Integer districtId;

    private String address;

    private String signboardCode;

    private Integer collDogType;

    private String dogName;

    private String remarks;

    private Long operatorId;

    private Date collectionTime;

    private String doghouseNum;

    private Integer resultType;

    private Date creationTime;

    private Integer dogGender;

    private String dogCharacter;

    private Integer dogBreedType;

    private Integer dogColorType;

    private Double weight;

    private Integer dogAge;

    private Integer healthStatus;

    private Date handlingTime;

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getDogCode() {
        return dogCode;
    }

    public void setDogCode(String dogCode) {
        this.dogCode = dogCode == null ? null : dogCode.trim();
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSignboardCode() {
        return signboardCode;
    }

    public void setSignboardCode(String signboardCode) {
        this.signboardCode = signboardCode == null ? null : signboardCode.trim();
    }

    public Integer getCollDogType() {
        return collDogType;
    }

    public void setCollDogType(Integer collDogType) {
        this.collDogType = collDogType;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName == null ? null : dogName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getDoghouseNum() {
        return doghouseNum;
    }

    public void setDoghouseNum(String doghouseNum) {
        this.doghouseNum = doghouseNum == null ? null : doghouseNum.trim();
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getDogGender() {
        return dogGender;
    }

    public void setDogGender(Integer dogGender) {
        this.dogGender = dogGender;
    }

    public String getDogCharacter() {
        return dogCharacter;
    }

    public void setDogCharacter(String dogCharacter) {
        this.dogCharacter = dogCharacter == null ? null : dogCharacter.trim();
    }

    public Integer getDogBreedType() {
        return dogBreedType;
    }

    public void setDogBreedType(Integer dogBreedType) {
        this.dogBreedType = dogBreedType;
    }

    public Integer getDogColorType() {
        return dogColorType;
    }

    public void setDogColorType(Integer dogColorType) {
        this.dogColorType = dogColorType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Date getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(Date handlingTime) {
        this.handlingTime = handlingTime;
    }
}