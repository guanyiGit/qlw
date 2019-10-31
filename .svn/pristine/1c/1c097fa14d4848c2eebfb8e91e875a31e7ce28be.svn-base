package com.soholy.dogmanager.service.violation.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.enums.AdoptionDogStatus;
import com.soholy.dogmanager.common.enums.CollectionResultStatus;
import com.soholy.dogmanager.common.enums.SexType;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.TAdoptionRecordsExample.Criteria;
import com.soholy.dogmanager.mapper.TAdoptionPublicityMapper;
import com.soholy.dogmanager.mapper.TAdoptionRecordsMapper;
import com.soholy.dogmanager.mapper.TCollectionMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.mapper.violation.CollectionMapper;
import com.soholy.dogmanager.pojo.violation.AdoptionCollectionVO;
import com.soholy.dogmanager.pojo.violation.AdoptionVO;
import com.soholy.dogmanager.pojo.violation.PublishVO;
import com.soholy.dogmanager.service.notice.NoticeService;
import com.soholy.dogmanager.service.violation.AdoptionService;
import org.apache.commons.lang3.StringUtils;
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
* 类名称：AdoptionServiceImpl 
* 类描述： 领养平台service
* 创建人：YL
* 创建时间：2018年8月24日 下午6:02:39 
* 修改人：Administrator 
* 修改时间：2018年8月24日 下午6:02:39 
* 修改备注： 
* 
*/
@Service
public class AdoptionServiceImpl implements AdoptionService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(AdoptionServiceImpl.class);

	@Autowired
	private TAdoptionPublicityMapper tAdoptionPublicityMapper;
	@Autowired
	private CollectionMapper collectionMapper;
	@Autowired
	private TCollectionMapper tCollectionMapper;
	@Autowired
	private TAdoptionRecordsMapper tAdoptionRecordsMapper;
	@Value("${SMS_BASE_URL}")
	private String sms_base_url;

	@Autowired
	private TUsersMapper usersMapper;

	@Autowired
	private NoticeService noticeService;

	/**
	 * 发布到领养平台
	 * */
	@Override
	@Transactional
	public DogResult saveAdoptionPublicity(TAdoptionPublicity tAdoptionPublicity) {
		//1.发布到领养平台
		tAdoptionPublicityMapper.insertSelective(tAdoptionPublicity);
		//2.修改收容状态到发布中
		TCollection collection = new TCollection();
		collection.setCollectionId(tAdoptionPublicity.getCollectionId());
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_PUBLISH.getCode());
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		return DogResult.ok();
	}

	/**
	 * 查询发布中列表（分页）
	 * */
	@Override
	public Page<AdoptionCollectionVO> findAdoptablList(int pn, int pageSize, String string) {
		HashMap<String, Object> map = new HashMap<>();
		if(!StringUtils.isEmpty(string)){
			if(string.equals(SexType.dog_sex_boy.getMsg())){
				string=SexType.dog_sex_boy.getCode().toString();
			}
			if(string.equals(SexType.dog_sex_girl.getMsg())){
				string=SexType.dog_sex_girl.getCode().toString();
			}
		}
		map.put("string", string);
		Page<AdoptionCollectionVO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(collectionMapper.findAdoptionCollectionVOListCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<AdoptionCollectionVO> collectionVOList = collectionMapper.findAdoptionCollectionVOList(map);
		page.setLists(collectionVOList);
		return page;
	}
	
	/**
	 * 查询(申请)已领养列表（分页）
	 * */
	@Override
	public Page<AdoptionVO> findAdoptabledList(int pn, int pageSize, String string,int status,int type) {
		HashMap<String, Object> map = new HashMap<>();
		if(!StringUtils.isEmpty(string)){
			if(string.equals(SexType.dog_sex_boy.getMsg())){
				string=SexType.dog_sex_boy.getCode().toString();
			}
			if(string.equals(SexType.dog_sex_girl.getMsg())){
				string=SexType.dog_sex_girl.getCode().toString();
			}
		}
		map.put("string", string);
		map.put("status", status);
		map.put("type", type);
		Page<AdoptionVO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(collectionMapper.findAdoptionVOListCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		 List<AdoptionVO> adoptionVOList = collectionMapper.findAdoptionVOList(map);
		page.setLists(adoptionVOList);
		return page;
	}
	
	
	/**
	 * 批量添加到领养平台
	 * */
	@Override
	@Transactional
	public DogResult saveAdoptionPublicityBatch(List<Long> collectionIdList) {
			List<TAdoptionPublicity> tAdoptionPublicityList1 = new ArrayList<>();
		for (Long collectionId : collectionIdList) {
			//1.改变状态到发布中
			TCollection collection = new TCollection();
			collection.setCollectionId(collectionId);
			collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_PUBLISH.getCode());
			tCollectionMapper.updateByPrimaryKeySelective(collection);
			TAdoptionPublicity tAdoptionPublicity = new TAdoptionPublicity();
			tAdoptionPublicity.setCreateDate(new Date());
			tAdoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_PUBLICITY.getCode());
			tAdoptionPublicity.setPublishDate(new Date());
			tAdoptionPublicity.setCollectionId(collectionId);
			tAdoptionPublicityList1.add(tAdoptionPublicity);
		}
		
		//2.添加到领养平台
		tAdoptionPublicityMapper.saveAdoptionPublicityBatch(tAdoptionPublicityList1);
		return DogResult.ok();
	}
	
	/**
	 * 撤回到收容库
	 * */
	@Override
	@Transactional
	public DogResult updateAdoptionCollection(Long adoptionId,Long collectionId) {
		//1.领养公示过期
		TAdoptionPublicity adoptionPublicity = new TAdoptionPublicity();
		adoptionPublicity.setAdoptionPublicityId(adoptionId);
		adoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_OVERDUE.getCode());
		tAdoptionPublicityMapper.updateByPrimaryKeySelective(adoptionPublicity);
		//2.改变状态到收容中
		TCollection collection = new TCollection();
		collection.setCollectionId(collectionId);
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_ACCEPT.getCode());
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		return DogResult.ok();
	}
	
	/**
	 * 批量撤回到收容库
	 * */
	@Override
	@Transactional
	public DogResult updateAdoptionCollectionBatch(List<PublishVO> PublishVOList) {
		for (PublishVO publishVO : PublishVOList) {
			//1.领养公示过期
			TAdoptionPublicity adoptionPublicity = new TAdoptionPublicity();
			adoptionPublicity.setAdoptionPublicityId(publishVO.getAdoptionPublicityId());
			adoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_OVERDUE.getCode());
			tAdoptionPublicityMapper.updateByPrimaryKeySelective(adoptionPublicity);
			//2.改变状态到收容中
			TCollection collection = new TCollection();
			collection.setCollectionId(publishVO.getCollectionId());
			collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_ACCEPT.getCode());
			tCollectionMapper.updateByPrimaryKeySelective(collection);
		}
		return DogResult.ok();
	}

	

	/**
	 * 领养申请
	 * */
	@Override
	@Transactional
	public DogResult AdoptionApplyDog(TAdoptionRecords tAdoptionRecords) {
		//1.添加领养记录
		tAdoptionRecords.setCreationTime(new Date());
		tAdoptionRecordsMapper.insertSelective(tAdoptionRecords);
		//2.更改公示状态到已预约
		TAdoptionPublicity tAdoptionPublicity = new TAdoptionPublicity();
		tAdoptionPublicity.setAdoptionPublicityId(tAdoptionRecords.getDogPublicityId());
		tAdoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_ORDER.getCode());
		tAdoptionPublicityMapper.updateByPrimaryKeySelective(tAdoptionPublicity);
		return DogResult.ok();
	}

	/**
	 * 领养确认
	 * */
	@Override
	@Transactional
	public DogResult AdoptionApplySuer(TAdoptionRecords tAdoptionRecords) {
		//1.更改被预约到已领养
		TAdoptionPublicity tAdoptionPublicity = new TAdoptionPublicity();
		tAdoptionPublicity.setAdoptionPublicityId(tAdoptionRecords.getDogPublicityId());
		tAdoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_BYADOPT.getCode());
		tAdoptionPublicityMapper.updateByPrimaryKeySelective(tAdoptionPublicity);
		//2.更改发布中到已领养
		TCollection tCollection = new TCollection();
		tCollection.setCollectionId(tAdoptionRecords.getCollectionId());
		tCollection.setResultType(CollectionResultStatus.COLLECTION_RESULT_ADOPTION.getCode());
		tCollection.setHandlingTime(new Date());
		tCollectionMapper.updateByPrimaryKeySelective(tCollection);
		//3.完善领养记录
		tAdoptionRecords.setAdoptionTime(new Date());
		tAdoptionRecords.setAdoptionStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_BYADOPT.getCode());
		tAdoptionRecordsMapper.updateByPrimaryKeySelective(tAdoptionRecords);
		//发送短信
		Map<String, String> params = new HashMap<>();
		//查询操作人所在机构名称
		String orgName=tAdoptionRecordsMapper.selectOrgName(tAdoptionRecords.getOperatorId());
		//查询领养人电话
		String phone=tAdoptionRecordsMapper.selectPhone(tAdoptionRecords.getAdoptionRecordsId());

		params.put("phone", phone);
		params.put("type",Integer.toString(11));
		Map<String, String> template_param = new HashMap<>();
		template_param.put("orgName",orgName);
		template_param.put("date","三天内");
		params.put("template_param", JSONObject.toJSONString(template_param));
		//发送通知
		try {
			List<TUsers> users = usersMapper.selectUserByPhone(phone);
			if (users != null || users.size() > 0){
				TUsers user = users.get(0);
				TNotification notification = new TNotification();
				String content = "您的领养申请已通过，请于三天内到"+orgName+"领养";
				notification.setNotifReceiverId(user.getUserId());
				notification.setNotifTitle("领养提醒");
				notification.setNotifType(4);
				notification.setNotiContent(content);
				noticeService.addNotice(notification);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Thread(()->{
			try {
				HttpResult httpResult  = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}).start();
		return DogResult.ok();
	}

	/**
	 * 查询预约列表
	 * */
	@Override
	public List<TAdoptionRecords> findTAdoptionRecordsList(Long adoptionPublicityId) {
		TAdoptionRecordsExample example =new TAdoptionRecordsExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andDogPublicityIdEqualTo(adoptionPublicityId)
		 			.andAdoptionStatusNotEqualTo(AdoptionDogStatus.ADOPTION_DOGSTATUS_NOADOPT.getCode());
		 List<TAdoptionRecords> tAdoptionRecordList = tAdoptionRecordsMapper.selectByExample(example);
		 return tAdoptionRecordList;
	}


	/**
	 * 查询已领养详情
	 * */
	@Override
	public AdoptionVO findOne(Long adoptionRecordId) {
		AdoptionVO adoptionVO = collectionMapper.findAdoptionVOByAdoptionRecordsId(adoptionRecordId);
		return adoptionVO;
	}

	/**
	 * 重新发布
	 * */
	@Override
	public DogResult againPublish(List<TAdoptionRecords> AdoptionRecordList) {
		for (TAdoptionRecords tAdoptionRecords : AdoptionRecordList) {
			//1.修改申请记录到未领养
			TAdoptionRecords adoptionRecords = new TAdoptionRecords();
			adoptionRecords.setAdoptionRecordsId(tAdoptionRecords.getAdoptionRecordsId());
			adoptionRecords.setAdoptionStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_NOADOPT.getCode());
			tAdoptionRecordsMapper.updateByPrimaryKeySelective(adoptionRecords);
			//2.修改预约中到公示中
			TAdoptionPublicity adoptionPublicity = new TAdoptionPublicity();
			adoptionPublicity.setAdoptionPublicityId(tAdoptionRecords.getDogPublicityId());
			adoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_PUBLICITY.getCode());
			tAdoptionPublicityMapper.updateByPrimaryKeySelective(adoptionPublicity);
		}
		return DogResult.ok();
	}

	
	
	

}
