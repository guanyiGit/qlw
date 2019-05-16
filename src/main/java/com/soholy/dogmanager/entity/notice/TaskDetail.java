package com.soholy.dogmanager.entity.notice;

import com.soholy.dogmanager.entity.TTask;
import com.soholy.dogmanager.entity.TTaskRecipient;

import java.util.List;

public class TaskDetail extends TTask {

    private List<TTaskRecipient> tTaskRecipients;

    public List<TTaskRecipient> gettTaskRecipients() {
        return tTaskRecipients;
    }

    public void settTaskRecipients(List<TTaskRecipient> tTaskRecipients) {
        this.tTaskRecipients = tTaskRecipients;
    }
}
