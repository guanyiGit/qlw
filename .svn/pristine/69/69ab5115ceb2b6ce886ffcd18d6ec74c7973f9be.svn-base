package com.soholy.dogmanager.entity;

import java.util.Date;

public class TNotification {
    private Long notifId;

    /**
     * 1处罚通知，2收容通知，3领养通知，4预约通知,5电量告警通知，6进入禁养区域通知 7.其他，8信息审核通知
     */
    private Integer notifType;

    /**
     * 发送人id  系统发送为0
     */
    private Long notifSenderId;

    /**
     * 接收人id
     */
    private Long notifReceiverId;

    /**
     * titile
     */
    private String notifTitle;

    /**
     * 关联任务id  默认0
     */
    private Integer taskId;

    /**
     * 0未读，1已读，2已删除
     */
    private Integer status;

    private Date creationTime;

    /**
     * 内容
     */
    private String notiContent;

    /**
     * 读取时间
     */
    private Date readTime;


    public Long getNotifId() {
        return notifId;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public void setNotifId(Long notifId) {
        this.notifId = notifId;
    }

    public Integer getNotifType() {
        return notifType;
    }

    public void setNotifType(Integer notifType) {
        this.notifType = notifType;
    }

    public Long getNotifSenderId() {
        return notifSenderId;
    }

    public void setNotifSenderId(Long notifSenderId) {
        this.notifSenderId = notifSenderId;
    }

    public Long getNotifReceiverId() {
        return notifReceiverId;
    }

    public void setNotifReceiverId(Long notifReceiverId) {
        this.notifReceiverId = notifReceiverId;
    }

    public String getNotifTitle() {
        return notifTitle;
    }

    public void setNotifTitle(String notifTitle) {
        this.notifTitle = notifTitle == null ? null : notifTitle.trim();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent == null ? null : notiContent.trim();
    }
}