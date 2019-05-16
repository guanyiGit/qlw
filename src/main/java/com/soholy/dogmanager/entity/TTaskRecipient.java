package com.soholy.dogmanager.entity;

public class TTaskRecipient {
    private Integer tTaskRecipientId;

    private Integer recipientType;

    private Integer recipientId;

    private Integer taskId;

    public Integer gettTaskRecipientId() {
        return tTaskRecipientId;
    }

    public void settTaskRecipientId(Integer tTaskRecipientId) {
        this.tTaskRecipientId = tTaskRecipientId;
    }

    public Integer getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(Integer recipientType) {
        this.recipientType = recipientType;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}