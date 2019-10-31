package com.soholy.dogmanager.mapper.dogCard;

import com.soholy.dogmanager.entity.dogCard.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//证件服务
public interface DogCardMapper {
    void updateDogOwnerCard(DogOwners dogOwners);//修改犬主信息证件表
    ImmuneCard selectImmuneCard(@Param("cardNum") String cardNum, @Param("dogid") Long dogid);//查询免疫证信息和犬、犬主id
    List<Device> selectDevice(@Param("dogId") Long dogId);//查询设备详情
    Long selectDogIdByDeviceId(@Param("deviceNumber") String deviceNumber);//根据设备编号查询犬id
    String selectDogNameByDeviceId(@Param("deviceId") Long deviceId);//根据设备id查询犬名字
    DogCard selectDogCard(@Param("dogId") Long dogId);//查询犬证信息
    void updateDevice(@Param("deviceId") Integer deviceId, @Param("status") Integer status, @Param("startTime") Date startTime, @Param("orgId") Integer orgId);//办证修改设备信息
    Integer selectDeviceId(@Param("deviceNumber") String deviceNumber);//根据设备编号查询设备id
    void updateCardDate(@Param("dogId") Long dogId, @Param("endDate") Date endDate);//犬证续期
    List<DogCardRelatedInfo> selectDogInfos(@Param("status") Integer status,@Param("orgId") Integer orgId,@Param("input") String input, @Param("start") Integer start, @Param("size") Integer size);//医院查询犬列表
    Integer selectDogInfosCount(@Param("status") Integer status,@Param("orgId") Integer orgId,@Param("input") String input, @Param("start") Integer start, @Param("size") Integer size);//医院查询犬列表总数
    List<ElectronicDogCard> selectElectronicDogCard(@Param("userId") Long userId);//查询电子犬证
    User selectUserByUserId(@Param("userId") Long userId);//根据用户id查询用户信息
    void cancellationDog(@Param("cancellation") String cancellation,@Param("cancellationNote") String cancellationNote, @Param("cancellationTime") Date cancellationTime, @Param("dogId") Long dogId);//注销犬
    void cancellationDogCard(@Param("dogId") Long dogId);//注销犬证
    void cancellationEquipment(@Param("dogId") Long dogId);//注销设备
    List<Conditions> selectDogSpecies();//查询犬只种类
    List<Conditions> selectDogColor();//查询犬只毛色
    List<Conditions> selectDogCollType();//查询收容原因
    List<Conditions> selectViolationType();//查询违法类型
    List<String> selectImmuneCardNums(@Param("input") String input);//查所有的免疫证号
    Long selectIdsByurl(String url);//根据图片url查图片id

    /**
     * 根据犬图id删犬图
     * @param picId
     *
     */
    void delectPic(@Param("picId") Long picId);
    void delectPicRef(@Param("picId") Long picId);

    /**
     * 根据设备编号查询设备id 模糊查询
     * @param deviceNumberkeyWord
     * @return
     */
    Integer likeDeviceId(String deviceNumberkeyWord);

    void dogCardAudit(@Param("dogId") Long dogId,@Param("status") Integer status,@Param("lssueOrgId") Integer lssueOrgId,@Param("lssuerId") Long lssuerId,@Param("dogCardNum") String dogCardNum,@Param("reason") String reason,@Param("startTime") Date startTime,@Param("endTime") Date endTime);


    /**
     * 查询犬的信息 参数传其一
     * @param immuneCardNum 免疫证号
     * @param seqId 免疫证id
     * @return
     */
    List<DogAndDogOwnerInfo> findDogAllInfoByImcardNumOrSeqId(@Param("immuneCardNum") String immuneCardNum, @Param("seqId")Integer seqId);

    void initPassword(@Param("account") String account,@Param("password") String password);

}
