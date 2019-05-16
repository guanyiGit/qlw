package com.soholy.dogmanager.entity;

import java.util.Date;

public class TAppointment {
    private Long appointmentId;

    private Integer bizType;

    private String appointmentName;

    private String appointmentPhone;

    private Integer appointmentChannel;

    private Date scheduleTime;

    private Long orgId;

    private Integer status;

    private Date creationTime;

    private Long userId;

    private String remarks;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName == null ? null : appointmentName.trim();
    }

    public String getAppointmentPhone() {
        return appointmentPhone;
    }

    public void setAppointmentPhone(String appointmentPhone) {
        this.appointmentPhone = appointmentPhone == null ? null : appointmentPhone.trim();
    }

    public Integer getAppointmentChannel() {
        return appointmentChannel;
    }

    public void setAppointmentChannel(Integer appointmentChannel) {
        this.appointmentChannel = appointmentChannel;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}