package com.soholy.dogmanager.service.violation.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.enums.DogStatus;
import com.soholy.dogmanager.common.enums.IsCollection;
import com.soholy.dogmanager.common.enums.ResultEnum;
import com.soholy.dogmanager.common.exception.DogException;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.mapper.*;
import com.soholy.dogmanager.mapper.dogCard.DogAndOwnerMapper;
import com.soholy.dogmanager.mapper.violation.PunishMapper;
import com.soholy.dogmanager.pojo.violation.*;
import com.soholy.dogmanager.service.notice.NoticeService;
import com.soholy.dogmanager.service.violation.PunishService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* 项目名称：dogmanager-violation
* 类名称：OpinionServiceImpl
* 类描述： 执法处罚service
* 创建人：YL
* 创建时间：2018年8月23日 下午4:47:10
* 修改人：Administrator
* 修改时间：2018年8月23日 下午4:47:10
* 修改备注：
*
*/
@Service
public class PunishServiceImpl implements PunishService {

	private static Logger LOGGER = LoggerFactory.getLogger(PunishServiceImpl.class);

	@Autowired
	private PunishMapper punishMapper;
	@Autowired
	private TViolationMapper tViolationMapper;
	@Autowired
	private TPunishMapper tPunishMapper;
	@Autowired
	private TCollectionMapper tCollectionMapper;
	@Autowired
	private TDogInfoMapper dogInfoMapper;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private TDictionaryMapper tDictionaryMapper;
	@Autowired
	private DogAndOwnerMapper dogAndOwnerMapper;
	@Value("${SMS_BASE_URL}")
	private String sms_base_url;

	@Autowired
	private TUsersMapper usersMapper;

	/**
	 *查询所有（分页）
	 * @throws Exception
	 *
	 * */
	@Override
	public Page<ViolationPunish3VO> findAll(int pn, int pageSize,String string) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("string", StringUtils.isEmpty(string)?null:string);
		Page<ViolationPunish3VO> page = new Page<>();
		page.setPageNumber(pn);
		page.setPageSize(pageSize);
		int count = punishMapper.findViolationListsCount(map);
		page.setTotalRecord(count);
		if (count<=0) {
			LOGGER.info("【数据为null】totalRecord={}",page.getTotalRecord());
			return null;
		}
		map.put("index", page.getIndex());
		map.put("pageSize", pageSize);
		List<ViolationPunish3VO> violationLists = this.punishMapper.findViolationLists(map);
		page.setLists(violationLists);
		return page;
	}
	/**
	 * 根据id查询详情
	 * */
	@Override
	public ViolationPunish3VO findOne(Long violationId) {
		ViolationPunish3VO violationInfo3VO = this.punishMapper.findViolationById(violationId);
		return violationInfo3VO;
	}
	/**
	 * 添加违规记录
	 * */
	@Override
	@Transactional
	public DogResult save(ViolationPunish2VO violationPunish2VO) throws Exception {
		//1.添加违规记录
		TViolation violation = new TViolation();
		BeanUtils.copyProperties(violationPunish2VO, violation);
		violation.setCreationTime(new Date());
		tViolationMapper.insertSelective(violation);

		//2.添加处罚记录
		TPunish punish = new TPunish();
		BeanUtils.copyProperties(violationPunish2VO, punish);
		punish.setCreationTime(new Date());
		punish.setViolationId(violation.getViolationId());
		tPunishMapper.insertSelective(punish);

		//3.累计扣分
		TDogInfo tDogInfo = dogInfoMapper.selectByPrimaryKey(violation.getDogId());
		if(tDogInfo==null){
			LOGGER.info("【查无此犬】 tDogInfo={}",tDogInfo);
			throw new DogException(ResultEnum.DOGINFO_NULL);
		}
		if (tDogInfo.getDeductionSum()==null){
			tDogInfo.setDeductionSum(0.0);
		}
		Double count=tDogInfo.getDeductionSum()+punish.getPoints();
		tDogInfo.setDeductionSum(count);
		dogInfoMapper.updateByPrimaryKeySelective(tDogInfo);

		//4.判断是否收容
		if(punish.getIsCollection()==IsCollection.YES.getCode()){
			//1.添加收容信息
			TCollection collection = new TCollection();
			BeanUtils.copyProperties(tDogInfo, collection);
			collection.setCollectionTime(violationPunish2VO.getPunishTime());
			tCollectionMapper.insertSelective(collection);
			//2.更改犬只状态到收容
			tDogInfo.setDogStatus(DogStatus.DOG_STATUS_ACCEPT.getCode());
			dogInfoMapper.updateByPrimaryKeySelective(tDogInfo);
		}


		//发送短信
		Map<String,String> map=new HashMap<>();
		map=dogAndOwnerMapper.selectOwnerInfo(violationPunish2VO.getDogOwnerId());
		Map<String, String> params = new HashMap<>();
		params.put("phone", map.get("phone"));
		params.put("type",Integer.toString(6));
		Map<String, String> template_param = new HashMap<>();
		template_param.put("name", map.get("name"));
		template_param.put("place", violationPunish2VO.getViolationPlace());
		String mistake=null;
		if (violationPunish2VO.getViolationType()==1){
			mistake="不牵犬绳";
		}else if (violationPunish2VO.getViolationType()==2){
			mistake="犬只扰民";
		} else if (violationPunish2VO.getViolationType()==3){
			mistake="无人看管";
		}else if (violationPunish2VO.getViolationType()==4){
			mistake="随地大小便";
		}else if (violationPunish2VO.getViolationType()==5){
			mistake="进入禁养区域";
		}else if (violationPunish2VO.getViolationType()==6){
			mistake="伤人";
		}else if (violationPunish2VO.getViolationType()==7){
			mistake="犬吠";
		}else if (violationPunish2VO.getViolationType()==8){
			mistake="其它";
		}
		template_param.put("mistake", mistake);
		template_param.put("fraction", violationPunish2VO.getPoints()+"");
		String isTakeIn=null;
		if (violationPunish2VO.getIsCollection()==0){
			isTakeIn="已";
		}else if (violationPunish2VO.getIsCollection()==1){
			isTakeIn="未";
		}
		template_param.put("isTakeIn", isTakeIn);
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
		List<TUsers> tUsers = usersMapper.selectUserByPhone(map.get("phone"));
		if (tUsers !=null && tUsers.size()>0){
			TNotification notification = new TNotification();
			notification.setNotifType(5);
			notification.setNotifReceiverId(tUsers.get(0).getUserId());
			notification.setNotifTitle("违法处罚");
			notification.setNotiContent("尊敬的"+map.get("name")+"用户，您的宠物在"+
					violationPunish2VO.getViolationPlace()+"地点"+mistake+"，本次扣"+violationPunish2VO.getPoints()+"分。");
			noticeService.addNotice(notification);
		}

//		String content = httpResult.getContent();
//		System.err.println(content);
		return DogResult.ok();
	}

	/**
	 * 根据项圈编码查犬信息
	 * */
	@Override
	public DeviceDogVo findDeviceDogVoByDeviceCode(String code) {
		DeviceDogVo deviceDogVo = punishMapper.findDeviceDogVoByDeviceCode(code);
		return deviceDogVo;
	}

	/**
	 * 根据犬id查违法记录
	 * */
	@Override
	public List<ViolationPunishVO> findViolationPunishListByDogId(Long dogId) {
		  List<ViolationPunishVO> ViolationPunishVOList = punishMapper.findViolationPunishListByDogId(dogId);
		return ViolationPunishVOList;
	}

	/**
	 * 根据犬主id查犬最近扣分列表
	 * */
	@Override
	public List<ViolationPunish4VO> findViolationPunish4VOListBydogOwnerId(Long OwnerId) {
		List<ViolationPunish4VO> list = punishMapper.findViolationPunish4VOListBydogOwnerId(OwnerId);
		return list;
	}


	/**
	 * 根据犬主id查年度扣分
	 * */
	@Override
	public List<DogInfo2VO> findtotalCountBydogOwnerId(Long OwnerId) {
		List<DogInfo2VO> list = punishMapper.findtotalCountBydogOwnerId(OwnerId);
		return list;
	}

	@Override
	public List<TDictionary> findTypes() {
		String dictionaryFidId = "violation_type";
		TDictionaryExample example=new TDictionaryExample();
		example.createCriteria()
				.andDictionaryFieldEqualTo(dictionaryFidId);

		return tDictionaryMapper
				.selectByExample(example);
	}

}
