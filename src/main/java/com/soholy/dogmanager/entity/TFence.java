package com.soholy.dogmanager.entity;

import java.util.Date;

public class TFence {
    private Long fenceId;

    private Integer fenceType;

    private String fenceName;

    private Long operatorId;

    private Integer status;

    private Date startTime;

    private Date creationTime;

    public Long getFenceId() {
        return fenceId;
    }

    public void setFenceId(Long fenceId) {
        this.fenceId = fenceId;
    }

    public Integer getFenceType() {
        return fenceType;
    }

    public void setFenceType(Integer fenceType) {
        this.fenceType = fenceType;
    }

    public String getFenceName() {
        return fenceName;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName == null ? null : fenceName.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}