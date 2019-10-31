package com.soholy.dogmanager.service.reservation.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.mapper.TAppointmentMapper;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.service.notice.NoticeService;
import com.soholy.dogmanager.service.reservation.ReservationService;
import com.soholy.dogmanager.service.reservation.ReserveInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    private TAppointmentMapper tAppointmentMapper;

    @Autowired
    private TDictionaryMapper tDictionaryMapper;

    @Autowired
    private TUsersMapper usersMapper;

    @Value("${advance.day}")
    private String advanceDay;

    @Value("${SMS_BASE_URL}")
    private String sms_base_url;

    @Autowired
    private NoticeService noticeService;

    @Override
    public List<ReserveInformation> findAppointmentsByUserIdAndLikeHospitalName(long userId, String hospitalName) {
        return tAppointmentMapper.findAppointmentsByUserIdAndLikeHospitalName(userId, hospitalName);
    }

    @Override
    public List<TDictionary> findAppointmentBizAll() {
        TDictionaryExample example = new TDictionaryExample();
        example.createCriteria().andDictionaryFieldEqualTo("biz_type");
        return tDictionaryMapper.selectByExample(example);
    }

    @Override
    public boolean saveAppointment(TAppointment tAppointment) {
        int count = tAppointmentMapper.insertSelective(tAppointment);
        if (count == 1) {
            // TODO 通知发送 短信发送
            Map<String, String> params = new HashMap<>();
			params.put("phone", tAppointment.getAppointmentPhone());
            params.put("type",Integer.toString(2));
			Map<String, String> template_param = new HashMap<>();
			template_param.put("name", tAppointment.getAppointmentName());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			template_param.put("date", sdf.format(tAppointment.getScheduleTime()));
			String bizType=null;
			if (tAppointment.getBizType()==0){
                bizType="看病";
            }else if (tAppointment.getBizType()==1){
                bizType="办证";
            }else if (tAppointment.getBizType()==2){
                bizType="年检";
            }else if (tAppointment.getBizType()==3){
                bizType="免疫";
            }
			template_param.put("business", bizType);
            String orgName=tAppointmentMapper.selectOrgName(tAppointment.getOrgId());
            template_param.put("orgName", orgName);
			params.put("template_param", JSONObject.toJSONString(template_param));
			//发送通知
            try {
                //生产环境一个电话号码对应一个用户
                List<TUsers> tUsers = usersMapper.selectUserByPhone(tAppointment.getAppointmentPhone());
                if (tUsers != null && tUsers.size()>0){
                    TUsers user = tUsers.get(0);
                    TNotification notification = new TNotification();
                    String content = "您已成功预约"+orgName+"网点的"+bizType+"业务，预约时间"+sdf.format(tAppointment.getScheduleTime());
                    notification.setNotifReceiverId(user.getUserId());
                    notification.setNotifTitle("预约通知");
                    notification.setNotifType(2);
                    notification.setNotiContent(content);
                    noticeService.addNotice(notification);
                }
            } catch (Exception e) {
                return false;
            }
            //发送短信
                new Thread(()->{
                    try {
                    HttpResult httpResult  = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }).start();
//            String content = httpResult.getContent();
//			System.err.println(content);
            return true;
        }
        return false;
    }

    @Override
    public List<ReserveInformation> findAppointmentsByOrgIdAndLikeUserInfo(Long orgId, String keyWord) {
        return tAppointmentMapper.findAppointmentsByOrgIdAndLikeUserInfo(orgId, keyWord);
    }

    // 定时扫描任务，检查预约是否到期
    public List<TAppointment> scanAppointmentExpireIsNotice() {
        Integer dayInt = Integer.valueOf(advanceDay);
        List<ReserveInformation> expireList = tAppointmentMapper.findAppointmentIsExpire(dayInt,
                Calendar.getInstance().getTime());
        // 短信提醒 通知提醒 TODO
        // 短信提醒 通知提醒 TODO
        // 短信提醒 通知提醒 TODO
        // 短信提醒 通知提醒 TODO
        // 短信提醒 通知提醒 TODO
        return null;
    }

    @Override
    public boolean removeByid(Long appointmentId) {
        return tAppointmentMapper.deleteByPrimaryKey(appointmentId) == 1;
    }

    @Override
    public List<Map<String, String>> findAppointmentChannelAll() {
        return tAppointmentMapper.findAppointmentChannelAll();
    }

    @Override
    public List<TDictionary> findBizTypes() {
        return tDictionaryMapper.findBizTypes("biz_type");
    }

    @Override
    public boolean modifyByid(Long appointmentId, Integer status) {
        TAppointment tAppointment = new TAppointment();
        tAppointment.setAppointmentId(appointmentId);
        tAppointment.setStatus(status);
        return tAppointmentMapper.updateByPrimaryKeySelective(tAppointment) == 1;
    }

    @Override
    public boolean modefyById(TAppointment tAppointment) {
        return tAppointmentMapper.updateByPrimaryKeySelective(tAppointment) == 1;
    }

}
