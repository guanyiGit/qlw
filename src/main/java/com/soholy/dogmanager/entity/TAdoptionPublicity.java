package com.soholy.dogmanager.entity;

import java.util.Date;

public class TAdoptionPublicity {
    private Long adoptionPublicityId;

    private Long collectionId;

    private Date publishDate;

    private Date expireDate;

    private Long operatorId;

    private Integer publishOrgId;

    private Integer dogStatus;

    private Date createDate;

    public Long getAdoptionPublicityId() {
        return adoptionPublicityId;
    }

    public void setAdoptionPublicityId(Long adoptionPublicityId) {
        this.adoptionPublicityId = adoptionPublicityId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPublishOrgId() {
        return publishOrgId;
    }

    public void setPublishOrgId(Integer publishOrgId) {
        this.publishOrgId = publishOrgId;
    }

    public Integer getDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(Integer dogStatus) {
        this.dogStatus = dogStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}