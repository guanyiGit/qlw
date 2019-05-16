package com.soholy.dogmanager.oauth;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Result;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.controller.shiro.LoginController;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.mapper.AepSaasApiMapper;
import com.soholy.dogmanager.pojo.user.UserInfo;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.user.UserService;
import com.soholy.dogmanager.utils.aouth.AccessTokenResult;
import com.soholy.dogmanager.utils.aouth.TelecomBackInfo;
import com.soholy.dogmanager.utils.aouth.TelecomUserInfo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.NetUtils;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RequestMapping("/biz/server")
@Controller
public class ServerController {
    private static Logger LOGGER = LoggerFactory.getLogger(ServerController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private AepSaasApiMapper aepSaasApiMapper;
    String client_id = null;
    String client_secret = null;
    String accessTokenUrl = null;
    String userInfoUrl = null;
    String redirect_url = null;
    String response_type = null;
    String code = null;
    String scope = null;
    String state = null;
    String testrefreshToken = null;
    String prefixUrl = "http://17k49k5395.51mypc.cn";

    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "hello";
    }

    //提交申请code的请求
    @RequestMapping("/requestServerCode")
    public String requestServerFirst(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) throws OAuthProblemException {
        client_id = "4RL4U67vujd";
        client_secret = "xkh1Qfaqpf";
        accessTokenUrl = "auth";
        redirect_url = prefixUrl + "/biz/server/callbackCode";
        scope = "tenant";
        response_type = "code";
        state = "fsdfsHFfhdfFHfdfL7F78fd8f8779779FFF9F797ff7f78d";
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        String requestUrl = null;
        try {
            //构建oauthd的请求。设置请求服务地址（accessTokenUrl）、clientId、response_type、redirectUrl
//            OAuthClientRequest accessTokenRequest = OAuthClientRequest.authorizationLocation(accessTokenUrl).setResponseType(response_type).setClientId(clientId).setRedirectURI(redirectUrl).buildQueryMessage();
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .authorizationLocation(accessTokenUrl)
                    .setResponseType(response_type)
                    .setClientId(client_id)
                    .setRedirectURI(redirect_url)
                    .setScope(scope)
                    .setState(state)
                    .buildQueryMessage();
            requestUrl = accessTokenRequest.getLocationUri();
            System.out.println(requestUrl);
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }
        return "redirect:https://iam.ctwing.cn/auth/#/" + requestUrl;
    }

    private String singleLogin() {
        client_id = "4RL4U67vujd";
        client_secret = "xkh1Qfaqpf";
        accessTokenUrl = "auth";
        redirect_url = prefixUrl + "/biz/server/callbackCode";
        scope = "tenant";
        response_type = "code";
        state = "fsdfsHFfhdfFHfdfL7F78fd8f8779779FFF9F797ff7f78d";
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        String requestUrl = null;
        try {
            //构建oauthd的请求。设置请求服务地址（accessTokenUrl）、clientId、response_type、redirectUrl
//            OAuthClientRequest accessTokenRequest = OAuthClientRequest.authorizationLocation(accessTokenUrl).setResponseType(response_type).setClientId(clientId).setRedirectURI(redirectUrl).buildQueryMessage();
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .authorizationLocation(accessTokenUrl)
                    .setResponseType(response_type)
                    .setClientId(client_id)
                    .setRedirectURI(redirect_url)
                    .setScope(scope)
                    .setState(state)
                    .buildQueryMessage();
            requestUrl = accessTokenRequest.getLocationUri();
            System.out.println(requestUrl);
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }
        return "redirect:https://iam.ctwing.cn/auth/#/" + requestUrl;
    }

    //接受客户端返回的code，提交申请access token的请求
    @RequestMapping("/callbackCode")
    public String toLogin(HttpServletRequest request) throws OAuthProblemException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        code = httpRequest.getParameter("code");
        System.out.println(code);
//        String urll=prefixUrl+"/#/transit?"+code;
        String urll = "http://localhost:8080/#/transit?" + code;
        return "redirect:" + urll;
    }

    //接受服务端传回来的access token，由此token去请求服务端的资源（用户信息等）
    @RequestMapping("/accessToken")
    @ResponseBody
    public DogResult accessToken(String code) {
        client_id = "4RL4U67vujd";
        client_secret = "xkh1Qfaqpf";
        accessTokenUrl = "https://iam.ctwing.cn/oauth2/access_token";
        //--------
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        String requestUrl = null;
        String accessToken = null;
        try {
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .tokenLocation(accessTokenUrl)
                    .setClientId(client_id)
                    .setClientSecret(client_secret)
                    .setCode(code)
                    .buildQueryMessage();
            requestUrl = accessTokenRequest.getLocationUri();
            requestUrl = requestUrl + "&grant_type=code";
            System.out.print(requestUrl);
            accessTokenRequest.setLocationUri(requestUrl);
//            -----------------------------
            String result = null;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(requestUrl);
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(get);
                if (response != null && response.getStatusLine().getStatusCode() == 200) {
                    result = EntityUtils.toString(response.getEntity(), "utf-8");
                    JSONObject jsStr = JSONObject.parseObject(result);
                    AccessTokenResult accessTokenResult = (AccessTokenResult) JSONObject.toJavaObject(jsStr, AccessTokenResult.class);
                    accessToken = accessTokenResult.getAccessToken();
                    String testrefreshToken = accessTokenResult.getRefreshToken();
                    System.out.println(testrefreshToken);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("-----------客户端/callbackCode--------------------------------------------------------------------------------");
        } catch (OAuthSystemException e) {
            e.printStackTrace();
            return DogResult.build(515, "获取access_token失败!!!");
        }
        //--------
        userInfoUrl = "https://iam.ctwing.cn/services/oauth2/UserInfo?access_token=" + accessToken;
        String result = null;
        TelecomUserInfo telecomUserInfo = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(userInfoUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                JSONObject jsStr = JSONObject.parseObject(result);
                TelecomBackInfo telecomBackInfo = (TelecomBackInfo) JSONObject.toJavaObject(jsStr, TelecomBackInfo.class);
                telecomUserInfo = telecomBackInfo.getData();
                if (telecomUserInfo != null && telecomUserInfo.getLoginId() != null) {
                    //2 生成用户
                    UserVo tUsers = new UserVo();
                    tUsers.setCreateTime(new Date());
                    tUsers.setOrganizationId(114);
                    tUsers.setSex(0);
                    tUsers.setDogOwnId((long) 0);
                    tUsers.setUsername(telecomUserInfo.getLoginId());
                    tUsers.setPassword(telecomUserInfo.getUserId());
                    tUsers.setPhone(telecomUserInfo.getLoginId());
                    tUsers.setuStatus(1);
                    tUsers.setOrgType(5);
                    tUsers.setName(telecomUserInfo.getContactName());
                    tUsers.setRoleId(7);
                    userService.thirdAddUser(tUsers);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("获取用户信息或新增用户失败！");
            return DogResult.build(514, "获取用户信息或新增用户失败!!!");
        }
        //以下是登陆逻辑---------------------------------------------------------------------------------------------------------
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        UserInfo userInfo = null;
        // 判断当前是否登录
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为usernamepasswordtoken对象
            UsernamePasswordToken token = new UsernamePasswordToken(telecomUserInfo.getLoginId(), telecomUserInfo.getUserId());
            try {
                currentUser.login(token);
                Serializable id = currentUser.getSession().getId();
                response.addHeader("token", id.toString());
                TUsers user = (TUsers) SecurityUtils.getSubject().getPrincipal();
//                userInfo = userService.getUserInfo(user.getUserId());
//                System.err.println(JSONObject.toJSONString(userInfo));
                try {
                    //登陸成功修改用戶登陸信息
                    userService.modifyUserLoginInfoById(user);
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.info("登陸修改用戶信息失敗！");
                }
            } catch (UnknownAccountException e) {
                LOGGER.error("账号不存在：{}", e);
                return DogResult.build(511, "账号不存在!!!");
            } catch (DisabledAccountException e) {
                LOGGER.error("账号未启用：{}", e);
                return DogResult.build(512, "账号未启用!!!");
            } catch (IncorrectCredentialsException e) {
                LOGGER.error("密码错误：{}", e);
                return DogResult.build(513, "账号或密码错误!!!");
            } catch (Exception e) {
                LOGGER.error("未知错误,请联系管理员：{}", e);
                return DogResult.build(513, "账号或密码错误!!!");
            }
        } else {
            try {//已经登录返回登录信息
                userInfo = userService.getUserInfo(((TUsers) SecurityUtils.getSubject().getPrincipal()).getUserId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return DogResult.ok(userInfo);
    }

    //刷新access_token
    @RequestMapping("/refresh")
    public void refreshAccessToken() {
        client_id = "4RL4U67vujd";
        client_secret = "xkh1Qfaqpf";
        userInfoUrl = "https://iam.ctwing.cn/services/oauth2/Refresh";
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        String requestUrl = null;
        try {
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .tokenLocation(userInfoUrl)
                    .setClientId(client_id)
                    .setRefreshToken("04073638849047088881330418166695")
                    .buildQueryMessage();
            requestUrl = accessTokenRequest.getLocationUri();
            requestUrl = requestUrl + "&grant_type=refresh_token";
            System.out.print(requestUrl);
            accessTokenRequest.setLocationUri(requestUrl);
//            -----------------------------
            String result = null;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(requestUrl);
            CloseableHttpResponse response = null;
            String accessToken = null;
            try {
                response = httpClient.execute(get);
                if (response != null && response.getStatusLine().getStatusCode() == 200) {
                    result = EntityUtils.toString(response.getEntity(), "utf-8");
                    JSONObject jsStr = JSONObject.parseObject(result);
                    System.out.println("-------------------------------------------------");
                    System.out.println(jsStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }
    }

    //电信平台调用我方接口
    @RequestMapping("/aepSaasApi")
    public Result aepSaasApi(@RequestBody final RequestParams request) {
        //参数校验
        Date now = new Date();
        long nowdate = now.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(request.getTimeStamp());
        } catch (ParseException e) {
            return Result.build(100010202, "参数错误");
        }
        long parmdate = date.getTime();
        if (nowdate-parmdate>60000){
            return Result.build(100010104, "timestamp 过期");
        }
        String sign = "amstt"+"appSecret";
        String signn = Md5Encode.getMD5(sign);
        if (!signn.equals(request.getSign())){
            return Result.build(100010105, "签名错误");
        }
        String appKey = "4RL4U67vujd";
        if (!appKey.equals(request.getAppKey())){
            return Result.build(100010103, "AppId 不合法");
        }
        try {
            new Thread(() -> {
                String topic = request.getTopic();
                BaseMessage message = request.getMessage();
                if("aepLogin".equals(topic)){//单点登陆
                    singleLogin();
                } else if("aepSynCustInfo".equals(topic)){//同步租户信息
                    AepSynCustInfo a =(AepSynCustInfo)message;
                    a.setCreateTime(new Date());
                    aepSaasApiMapper.insertAepSynCustInfo(a);
                }else if("aepSynBusiInfo".equals(topic)){//同步业务信息
                    AepSynBusiInfo b = (AepSynBusiInfo)message;
                }else if("aepQryProdInfo".equals(topic)){//产品信息查询

                }else if("addDeleteDevice：".equals(topic)){//设备导入同步
                    AddDeleteDevice c = (AddDeleteDevice)message;
                }
            }).start();
        } catch (Exception e) {
            return Result.build(100010200, "失败");
        }
        return Result.ok();
    }
}
