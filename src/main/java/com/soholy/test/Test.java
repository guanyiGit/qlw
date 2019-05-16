package com.soholy.test;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Test {

//    public static void main(String[] args) {
//        Map<String, Object> params = new HashMap<>();
//			params.put("phone", "13689587016");
//			params.put("type",12);
//			Map<String, String> template_param = new HashMap<>();
//            template_param.put("name","彭雨");
//			template_param.put("username", "pengyu");
//			template_param.put("password", "123456");
//			params.put("template_param", JSONObject.toJSONString(template_param));
//        HttpResult httpResult = null;
//        try {
//            httpResult = HttpClientUtil.executeHttpParams("http://192.168.0.14:8889/sms" + "/SendSMS", "post", params);
//            String content = httpResult.getContent();
//            System.out.println(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
//        Map<String, String> params = new HashMap<>();
//        params.put("phone", "13689587016");
//        params.put("type",Integer.toString(12));
//        new Thread(){
//            public void run(){
//                try {
//                    HttpResult httpResult = HttpClientUtil.executeHttpParams("http://192.168.0.14:8888/sms" + "/SendSMS", "post", params);
//                    String content = httpResult.getContent();
//                    System.out.println(content);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (URISyntaxException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        System.out.println("xxxxx");
        try {
            Map<String, String> params = new HashMap<>();
            params.put("phone", "13689587016");
            Map<String, String> template_param = new HashMap<>();
            template_param.put("name","pengyu");
            template_param.put("username", "13689587016");
            template_param.put("password", "xxxxxxx");
            params.put("template_param", JSONObject.toJSONString(template_param));
            HttpResult httpResult = HttpClientUtil.executeHttpParams("http://192.168.0.14:8888/sms/PassWordSMS", "post", params);
            String content = httpResult.getContent();
            System.out.println(httpResult);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }




}
