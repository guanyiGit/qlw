package com.soholy.dogmanager.entity.dogCard;

import java.util.Date;

public class DogVarieties {
    private Integer dictionaryId;//字典表主鍵id
    private String dogVarieties;//犬品種名稱
    private Date creationTime;

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDogVarieties() {
        return dogVarieties;
    }

    public void setDogVarieties(String dogVarieties) {
        this.dogVarieties = dogVarieties;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "DogVarieties{" +
                "dictionaryId=" + dictionaryId +
                ", dogVarieties='" + dogVarieties + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
