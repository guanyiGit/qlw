package com.soholy.dogmanager.shiro.session;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

public class LocalRedisSessionDAO extends CachingSessionDAO{
	
	private RedisSessionDao redisSessionDao;

	public void setRedisSessionDao(RedisSessionDao redisSessionDao) {
		this.redisSessionDao = redisSessionDao;
	}

	@Override
	protected void doDelete(Session session) {
		redisSessionDao.delete(session);
	}

	@Override
	protected void doUpdate(Session session) {
		redisSessionDao.update(session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return redisSessionDao.readSession(sessionId);
	}

}
