package com.soholy.dogmanager.controller.shiro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpsUtils;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.pojo.user.UserInfo;
import com.soholy.dogmanager.service.user.UserService;
import com.soholy.dogmanager.shiro.exception.SerializationException;
import com.soholy.dogmanager.shiro.redis.impl.RedisManager;
import com.soholy.dogmanager.shiro.serializer.ObjectSerializer;
import com.soholy.dogmanager.shiro.serializer.RedisSerializer;
import com.soholy.dogmanager.shiro.serializer.StringSerializer;

@Controller
@RequestMapping("/biz")
public class LoginController {

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Value("${appid}")
	private String appid;

	@Value("${AppSecret}")
	private String appSecret;
	
	@Value("${BASE_URL}")
	private String BASE_URL;
	
	@Autowired
	private RedisManager redisManager;

	/**
	 * 首页
	 *
	 * @return
	 */
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/static/index";
	}

	/**
	 * 首页
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "/static/index";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public DogResult checkLogin(HttpServletResponse response){
		LOGGER.info("checkLogin GET请求登录");
		if (SecurityUtils.getSubject().isAuthenticated()) {
			response.setHeader("statusCode", "200");
			return DogResult.ok();
		}
//		response.setStatus(401);
		response.setHeader("statusCode", "401");
		return DogResult.build(401, "未登录或登录超时");
	}
	

	
	
	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	@ResponseBody
	public String getToken(HttpServletRequest request, String code) {
		
		RedisSerializer keySerializer = new StringSerializer();
		RedisSerializer valueSerializer = new ObjectSerializer();
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> params = new HashMap<>();
		params.put("appid", appid);
		params.put("secret", appSecret);
		params.put("js_code", code);
		params.put("grant_type", "authorization_code");
		JSONObject doGet = HttpsUtils.doGet(url, params);
		System.err.println(doGet.toJSONString());
		String session_key = doGet.getString("session_key");
		String open_id = doGet.getString("openid");
		// 生成登录态
		String token = Md5Encode.getMD5(session_key + open_id);
		// 创建一个session
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		//将session存入redisManager
		try {
			redisManager.set(keySerializer.serialize(sessionId), valueSerializer.serialize(session_key+open_id), 60 * 60 * 24 * 30);
		} catch (SerializationException e) {
			e.printStackTrace();
		}
		return sessionId;
	}
	
	@RequestMapping(value = "/getUSerInfo", method = RequestMethod.POST)
	@ResponseBody
	public DogResult getUSerInfo(){
		TUsers user = (TUsers) SecurityUtils.getSubject().getPrincipal();
		try {
			UserInfo userInfo = userService.getUserInfo(user.getUserId());
			return DogResult.ok(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"服务器异常，请稍后再试！！！");
		}
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public DogResult login(String username, String password,HttpServletResponse response) {
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		UserInfo userInfo = null;
		// 判断当前是否登录
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为usernamepasswordtoken对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				currentUser.login(token);
				Serializable id = currentUser.getSession().getId();
				response.addHeader("token", id.toString());
				TUsers user = (TUsers) SecurityUtils.getSubject().getPrincipal();
				userInfo = userService.getUserInfo(user.getUserId());
				System.err.println(JSONObject.toJSONString(userInfo));
				try {
					//登陸成功修改用戶登陸信息
					userService.modifyUserLoginInfoById(user);
				}catch (Exception e){
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
		}else {
			try {//已经登录返回登录信息
				userInfo = userService.getUserInfo(((TUsers) SecurityUtils.getSubject().getPrincipal()).getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DogResult.ok(userInfo);
	}
	
	

	/**
	 * 未授权
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	public String unauth() {
		if (SecurityUtils.getSubject().isAuthenticated() == false) {
			return "redirect:/login";
		}
		return "/unauthorized";
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public DogResult logout() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			currentUser.logout();
			return DogResult.ok();
		}else {
			return DogResult.build(400,"当前未登录，请登录后再试！！");
		}
	}

}
