package com.soholy.dogmanager.mapper.user;

import java.util.List;

import com.soholy.dogmanager.pojo.user.UserInfo;

public interface UserInfoMapper {
	
	//根据用户获取id获取用户及犬以及犬设备(项圈)信息
	UserInfo selectUserInfo(Long userId);
	
}
