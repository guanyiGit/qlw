package com.soholy.dogmanager.entity;

import java.util.Date;

public class TDictionary {
    private Integer dictionaryId;

    private String dictionaryField;

    private Integer dictionaryValue;

    private String dictionaryDescribe;

    private Date creationTime;

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDictionaryField() {
        return dictionaryField;
    }

    public void setDictionaryField(String dictionaryField) {
        this.dictionaryField = dictionaryField == null ? null : dictionaryField.trim();
    }

    public Integer getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(Integer dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public String getDictionaryDescribe() {
        return dictionaryDescribe;
    }

    public void setDictionaryDescribe(String dictionaryDescribe) {
        this.dictionaryDescribe = dictionaryDescribe == null ? null : dictionaryDescribe.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}