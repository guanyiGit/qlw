package com.soholy.dogmanager.entity;

import java.util.Date;

public class TOpinionRefDog {
    private Integer opinionRefDogId;

    private Long dogId;

    private Long opinionId;

    private Date creationTime;

    public Integer getOpinionRefDogId() {
        return opinionRefDogId;
    }

    public void setOpinionRefDogId(Integer opinionRefDogId) {
        this.opinionRefDogId = opinionRefDogId;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public Long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Long opinionId) {
        this.opinionId = opinionId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}