package com.soholy.dogmanager.controller.dogCard;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.mapper.dogCard.DogAndOwnerMapper;
import com.soholy.dogmanager.service.notice.NoticeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TimerTask {
    @Value("${SMS_BASE_URL}")
    private String sms_base_url;
    @Autowired
    DogAndOwnerMapper dogAndOwnerMapper;

    @Autowired
    private TUsersMapper usersMapper;

    @Autowired
    private NoticeService noticeService;

    private static final Logger logger = Logger.getLogger(TimerTask.class);
    @Scheduled(cron="0 0 9 ? * *")// 每天上午9点执行秒（0~59）分钟（0~59）小时（0~23）天（月）（0~31，但是你需要考虑你月的天数）月（0~11）天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）7.年份（1970－2099）
    //@Scheduled(cron="0/10 * * * * *")
    public void test(){
        try {
            //要执行的任务逻辑写在这里
            mmuneToRemind();//免疫提醒
            medicineRemind();//喂药提醒
        } catch (Exception e) {
            logger.error("定时任务执行失败！");
        }
    }


    //免疫提醒
    private void mmuneToRemind(){
        List<Map<String,Object>> maps = null;
        try {
            maps = dogAndOwnerMapper.selectImmuneToRemind();
            for (int i=0;i<maps.size();i++){
                Map<String, Object> params = new HashMap<>();
                params.put("phone", maps.get(i).get("phone"));
                params.put("type",Integer.toString(1));
                Map<String, Object> template_param = new HashMap<>();
                template_param.put("name", maps.get(i).get("name"));
                template_param.put("dogName", maps.get(i).get("dogName"));
                template_param.put("date", maps.get(i).get("time"));
                params.put("template_param", JSONObject.toJSONString(template_param));
                //发送通知
                    TNotification notification = new TNotification();
                    String content = "您的宠物"+maps.get(i).get("dogName")+"下次免疫时间为"+maps.get(i).get("time")+"，请及时为您的宠物接种免疫";
                    notification.setNotifReceiverId(Long.valueOf(String.valueOf(maps.get(i).get("userId"))));
                    notification.setNotifTitle("免疫提醒");
                    notification.setNotifType(1);
                    notification.setNotiContent(content);
                    noticeService.addNotice(notification);

                new Thread(() -> {
                    try {
                        HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            String log = "查询免疫提醒信息失败！";
            logger.error(log, e);
        }
    }

    //喂药提醒
    private void medicineRemind(){
        List<Map<String,Object>> maps = null;
        try {
            maps = dogAndOwnerMapper.selectMedicineRemind();
            for (int i=0;i<maps.size();i++){
                Map<String, Object> params = new HashMap<>();
                params.put("phone", maps.get(i).get("phone"));
                params.put("type",Integer.toString(3));
                Map<String, Object> template_param = new HashMap<>();
                template_param.put("orgName",maps.get(i).get("orgName"));
                template_param.put("name", maps.get(i).get("name"));
                template_param.put("dogName", maps.get(i).get("dogName"));
                template_param.put("drugName",maps.get(i).get("drugName"));
                template_param.put("date", maps.get(i).get("time"));
                params.put("template_param", JSONObject.toJSONString(template_param));

                //发送通知
                    TNotification notification = new TNotification();
                    String content = maps.get(i).get("orgName")+"提醒您：尊敬的"+ maps.get(i).get("name")+"用户，您的宠物"+ maps.get(i).get("dogName")+"下次投喂"+ maps.get(i).get("drugName")+"的时间为"+maps.get(i).get("time")+"，请及时为您的宠物喂药。";
                Long a= Long.valueOf(String.valueOf(maps.get(i).get("userId")));
                System.out.println(a);
                    notification.setNotifReceiverId(null);
                    notification.setNotifTitle("喂药通知");
                    notification.setNotifType(3);
                    notification.setNotiContent(content);
                    noticeService.addNotice(notification);

                new Thread(() -> {
                    try {
                        HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            String log = "查询喂药提醒信息失败！";
            logger.error(log, e);
        }
    }
}
