package com.soholy.dogmanager.controller.notice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.controller.shiro.BaseController;
import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.entity.TTask;
import com.soholy.dogmanager.entity.notice.TaskDetail;
import com.soholy.dogmanager.pojo.notice.NoticeVo;
import com.soholy.dogmanager.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/biz/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    /**
     * @param notification
     * @Description:添加通知
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/notice/add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addNotice(TNotification notification) {
        try {
            DogResult dogResult = noticeService.addNotice(notification);
            return dogResult;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param notificationId
     * @Description:删除通知
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/notice/delete") // 添加权限控制
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public DogResult deleteNotice(Long notificationId) {
        try {
            DogResult dogResult = noticeService.deleteNoticeById(notificationId);
            return dogResult;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param notificationId
     * @param receiverd
     * @Description:执法人员接受任务更改状态(适用执法人员)
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/notice/updateNoticeReceiverd")
    @RequestMapping(value = "/updateNoticeReceiverd", method = RequestMethod.POST)
    @ResponseBody
    public DogResult updateNoticeReceiverd(Long notificationId, Long receiverd) {
        try {
            DogResult dogResult = noticeService.updateNoticeReceiverd(notificationId, receiverd);
            return dogResult;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }


    /**
     * @param receiverd 接收人id 可为空
     * @param status 消息类型，可null  [0/未读消息,1已读消息，2全部]
     * @Description:根据接收人查询所有通知(适用于游客)
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/notice/selectNoticeByReceiverd")
    @RequestMapping(value = "/selectNoticeByReceiverd", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectNoticeByReceiverd(Long receiverd, Integer offset, Integer limit,Integer status) {
        if (offset == null)
            offset = 1;
        if (limit == null)
            limit = 10;
        try {
            Page pege = PageHelper.startPage(offset, limit);
            List<TNotification> noticeByReceiverd = noticeService.selectNoticeByReceiverd(receiverd,status);
            PageInfo<TNotification> pageInfo = new PageInfo<>(noticeByReceiverd);
            pageInfo.setTotal(pageInfo.getTotal());
            return DogResult.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 根据通知id查通知详情
     * @param notifId 通知id  必须
     * @param isRead 是否将此条资讯标记为已读
     * @return
     */
    @RequestMapping(value = "/detail/{notifId}", method = RequestMethod.GET)
    @ResponseBody
    public String noticeDetail(@PathVariable long notifId,@RequestParam(required = false,defaultValue = "false") Boolean isRead) {
        return new GlobalResult().resultJSON(noticeService.findNoticeDetailById(notifId,isRead));
    }


    /**
     * @param receiverd 用户id   默认为0，当有执法人员接收任务， receiverd为空查询所有未领取的任务
     * @param offset
     * @param limit
     * @Description:根据通知类型和接受人查询通知列表(使用与执法人员)
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/notice/selectNoticeByTypeAndReceiverd")
    @RequestMapping(value = "/selectNoticeByTypeAndReceiverd", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectNoticeByTypeAndReceiverd(Long receiverd, Long notif_sender_id, Integer offset, Integer limit) {
        try {

            Page pege = PageHelper.startPage(offset, limit);
            List<TNotification> list = noticeService.selectNoticeByTypeAndReceiverd(receiverd, notif_sender_id);
            PageInfo<TNotification> pageInfo = new PageInfo<>(list);
            pageInfo.setTotal(pageInfo.getTotal());
            return DogResult.ok(pageInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 根据结构id查询機構的任务
     *
     * @param orgId
     * @param taskStatus 0待接收，1已接收，2已完成，3废弃
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list/org/{orgId}")
    @ResponseBody
    public String findCollNots(@PathVariable int orgId, @RequestParam(required = false) List<Integer> taskStatus, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TaskDetail> list = new PageInfo<>(noticeService.findCollNotsByOrgId(orgId, taskStatus));
        return new GlobalResult().resultJSON(list);
    }


    /**
     * 接收任务
     *
     * @param taskId
     * @param status 0待接收，1已接收，2已完成，3废弃
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/task/receive/{taskId}", method = RequestMethod.PUT)
    public String receiveTask(@PathVariable Integer taskId, @RequestParam Integer status, @RequestParam(required = false) Long userId) {
        if (status == null || status < 0 || status > 3) {
            new GlobalResult().resultJSON(null, "参数错误");
        }
        return new GlobalResult().resultJSON(noticeService.updateTaskStatusById(taskId, status, userId));
    }

    /**
     * 查看是我的任务
     *
     * @param userId
     * @param taskStatus
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list/my/{userId}")
    @ResponseBody
    public String viewMyTask(@PathVariable long userId, @RequestParam(required = false) List<Integer> taskStatus, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TTask> list = new PageInfo<TTask>(noticeService.findMyTaskMyUserId(userId, taskStatus));
        return new GlobalResult().resultJSON(list);
    }



    /**
     * 查看我的任务
     *
     * @param userId:当前登录用户的userId
     * @param status:0未读；1已读
     *
     * @return
     */
    @RequestMapping("/noticeList")
    @ResponseBody
    public DogResult noticeList(Integer userId,Integer status,Integer offset,Integer limit) {

        PageInfo<NoticeVo> pageInfo =null;
        try {
            PageHelper.startPage(offset, limit);
            List<NoticeVo>list=noticeService.noticeList(userId,status);
            pageInfo = new PageInfo<>(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查看通知失败!");
        }
        return DogResult.ok(pageInfo);
    }

    /**
     * 已读/未读
     *
     * @param userId:当前登录用户的userId
     * @param status:0未读；1已读
     *
     * @return
     */
    @RequestMapping("/updateNotice")
    @ResponseBody
    public DogResult updateNotice(Integer noticeId) {

        int a=0;
        try {
           a= noticeService.update(noticeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DogResult.ok(a);
    }




}
