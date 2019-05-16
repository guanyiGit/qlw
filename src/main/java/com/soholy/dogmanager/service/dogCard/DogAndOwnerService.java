package com.soholy.dogmanager.service.dogCard;

import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.pojo.dogCard.DogArchivesParm;

import java.rmi.ServerException;
import java.util.List;

public interface DogAndOwnerService {
    /**
     *  修改犬主信息
     * @param user  用户信息
     * @param dogOwners 犬主id
     * @throws ServerException
     */
    void updatetDogOwnerInfo(User user, DogOwners dogOwners) throws ServerException;


    DogOwnerAllInfo selectDogOwnerAllInfo(Long ownerId) throws ServerException;//查询犬主档案里的犬主详情

    List<DogOwners> selectDogOwnersByPhone(String phone) throws ServerException;//查询犬主详情根据电话
    List<DogOwners> selectDogOwnersByPhoneee(String phone) throws ServerException;//查询犬主详情根据电话

    User selectUserByUserId(Long userId) throws ServerException;//根据用户id查询用户信息

    void updateDog(DogInfo dogInfo) throws ServerException;//修改犬信息

    List<MyDog> selectMyDogs(Long ownerId) throws ServerException;//查询我的宠物列表

    List<MyDog> selectDogList(DogArchivesParm dogArchivesParm) throws ServerException;//查询犬只档案列表

    PageInfo selectDogLiatCount(DogArchivesParm dogArchivesParm) throws ServerException;//查询犬只档案列表总条数

    List<MyDog> selectDogListAccurate(DogArchivesParm dogArchivesParm) throws ServerException;//查询犬只档案列表精准

    PageInfo selectDogLiatCountAccurate(DogArchivesParm dogArchivesParm) throws ServerException;//查询犬只档案列表总条数精准

    List<DogOwners> selectOwnerArchivesList(String input, Integer num, Integer size) throws ServerException;//查询犬主档案列表

    PageInfo selectOwnerArchivesListCount(String input, Integer num, Integer size) throws ServerException;//查询犬主档案列表总数

    String selectBanDog(String dogName) throws ServerException;//查詢禁養品種是否存在

    Integer insertDogBan(DogBan dogBan) throws ServerException;//插入禁养犬种

    void updateDogBan(DogBan dogBan) throws ServerException;//修改禁养犬种

    DogBan selectDogBan(Long dogBreedId) throws ServerException;//查询禁养犬种详情

    List<DogBan> selectDogBanList(Integer num, Integer size, String input) throws ServerException;//查询禁养犬种列表

    List<DogBan> selectDogBanListAll(String input) throws ServerException;//首页查询禁养犬种列表

    PageInfo selectDogBanListPage(Integer num, Integer size, String input) throws ServerException;//查询禁养犬种列表总数

    void cancellationDog(String cancellation, String cancellationNote, Long dogId) throws ServerException;//注销犬

    /**
     * @return
     * @Description (查询注销原因)
     */
    List<TDictionary> FindlogoutReasons();

    /**
     * 删除禁养犬种
     * @param id
     * @return
     */
    boolean banRemoveByid(Integer id);

    DogInfo selectDogInfoByDogId(Long dogId) throws ServerException;

    List<MyDog> selectNoDogCard(Integer num, Integer size, String input) throws ServerException;

    PageInfo selectNoDogCardCont(Integer num, Integer size,String input) throws ServerException;

    List<DogOwners> queryDogOwners(ListParams listParams) throws ServerException;

    PageInfo queryDogOwnersCount(ListParams listParams) throws ServerException;

    List<MyDog> selectMyDogsPag(ListParams listParams)throws ServerException;

    PageInfo selectMyDogsPagCount(ListParams listParams)throws ServerException;
}
