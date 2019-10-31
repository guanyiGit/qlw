package com.soholy.dogmanager.mapper.dogCard;

import com.soholy.dogmanager.entity.TMemberCard;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.pojo.dogCard.DogArchivesParm;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

//犬和犬主
public interface DogAndOwnerMapper {
    DogOwners selectDogOwners(@Param("ownerId") Long ownerId);//查询犬主详情
    List<DogOwners> selectDogOwnersByPhone(@Param("phone") String phone);//查询犬主详情根据电话
    List<DogOwners> selectDogOwnersByPhoneee(@Param("phone") String phone);//查询犬主详情根据电话
    TMemberCard selectTMemberCard(@Param("ownerId") Long ownerId);//查询会员证详情
    void updatetDogOwner(DogOwners dogOwners);//修改犬主信息犬主表
    void updateTUser(User user);//修改犬主信息用户表
    DogInfo selectDogInfo(@Param("dogId") Long dogId);//查看犬详情
    void updateDog(DogInfo dogInfo);//修改犬信息
    List<Photos> selectDogPhotos(@Param("dogId") Long dogId);//查询犬的照片
    List<Photos> selectDogOwnerPhotos(@Param("ownerId") Long ownerId);//查询犬主的照片
    List<MyDog> selectMyDogs(@Param("ownerId") Long ownerId);//查询我的宠物列表
    List<MyDog> selectDogList(DogArchivesParm dogArchivesParm);//查询犬只档案列表
    Integer selectDogLiatCount(DogArchivesParm dogArchivesParm);//查询犬只档案列表总条数
    List<MyDog> selectDogListAccurate(DogArchivesParm dogArchivesParm);//查询犬只档案列表精准
    Integer selectDogLiatCountAccurate(DogArchivesParm dogArchivesParm);//查询犬只档案列表总条数精准
    List<MyDog> selectNoDogCard(@Param("start") Integer start, @Param("size") Integer size,@Param("input") String input);//精准查询有免疫证但没犬证的犬只信息
    Integer selectNoDogCardCont(@Param("input") String input);//精准查询有免疫证但没犬证的犬只信息条数
    List<DogOwners> selectOwnerArchivesList(@Param("input") String input, @Param("start") Integer start, @Param("size") Integer size);//查询犬主档案列表
    Integer selectOwnerArchivesListCount(@Param("input") String input, @Param("start") Integer start, @Param("size") Integer size);//查询犬主档案列表总数
    String selectBanDog(@Param("dogName") String dogName);//查詢禁養品種是否存在
    DogVarieties selectDogVarieties(@Param("dogName") String dogName);//查詢品種是否存在
    void insertDictionary(@Param("dogVarieties") DogVarieties dogVarieties);//插入字典表犬品种
    void insertDogBan(@Param("dogBan") DogBan dogBan);//插入禁养犬种
    void insertDogBanPicUrl(DogBan dogBan);//插入禁养犬种图片url
    void insertDogBanPicUrlRef(@Param("imageId") Long imageId, @Param("type") Integer type, @Param("refId") Long refId, @Param("creationTime")Date creationTime);//插入禁养犬种图片关联信息
    void updateDogBan(DogBan dogBan);//修改禁养犬种
    DogBan selectDogBan(Long dogBreedId);//查询禁养犬种详情
    List<DogBan> selectDogBanList(@Param("start") Integer start, @Param("size") Integer size, @Param("input") String input);//查询禁养犬种列表
    List<DogBan> selectDogBanListAll(@Param("input") String input);//首页查询禁养犬种列表
    Integer selectDogBanListCount(@Param("input") String input);//查询禁养犬种列表总数
    List<Therapy> selectTherapys(Long dogId);//根据犬id查病历
    List<Vaccine> selectVaccines(Long dogId);//根据犬id查防疫信息
    List<InspectionsInfo> selectInspectionsInfos(Long dogId);//根据犬id查年检记录
    List<Violation> selectViolations(Long dogId);//根据犬id查犬违法信息

    /**
     * 删除禁养犬种
     * @param id
     * @return
     */
    int banRemoveByid(Integer id);

    String selectDodCarDogId(@Param("dogCardNum") String dogCardNum);

    /**
     *根据犬主姓名或电话查犬主信息列表
     * @param start
     * @param size
     * @param input
     * @return
     */
    List<DogOwners> queryDogOwners(@Param("start") Integer start,@Param("size") Integer size,@Param("input") String input);

    Integer queryDogOwnersCount(@Param("input") String input);

    List<MyDog> selectMyDogsPag(@Param("start") int start,@Param("size") Integer size,@Param("input") String input,@Param("id") Integer id);//根据犬主id查我的宠物列表

    Integer selectMyDogsPagCount(@Param("input") String input,@Param("id") Integer id);//根据犬主id查我的宠物列表总数

    List<Map<String,Object>> selectImmuneToRemind();//查询免疫提醒信息
    List<Map<String,Object>> selectMedicineRemind();//查询喂药提醒信息
    Map<String,String> selectOwnerInfo(@Param("dogOwnerId") Long dogOwnerId);
}
