package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.entity.TNotificationExample;
import com.soholy.dogmanager.entity.notice.TNotificationDetail;
import com.soholy.dogmanager.pojo.notice.NoticeVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TNotificationMapper {
    int countByExample(TNotificationExample example);

    int deleteByExample(TNotificationExample example);

    int deleteByPrimaryKey(Long notifId);

    int insert(TNotification record);

    int insertSelective(TNotification record);

    List<TNotification> selectByExampleWithBLOBs(TNotificationExample example);

    List<TNotification> selectByExample(TNotificationExample example);

    TNotification selectByPrimaryKey(Long notifId);

    int updateByExampleSelective(@Param("record") TNotification record, @Param("example") TNotificationExample example);

    int updateByExampleWithBLOBs(@Param("record") TNotification record, @Param("example") TNotificationExample example);

    int updateByExample(@Param("record") TNotification record, @Param("example") TNotificationExample example);

    int updateByPrimaryKeySelective(TNotification record);

    int updateByPrimaryKeyWithBLOBs(TNotification record);

    int updateByPrimaryKey(TNotification record);

    //添加信息
    int addNotification(TNotification notification);

    //删除信息
    int deleteNotification(Long notifId);

    //更新信息接收状态
    int updateNotification(@Param("notifId") Long notifId, @Param("receiverd") Long receiverd);

    //根据通知类型查询通知列表(适用于管理员)
    List<TNotification> selectNoticeByType(Integer notifType);

    //根据接收人查询所有通知(适用于游客)
    List<TNotification> selectNoticeByReceiverd(@Param("receiverd") Long receiverd, @Param("status") Integer status);

    //根据通知类型和接受人查询通知列表(适用与执法人员)
    List<TNotification> selectNoticeByTypeAndReceiverd(@Param("notifType") Integer notifType, @Param("receiverd") Long receiverd, @Param("notif_sender_id") Long notif_sender_id);

    /**
     * 查询给用户最后一次通知
     *
     * @param userId
     * @param notifType 0处罚通知，1预约通知,2.到期提醒， 3收容所人员执法通知,4其他通知
     */
    TNotification findMaxNotifDateByUserId(@Param("userId") Long userId, @Param("notifType") int notifType);

    /**
     * 根据通知id查通知详情
     *
     * @param notifId 通知id  必须
     * @return
     */
    TNotificationDetail findNoticeDetailById(long notifId);

    /**
     * 查看我的通知
     *
     * @param userId
     * @param status
     * @return
     */
    List<NoticeVo> noticeList(@Param("userId")Integer userId, @Param("status")Integer status);

    /**
     * 已读/未读
     *
     * @param noticeId
     */
    int update(@Param("noticeId")Integer noticeId, @Param("date")Date date);
}