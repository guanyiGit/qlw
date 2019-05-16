package com.soholy.dogmanager.service.dogCard.impl;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.soholy.dogmanager.entity.dogCard.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.mapper.dogCard.DogAndOwnerMapper;
import com.soholy.dogmanager.mapper.dogCard.DogCardMapper;
import com.soholy.dogmanager.pojo.dogCard.DogArchivesParm;
import com.soholy.dogmanager.service.dogCard.DogAndOwnerService;

@Service
public class DogAndOwnerServiceImpl implements DogAndOwnerService {

    private static final Logger logger = Logger.getLogger(DogCardServiceImpl.class);
    @Autowired
    DogCardMapper dogCardMapper;
    @Autowired
    TUsersMapper tUsersMapper;
    @Autowired
    DogAndOwnerMapper dogAndOwnerMapper;
    @Autowired
    private TDictionaryMapper tDictionaryMapper;

    // 修改犬主信息
    @Override
    @Transactional
    public void updatetDogOwnerInfo(User user, DogOwners dogOwners) throws ServerException {
        if (dogOwners == null) {
            String log = "[犬证服务][修改犬主信息]：犬主对象参数为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        if (user == null) {
            String log = "[犬证服务][修改犬主信息]：用户对象参数为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        try {
            dogAndOwnerMapper.updatetDogOwner(dogOwners);
            dogCardMapper.updateDogOwnerCard(dogOwners);
            dogAndOwnerMapper.updateTUser(user);
        } catch (Exception e) {
            String log = "[犬证服务][修改犬主信息]：修改犬主信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    // 查询犬主档案里的犬主详情
    @Override
    public DogOwnerAllInfo selectDogOwnerAllInfo(Long ownerId) throws ServerException {
        if (ownerId == null) {
            String log = "[犬证服务][查询犬主详情]：犬主id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        DogOwnerAllInfo dogOwnerAllInfo = new DogOwnerAllInfo();
        TMemberCard tMemberCard = new TMemberCard();
        DogOwners dogOwners = new DogOwners();
        List<MyDog> myDogs = new ArrayList<>();
        try {
            tMemberCard = dogAndOwnerMapper.selectTMemberCard(ownerId);
            dogOwners = dogAndOwnerMapper.selectDogOwners(ownerId);
            myDogs = dogAndOwnerMapper.selectMyDogs(ownerId);
            dogOwnerAllInfo.settMemberCard(tMemberCard);
            dogOwnerAllInfo.setDogOwners(dogOwners);
            dogOwnerAllInfo.setMyDogs(myDogs);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬主详情]：查询犬主详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogOwnerAllInfo;
    }

    // 查询犬主详情根据电话模糊
    @Override
    public List<DogOwners> selectDogOwnersByPhone(String phone) throws ServerException {
        if (phone == null) {
            String log = "[犬证服务][查询犬主详情]：犬主phone为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        List<DogOwners> dogOwners = null;
        try {
            dogOwners = dogAndOwnerMapper.selectDogOwnersByPhone(phone);
        } catch (Exception e) {
            String log = "[犬证服务][查询犬主详情]：查询犬主详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return  dogOwners;
    }
    // 查询犬主详情根据电话精准
    @Override
    public List<DogOwners> selectDogOwnersByPhoneee(String phone) throws ServerException {
        if (phone == null) {
            String log = "[犬证服务][查询犬主详情]：犬主phone为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        List<DogOwners> dogOwners = null;
//        List<Photos> ownerUrllsit = new ArrayList<>();//狗主照片url集合
//        DogOwners dogOwner = null;
        try {
            dogOwners = dogAndOwnerMapper.selectDogOwnersByPhoneee(phone);
//            dogOwner=dogOwners.get(0);
//            if (dogOwner.getDogOwnerId()!=null){
//                ownerUrllsit = dogAndOwnerMapper.selectDogOwnerPhotos(dogOwners.get(0).getDogOwnerId());
//                dogOwner.setOwnerUrlLsit(ownerUrllsit);
//                dogOwners.set(0,dogOwner);
//            }
        } catch (Exception e) {
            String log = "[犬证服务][查询犬主详情]：查询犬主详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return  dogOwners;
    }
    // 修改犬信息
    @Override
    public void updateDog(DogInfo dogInfo) throws ServerException {
        if (dogInfo == null) {
            String log = "[犬证服务][修改犬信息]：犬对象参数为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        try {
            dogAndOwnerMapper.updateDog(dogInfo);
        } catch (Exception e) {
            String log = "[犬证服务][修改犬信息]：修改犬信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    // 根据用户id查询用户信息
    @Override
    public User selectUserByUserId(Long userId) throws ServerException {
        if (userId == null) {
            String log = "[犬证服务][查询犬主id]：用户id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        User user = null;
        try {
            user = dogCardMapper.selectUserByUserId(userId);
        } catch (Exception e) {
            String log = "[犬证服务][查询用户]：查询用户失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return user;
    }

    // 查询我的宠物列表
    @Override
    public List<MyDog> selectMyDogs(Long ownerId) throws ServerException {
        if (ownerId == null) {
            String log = "[犬证服务][查看我的宠物列表]：犬主id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.selectMyDogs(ownerId);
        } catch (Exception e) {
            String log = "[犬证服务][查看我的宠物列表]：查询我的宠物列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 查询犬只档案列表
    @Override
    public List<MyDog> selectDogList(DogArchivesParm dogArchivesParm) throws ServerException {
        if (dogArchivesParm == null) {
            String log = "[犬证服务][查看犬只档案列表]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        PageInfo page = new PageInfo();
        if (dogArchivesParm.getNum() == null) {
            dogArchivesParm.setStart(0);
            page.setPageNum(1);
        } else {
            page.setPageNum(dogArchivesParm.getNum());
        }
        if (dogArchivesParm.getSize() == null) {
            dogArchivesParm.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(dogArchivesParm.getSize());
        }
        if (page.isFirst()) {
            dogArchivesParm.setStart(0);
        } else {
            dogArchivesParm.setStart(page.getTotalStart());
        }
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.selectDogList(dogArchivesParm);
        } catch (Exception e) {
            String log = "[犬证服务][查看犬只档案列表]：查看犬只档案列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 查询犬只档案列表总条数
    @Override
    public PageInfo selectDogLiatCount(DogArchivesParm dogArchivesParm) throws ServerException {
        if (dogArchivesParm == null) {
            String log = "[犬证服务][查看犬只档案列表]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        PageInfo page = new PageInfo();
        if (dogArchivesParm.getNum() == null) {
            dogArchivesParm.setStart(0);
            page.setPageNum(1);
        } else {
            page.setPageNum(dogArchivesParm.getNum());
        }
        if (dogArchivesParm.getSize() == null) {
            dogArchivesParm.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(dogArchivesParm.getSize());
        }
        if (page.isFirst()) {
            dogArchivesParm.setStart(0);
        } else {
            dogArchivesParm.setStart(page.getTotalStart());
        }
        Integer count = null;
        try {
            count = dogAndOwnerMapper.selectDogLiatCount(dogArchivesParm);
        } catch (Exception e) {
            String log = "[犬证服务][查看犬只档案列表]：查看犬只档案列表总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }

    // 查询犬只档案列表精准
    @Override
    public List<MyDog> selectDogListAccurate(DogArchivesParm dogArchivesParm) throws ServerException {
        if (dogArchivesParm == null) {
            String log = "[犬证服务][查看犬只档案列表]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        PageInfo page = new PageInfo();
        if (dogArchivesParm.getNum() == null) {
            dogArchivesParm.setStart(0);
            page.setPageNum(1);
        } else {
            page.setPageNum(dogArchivesParm.getNum());
        }
        if (dogArchivesParm.getSize() == null) {
            dogArchivesParm.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(dogArchivesParm.getSize());
        }
        if (page.isFirst()) {
            dogArchivesParm.setStart(0);
        } else {
            dogArchivesParm.setStart(page.getTotalStart());
        }
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.selectDogListAccurate(dogArchivesParm);
        } catch (Exception e) {
            String log = "[犬证服务][查看犬只档案列表]：查看犬只档案列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 查询犬只档案列表总条数精准
    @Override
    public PageInfo selectDogLiatCountAccurate(DogArchivesParm dogArchivesParm) throws ServerException {
        if (dogArchivesParm == null) {
            String log = "[犬证服务][查看犬只档案列表]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        PageInfo page = new PageInfo();
        if (dogArchivesParm.getNum() == null) {
            dogArchivesParm.setStart(0);
            page.setPageNum(1);
        } else {
            page.setPageNum(dogArchivesParm.getNum());
        }
        if (dogArchivesParm.getSize() == null) {
            dogArchivesParm.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(dogArchivesParm.getSize());
        }
        if (page.isFirst()) {
            dogArchivesParm.setStart(0);
        } else {
            dogArchivesParm.setStart(page.getTotalStart());
        }
        Integer count = null;
        try {
            count = dogAndOwnerMapper.selectDogLiatCountAccurate(dogArchivesParm);
        } catch (Exception e) {
            String log = "[犬证服务][查看犬只档案列表]：查看犬只档案列表总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }
    // 查询犬主档案列表
    @Override
    public List<DogOwners> selectOwnerArchivesList(String input, Integer num, Integer size) throws ServerException {
        int start = 0;
        PageInfo page = new PageInfo();
        if (num == null || num == 1) {
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
        if (page.isFirst()) {
            start = 0;
        } else {
            start = (page.getTotalStart());
        }
        List<DogOwners> list = new ArrayList<DogOwners>();
        try {
            list = dogAndOwnerMapper.selectOwnerArchivesList(input, start, size);
        } catch (Exception e) {
            String log = "[犬证服务][查看犬主档案列表]：查看犬主档案列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 查询犬主档案列表总数
    @Override
    public PageInfo selectOwnerArchivesListCount(String input, Integer num, Integer size) throws ServerException {
        int start = 0;
        Integer count = null;
        PageInfo page = new PageInfo();
        if (num == null || num == 1) {
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
        if (page.isFirst()) {
            start = 0;
        } else {
            start = (page.getTotalStart());
        }
        try {
            count = dogAndOwnerMapper.selectOwnerArchivesListCount(input, start, size);
        } catch (Exception e) {
            String log = "[犬证服务][犬证列表]：查询犬证列表总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }

    @Override
    public String selectBanDog(String dogName) throws ServerException {
        String dogNamee=null;
        try {
            dogNamee=dogAndOwnerMapper.selectBanDog(dogName);
        } catch (Exception e) {
            String log = "[犬证服务][插入禁养犬种]：查詢禁养犬种失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogNamee;
    }

    // 插入禁养犬种
    @Override
    public Integer insertDogBan(DogBan dogBan) throws ServerException {
        if (dogBan == null) {
            String log = "[犬证服务][插入禁养犬种]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        Integer id=null;
//        Long picId=null;
        dogBan.setCreationTime(new Date());
        DogVarieties dogVarieties = null;
        try {
            dogVarieties = dogAndOwnerMapper.selectDogVarieties(dogBan.getDogBanName());
            if (dogVarieties.getDogVarieties()==null){
                dogAndOwnerMapper.insertDictionary(dogVarieties);
            }
            dogBan.setDictionaryId(dogVarieties.getDictionaryId());
            dogAndOwnerMapper.insertDogBan(dogBan);
            id=dogBan.getDogBanId();
//            dogAndOwnerMapper.insertDogBanPicUrl(dogBan);
//            picId=dogBan.getDogBanId();
//            dogAndOwnerMapper.insertDogBanPicUrlRef(picId,6,id,new Date());
        } catch (Exception e) {
            String log = "[犬证服务][插入禁养犬种]：插入禁养犬种失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return id;
    }

    // 修改禁养犬种
    @Override
    public void updateDogBan(DogBan dogBan) throws ServerException {
        if (dogBan == null) {
            String log = "[犬证服务][修改禁养犬种]：参数对象为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        try {
            dogAndOwnerMapper.updateDogBan(dogBan);
        } catch (Exception e) {
            String log = "[犬证服务][插入禁养犬种]：修改禁养犬种失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    // 查询禁养犬种详情
    @Override
    public DogBan selectDogBan(Long dogBreedId) throws ServerException {
        DogBan dogBan = new DogBan();
        try {
            dogBan = dogAndOwnerMapper.selectDogBan(dogBreedId);
        } catch (Exception e) {
            String log = "[犬证服务][查询禁养犬种详情]：查询禁养犬种详情失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return dogBan;
    }

    // 查询禁养犬种列表
    @Override
    public List<DogBan> selectDogBanList(Integer num, Integer size,String input) throws ServerException {
        int start = 0;
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
        if (page.isFirst()) {
            start = 0;
        } else {
            start = (page.getTotalStart());
        }
        List<DogBan> list = new ArrayList<DogBan>();
        try {
            list=dogAndOwnerMapper.selectDogBanList(start, size,input);
        } catch (Exception e) {
            String log = "[犬证服务][查询禁养犬种列表]：查询禁养犬种列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 首页查询禁养犬种列表
    @Override
    public List<DogBan> selectDogBanListAll(String input) throws ServerException {
        List<DogBan> list = new ArrayList<DogBan>();
        try {
            list=dogAndOwnerMapper.selectDogBanListAll(input);
        } catch (Exception e) {
            String log = "[犬证服务][查询禁养犬种列表]：查询禁养犬种列表失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    // 查询禁养犬种列表总数
    @Override
    public PageInfo selectDogBanListPage(Integer num, Integer size,String input) throws ServerException {
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
        if (page.isFirst()) {
            start = 0;
        } else {
            start = (page.getTotalStart());
        }
        try {
            count = dogAndOwnerMapper.selectDogBanListCount(input);
        } catch (Exception e) {
            String log = "[犬证服务][查询禁养犬种列表分页]：查询禁养犬种列表分页失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }

    // 注销犬
    @Override
    @Transactional
    public void cancellationDog(String cancellation,String cancellationNote, Long dogId) throws ServerException {
        if (dogId == null) {
            String log = "[犬证服务][注销犬]：犬id为空！";
            logger.error(log);
            throw new IllegalArgumentException(log);
        }
        try {
            dogCardMapper.cancellationDog(cancellation, cancellationNote, new Date(), dogId);
            dogCardMapper.cancellationDogCard(dogId);
            dogCardMapper.cancellationEquipment(dogId);
        } catch (Exception e) {
            String log = "[犬证服务][注销犬]：注销犬失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
    }

    @Override
    public List<TDictionary> FindlogoutReasons() {
        return tDictionaryMapper.findBizTypes("logout_reason");
    }

    @Override
    public boolean banRemoveByid(Integer id) {
        return dogAndOwnerMapper.banRemoveByid(id)==1;
    }

    @Override
    public DogInfo selectDogInfoByDogId(Long dogId) throws ServerException {
        DogInfo tDogInfo = null;
        try {
            tDogInfo = dogAndOwnerMapper.selectDogInfo(dogId);
        } catch (Exception e) {
            String log = "查询犬只信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return tDogInfo;
    }

    @Override
    public List<MyDog> selectNoDogCard(Integer num, Integer size, String input) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (num == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(num);
        }
        if (size == null) {
            size=PageInfo.DefaultSize;
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(size);
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.selectNoDogCard(start,size,input);
        } catch (Exception e) {
            String log = "查看犬只信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    @Override
    public PageInfo selectNoDogCardCont(Integer num, Integer size,String input) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (num == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(num);
        }
        if (size == null) {
            size=PageInfo.DefaultSize;
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(size);
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        List<MyDog> list = new ArrayList<>();
        Integer count=null;
        try {
            count = dogAndOwnerMapper.selectNoDogCardCont(input);
        } catch (Exception e) {
            String log = "查看犬只信息总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }

    //查询犬主列表
    @Override
    public List<DogOwners> queryDogOwners(ListParams listParams) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (listParams.getNum() == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(listParams.getNum());
        }
        if (listParams.getSize() == null) {
            listParams.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(listParams.getSize());
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        List<DogOwners> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.queryDogOwners(start,listParams.getSize(),listParams.getInput());
        } catch (Exception e) {
            String log = "查看犬主列表信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    @Override
    public PageInfo queryDogOwnersCount(ListParams listParams) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (listParams.getNum() == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(listParams.getNum());
        }
        if (listParams.getSize() == null) {
            listParams.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(listParams.getSize());
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        Integer count=null;
        try {
            count = dogAndOwnerMapper.queryDogOwnersCount(listParams.getInput());
        } catch (Exception e) {
            String log = "查看犬主信息总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }

    /**
     * 根据犬主id查我的宠物列表
     * @param listParams
     * @return
     * @throws ServerException
     */
    @Override
    public List<MyDog> selectMyDogsPag(ListParams listParams) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (listParams.getNum() == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(listParams.getNum());
        }
        if (listParams.getSize() == null) {
            listParams.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(listParams.getSize());
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        List<MyDog> list = new ArrayList<>();
        try {
            list = dogAndOwnerMapper.selectMyDogsPag(start,listParams.getSize(),listParams.getInput(),listParams.getId());
        } catch (Exception e) {
            String log = "查看犬主列表信息失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        return list;
    }

    /**
     * 根据犬主id查我的宠物列表总数
     * @param listParams
     * @return
     * @throws ServerException
     */
    @Override
    public PageInfo selectMyDogsPagCount(ListParams listParams) throws ServerException {
        int start=0;
        PageInfo page = new PageInfo();
        if (listParams.getNum() == null) {
            start=0;
            page.setPageNum(1);
        } else {
            page.setPageNum(listParams.getNum());
        }
        if (listParams.getSize() == null) {
            listParams.setSize(PageInfo.DefaultSize);
            page.setPageSize(PageInfo.DefaultSize);
        } else {
            page.setPageSize(listParams.getSize());
        }
        if (page.isFirst()) {
            start=0;
        } else {
            start=page.getTotalStart();
        }
        Integer count=null;
        try {
            count = dogAndOwnerMapper.selectMyDogsPagCount(listParams.getInput(),listParams.getId());
        } catch (Exception e) {
            String log = "查看犬主信息总数失败！";
            logger.error(log, e);
            throw new ServerException(log, e);
        }
        page.setTotalCount(count);
        return page;
    }
}
