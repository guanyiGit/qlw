package com.soholy.dogmanager.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class SessionListenerImpl implements SessionListener{
	
	/**
	 * 会话过期
	 */
	@Override
	public void onExpiration(Session session) {
		System.out.println("会话过期：" + session.getId());		
	}
	
	/**
	 * 会话创建触发 已进入shiro的过滤连就触发这个方法  
	 */
	@Override
	public void onStart(Session session) {
		System.err.println("会话创建：" + session.getId());  
	}
	
	/**
	 * 退出
	 */
	@Override
	public void onStop(Session session) {
		 System.out.println("会话停止：" + session.getId());  
	}
	
	
	
}
