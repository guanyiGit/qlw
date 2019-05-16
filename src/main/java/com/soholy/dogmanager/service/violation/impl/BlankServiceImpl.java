package com.soholy.dogmanager.service.violation.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.enums.BlackStatus;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TBlacklist;
import com.soholy.dogmanager.entity.TNotification;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.mapper.TBlacklistMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.service.notice.NoticeService;
import com.soholy.dogmanager.service.violation.BlankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：BlackServiceImpl 
* 类描述： 黑名单service
* 创建人：YL
* 创建时间：2018年8月23日 下午3:10:06 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午3:10:06 
* 修改备注： 
* 
*/
@Service
public class BlankServiceImpl  implements BlankService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BlankServiceImpl.class);

	@Autowired
	private TBlacklistMapper blacklistMapper;
	@Value("${SMS_BASE_URL}")
	private String sms_base_url;

	@Autowired
	private TUsersMapper usersMapper;

	@Autowired
	private NoticeService noticeService;
	/**
	 * 添加黑名单
	 * */
	@Override
	@Transactional
	public DogResult save(TBlacklist tBlacklist) throws Exception {
		tBlacklist.setJoinTime(new Date());
		tBlacklist.setStatus( BlackStatus.BLACK_STATUS_OPEN.getCode());
		blacklistMapper.insertSelective(tBlacklist);
		//发送短信
		Map<String, String> params = new HashMap<>();
		params.put("phone", tBlacklist.getPhone());
		params.put("type",Integer.toString(10));
		Map<String, String> template_param = new HashMap<>();
		template_param.put("name", tBlacklist.getBlackName());
		template_param.put("reason", tBlacklist.getJoinCause());
		params.put("template_param", JSONObject.toJSONString(template_param));

		new Thread(() -> {
			try {
				HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}).start();

		//5.添加通知消息
		List<TUsers> tUsers = usersMapper.selectUserByPhone(tBlacklist.getPhone());
			if (tUsers !=null && tUsers.size()>0){
				TNotification notification = new TNotification();
				notification.setNotifType(9);
				notification.setNotifReceiverId(tUsers.get(0).getUserId());
				notification.setNotifTitle("黑名单通知");
				notification.setNotiContent("加入黑名单提醒：尊敬的"+ tBlacklist.getBlackName()+"用户，由于"+tBlacklist.getJoinCause()+"，您已被加入黑名单");
				noticeService.addNotice(notification);
			}

//		String content = httpResult.getContent();
//		System.err.println(content);
		return DogResult.ok();
	}
	/**
	 * 更新状态
	 * */
	@Override
	public DogResult update(TBlacklist tBlacklist) {
		blacklistMapper.updateByPrimaryKeySelective(tBlacklist);
		return DogResult.ok();
	}
	/**
	 * 查列表（分页）
	 * */
	@Override
	public Page<TBlacklist> findAll(int pn,int pageSize,String string) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("string", string);
		Page<TBlacklist> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(blacklistMapper.findTBlacklistAllCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<TBlacklist> tBlacklistAll = blacklistMapper.findTBlacklistAll(map);
		page.setLists(tBlacklistAll);
		return page;
	}
	/**
	 * 查详情
	 * */
	@Override
	public TBlacklist findOne(Long blackId) {
		TBlacklist blacklist = blacklistMapper.selectByPrimaryKey(blackId);
		return blacklist;
	}
	
	/**
	 * 根据姓名或身份证或电话检查黑名单是否存在
	 * */
	@Override
	public TBlacklist checkBlackList(String string) {
		TBlacklist blacklist = blacklistMapper.checkBlackList(string);
		return blacklist;
	}
	
	/**
	 * 批量移除
	 * */
	@Override
	public DogResult removeBatch(List<Long> blackIdList) {
		List<TBlacklist> TBlacklists = new ArrayList<>();
		for (Long blackId : blackIdList) {
			TBlacklist tBlacklist = new  TBlacklist();
			tBlacklist.setBlackId(blackId);
			tBlacklist.setStatus(BlackStatus.BLACK_STATUS_REMOVE.getCode());
			TBlacklists.add(tBlacklist);
		}
		blacklistMapper.removeBatch(TBlacklists);
		return DogResult.ok();
	}
	
}
