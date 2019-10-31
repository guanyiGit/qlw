package com.soholy.dogmanager.service.violation.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.enums.AdoptionDogStatus;
import com.soholy.dogmanager.common.enums.CollectionResultStatus;
import com.soholy.dogmanager.common.enums.DogStatus;
import com.soholy.dogmanager.common.enums.HandleRecordType;
import com.soholy.dogmanager.common.enums.SexType;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TAdoptionPublicity;
import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.entity.TCollection;
import com.soholy.dogmanager.entity.TCollectionExample;
import com.soholy.dogmanager.entity.TCollectionExample.Criteria;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.THandleRecord;
import com.soholy.dogmanager.mapper.TAdoptionPublicityMapper;
import com.soholy.dogmanager.mapper.TAdoptionRecordsMapper;
import com.soholy.dogmanager.mapper.TCollectionMapper;
import com.soholy.dogmanager.mapper.TDogInfoMapper;
import com.soholy.dogmanager.mapper.THandleRecordMapper;
import com.soholy.dogmanager.mapper.violation.CollectionMapper;
import com.soholy.dogmanager.pojo.violation.CollectionVO;
import com.soholy.dogmanager.pojo.violation.HandleCollection2VO;
import com.soholy.dogmanager.pojo.violation.HandleCollectionVO;
import com.soholy.dogmanager.service.violation.CollectionService;


/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：CollectionServiceImpl 
* 类描述： 收容service
* 创建人：YL
* 创建时间：2018年8月23日 下午8:38:40 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午8:38:40 
* 修改备注： 
* 
*/

@Service
public class CollectionServiceImpl implements CollectionService {

	private static Logger LOGGER = LoggerFactory.getLogger(CollectionServiceImpl.class);	
	
	@Autowired
	private TCollectionMapper tCollectionMapper;
	@Autowired
	private CollectionMapper collectionMapper;
	@Autowired
	private TDogInfoMapper dogInfoMapper;
	@Autowired
	private TAdoptionRecordsMapper tAdoptionRecordsMapper;
	@Autowired
	private THandleRecordMapper tHandleRecordMapper;
	@Autowired
	private TAdoptionPublicityMapper tAdoptionPublicityMapper;
	
	/**
	 * 检查犬只编号是否存在
	 * */
	@Override
	public DogResult checkDogCode(String dogCode) {
		TCollectionExample example =new TCollectionExample();
		Criteria criteria = example.createCriteria();
		criteria.andDogCodeEqualTo(dogCode);
		List<TCollection> list = tCollectionMapper.selectByExample(example);
		if(list.size()!=0){
		return 	DogResult.build(400, "犬只编号已存在");
		}
		return DogResult.ok();
	}
	
	/**
	 * 添加
	 * */
	@Override
	public DogResult save(TCollection collection) {
		collection.setCollectionTime(new Date());
		collection.setCreationTime(new Date());
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_ACCEPT.getCode());
		tCollectionMapper.insertSelective(collection);
		return DogResult.ok(collection.getCollectionId());
	}
	/**
	 * 更新
	 * */ 
	@Override
	public DogResult update(TCollection collection) {
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		return DogResult.ok();
	}

	/**
	 * 查询列表（分页）
	 * */
	@Override
	public Page<CollectionVO> findCollectionList(int pn, int pageSize, String string,int status) {
		if(!StringUtils.isEmpty(string)){
			if(string.equals(SexType.dog_sex_boy.getMsg())){
				string=SexType.dog_sex_boy.getCode().toString();
			}
			if(string.equals(SexType.dog_sex_girl.getMsg())){
				string=SexType.dog_sex_girl.getCode().toString();
			}
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("string", string);
		map.put("status", status);
		Page<CollectionVO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(collectionMapper.findCollectionListCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<CollectionVO> collectionList = collectionMapper.findCollectionList(map);
		page.setLists(collectionList);
		return page;
	}

	/**
	 * 查询详情
	 * */
	@Override
	public CollectionVO findCollectionByCollectionId(Long collectionId) {
		 CollectionVO collection = collectionMapper.findCollectionById(collectionId);
		return collection;
	}
	
	/**
	 * 认领登记
	 * */
	@Override
	@Transactional
	public DogResult claimMyDog(HandleCollectionVO handleCollectionVO) {
		//1.更改收容状态到已认领
		TCollection collection = new TCollection();
		collection.setCollectionId(handleCollectionVO.getCollectionId());
		collection.setHandlingTime(new Date());
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_CLAIM.getCode());
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		//2.更改犬状态到正常并清除积分
		if(handleCollectionVO.getDogId()!=null){
			TDogInfo tDogInfo = new TDogInfo();
			tDogInfo.setDogId(handleCollectionVO.getDogId());
			tDogInfo.setDogStatus(DogStatus.DOG_STATUS_NORMAL.getCode());
			tDogInfo.setDeductionSum(0.0);
			dogInfoMapper.updateByPrimaryKeySelective(tDogInfo);
		}
		//3.添加认领记录
		THandleRecord handleRecord = new THandleRecord();
		BeanUtils.copyProperties(handleCollectionVO, handleRecord);
		handleRecord.setHandleTime(new Date());
		handleRecord.setHandleType(HandleRecordType.DOG_HANDLE_CLAIM.getCode());
		//handleRecord.setOperatorId(operatorId);
		tHandleRecordMapper.insertSelective(handleRecord);
		return DogResult.ok();
	}
	
	/**
	 * 处理登记
	 * */
	@Override
	@Transactional
	public DogResult handleDog(HandleCollectionVO handleCollectionVO) {
		//1.更改收容状态到已处理
		TCollection collection = new TCollection();
		collection.setCollectionId(handleCollectionVO.getCollectionId());
		collection.setHandlingTime(handleCollectionVO.getHandleTime());
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_HANDLE.getCode());
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		//2.更改犬状态到已处理
		if(handleCollectionVO.getDogId()!=null){
			TDogInfo tDogInfo = new TDogInfo();
			tDogInfo.setDogId(handleCollectionVO.getDogId());
			tDogInfo.setDogStatus(DogStatus.DOG_STATUS_HANDLE.getCode());
			dogInfoMapper.updateByPrimaryKeySelective(tDogInfo);
		}
		//3.添加处理记录
		THandleRecord handleRecord = new THandleRecord();
		BeanUtils.copyProperties(handleCollectionVO, handleRecord);
		handleRecord.setHandleType(HandleRecordType.DOG_HANDLE_KILL.getCode());
		tHandleRecordMapper.insertSelective(handleRecord);
		return DogResult.ok();
	}

	/**
	 * 领养登记
	 * */
	@Override
	@Transactional
	public DogResult AdoptionPubDog(TAdoptionRecords tAdoptionRecords) {
	
		//2.更改收容状态到已领养
		TCollection collection = new TCollection();
		collection.setCollectionId(tAdoptionRecords.getCollectionId());
		collection.setResultType(CollectionResultStatus.COLLECTION_RESULT_ADOPTION.getCode());
		tCollectionMapper.updateByPrimaryKeySelective(collection);
		//3.更改公示状态到已领养
		TAdoptionPublicity tAdoptionPublicity = new TAdoptionPublicity();
		tAdoptionPublicity.setCollectionId(tAdoptionRecords.getCollectionId());
		tAdoptionPublicity.setDogStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_BYADOPT.getCode());
		tAdoptionPublicity.setCreateDate(new Date());
		tAdoptionPublicity.setPublishDate(new Date());
		tAdoptionPublicity.setOperatorId(tAdoptionRecords.getOperatorId());
		tAdoptionPublicityMapper.insertSelective(tAdoptionPublicity);
		//1.添加领养记录
		tAdoptionRecords.setCreationTime(new Date());
		tAdoptionRecords.setDogPublicityId(tAdoptionPublicity.getAdoptionPublicityId());
		tAdoptionRecords.setAdoptionStatus(AdoptionDogStatus.ADOPTION_DOGSTATUS_BYADOPT.getCode());
		tAdoptionRecordsMapper.insertSelective(tAdoptionRecords);
		return DogResult.ok();
	}
	
	/**
	 * 
	 * 认领处理列表
	 * */
	@Override
	public Page<HandleCollection2VO> findHandleCollectionVOList(int pn, int pageSize, String string, int type) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("string", string);
		map.put("type", type);
		Page<HandleCollection2VO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(collectionMapper.findHandleCollectionListCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<HandleCollection2VO> handleCollection2List = collectionMapper.findHandleCollectionList(map);
		page.setLists(handleCollection2List);
		return page;
	}
	
	/**
	 * 认领处理详情
	 * */
	@Override
	public HandleCollection2VO findHandleCollectionByHandleId(Long handleId) {
		HandleCollection2VO handleCollection2VO = collectionMapper.findHandleCollectionByHandId(handleId);
		return handleCollection2VO;
	}
	
	/**
	 * 查爱心领养平台列表
	 * */
	@Override
	public Page<CollectionVO> findAdoptionCollectionVOs(int pn,int pageSize,String string,int status) {
		HashMap<String, Object> map = new HashMap<>();
		if(!StringUtils.isEmpty(string)){
			JSONObject object = JSONObject.parseObject(string);
			map.put("breed", (String) object.get("breed"));
			map.put("gender", (String) object.get("gender"));
			map.put("beginAge", (Integer) object.get("startAge"));
			map.put("endAge", (Integer) object.get("endAge"));
			map.put("color", (String) object.get("color"));
		}
		map.put("status", status);
		Page<CollectionVO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		page.setTotalRecord(collectionMapper.findAdoptionCollectionVOsCount(map));
		if (page.getIndex()<0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<CollectionVO> collectionList = collectionMapper.findAdoptionCollectionVOs(map);
		page.setLists(collectionList);
		return page;
	}

     
}
