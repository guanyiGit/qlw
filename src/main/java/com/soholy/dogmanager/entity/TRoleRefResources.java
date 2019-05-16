package com.soholy.dogmanager.entity;

import java.util.Date;

public class TRoleRefResources {
    private Integer roleRefResourcesId;

    private Integer roleId;

    private Integer resourcesId;

    private Integer haveLevStatus;

    private Date creationTime;

    public Integer getRoleRefResourcesId() {
        return roleRefResourcesId;
    }

    public void setRoleRefResourcesId(Integer roleRefResourcesId) {
        this.roleRefResourcesId = roleRefResourcesId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getHaveLevStatus() {
        return haveLevStatus;
    }

    public void setHaveLevStatus(Integer haveLevStatus) {
        this.haveLevStatus = haveLevStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}