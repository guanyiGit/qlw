package com.soholy.dogmanager.oauth;

import java.util.Date;

/**
 * 同步租户信息
 */
public class AepSynCustInfo extends BaseMessage {
    private Integer tenantId;
    private String tenantName;
    private String tenanType;
    private String ownerProvId;
    private String ownerCityId;
    private String tenantAddr;
    private String remark;
    private String aepLoginUser;
    private Date createTime;
    private Date updateTime;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenanType() {
        return tenanType;
    }

    public void setTenanType(String tenanType) {
        this.tenanType = tenanType;
    }

    public String getOwnerProvId() {
        return ownerProvId;
    }

    public void setOwnerProvId(String ownerProvId) {
        this.ownerProvId = ownerProvId;
    }

    public String getOwnerCityId() {
        return ownerCityId;
    }

    public void setOwnerCityId(String ownerCityId) {
        this.ownerCityId = ownerCityId;
    }

    public String getTenantAddr() {
        return tenantAddr;
    }

    public void setTenantAddr(String tenantAddr) {
        this.tenantAddr = tenantAddr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAepLoginUser() {
        return aepLoginUser;
    }

    public void setAepLoginUser(String aepLoginUser) {
        this.aepLoginUser = aepLoginUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}