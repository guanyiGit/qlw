package com.soholy.dogmanager.service.iot;

import com.soholy.dogmanager.entity.iot.auth.AccessToken;

import java.util.Map;

public interface AuthService {

    /**
     * 获取iot服务器地址url
     * @return
     */
    public String iotServerBaseUrl();

    /**
     * @Description (获取AccessToken)
     * @return
     * @throws Exception
     */
    public abstract AccessToken getAccessToken() throws Exception;

    /**
     * @Description (刷新 token)
     * @return
     * @throws Exception
     */
    public abstract AccessToken refreshToken() throws Exception;

    /**
     * @Description (注销鉴权信息)
     * @return
     * @throws Exception
     */
    public boolean logoutAuth() throws Exception;

    /**
     * @Description (设置请求头)
     * @return
     * @throws Exception
     */
    Map<String, String> setAuthentication() throws Exception;
}
