package com.soholy.dogmanager.pojo.notice;

import com.soholy.dogmanager.entity.TNotification;

public class NoticeVo extends TNotification {
    private String dicNotiType;//通知类型,字典表

    public String getDicNotiType() {
        return dicNotiType;
    }

    public void setDicNotiType(String dicNotiType) {
        this.dicNotiType = dicNotiType;
    }
}
