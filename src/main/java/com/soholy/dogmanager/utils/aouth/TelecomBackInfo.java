package com.soholy.dogmanager.utils.aouth;

/**
 * 电信返回的信息（包含用户信息）
 */
public class TelecomBackInfo {
     private String duration;
     private String reason;
     private String code;
     private TelecomUserInfo data;
     private String serial;
     private String host;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TelecomUserInfo getData() {
        return data;
    }

    public void setData(TelecomUserInfo data) {
        this.data = data;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
