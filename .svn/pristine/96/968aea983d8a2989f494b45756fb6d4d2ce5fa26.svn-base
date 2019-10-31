package com.soholy.dogmanager.service.notice;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.entity.TTask;
import com.soholy.dogmanager.entity.notice.TNotificationDetail;
import com.soholy.dogmanager.entity.notice.TaskDetail;
import com.soholy.dogmanager.pojo.notice.NoticeVo;

import java.util.List;

public interface NoticeService {

    /**
     * @param notification
     * @Description: 添加通知消息()
     * @return（展示方法参数和返回值）
     */
    DogResult addNotice(TNotification notification);


    /**
     * @param notificationId
     * @Description:删除通知
     * @return（展示方法参数和返回值）
     */
    DogResult deleteNoticeById(Long notificationId);

    /**
     * @param notificationId
     * @param receiverd      接收人id(关联用户表)
     * @Description:执法人员接受任务更改状态(适用执法人员)
     * @return（展示方法参数和返回值）
     */
    DogResult updateNoticeReceiverd(Long notificationId, Long receiverd);

    /**
     * @Description:根据通知类型查询通知列表(默认查询执法任务通知)
     * @return（展示方法参数和返回值）
     */
    List<TNotification> selectNoticeByType();

    /**
     * @param notifType
     * @Description:根据通知类型查询通知列表(适用于管理员)
     * @return（展示方法参数和返回值）
     */
    List<TNotification> selectNoticeByType(Integer notifType);

    /**
     * @param receiverd
     * @param status
     * @Description:根据接收人查询所有通知(适用于游客)
     * @return（展示方法参数和返回值）
     */
    List<TNotification> selectNoticeByReceiverd(Long receiverd, Integer status);


    /**
     * @param type
     * @param receiverd 默认为0，当有执法人员接收任务，
     * @Description:根据通知类型和接受人查询通知列表(使用与执法人员)
     * @return（展示方法参数和返回值）
     */
    List<TNotification> selectNoticeByTypeAndReceiverd(Long receiverd, Long notif_sender_id);

    List<TNotification> selectNoticeByTypeAndReceiverd(Integer notifType, Long receiverd, Long notif_sender_id);

    /**
     * 根据结构id查询機構的任务
     *
     * @param orgId
     * @param taskStatus
     * @return
     */
    List<TaskDetail> findCollNotsByOrgId(int orgId, List<Integer> taskStatus);

    /**
     * 修改任务状态 完成任务，删除任务
     *
     * @param taskId
     * @param status
     * @param userId
     * @return
     */
    boolean updateTaskStatusById(Integer taskId, Integer status, Long userId);

    /**
     * 查看我的任务
     * @param userId
     * @param taskStatus
     * @return
     */
    List<TTask> findMyTaskMyUserId(long userId, List<Integer> taskStatus);

    /**
     * 根据通知id查通知详情
     * @param notifId 通知id  必须
     * @param isRead
     * @return
     */
    TNotificationDetail findNoticeDetailById(long notifId, Boolean isRead);

    /**
     * 通知列表
     * @param map
     * @return
     */
    List<NoticeVo> noticeList(Integer userId, Integer status);

    /**
     *
     * @param noticeId
     */
    int update(Integer noticeId);
}
