package com.soholy.dogmanager.service.notice.impl;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.entity.TTask;
import com.soholy.dogmanager.entity.TTaskExample;
import com.soholy.dogmanager.entity.notice.TNotificationDetail;
import com.soholy.dogmanager.entity.notice.TaskDetail;
import com.soholy.dogmanager.mapper.TNotificationMapper;
import com.soholy.dogmanager.mapper.TTaskMapper;
import com.soholy.dogmanager.pojo.notice.NoticeVo;
import com.soholy.dogmanager.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private TNotificationMapper notificationMapper;

    @Autowired
    private TTaskMapper tTaskMapper;


    @Override
    public DogResult addNotice(TNotification notification) {
        try {
            notification.setCreationTime(new Date());
            int count = notificationMapper.insertSelective(notification);
            return DogResult.ok(count);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后再试！！！");
        }
    }

    @Override
    public DogResult deleteNoticeById(Long notificationId) {
        try {
            int count = notificationMapper.deleteNotification(notificationId);
            return DogResult.ok(count);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后再试！！！");
        }
    }

    @Override
    public DogResult updateNoticeReceiverd(Long notificationId, Long receiverd) {
        try {
            notificationMapper.updateNotification(notificationId, receiverd);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后再试！！！");
        }
    }

    // 默认查询执法通知
    @Override
    public List<TNotification> selectNoticeByType() {
        return this.selectNoticeByType(4);
    }

    @Override
    public List<TNotification> selectNoticeByType(Integer notifType) {
        try {
            List<TNotification> noticeByTypes = notificationMapper.selectNoticeByType(notifType);
            return noticeByTypes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TNotification> selectNoticeByReceiverd(Long receiverd, Integer status) {
        try {
            List<TNotification> noticeByReceiverds = notificationMapper.selectNoticeByReceiverd(receiverd,status);
            return noticeByReceiverds;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TNotification> selectNoticeByTypeAndReceiverd(Long receiverd, Long notif_sender_id) {
        return this.selectNoticeByTypeAndReceiverd(null, receiverd, notif_sender_id);
    }

    @Override
    public List<TNotification> selectNoticeByTypeAndReceiverd(Integer notifType, Long receiverd, Long notif_sender_id) {
        try {
            List<TNotification> noticeByTypeAndReceiverd = notificationMapper.selectNoticeByTypeAndReceiverd(notifType,
                    receiverd, notif_sender_id);
            return noticeByTypeAndReceiverd;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TaskDetail> findCollNotsByOrgId(int orgId, List<Integer> taskStatus) {
        return tTaskMapper.findCollNotsByOrgId(orgId, taskStatus);
    }

    @Override
    public boolean updateTaskStatusById(Integer taskId, Integer status, Long userId) {
        TTask record = new TTask();
        record.setTaskId(taskId);
        record.setTaskStatus(status);

        if ((status == 1 || status == 2) && userId != null) {
            record.setCompUserId(userId);
        }
        return tTaskMapper.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public List<TTask> findMyTaskMyUserId(long userId, List<Integer> taskStatus) {
        TTaskExample example = new TTaskExample();
        TTaskExample.Criteria criteria = example.createCriteria().andCompUserIdEqualTo(userId);
        if (taskStatus != null && taskStatus.size() > 0) {
            taskStatus.stream()
                    .filter(x -> x.intValue() >= 0 && x.intValue() <= 3)
                    .forEach(x -> {
                        TTaskExample.Criteria criteria1 = example.createCriteria().andTaskStatusEqualTo(x.intValue());
                        example.or(criteria1);
                    });
        }
        return tTaskMapper.selectByExample(example);
    }

    @Override
    public TNotificationDetail findNoticeDetailById(long notifId, Boolean isRead) {
        TNotificationDetail notificationDetail = notificationMapper.findNoticeDetailById(notifId);
        if (notificationDetail != null && notificationDetail.getReadTime() == null && isRead) {
            TNotification tNotification = new TNotification();
            tNotification.setNotifId(notificationDetail.getNotifId());
            tNotification.setReadTime(Calendar.getInstance().getTime());
            tNotification.setStatus(1);
            notificationMapper.updateByPrimaryKeySelective(tNotification);
        }
        return notificationDetail;
    }

    //任务列表
    @Override
    public List<NoticeVo> noticeList(Integer userId,Integer status) {

        List<NoticeVo>list= notificationMapper.noticeList(userId,status);
        return list;
    }

    @Override
    public int update(Integer noticeId) {
        Date date=new Date();
        return notificationMapper.update(noticeId,date);
    }

}
