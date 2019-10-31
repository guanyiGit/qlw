package com.soholy.dogmanager.service.statistic.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.pojo.TableSplitResult;
import com.soholy.dogmanager.common.utils.MathUtils;
import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.TDictionaryExample.Criteria;
import com.soholy.dogmanager.entity.dogCard.DogIdAndOwnerId;
import com.soholy.dogmanager.entity.dogCard.DogOwners;
import com.soholy.dogmanager.entity.dogCard.ImmuneCard;
import com.soholy.dogmanager.entity.dogCard.PageInfo;
import com.soholy.dogmanager.entity.statistic.DogImmune;
import com.soholy.dogmanager.entity.statistic.DogInfo;
import com.soholy.dogmanager.entity.statistic.DogInspection;
import com.soholy.dogmanager.entity.statistic.DogOwner;
import com.soholy.dogmanager.mapper.*;
import com.soholy.dogmanager.mapper.dogCard.DogAndOwnerMapper;
import com.soholy.dogmanager.mapper.dogCard.DogCardMapper;
import com.soholy.dogmanager.mapper.statistic.DogInfoMapper;
import com.soholy.dogmanager.mapper.statistic.DogInspectionMapper;
import com.soholy.dogmanager.mapper.statistic.TVaccineMapper;
import com.soholy.dogmanager.pojo.statistic.DogInfoVO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerDTO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerVO2;
import com.soholy.dogmanager.pojo.statistic.ImmuneRegister;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.pojo.violation.CollectionVO;
import com.soholy.dogmanager.service.fileManager.util.FileUpload;
import com.soholy.dogmanager.service.statistic.DogInfoService;
import com.soholy.dogmanager.service.user.UserService;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.util.*;

@Service
public class DogInfoServiceImpl implements DogInfoService {
	@Autowired
	private DogInfoMapper dogInfoMapper;
	@Autowired
	private TImmuneCardMapper tImmuneCardMapper;
	@Autowired
	private TDogInfoMapper tDogInfoMapper;
	@Autowired
	private TDogOwnerMapper tDogOwnerMapper;
	@Autowired
	private DogInspectionMapper dogInspectionMapper;
	@Autowired
	private TTherapyMapper tTherapyMapper;
	@Autowired
	private TDogOwnerCardMapper tDogOwnerCardMapper;
	@Autowired
	private TDictionaryMapper tDictionaryMapper;
	@Autowired
	private TDistrictMapper tDistrictMapper;
	@Autowired
	private TTherapyMapper therapyMapper;
	@Resource
	TVaccineMapper tVaccineMapper;
	@Autowired
	DogAndOwnerMapper dogAndOwnerMapper;
	@Autowired
	DogCardMapper dogCardMapper;
    @Autowired
    HealthConditionMapper healthConditionMapper;
    @Autowired
    TVaccineRegisterMapper vaccineRegisterMapper;
    @Autowired
    TVaccineInjectionMapper vaccineInjectionMapper;
    @Autowired
	TUserRefRolesMapper tUserRefRolesMapper;
    @Autowired
    private TUsersMapper usersMapper;

    @Autowired
	private UserService userService;

    @Autowired
	private TDogOwnerCardMapper dogOwnerCardMapper;
    @Autowired
	private TDogInfoMapper tdogInfoMapper;
    @Autowired
    private TImagesMapper imagesMapper;
    @Autowired
    private TImagesRefMapper imagesRefMapper;
    @Value("${SMS_BASE_URL}")
    private String sms_base_url;

    //病历列表
	@Override
	public Object findTherapyList(Integer index, Integer pageSize, String searchKey,Integer orgId) throws UnsupportedEncodingException {
		/*if(searchKey!=null) {
			searchKey=new String(searchKey.getBytes("ISO8859_1"), "UTF-8");
		}*/
		
				//1.从session中获得当前登录用户的相关信息(待完成)
				//2.获得当前登录人的部门id
				//Integer orgId=1;
				//map用来传递参数
				HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("searchKey", searchKey);
					map.put("orgId", orgId);
				//统计病历总记录数
				Integer totalRecord=dogInfoMapper.findTherapyListRecord(map);
				PageInfo pageInfo=new PageInfo();
				pageInfo.setTotalCount(totalRecord);
				pageInfo.setPageSize(pageSize);
				pageInfo.setPageNum(index);
					map.put("index", pageInfo.getTotalStart());
					map.put("pageSize", pageSize);
					List<DogInfo> therapyList = dogInfoMapper.findTherapyList(map);
					Map<Object, Object> maps=new HashMap<Object, Object>();
					maps.put("pageInfo", pageInfo);
					maps.put("list", therapyList);
				return maps;
	}

	//根据犬只id查找病历详情
	@Override
	public DogInfo findTherapyDetail(Long dogId,Integer orgId) {
		
		return dogInfoMapper.findTherapyDetail(dogId,orgId);
	}
	
	//免疫证列表
	@Override
	public TableSplitResult<List<DogInfo>> findImmuneCardList(Integer index, Integer pageSize,Integer orgId, String searchKey) throws UnsupportedEncodingException {
		if(searchKey!=null) {
			searchKey=new String(searchKey.getBytes("ISO8859_1"), "UTF-8");
		}
		TableSplitResult<List<DogInfo>> result =new TableSplitResult<List<DogInfo>>();
		//1.从session中获得当前登录用户的相关信息(待完成)
		//2.获得当前登录人的部门id
		//Integer orgId=1;
		//map用来传递参数
		HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("searchKey", searchKey);
			map.put("orgId", orgId);
		//统计病历总记录数
		Integer totalRecord=dogInfoMapper.findImmuneListRecord(map);
			map.put("index", index);
			map.put("pageSize", pageSize);
			List<DogInfo> therapyList = dogInfoMapper.findImmuneCardList(map);
			result.setTotal(totalRecord);
			result.setRows(therapyList);
		return result;
	}

	//查看免疫证办理详情
	@Override
	public DogInfo findImmuneDetail(Long dogId) {
		return dogInfoMapper.findImmuneDetail(dogId);
	}

//	//插入免疫证信息
//	@Override
//	@Transactional
//	public Long insertImmuneMsg(DogInfo dogInfo) throws SubmitRepeatException{
//		//1.获取犬主信息
//		DogOwner dogOwner = dogInfo.getDogOwner();
//		dogOwner.setCreationTime(new Date());
//		Long dogOwnerId = null;
//		DogImmune dogImmune = dogInfo.getDogImmune();
//		String minNum=tDogOwnerMapper.selectIminNumBymin(dogImmune.getImmuneCardNum());
//		if (minNum!=null){
//			String log = "免疫证号重复！";
//			throw new SubmitRepeatException(log);
//		}
//		//2.插入犬主信息
//		if (dogOwner.getDogOwnerId()!=null){
//			dogOwnerId =dogOwner.getDogOwnerId();
//			DogOwners dogOwners = new DogOwners();
//			dogOwners.setDogOwnerId(dogOwner.getDogOwnerId());
//			dogOwners.setDistrictId(dogOwner.getDistrictId());
//			dogOwners.setCommunity(dogOwner.getCommunity());
//			dogOwners.setAddress(dogOwner.getAddress());
//				dogAndOwnerMapper.updatetDogOwner(dogOwners);
//		}else {
//			tDogOwnerMapper.insertSelective(dogOwner);
//			dogOwnerId =dogOwner.getDogOwnerId();
//		}
//		TDogOwnerCard card = dogOwner.gettDogOwnerCard();
//		card.setDogOwnerId(dogOwnerId);
//		card.setCreationTime(new Date());
//		if(card.getDogOwnerCardId()!=null){
//			DogOwners dogOwnerss = new DogOwners();
//			dogOwnerss.setDogOwnerId(dogOwnerId);
//			dogOwnerss.setCardType(card.getCardType());
//			dogOwnerss.setCardNum(card.getCardNum());
//			dogOwnerss.setDogOwnerCardId(card.getDogOwnerCardId());
//			dogCardMapper.updateDogOwnerCard(dogOwnerss);
//		}else {
//			//插入犬主证件信息
//			tDogOwnerCardMapper.insertSelective(card);
//		}
//		Long dogId = null;
//		if (dogInfo.getDogId()!=null){
//			dogId = dogInfo.getDogId();
//
//		}else {
//			//3.返回犬主主键,
//			dogInfo.setDogOwnerId(dogOwnerId);
//			dogInfo.setCreationTime(new Date());
//			//4.插入犬只信息
//			tDogInfoMapper.insertSelective(dogInfo);
//			//返回自增dogId
//			dogId= dogInfo.getDogId();
//		}
//		// 1.获取免疫证信息
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());//设置起时间
//		cal.add(Calendar.YEAR, 20);//增加20年
//		dogImmune.setCreationTime(new Date());
//		dogImmune.setStartTime(new Date());
//		dogImmune.setEndTime(cal.getTime());
//		dogImmune.setDogId(dogId);
//		dogImmune.setDogOwnerId(dogOwnerId);
//		dogImmune.setImmuneCardNum(dogImmune.getImmuneCardNum());
//		dogImmune.setLssueTime(new Date());
//		dogImmune.setStatus(1);
//		//插入免疫证信息
//		tImmuneCardMapper.insertSelective(dogImmune);
//
//		return dogId;
//	}


	//插入免疫证信息
	@Override
	@Transactional
	public DogIdAndOwnerId insertImmuneMsg(DogInfo dogInfo) {
		DogIdAndOwnerId dogIdAndOwnerId = new DogIdAndOwnerId();
		//1.获取犬主信息
		DogOwner dogOwner = dogInfo.getDogOwner();
		dogOwner.setCreationTime(new Date());
		Long dogOwnerId = null;
		DogImmune dogImmune = dogInfo.getDogImmune();
		String minNum=tDogOwnerMapper.selectIminNumBymin(dogImmune.getImmuneCardNum());
		if (minNum!=null){
			String log = "免疫证号重复！";
			dogIdAndOwnerId.setIsRepeat(1);
		}
		if(minNum==null||minNum.equals("")){
			//2.插入犬主信息
			if (dogOwner.getDogOwnerId()!=null){
				dogOwnerId =dogOwner.getDogOwnerId();
				DogOwners dogOwners = new DogOwners();
				dogOwners.setDogOwnerId(dogOwner.getDogOwnerId());
				dogOwners.setDistrictId(dogOwner.getDistrictId());
				dogOwners.setCommunity(dogOwner.getCommunity());
				dogOwners.setAddress(dogOwner.getAddress());
				dogAndOwnerMapper.updatetDogOwner(dogOwners);
			}else {
				tDogOwnerMapper.insertSelective(dogOwner);
				dogOwnerId =dogOwner.getDogOwnerId();
			}
			dogIdAndOwnerId.setDogOwnerId(dogOwnerId);
			TDogOwnerCard card = dogOwner.gettDogOwnerCard();
			card.setDogOwnerId(dogOwnerId);
			card.setCreationTime(new Date());
			if(card.getDogOwnerCardId()!=null){
				DogOwners dogOwnerss = new DogOwners();
				dogOwnerss.setDogOwnerId(dogOwnerId);
				dogOwnerss.setCardType(card.getCardType());
				dogOwnerss.setCardNum(card.getCardNum());
				dogOwnerss.setDogOwnerCardId(card.getDogOwnerCardId());
				dogCardMapper.updateDogOwnerCard(dogOwnerss);
			}else {
				//插入犬主证件信息
				tDogOwnerCardMapper.insertSelective(card);
			}
			//根据犬名和犬主id判断犬是否存在
			Integer s=tVaccineMapper.getDogIds(dogOwnerId.intValue(),dogInfo.getDogName());
			Long dogId=null;
			if (s!=null){
				dogId=s.longValue();
			}

			//tVaccineMapper.get
			//Long dogId = null;

			if (dogId!=null){

			}else {
				//3.返回犬主主键,
				dogInfo.setDogOwnerId(dogOwnerId);
				dogInfo.setCreationTime(new Date());
				//4.插入犬只信息
				tDogInfoMapper.insertSelective(dogInfo);
				//返回自增dogId
				dogId= dogInfo.getDogId();
			}
			dogIdAndOwnerId.setDogId(dogId);
			// 1.获取免疫证信息
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());//设置起时间
			cal.add(Calendar.YEAR, 20);//增加20年
			dogImmune.setCreationTime(new Date());
			dogImmune.setStartTime(new Date());
			dogImmune.setEndTime(cal.getTime());
			dogImmune.setDogId(dogId);
			dogImmune.setDogOwnerId(dogOwnerId);
			dogImmune.setImmuneCardNum(dogImmune.getImmuneCardNum());
			dogImmune.setLssueTime(new Date());
			dogImmune.setStatus(1);
			//插入免疫证信息
			tImmuneCardMapper.insertSelective(dogImmune);
			Map<String,Object>  map = new HashMap<>();
			map.put("dog_id",dogId);
			map.put("org_id",dogInfo.getDogImmune().getLssueOrgId());
			map.put("first_injection_date",new Date());
			Integer id=tVaccineMapper.getVaccineRegisterIds(dogId.intValue(),dogInfo.getDogImmune().getLssueOrgId());
			if(id==null || id.equals("")) {//if存在该免疫证登记id不添加免疫数据
				tVaccineMapper.addTVaccine(map);//添加免疫登记
			}
			//插入用户信息
			List<TUsers> users = usersMapper.selectUserByPhone(dogOwner.getDogOwnerPhone());
			if (users == null || users.size()<=0){
				//该电话用户不存在，添加用户
				UserVo tUsers = new UserVo();
				tUsers.setCreateTime(new Date());
				tUsers.setDogOwnId(dogImmune.getDogOwnerId());
				tUsers.setUsername(dogOwner.getDogOwnerPhone());
				tUsers.setPhone(dogOwner.getDogOwnerPhone());
				tUsers.setSex(dogOwner.getSex());
				tUsers.setEmail(dogOwner.geteMail());
				tUsers.setuStatus(1);
//				tUsers.setOrgType(inertDogCard.getOrgType());
				tUsers.setName(dogOwner.getDogOwnerName());
				tUsers.setRoleId(3);
				DogResult dogResult = userService.addUser(tUsers);
				if (dogResult.getStatus() !=200){
					throw new RuntimeException();
				}
			}
		}

		return dogIdAndOwnerId;
	}
	
	
		//根据免疫证号查询犬只信息,犬主信息,犬证号
		@Override
		public DogInspection findDogInspectionByImmuneCode(String immuneCardNum) throws UnsupportedEncodingException {
			immuneCardNum=new String(immuneCardNum.getBytes("ISO8859_1"), "UTF-8");
			return dogInspectionMapper.findDogInspectionByImmuneCode(immuneCardNum);
		}
		
		//查看年检记录详情 
		@Override
		public DogInspection findDogInspectionDetail(Integer inspectionsId) {
			return dogInspectionMapper.findDogInspectionDetail(inspectionsId);
		}
	
	//年检列表
	@Override
	public HashMap<String, Object> findDogInspectionList(Integer pageNumber, Integer pageSize, String searchKey,Integer orgId,Integer orgType) throws UnsupportedEncodingException {
		if(searchKey!=null) {
			searchKey=new String(searchKey.getBytes("ISO8859_1"), "UTF-8");
		}
		//map1用来返回数据
		HashMap<String, Object> map1=new HashMap<String, Object>();
		//1.从session中获得当前登录用户的相关信息(待完成)
		//2.获得当前登录人的部门id和部门类型
//		Integer orgId=1;
//		Integer orgType=1;
		//0犬只办,1收容所,2宠物医院
		//当机构类型不是宠物医院时,设置orgType为null
		if(orgType!=2) {
			orgType=null;
		}
		//map用来传递参数
		HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("searchKey", searchKey);
			map.put("orgId", orgId);
			map.put("orgType", orgType);
		//统计年检总记录数
		Integer totalRecord=dogInspectionMapper.findDogInspectionListRecord(map);
		Page page=new Page();
			page.setPageNumber(pageNumber);
			page.setPageSize(pageSize);
			page.setTotalRecord(totalRecord);
			Integer index=page.getIndex();
		if(index>=0) {
			map.put("index", index);
			map.put("pageSize", pageSize);
			List<DogInspection> inspectionList = dogInspectionMapper.findDogInspectionList(map);
			map1.put("inspectionList", inspectionList);
			map1.put("page", page);
		}
		return map1;
	}

	//插入年检信息
	@Override
	@Transactional
	public int insertInspection(DogInspection dogInspection) {
		return dogInspectionMapper.insertDogInspectionSelective(dogInspection);
	}

	//插入病历记录
	@Override
	public int insertTherapyRecord(TTherapy tTherapy) {
		try {
			int i=tTherapyMapper.insertSelective(tTherapy);
			if(i>0) {
				return tVaccineMapper.getVaccineRegisterId();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}
	
	//查看犬只品种，犬只颜色，和犬主区域
	@Override
	public HashMap<String, Object> findBreedColorDistrict() {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		TDictionaryExample example=new TDictionaryExample();
			Criteria criteria = example.createCriteria();
				List<String> values=new ArrayList<String>();
					values.add("dog_breed_type");
					values.add("dog_color_type");
				criteria.andDictionaryFieldIn(values);
		List<TDictionary> list = tDictionaryMapper.selectByExample(example);
		//品种集合
		List<TDictionary> breedList=new ArrayList<TDictionary>();
		//颜色集合
		List<TDictionary> colorList=new ArrayList<TDictionary>();
			for(TDictionary td:list) {
				if("dog_breed_type".equalsIgnoreCase(td.getDictionaryField())) {
					breedList.add(td);
				}else {
					colorList.add(td);
				}
			}
		TDistrictExample disDrictExample=new TDistrictExample();
			com.soholy.dogmanager.entity.TDistrictExample.Criteria criteria2 = disDrictExample.createCriteria();
				criteria2.andDistrictTypeEqualTo(2);
		//区域集合
		List<TDistrict>disTrictList=tDistrictMapper.selectByExample(disDrictExample);
		
			map.put("disTrictList", disTrictList);
			map.put("breedList", breedList);
			map.put("colorList", colorList);
		return map;
	}

	//查看详情中的病历列表
	@Override
	public List<TTherapy> findDetailTherapyList(Integer dogId, Integer orgId) {
		TTherapyExample example=new TTherapyExample();
			com.soholy.dogmanager.entity.TTherapyExample.Criteria criteria = example.createCriteria();
				criteria.andDogIdEqualTo((long)dogId);
				criteria.andOrgIdEqualTo(orgId);
				
		return therapyMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<String> getImmuneCardNumsList(String input) throws ServerException {
		List<String> list = new ArrayList<>();
        try {
            list = dogInfoMapper.getImmuneCardNumsList(input);
        } catch (Exception e){
            String log = "[犬证服务][查询所有免疫证号]：查询所有免疫证号失败！";
            //logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
	}

	/**
	 * 编辑免疫登记信息
	 * @param dogInfo
	 * @return
	 */
	@Transactional
	@Override
	public DogResult updateDogImmune(DogInfo dogInfo)throws Exception{
		try {
			DogImmune dogImmune = dogInfo.getDogImmune();
			TDogInfo tDogInfo = new TDogInfo();
			PropertyUtils.copyProperties(tDogInfo,dogInfo);
			//编辑免疫证信息
			tImmuneCardMapper.updateByPrimaryKeySelective(dogImmune);
			//编辑犬只信息
			tDogInfoMapper.updateByPrimaryKeySelective(tDogInfo);
			//编辑犬主信息
            DogOwner dogOwner = dogInfo.getDogOwner();
            TUsers user = usersMapper.getUserByOwnerId(dogOwner.getDogOwnerId());
            //如果传过来的电话和用户电话不一致，则修改了电话，需要重置密码
            if (!user.getPhone().equals(dogOwner.getDogOwnerPhone())){
				userService.updatePhone(user.getUserId(),dogOwner.getDogOwnerPhone());
            }
            tDogOwnerMapper.updateByPrimaryKeySelective(dogOwner);
            //获取犬主证件信息
			TDogOwnerCard tDogOwnerCard = dogOwner.gettDogOwnerCard();
			//
			dogOwnerCardMapper.updateByPrimaryKeySelective(tDogOwnerCard);
			return DogResult.ok();
		} catch (Exception e) {
			throw new RuntimeException();
	    }
	}

	//===============================================================================================================

	/**
	 * 免疫登记
     * 添加犬只犬主
     * 生成免疫证
	 * */
	@Override
    @Transactional
	public DogResult saveImmuneRegister(ImmuneRegister immuneRegister) {
        HashMap<String, Object> immuneResult = new HashMap<>();
        //1	添加犬主信息
        TDogOwner dogOwner = immuneRegister.getDogOwner();
        dogOwner.setCreationTime(new Date());
        dogOwner.setStatus(0);
        if(StringUtils.isEmpty(dogOwner.getDogOwnerId())){
			 tDogOwnerMapper.insertSelective(dogOwner);
            TDogOwnerCard dogOwnerCard = immuneRegister.getDogOwnerCard();
            dogOwnerCard.setDogOwnerId(dogOwner.getDogOwnerId());
            dogOwnerCard.setCreationTime(new Date());
            tDogOwnerCardMapper.insertSelective(dogOwnerCard);
		}
        immuneResult.put("dogOwnerId",dogOwner.getDogOwnerId());
		//2 添加犬只信息
            TDogInfo dogInfo = immuneRegister.getDogInfo();
            dogInfo.setDogOwnerId(dogOwner.getDogOwnerId());
            dogInfo.setCreationTime(new Date());
            dogInfo.setDogStatus(0);
		    tDogInfoMapper.insertSelective(dogInfo);
            immuneResult.put("dogId",dogInfo.getDogId());
                //3 生成免疫证
                ImmuneCard immuneCard = immuneRegister.getImmuneCard();
                immuneCard.setCreationTime(new Date());
                immuneCard.setStartTime(new Date());
                immuneCard.setDogId(dogInfo.getDogId());
                immuneCard.setDogOwnerId(dogOwner.getDogOwnerId());
                tImmuneCardMapper.insertSelective(immuneCard);

        return DogResult.ok(immuneResult);
	}

    /**
     * 免疫登记
     * 添加犬只健康状况
     * */
    @Override
    public DogResult saveHealthCondition(HealthConditionDO healthConditionDO) {
        healthConditionDO.setCreateTime(new Date());
        healthConditionDO.setInspectTime(new Date());
        healthConditionDO.setStatus(1);
        healthConditionMapper.save(healthConditionDO);
        return DogResult.ok();
    }

    /**
     * 免疫登记
     * 添加免疫记录
     * */
    @Override
    @Transactional
    public DogResult saveImmuneRecord(ImmuneRegister immuneRegister) {
        Long dogId = immuneRegister.getVaccineRegister().getDogId();
        Long vaccineRegisterId=null;
        TVaccineRegisterExample example = new TVaccineRegisterExample();
        TVaccineRegisterExample.Criteria criteria = example.createCriteria();
        criteria.andDogIdEqualTo(dogId);
//        List<TVaccineRegister> tVaccineRegisters = vaccineRegisterMapper.selectByExample(example);
//        if(tVaccineRegisters.size()==0){
//            TVaccineRegister vaccineRegister = immuneRegister.getVaccineRegister();
//            vaccineRegister.setFirstInjectionDate(new Date());
//            vaccineRegister.setCreationTime(new Date());
//            vaccineRegister.setSchedule(1);
//            vaccineRegisterMapper.insertSelective(vaccineRegister);
            TVaccineInjection vaccineInjection = immuneRegister.getVaccineInjection();
//            vaccineInjection.setVaccineRegisterId(vaccineRegister.getVaccineRegisterId());
            vaccineInjection.setFactInjectionDate(new Date());
            vaccineInjection.setInjectionStatus(0L);
            vaccineInjection.setCreateDate(new Date());
            vaccineInjectionMapper.insertSelective(vaccineInjection);
            //------
		TImmuneCard tImmuneCard = immuneRegister.getImmuneCard();
		if (tImmuneCard.getSeqId()==null){
			String immuneCard = tImmuneCardMapper.selectImmuneCardNumById(dogId);
			if (immuneCard==null){
				String pre=tImmuneCardMapper.selectImmunePre();
				String immuneCardNum=tImmuneCardMapper.selectImmuneCardNum();
				String immuneCardNumxin = null;
				if (immuneCardNum==null){
					immuneCardNumxin=pre+"000001";
				}else {
					String suf=immuneCardNum.substring(immuneCardNum.length()-6);
					Integer suff=Integer.parseInt(suf);
					suff++;
					immuneCardNumxin = String.format("%06d", suff);
					immuneCardNumxin=pre+immuneCardNumxin;
				}
				// 1.获取免疫证信息
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());//设置起时间
				cal.add(Calendar.YEAR, 20);//增加20年
				tImmuneCard.setCreationTime(new Date());
				tImmuneCard.setStartTime(new Date());
				tImmuneCard.setEndTime(cal.getTime());
				tImmuneCard.setDogId(dogId);
//			tImmuneCard.setDogOwnerId(dogOwnerId);
				tImmuneCard.setImmuneCardNum(immuneCardNumxin);
				tImmuneCard.setLssueTime(new Date());
				tImmuneCard.setStatus(1);
				//插入免疫证信息
				tImmuneCardMapper.insertSelective(tImmuneCard);
			}
		}
		//------
//        }else if(tVaccineRegisters.size()==1){
//            vaccineRegisterId=tVaccineRegisters.get(0).getVaccineRegisterId();
//            TVaccineInjection vaccineInjection = immuneRegister.getVaccineInjection();
//            vaccineInjection.setVaccineRegisterId(vaccineRegisterId);
//            vaccineInjection.setFactInjectionDate(new Date());
//            vaccineInjection.setInjectionStatus(0L);
//            vaccineInjection.setCreateDate(new Date());
//            vaccineInjectionMapper.insertSelective(vaccineInjection);
//        }else{
//           throw new RuntimeException("免疫登记数据有误");
//        }
        return DogResult.ok();
    }

	@Override
	public DogOwners findDogOwnerByPhone(String phone) {
        DogOwners dogOwners = tDogOwnerMapper.selectDogOwnerByPhone(phone);
        return dogOwners;
	}

    /**
     * 添加犬主
     * 生成用户
     */
	@Override
	@Transactional
	public DogResult saveDogOwner(DogOwnerDTO dogOwnerDTO){

        List<TUsers> usersList = usersMapper.selectUserByPhone(dogOwnerDTO.getDogOwnerPhone());
        if(usersList.size()>0){
			return  DogResult.build(100,"用户已存在，不能重复录入");
        }
        //1	添加犬主信息
        TDogOwner dogOwner = new TDogOwner();
        BeanUtils.copyProperties(dogOwnerDTO,dogOwner);
        dogOwner.setCreationTime(new Date());
		dogOwner.setStatus(0);
		tDogOwnerMapper.insertSelective(dogOwner);
        TDogOwnerCard dogOwnerCard = new TDogOwnerCard();
        BeanUtils.copyProperties(dogOwnerDTO,dogOwnerCard);
		dogOwnerCard.setDogOwnerId(dogOwner.getDogOwnerId());
		dogOwnerCard.setCreationTime(new Date());
		tDogOwnerCardMapper.insertSelective(dogOwnerCard);
		//2 生成用户
        UserVo tUsers = new UserVo();
        tUsers.setCreateTime(new Date());
        tUsers.setOrganizationId(dogOwner.getOrgId());
        tUsers.setSex(dogOwner.getSex());
        tUsers.setDogOwnId(dogOwner.getDogOwnerId());
        tUsers.setUsername(dogOwner.getDogOwnerPhone());
        tUsers.setPhone(dogOwner.getDogOwnerPhone());
        tUsers.setSex(dogOwner.getSex());
        tUsers.setuStatus(1);
        tUsers.setOrgType(4);
        tUsers.setName(dogOwner.getDogOwnerName());
        tUsers.setRoleId(3);
        userService.saveUser(tUsers);
		return DogResult.ok();
	}

	@Override
	public DogResult addDogOwner(DogOwnerDTO dogOwnerDTO) {
		try {
			if(dogOwnerDTO.getDogOwnerName()!=null&&dogOwnerDTO.getDogOwnerPhone()!=null){
				//1验证用户名是否存在
				if(usersMapper.getTUserByUserName(dogOwnerDTO.getDogOwnerName())!=null){
					return DogResult.build(400,"用户名已经存在，请重新输入");
				}
				//2验证手机号是否注册
				if(usersMapper.getTUserByPhone(dogOwnerDTO.getDogOwnerPhone())!=null){
					return DogResult.build(400,"手机号已经存在，请重新输入");
				}
				dogOwnerDTO.setStatus(0);
				dogOwnerDTO.setCreationTime(new Date());
				//添加犬主
				if(tDogOwnerMapper.insert(dogOwnerDTO)>0){
					//添加用户
					TUsers tUsers=new TUsers();
					tUsers.setDogOwnId(dogOwnerDTO.getDogOwnerId());
					tUsers.setOpenId("0");
					tUsers.setUsername(dogOwnerDTO.getDogOwnerName());
					tUsers.setPassword(Md5Encode.getCredentials(dogOwnerDTO.getDogOwnerName()//密码
							,dogOwnerDTO.getPassword()).toString());
					tUsers.setName(dogOwnerDTO.getDogOwnerName());
					tUsers.setPhone(dogOwnerDTO.getDogOwnerPhone());
					tUsers.setuStatus(1);
					tUsers.setCreationTime(new Date());
					if(usersMapper.insertUser(tUsers)>0){
						//添加用户角色关联表
						TUserRefRoles tUserRefRoles=new TUserRefRoles();
						tUserRefRoles.setRoleId(3);
						tUserRefRoles.setUserId(tUsers.getUserId());
						tUserRefRoles.setCreationTime(new Date());
						if(tUserRefRolesMapper.insert(tUserRefRoles)>0){
							return DogResult.build(200,"添加成功");
						}else {
							return DogResult.build(400,"添加用户角色关联失败");
						}
					}else {
						return DogResult.build(400,"添加用户失败");
					}
				}else {
					return DogResult.build(400,"添加犬主失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DogResult.build(400,"添加失败");
	}

	@Override
	public DogResult updPassword(DogOwnerDTO dogOwnerDTO) {
		try {
			//1判断用户名和手机号是否同一账号
			TUsers tUsers=usersMapper.getTUserByUserName(dogOwnerDTO.getDogOwnerName());
			if(null==tUsers){
				return DogResult.build(400,"用户名不正确");
			}
			TUsers tUserss=usersMapper.getTUserByPhone(dogOwnerDTO.getDogOwnerPhone());
			if(null==tUserss){
				return DogResult.build(400,"手机号不正确");
			}
			if(tUsers.getUserId().intValue()!=tUserss.getUserId().intValue()){
				return DogResult.build(400,"用户名和手机号不匹配");
			}
			String password=Md5Encode.getCredentials(dogOwnerDTO.getDogOwnerName(),dogOwnerDTO.getPassword()).toString();
			//2修改密码
			if(usersMapper.updPasswordById(tUsers.getUserId().intValue(),password)>0){
				return DogResult.build(200,"修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"出现错误");
		}
		return DogResult.build(400,"修改失败，稍后重试");
	}

	@Override
    public Page<DogOwnerDTO> findDogOwnerList(HashMap<String,Object> map){
        int num = Integer.parseInt(map.get("num").toString());
        int size = Integer.parseInt(map.get("size").toString());

        Page<DogOwnerDTO> page = new Page<>();
        page.setPageNumber(num);
        page.setPageSize(size);
        page.setTotalRecord(tDogOwnerMapper.findDogOwnerListCount(map));
        if (page.getIndex()<0) {
            return page;
        }
        map.put("index", page.getIndex());
        map.put("pageSize", size);
        List<DogOwnerDTO> dogOwnerList = tDogOwnerMapper.findDogOwnerList(map);
        page.setLists(dogOwnerList);
        return page;
    }

    @Override
    public DogOwnerDTO findDogOwnerById(Long dogOwnerId) {
        return tDogOwnerMapper.findDogOwnerById(dogOwnerId);
    }

    @Override
    public DogInfoVO findDogInfoVOById(Long dogId) {
        DogInfoVO dogInfoVO = tdogInfoMapper.findDogInfoVOById(dogId);
        return  dogInfoVO;
    }

    @Override
    public void saveDog(TDogInfo dogInfo) {
        dogInfo.setCreationTime(new Date());
        dogInfo.setDogStatus(0);
        tDogInfoMapper.insertSelective(dogInfo);
    }

    @Override
    @Transactional
    public DogResult updateDogOwner(DogOwnerVO2 dogOwnerVO2) {

        //1.判断联系电话是否改变
        TDogOwner tDogOwner = tDogOwnerMapper.selectByPrimaryKey(dogOwnerVO2.getDogOwnerId());
        String oldDogOwnerPhone = tDogOwner.getDogOwnerPhone();
        String newDogOwnerPhone = dogOwnerVO2.getDogOwnerPhone();

        if(!oldDogOwnerPhone.equals(newDogOwnerPhone)){

			List<TUsers> usersList = usersMapper.selectUserByPhone(newDogOwnerPhone);
			if(usersList.size()>0){
				return  DogResult.build(100,"用户已存在，不能重复录入");
			}
            //2.如果联系电话发生变化
            String randomNumber = MathUtils.getRandomNumber();
            String password = Md5Encode.getCredentials(newDogOwnerPhone, randomNumber).toString();
            //2.1 修改用户
            int i = usersMapper.updateUserByName(newDogOwnerPhone, password, oldDogOwnerPhone);
            if(i!=1){
                throw new RuntimeException("修改用户失败oldDogOwnerPhone:"+oldDogOwnerPhone);
            }
            //2.2 发短信
            Map<String, String> params = new HashMap<>();
            params.put("phone", newDogOwnerPhone);
            Map<String, String> template_param = new HashMap<>();
            template_param.put("name",dogOwnerVO2.getDogOwnerName() );
            template_param.put("username", newDogOwnerPhone);
            template_param.put("password", randomNumber);
            params.put("template_param", JSONObject.toJSONString(template_param));
            new Thread(() -> {
                try {
                    HttpResult httpResult = HttpClientUtil.executeHttpParams(sms_base_url + "/PassWordSMS", "post", params);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //3.修改犬主信息
        TDogOwner dogOwner = new TDogOwner();
        BeanUtils.copyProperties(dogOwnerVO2,dogOwner);
        tDogOwnerMapper.updateByPrimaryKeySelective(dogOwner);
        TDogOwnerCard ownerCard = new TDogOwnerCard();
        BeanUtils.copyProperties(dogOwnerVO2,ownerCard);
        tDogOwnerCardMapper.updateByPrimaryKeySelective(ownerCard);
		return  DogResult.ok();
    }

    @Override
    public void updateDog(TDogInfo dogInfo) {
        tdogInfoMapper.updateByPrimaryKeySelective(dogInfo);
    }

    @Override
    @Transactional
    public void deletePic(Long fid){
        TImages images = imagesMapper.selectByPrimaryKey(fid);
        String url = images.getImageUrl();
        String suburl = url.substring(url.indexOf("group"));
        String url_group_name = suburl.split("/")[0];
        String url_remote_filename = suburl.substring(suburl.indexOf("/")+1);
        FileUpload.deletePic(url_group_name, url_remote_filename);
        String thumbnailUrl = images.getThumbnailUrl();
        String subThumbnailUrl = thumbnailUrl.substring(thumbnailUrl.indexOf("group"));
        String thu_group_name = subThumbnailUrl.split("/")[0];
        String thu_remote_filename = subThumbnailUrl.substring(subThumbnailUrl.indexOf("/")+1);
        FileUpload.deletePic(thu_group_name, thu_remote_filename);
        imagesMapper.deleteByPrimaryKey(fid);
        TImagesRefExample example = new TImagesRefExample();
        example.createCriteria().andImageIdEqualTo(fid);
        imagesRefMapper.deleteByExample(example);
    };
}

