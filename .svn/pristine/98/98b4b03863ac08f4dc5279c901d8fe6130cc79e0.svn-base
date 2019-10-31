package com.soholy.dogmanager.service.dogCard.impl;

import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.exception.GlobalException;
import com.soholy.dogmanager.common.httpclient.HttpClientUtil;
import com.soholy.dogmanager.common.httpclient.HttpResult;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.exception.DataMismatchException;
import com.soholy.dogmanager.exception.SubmitRepeatException;
import com.soholy.dogmanager.mapper.*;
import com.soholy.dogmanager.mapper.dogCard.DogAndOwnerMapper;
import com.soholy.dogmanager.mapper.dogCard.DogCardMapper;
import com.soholy.dogmanager.mapper.statistic.DogInfoMapper;
import com.soholy.dogmanager.pojo.dogCard.DeviceRefDog;
import com.soholy.dogmanager.pojo.dogCard.InertDogCard;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.dogCard.DogCardService;
import com.soholy.dogmanager.service.notice.NoticeService;
import com.soholy.dogmanager.service.user.UserService;
import org.apache.http.ParseException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DogCardServiceImpl implements DogCardService {
    private static final Logger logger = Logger.getLogger(DogCardServiceImpl.class);
    @Autowired
    DogCardMapper dogCardMapper;
    @Autowired
    TDogCardMapper tDogCardMapper;
    @Autowired
    TDeviceRefDogMapper tDeviceRefDogMapper;
    @Autowired
    DogAndOwnerMapper dogAndOwnerMapper;
    @Autowired
    TUsersMapper tUsersMapper;
    @Autowired
    TMemberCardMapper tMemberCardMapper;
    @Autowired
    private DogInfoMapper dogInfoMapper;
    @Autowired
    UserService userService;
    @Autowired
    private TDeviceMapper tDeviceMapper;
    @Autowired
    private TDogOwnerCardMapper tDogOwnerCardMapper;
    @Autowired
    private TImmuneCardMapper tImmuneCardMapper;
    @Value("${SMS_BASE_URL}")
    private String sms_base_url;

    @Autowired
    private NoticeService noticeService;


    //查看犬证详情或查看犬只详情包含犬只所有详细信息
    @Override
    public DogAllInfo selectDogCardInfo(String cardNum, Long dogid) throws ServerException {
        if (StringUtils.isEmpty(cardNum) && dogid == null) {
            String log = "[犬证服务][查询犬证详情]：免疫证号和犬id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        if (StringUtils.isEmpty(cardNum)) {
            cardNum = null;
        }
        if (dogid != null) {
            cardNum = null;
        }
        DogInfo tDogInfo = null;
        DogOwners dogOwners = null;
        ImmuneCard immuneCard = null;
        DogCard dogCard = null;
        List<Device> devices = null;
        TMemberCard tMemberCard = null;
        List<Photos> urllsit = new ArrayList<>();//狗照片url集合
        List<Photos> ownerUrllsit = new ArrayList<>();//狗主照片url集合
        List<Therapy> therapyList = new ArrayList<>();//病历对象集合
        List<Vaccine> vaccineList = new ArrayList<>();//防疫信息集合
        List<InspectionsInfo> inspectionsInfoList = new ArrayList<>();//年检记录集合
        List<Violation> violationList = new ArrayList<>();//违法信息集合
        DogAllInfo dogAllInfo = new DogAllInfo();
        boolean bl = false;
        Long dogId = null;
        if (dogid!=null){
            dogId=dogid;
        }
        Long ownerId = null;
        try {
            immuneCard = dogCardMapper.selectImmuneCard(cardNum, dogid);
            if (null != immuneCard) {
                bl = true;
                dogAllInfo.setImmuneCard(immuneCard);
                dogId = immuneCard.getDogId();
                ownerId = immuneCard.getDogOwnerId();
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证免疫信息]：查询犬证免疫信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            tDogInfo = dogAndOwnerMapper.selectDogInfo(dogId);
            ownerId = tDogInfo.getDogOwnerId();
            dogAllInfo.setDogInfo(tDogInfo);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证犬详情]：查询犬证犬详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            dogOwners = dogAndOwnerMapper.selectDogOwners(ownerId);
            dogAllInfo.setDogOwners(dogOwners);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证犬主详情]：查询犬证犬主详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                tMemberCard = tMemberCardMapper.selectTMemberCardByOwner(ownerId);
                dogAllInfo.settMemberCard(tMemberCard);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证会员证详情]：查询犬证会员证详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                devices = dogCardMapper.selectDevice(dogId);
                dogAllInfo.setDevices(devices);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证设备信息]：查询犬证设备信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                dogCard = dogCardMapper.selectDogCard(dogId);
                dogAllInfo.setDogCard(dogCard);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证信息]：查询犬证信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            urllsit = dogAndOwnerMapper.selectDogPhotos(dogId);
            dogAllInfo.setUrlLsit(urllsit);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证照片]：查询犬证照片失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            ownerUrllsit = dogAndOwnerMapper.selectDogOwnerPhotos(ownerId);
            dogAllInfo.setOwnerUrlLsit(ownerUrllsit);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证照片]：查询犬主照片失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            therapyList = dogAndOwnerMapper.selectTherapys(dogId);
            dogAllInfo.setTherapyList(therapyList);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬病历]：查询犬病历失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                vaccineList = dogAndOwnerMapper.selectVaccines(dogId);
                dogAllInfo.setVaccineList(vaccineList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬防疫信息]：查询犬防疫信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                inspectionsInfoList = dogAndOwnerMapper.selectInspectionsInfos(dogId);
                dogAllInfo.setInspectionsInfoList(inspectionsInfoList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬年检记录]：查询犬年检记录失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                violationList = dogAndOwnerMapper.selectViolations(dogId);
                dogAllInfo.setViolationList(violationList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬违法信息]：查询犬违法信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogAllInfo;
    }

    //查看犬证详情或查看犬只详情包含犬只所有详细信息
    @Override
    public DogAllInfo selectDogCardInfoByDevice(String deviceNum) throws ServerException {
        if (StringUtils.isEmpty(deviceNum)) {
            String log = "[犬证服务][查询犬证详情]：设备编号为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        DogInfo tDogInfo = null;
        DogOwners dogOwners = null;
        ImmuneCard immuneCard = null;
        DogCard dogCard = null;
        List<Device> devices = null;
        TMemberCard tMemberCard = null;
        List<Photos> urllsit = new ArrayList<>();//狗照片url集合
        List<Therapy> therapyList = new ArrayList<>();//病历对象集合
        List<Vaccine> vaccineList = new ArrayList<>();//防疫信息集合
        List<InspectionsInfo> inspectionsInfoList = new ArrayList<>();//年检记录集合
        List<Violation> violationList = new ArrayList<>();//违法信息集合
        DogAllInfo dogAllInfo = new DogAllInfo();
        boolean bl = false;
        Long dogId = null;
        Long ownerId = null;
        try {
            dogId = dogCardMapper.selectDogIdByDeviceId(deviceNum);
        } catch (Exception e) {
            String log = "[犬证服务]：查询犬id失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        if(dogId==null){
            return null;
        }
        try {
            immuneCard = dogCardMapper.selectImmuneCard(null, dogId);
            if (null != immuneCard) {
                bl = true;
                dogAllInfo.setImmuneCard(immuneCard);
                ownerId = immuneCard.getDogOwnerId();
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证免疫信息]：查询犬证免疫信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                tDogInfo = dogAndOwnerMapper.selectDogInfo(dogId);
                ownerId = tDogInfo.getDogOwnerId();
                dogAllInfo.setDogInfo(tDogInfo);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证犬详情]：查询犬证犬详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                dogOwners = dogAndOwnerMapper.selectDogOwners(ownerId);
                dogAllInfo.setDogOwners(dogOwners);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证犬主详情]：查询犬证犬主详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                tMemberCard = tMemberCardMapper.selectTMemberCardByOwner(ownerId);
                dogAllInfo.settMemberCard(tMemberCard);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证会员证详情]：查询犬证会员证详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                devices = dogCardMapper.selectDevice(dogId);
                dogAllInfo.setDevices(devices);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证设备信息]：查询犬证设备信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                dogCard = dogCardMapper.selectDogCard(dogId);
                dogAllInfo.setDogCard(dogCard);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证信息]：查询犬证信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                urllsit = dogAndOwnerMapper.selectDogPhotos(dogId);
                dogAllInfo.setUrlLsit(urllsit);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬证照片]：查询犬证照片失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                therapyList = dogAndOwnerMapper.selectTherapys(dogId);
                dogAllInfo.setTherapyList(therapyList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬病历]：查询犬病历失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                vaccineList = dogAndOwnerMapper.selectVaccines(dogId);
                dogAllInfo.setVaccineList(vaccineList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬防疫信息]：查询犬防疫信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                inspectionsInfoList = dogAndOwnerMapper.selectInspectionsInfos(dogId);
                dogAllInfo.setInspectionsInfoList(inspectionsInfoList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬年检记录]：查询犬年检记录失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        try {
            if (bl) {
                violationList = dogAndOwnerMapper.selectViolations(dogId);
                dogAllInfo.setViolationList(violationList);
            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬违法信息]：查询犬违法信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogAllInfo;
    }

    //办理犬证
    @Override
    @Transactional
    public void insertDogCard(InertDogCard inertDogCard, String clientIp) throws ServerException, ParseException, IOException, URISyntaxException, SubmitRepeatException, DataMismatchException {
        if (inertDogCard == null) {
            String log = "[犬证服务][办理犬证]：参数为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        if (inertDogCard.getDogId() == null) {
            String log = "[犬证服务][办理犬证]：犬id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        if (inertDogCard.getDogOwnerId() == null) {
            String log = "[犬证服务][办理犬证]：犬主id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        String dogCardNum = dogAndOwnerMapper.selectDodCarDogId(inertDogCard.getDogCardNum());
        if (dogCardNum != null) {
            String log = "[犬证服务][办理犬证]：重复提交！";
            logger.error(log);
            throw new SubmitRepeatException(log);
        }
//        DogOwners dogOwnerss=null;
//        try {
//            dogOwnerss = dogAndOwnerMapper.selectDogOwners(inertDogCard.getDogOwnerId());
//        } catch (Exception e) {
//            String log = "[犬证服务][办理犬证]：插入犬证信息失败！";
//            logger.error(log, e);
//            throw new ServerException(log, e);
//        }
//        if (inertDogCard.getName()!=dogOwnerss.getDogOwnerName() || inertDogCard.getPhone()!=dogOwnerss.getDogOwnerPhone() || inertDogCard.getCardType()!=dogOwnerss.getCardType() || inertDogCard.getCardNum()!=dogOwnerss.getCardNum()){
//            String log = "[犬证服务][办理犬证]：插入犬证信息失败！";
//            logger.error(log);
//            throw new DataMismatchException(log);
//        }
//        if (inertDogCard.getDeviceId() == null) {
//            String log = "[犬证服务][办理犬证]：设备id为空！";
//            logger.error(log);
//            throw new IllegalArgumentException(log);
//        }
//        if (inertDogCard.getLssueOrgId() == null) {
//            String log = "[犬证服务][办理犬证]：办理机构id为空！";
//            logger.error(log);
//            throw new IllegalArgumentException(log);
//        }
//        if (inertDogCard.getLssuerId() == null) {
//            String log = "[犬证服务][办理犬证]：办理人id为空！";
//            logger.error(log);
//            throw new IllegalArgumentException(log);
//        }
//        Long refDogId = (long) ((Math.random() * 9 + 1) * 100000);
//        UserVo tUsers = new UserVo();
//        tUsers.setCreateTime(new Date());
//        tUsers.setDogOwnId(inertDogCard.getDogOwnerId());
//        tUsers.setUsername(inertDogCard.getPhone());
//        tUsers.setPhone(inertDogCard.getPhone());
//        tUsers.setSex(inertDogCard.getGender());
//        tUsers.setEmail(inertDogCard.getEmail());
//        tUsers.setuStatus(1);
//        tUsers.setOrgType(inertDogCard.getOrgType());
//        tUsers.setName(inertDogCard.getName());
//        tUsers.setRoleId(3);
//        String dogCardNum = RandomStringUtils.random(8, "1234567890");
        TDogCard tDogCard = new TDogCard();
        tDogCard.setDogId(inertDogCard.getDogId());
        tDogCard.setDogOwnerId(inertDogCard.getDogOwnerId());
        tDogCard.setDogCardNum(inertDogCard.getDogCardNum());
        tDogCard.setMemberCardId(inertDogCard.getMemberCardId());
        tDogCard.setStartTime(inertDogCard.getStartTime());
        tDogCard.setEndTime(inertDogCard.getEndTime());
        tDogCard.setLssueTime(inertDogCard.getLssueTime());
        tDogCard.setLssueOrgId(inertDogCard.getLssueOrgId());
        tDogCard.setLssuerId(inertDogCard.getLssuerId());
        if (inertDogCard.getStatus() == null) {
            tDogCard.setStatus(1);
        } else {
            tDogCard.setStatus(inertDogCard.getStatus());
        }
        tDogCard.setCreationTime(new Date());
        String deviceId=tDeviceRefDogMapper.selectDeviceIdByImmi(inertDogCard.getDeviceId());
        List<TDeviceRefDog> listt=tDeviceRefDogMapper.findDeviceBindInfo(inertDogCard.getDeviceId());
        TDeviceRefDog tDeviceRefDog = new TDeviceRefDog();
//        tDeviceRefDog.setDeviceRefDogId(null);
        tDeviceRefDog.setDeviceId(deviceId);
        tDeviceRefDog.setDogId(inertDogCard.getDogId() + "");
        tDeviceRefDog.setUseStatus(0);
        tDeviceRefDog.setCreationTime(inertDogCard.getCreationTime());
        tDeviceRefDog.setExpireTime(inertDogCard.getExpireTime());

        DogOwners dogOwners = new DogOwners();
        dogOwners.setDogOwnerId(inertDogCard.getDogOwnerId());
        dogOwners.setDogOwnerName(inertDogCard.getName());
        dogOwners.setSex(inertDogCard.getGender());
        dogOwners.setEthnic(inertDogCard.getEthnic());
        dogOwners.setBirthDate(inertDogCard.getBirthday());
        dogOwners.seteMail(inertDogCard.getEmail());
        dogOwners.setDistrictId(inertDogCard.getDistrictId());
        dogOwners.setCommunity(inertDogCard.getStreet());
        dogOwners.setAddress(inertDogCard.getAddrees());
        dogOwners.setDogOwnerCardId(inertDogCard.getDogOwnerCardId());
        dogOwners.setCardNum(inertDogCard.getCardNum());
        dogOwners.setCardType(inertDogCard.getCardType());
        try {
            if (inertDogCard.getSeqNum() == null) {
                tDogCardMapper.insert(tDogCard);
            } else {
                dogCardMapper.dogCardAudit(inertDogCard.getDogId(), 1, inertDogCard.getLssueOrgId(), inertDogCard.getLssuerId(), inertDogCard.getDogCardNum(), inertDogCard.getReason(), new Date(), inertDogCard.getEndTime());
            }
            dogAndOwnerMapper.updatetDogOwner(dogOwners);
            if (inertDogCard.getDogOwnerCardId() == null) {
                TDogOwnerCard card = new TDogOwnerCard();
                card.setCardNum(inertDogCard.getCardNum());
                card.setCardType(inertDogCard.getCardType());
                card.setDogOwnerId(inertDogCard.getDogOwnerId());
                card.setCreationTime(new Date());
                tDogOwnerCardMapper.insertSelective(card);
            } else {
                dogCardMapper.updateDogOwnerCard(dogOwners);
            }
            if (listt.size()>0){}else {
                tDeviceRefDogMapper.insert(tDeviceRefDog);
                dogCardMapper.updateDevice(Integer.parseInt(deviceId), inertDogCard.getStatus(), inertDogCard.getCreationTime(), inertDogCard.getLssueOrgId());
            }
//            userService.addUser(tUsers);
        } catch (Exception e) {
            String log = "[犬证服务][办理犬证]：插入犬证信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
//        String smsUrl = "http://api.189.cn/v2/emp/templateSms/sendSms";
//        // 时间戳，格式yyyy-MM-dd HH:mm:ss
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        params.put("timestamp", format.format(new Date()));
//        try {
//            HttpResult result = HttpClientUtil.executeHttpParams(smsUrl, "post", params);
//            String content = result.getContent();
//            JSONObject JsonContent = JSONObject.parseObject(content);
//            // 获取电信接口返回码
//            String res_code = JsonContent.getString("res_code");
//            logger.info("电信接口返回数据:"+content);
////            System.out.println(res_code);
////            if (Integer.parseInt(res_code) == 0) {
////                return Result.ok(content);
////            } else {
////                // 后续添加
////                return Result.build(Integer.parseInt(res_code), content);
////            }
//        } catch (ParseException e) {
//            String log = "[犬证服务][办理犬证]：服务器异常，发送密码短信失败！";
//            logger.error(log, e);
//            throw new ParseException();
//        } catch (IOException e) {
//            String log = "[犬证服务][办理犬证]：服务器异常，发送密码短信失败！";
//            logger.error(log, e);
//            throw new IOException();
//        } catch (URISyntaxException e) {
//            String log = "[犬证服务][办理犬证]：服务器异常，发送密码短信失败！";
//            logger.error(log, e);
//            throw new URISyntaxException(log,log);
//        }
    }

    //根据设备编号查询设备id
    @Override
    public Integer selectDeviceId(String deviceNumber) throws ServerException {
        if (deviceNumber == null) {
            String log = "[犬证服务][查询设备id]：设备编号为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        Integer deviceId = null;
        try {
            deviceId = dogCardMapper.selectDeviceId(deviceNumber);
        } catch (Exception e) {
            String log = "[犬证服务][查询设备id]：查询设备id失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return deviceId;
    }


    //根据设备编号查询犬id
    @Override
    public Long selectDogIdByDeviceId(String deviceNumber) throws ServerException {
        if (deviceNumber == null) {
            String log = "[犬证服务][根据设备编号查询犬id]：设备编号为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        Long dogId = null;
        try {
            dogId = dogCardMapper.selectDogIdByDeviceId(deviceNumber);
        } catch (Exception e) {
            String log = "[犬证服务][根据设备编号查询犬id]：查询犬id失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogId;
    }

    //医院查询犬列表
    @Override
    public List<DogCardRelatedInfo> selectDogInfos(Integer status, Integer orgId, String input, Integer num, Integer size) throws ServerException {
        int start = 0;
        PageInfo page = new PageInfo();
        if (num == null) {
            start = 0;
            page.setPageNum(1);
        } else if (num.intValue() == 1) {
            start = 0;
        } else {
            page.setPageNum(num);
            start = (num - 1) * size;
        }
        if (size == null) {
            size = (PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(size);
        }
        List<DogCardRelatedInfo> list = new ArrayList<DogCardRelatedInfo>();
        try {
            list = dogCardMapper.selectDogInfos(status, orgId, input, start, size);
        } catch (Exception e) {
            String log = "[犬证服务][犬证列表]：查询犬证列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    //医院查询犬列表分页总数
    @Override
    public PageInfo selectDogInfosPage(Integer status, Integer orgId, String input, Integer num, Integer size) throws ServerException {
        int start = 0;
        Integer count = null;
        PageInfo page = new PageInfo();
        if (num == null) {
            start = 0;
            page.setPageNum(1);
        } else {
            page.setPageNum(num);
        }
        if (size == null) {
            size = (PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(size);
        }
        try {
            count = dogCardMapper.selectDogInfosCount(status, orgId, input, start, size);
        } catch (Exception e) {
            String log = "[犬证服务][犬证列表]：查询犬证列表总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        if (page.isFirst()) {
            start = 0;
        } else {
            start = (page.getTotalStart());
        }
        return page;
    }

    //犬证续期
    @Override
    public void updateCardDate(Long dogId, Date endDate) throws ServerException {
        if (dogId == null) {
            String log = "[犬证服务][犬证续期]：犬证id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        try {
            dogCardMapper.updateCardDate(dogId, endDate);
        } catch (Exception e) {
            String log = "[犬证服务][犬证续期]：犬证续期失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    //查询电子犬证
    @Override
    public List<ElectronicDogCard> selectElectronicDogCard(Long userId) throws ServerException {
        if (userId == null) {
            String log = "[犬证服务][电子犬证]：用户id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        List<ElectronicDogCard> electronicDogCard = new ArrayList<ElectronicDogCard>();
        try {
            electronicDogCard = dogCardMapper.selectElectronicDogCard(userId);
        } catch (Exception e) {
            String log = "[犬证服务][电子犬证]：查询电子犬证失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return electronicDogCard;
    }

    //查查询条件
    @Override
    public List<Conditions> selectConditions(Integer logg) throws ServerException {
        if (logg == null) {
            String log = "[犬证服务][电子犬证]：用户id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        List<Conditions> list = new ArrayList<>();
        try {
            if (logg.intValue() == 1) {//1表示查犬种类
                list = dogCardMapper.selectDogSpecies();
            } else if (logg.intValue() == 2) {//2表示查犬毛色
                list = dogCardMapper.selectDogColor();
            } else if (logg.intValue() == 3) {//3.查收容原因
                list = dogCardMapper.selectDogCollType();
            } else if (logg.intValue() == 4) {//4.查违规类型
                list = dogCardMapper.selectViolationType();
            }
        } catch (Exception e) {
            String log = "[犬证服务][查查询条件]：查查询条件失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    //查所有的免疫证号
    @Override
    public List<String> selectImmuneCardNums(String input) throws ServerException {
        List<String> list = new ArrayList<>();
        try {
            list = dogCardMapper.selectImmuneCardNums(input);
        } catch (Exception e) {
            String log = "[犬证服务][查询所有免疫证号]：查询所有免疫证号失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    @Override
    public TDogInfo fondDogInfoByDeviceNum(String deviceNum) {
        if (StringUtils.isEmpty(deviceNum)) return null;
        return dogInfoMapper.fondDogInfoByDeviceNum(deviceNum);
    }

    /**
     * 根据犬图id删犬图
     *
     * @param picId
     * @throws ServerException
     */
    @Transactional
    @Override
    public void delectPic(Long picId) throws ServerException {
        try {
            dogCardMapper.delectPic(picId);
            dogCardMapper.delectPicRef(picId);
        } catch (Exception e) {
            String log = "[删除犬只照片失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    @Override
    public DogAllInfo selectDogCardInfoByDeviceImei(String imei) throws ServerException {
        TDeviceExample example = new TDeviceExample();
        example.createCriteria().andImeiEqualTo(imei);
        List<TDevice> tDevices = tDeviceMapper.selectByExample(example);
        if (tDevices != null && tDevices.size() == 1) {
            return this.selectDogCardInfoByDevice(tDevices.get(0).getDeviceNumber());
        }
        return null;
    }

    @Override
    public List<DogAllInfo> selectDogCardInfoByDeviceImeis(List<String> deviceIds) throws ServerException {
        List<DogAllInfo> dogAllInfos = new ArrayList<>();
        for (String deviceId:deviceIds) {
            DogAllInfo dogAllInfo = this.selectDogCardInfoByDeviceImei(deviceId);
            if (dogAllInfo != null && !dogAllInfo.equals("")){
                dogAllInfos.add(dogAllInfo);
            }
        }
        return dogAllInfos;
    }

    @Override
    public boolean bindDeviceByDeviceId(long deviceId, long dogId) {
        TDevice record = new TDevice();
        record.setStartTime(Calendar.getInstance().getTime());
        record.setDeviceStatus(1);//启用
        record.setDeviceId(deviceId);
        tDeviceMapper.updateByPrimaryKeySelective(record);

        TDeviceRefDog record2 = new TDeviceRefDog();
        record2.setUseStatus(0);//使用中
        TDeviceRefDogExample example = new TDeviceRefDogExample();
        example.createCriteria().andDeviceIdEqualTo(String.valueOf(deviceId));
        if (0 == tDeviceRefDogMapper.updateByExampleSelective(record2, example)) {
            record2.setDeviceId(String.valueOf(deviceId));
            record2.setDogId(String.valueOf(dogId));
            record2.setCreationTime(Calendar.getInstance().getTime());
            return 1 == tDeviceRefDogMapper.insertSelective(record2);
        }
        return true;
    }

    @Override
    public DeviceRrfDog findDeviceBindInfo(String imei) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(imei)) {
            DeviceRrfDog deviceRrfDog = new DeviceRrfDog();
            TDeviceExample example = new TDeviceExample();
            example.createCriteria().andImeiEqualTo(imei).andDeviceStatusNotEqualTo(1);//没有启用
            List<TDevice> tDevices = tDeviceMapper.selectByExample(example);
            if (tDevices != null && tDevices.size() == 1) {
                deviceRrfDog.settDevice(tDevices.get(0));
                TDeviceRefDogExample exampleR = new TDeviceRefDogExample();
                exampleR.createCriteria().andDeviceIdEqualTo(tDevices.get(0).getDeviceId().toString());
                List<TDeviceRefDog> tDeviceRefDogs = tDeviceRefDogMapper.selectByExample(exampleR);
                if (tDeviceRefDogs != null && tDeviceRefDogs.size() > 0) {
                    deviceRrfDog.settDeviceRefDog(tDeviceRefDogs);
                }
            }
            return deviceRrfDog;
        }
        return null;
    }

    @Override
    public List<DogAndDogOwnerInfo> findDogAllInfoByImcardNumOrSeqId(String immuneCardNum, Integer seqId) {
        if (org.apache.commons.lang3.StringUtils.isBlank(immuneCardNum) && seqId == null)
            return null;
        List<DogAndDogOwnerInfo> list = dogCardMapper.findDogAllInfoByImcardNumOrSeqId(immuneCardNum, seqId);
        if (list != null && list.size() > 0) {
            list.stream()
                    .filter(x -> x.gettDogOwnerCardVo() != null)
                    .forEach(x -> {
                        HashSet<Long> ids = new HashSet<>();
                        List<TDogOwnerCardVo> collect = x.gettDogOwnerCardVo().stream()
                                .filter(y -> ids.add(y.getDogOwnerCardId()))
                                .collect(Collectors.toList());
                        x.settDogOwnerCardVo(collect);
                    });

            list.stream()
                    .filter(x -> x.getImageList() != null)
                    .forEach(x -> {
                        List<TImagesRefImageRef> collect = x.getImageList()
                                .stream()
                                .filter(y -> y.gettImagesRef() != null)
                                .filter(y -> y.gettImagesRef().getTargetType() != null)
                                .filter(y -> y.gettImagesRef().getTargetType() == 2 || y.gettImagesRef().getTargetType() == 10)
                                .collect(Collectors.toList());

                        List<TImagesRefImageRef> collect2 = x.getImageList()
                                .stream()
                                .filter(y -> y.gettImagesRef() != null)
                                .filter(y -> y.gettImagesRef().getTargetType() != null)
                                .filter(y -> y.gettImagesRef().getTargetType() == 11 || y.gettImagesRef().getTargetType() == 12 || y.gettImagesRef().getTargetType() == 13)
                                .collect(Collectors.toList());

                        x.settDogInfoImages(collect);
                        x.settDogOwnerImages(collect2);
                    });
        }
        return list;
    }


    @Override
    public List<DogAndDogOwnerInfo> findAndCheckdCardInfoByImmuneNum(String immuneCardNum, String dogOwnerName, String phone, int cardType, String cardNum) {
        List<DogAndDogOwnerInfo> list = this.findDogAllInfoByImcardNumOrSeqId(immuneCardNum, null);
        if (list != null && list.size() > 0) {
            long resultCount = list.stream()
                    .filter(x -> x.gettDogOwnerCardVo() != null && x.gettDogOwner() != null)
                    .filter(x -> {
                        TDogOwner tDogOwner = x.gettDogOwner();
                        return phone.equals(tDogOwner.getDogOwnerPhone()) && dogOwnerName.equals(tDogOwner.getDogOwnerName());
                    })
                    .filter(x -> {
                        List<TDogOwnerCardVo> cardVos = x.gettDogOwnerCardVo();
                        if (cardVos != null && cardVos.size() > 0) {
                            long count = cardVos.stream()
                                    .filter(n -> n.getCardType() != null && n.getCardNum() != null)
                                    .filter(n -> cardNum.equals(n.getCardNum()) && cardType == n.getCardType())
                                    .count();
                            return count == 1;
                        }
                        return false;
                    })
                    .count();
            if (resultCount != 1) {
                throw new GlobalException("您输入信息不匹配");
            }

        }
        return list;
    }

    @Transactional
    @Override
    public boolean bindDeviceByDeviceImei(String imei, long dogId) throws GlobalException {
        List<DeviceRefDog> list = tDeviceMapper.findDeviceRefDogByDeviceImei(imei);
        if (list == null || list.size() == 0) {
            throw new GlobalException("设备不存在!");
        }
        if (list.get(0).gettDeviceRefDogs() != null && list.get(0).gettDeviceRefDogs().get(0).getDeviceRefDogId() != null
                && list.get(0).gettDeviceRefDogs().get(0).getUseStatus() == 0) {
            throw new GlobalException("该设备已被绑定！");
        }
        //绑定操作
        DeviceRefDog device = list.get(0);
        TDeviceRefDog record = new TDeviceRefDog();
        record.setDeviceId(device.getDeviceId().toString());
        record.setCreationTime(Calendar.getInstance().getTime());
        record.setDogId(String.valueOf(dogId));
        record.setUseStatus(0);//使用中

        //启用该设备
        TDevice deviceRecord = new TDevice();
        deviceRecord.setDeviceId(device.getDeviceId());
        deviceRecord.setDeviceStatus(1);//启用
        deviceRecord.setStartTime(Calendar.getInstance().getTime());
        tDeviceMapper.updateByPrimaryKeySelective(deviceRecord);
        return 1 == tDeviceRefDogMapper.insertSelective(record);
    }

    @Override
    public boolean bindDeviceByDeviceImei(String imei, long dogId, String devicePwd) throws GlobalException {
        List<DeviceRefDog> list = tDeviceMapper.findDeviceRefDogByDeviceImei(imei);
        if (list == null || list.size() == 0) {
            throw new GlobalException("设备不存在!");
        }
        if (list.get(0).gettDeviceRefDogs() != null && list.get(0).gettDeviceRefDogs().get(0).getDeviceRefDogId() != null
                && list.get(0).gettDeviceRefDogs().get(0).getUseStatus() == 0) {
            throw new GlobalException("该设备已被绑定！");
        }
        if (!list.get(0).getDevicePwd().equals(devicePwd)){
            throw new GlobalException("该设备密码错误");
        }
        //绑定操作
        DeviceRefDog device = list.get(0);
        TDeviceRefDog record = new TDeviceRefDog();
        record.setDeviceId(device.getDeviceId().toString());
        record.setCreationTime(Calendar.getInstance().getTime());
        record.setDogId(String.valueOf(dogId));
        record.setUseStatus(0);//使用中

        //启用该设备
        TDevice deviceRecord = new TDevice();
        deviceRecord.setDeviceId(device.getDeviceId());
        deviceRecord.setDeviceStatus(1);//启用
        deviceRecord.setStartTime(Calendar.getInstance().getTime());
        tDeviceMapper.updateByPrimaryKeySelective(deviceRecord);
        return 1 == tDeviceRefDogMapper.insertSelective(record);
    }

    @Transactional
    @Override
    public boolean unbindDeviceById(long dogId, long deviceId) {
        TDeviceRefDogExample example = new TDeviceRefDogExample();
        example.createCriteria().andDeviceIdEqualTo(String.valueOf(deviceId)).andDogIdEqualTo(String.valueOf(dogId));
        tDeviceRefDogMapper.deleteByExample(example);//删除原关系
        TDevice tdvRecod = new TDevice();
        tdvRecod.setDeviceId(deviceId);
        tdvRecod.setDeviceStatus(0);//改为禁用状态
        return 1 == tDeviceMapper.updateByPrimaryKeySelective(tdvRecod);
    }

    @Override
    @Transactional
    public void dogCardAudit(InertDogCard inertDogCard) throws Exception {
        if (inertDogCard.getDogId() == null || inertDogCard.getStatus() == null || inertDogCard.getLssuerId() == null || inertDogCard.getEndTime() == null || inertDogCard.getDogCardNum().isEmpty()) {
            String log = "犬证审核参数为空！";
            logger.info("犬证审核参数为空！");
            throw new ServerException(log);
        }
        String dogCardNum = dogAndOwnerMapper.selectDodCarDogId(inertDogCard.getDogCardNum());
        if (dogCardNum != null) {
            String log = "[犬证服务][办理犬证]：重复提交！";
            logger.error(log);
            throw new SubmitRepeatException(log);
        }
        UserVo tUsers = new UserVo();
        tUsers.setCreateTime(new Date());
        tUsers.setDogOwnId(inertDogCard.getDogOwnerId());
        tUsers.setUsername(inertDogCard.getPhone());
        tUsers.setPhone(inertDogCard.getPhone());
        tUsers.setSex(inertDogCard.getGender());
        tUsers.setEmail(inertDogCard.getEmail());
        tUsers.setuStatus(1);
        tUsers.setName(inertDogCard.getName());
        tUsers.setRoleId(3);
        try {
            dogCardMapper.dogCardAudit(inertDogCard.getDogId(), inertDogCard.getStatus(), inertDogCard.getLssueOrgId(), inertDogCard.getLssuerId(), inertDogCard.getDogCardNum(), inertDogCard.getReason(), new Date(), inertDogCard.getEndTime());
//            userService.addUser(tUsers);
        } catch (Exception e) {
            String log = "犬证审核失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        //设备--------------------
        if (inertDogCard.getStatus()==1){
            String deviceId=tDeviceRefDogMapper.selectDeviceIdByImmi(inertDogCard.getDeviceId());
            List<TDeviceRefDog> listt=tDeviceRefDogMapper.findDeviceBindInfo(inertDogCard.getDeviceId());
            TDeviceRefDog tDeviceRefDog = new TDeviceRefDog();
            tDeviceRefDog.setDeviceId(deviceId);
            tDeviceRefDog.setDogId(inertDogCard.getDogId() + "");
            tDeviceRefDog.setUseStatus(0);
            tDeviceRefDog.setCreationTime(inertDogCard.getCreationTime());
            tDeviceRefDog.setExpireTime(inertDogCard.getExpireTime());
            if (listt.size()>0){}else {
                tDeviceRefDogMapper.insert(tDeviceRefDog);
                dogCardMapper.updateDevice(Integer.parseInt(deviceId), inertDogCard.getStatus(), inertDogCard.getCreationTime(), inertDogCard.getLssueOrgId());
            }
        }
        //------------------------
        //根据电话查询用户id
        List<TUsers> users = tUsersMapper.selectUserByPhone(inertDogCard.getPhone());

        Map<String, String> params = new HashMap<>();
        params.put("phone", inertDogCard.getPhone());

        TNotification notification = new TNotification();
            notification.setNotifType(8);

            notification.setNotifTitle("犬证审核");

        //犬证审核失败发送短信
        if (inertDogCard.getStatus()==5){
            params.put("type",Integer.toString(5));
            Map<String, String> template_param = new HashMap<>();
            template_param.put("name", inertDogCard.getName());
            template_param.put("reason", inertDogCard.getReason());
            params.put("template_param", JSONObject.toJSONString(template_param));

            new Thread(()->{
                try {
                    HttpResult httpResult  = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();

            //5.添加通知消息
            if (users !=null && users.size()>0){
                notification.setNotifReceiverId(users.get(0).getUserId());
                notification.setNotiContent("犬证审核失败：尊敬的"+inertDogCard.getName()+"用户，,您的犬证申请已被驳回，驳回原因："+inertDogCard.getReason());
                noticeService.addNotice(notification);
            }
        }
        //犬证审核成功发送短信
        if (inertDogCard.getStatus()==1){
            params.put("type",Integer.toString(4));
            Map<String, String> template_param = new HashMap<>();
            template_param.put("name", inertDogCard.getName());
            params.put("template_param", JSONObject.toJSONString(template_param));

            new Thread(()->{
                try {
                    HttpResult httpResult  = HttpClientUtil.executeHttpParams(sms_base_url + "/SendSMS", "post", params);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }).start();

            //5.添加通知消息
            if (users !=null && users.size()>0){
                notification.setNotifReceiverId(users.get(0).getUserId());
                notification.setNotiContent("犬证审核成功：尊敬的"+inertDogCard.getName()+"用户,您申请的犬证已通过");
                noticeService.addNotice(notification);
            }

        }
    }
}

