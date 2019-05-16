package com.soholy.dogmanager.entity.dogCard;

import java.util.Date;

//禁养犬种对象
public class DogBan {
    private static final long serialVersionUID = 1L;

    private Integer dogBanId;//禁养犬品种id
    private Integer dictionaryId;//犬品种id 对应字典表dictionary_id字段
    private String dogBanName;//犬类名称
    private String url;//原图
    private String thumbnailUrl;//缩略图
    private String note;//备注
    private Date creationTime;//创建时间

    public Integer getDogBanId() {
        return dogBanId;
    }

    public void setDogBanId(Integer dogBanId) {
        this.dogBanId = dogBanId;
    }

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDogBanName() {
        return dogBanName;
    }

    public void setDogBanName(String dogBanName) {
        this.dogBanName = dogBanName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "DogBan{" +
                "dogBanId=" + dogBanId +
                ", dictionaryId=" + dictionaryId +
                ", dogBanName='" + dogBanName + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", note='" + note + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
