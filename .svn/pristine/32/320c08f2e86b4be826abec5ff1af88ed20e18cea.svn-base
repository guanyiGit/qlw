package com.soholy.dogmanager.service.dogCard;

import com.soholy.dogmanager.common.exception.GlobalException;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.dogCard.*;
import com.soholy.dogmanager.exception.DataMismatchException;
import com.soholy.dogmanager.exception.SubmitRepeatException;
import com.soholy.dogmanager.pojo.dogCard.InertDogCard;
import org.apache.http.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

public interface DogCardService {
    DogAllInfo selectDogCardInfo(String cardNum, Long dogId) throws ServerException;//查看犬证详情或查看犬只详情包含犬只所有详细信息

    DogAllInfo selectDogCardInfoByDevice(String deviceNum) throws ServerException;//查看犬证详情或查看犬只详情包含犬只所有详细信息

    //    DogOwnerAllInfo selectDogOwnerAllInfo(Long )
    void insertDogCard(InertDogCard inertDogCard, String clientIp) throws ServerException, ParseException, IOException, URISyntaxException, SubmitRepeatException, DataMismatchException;//办犬证

    Integer selectDeviceId(String deviceNumber) throws ServerException;//根据设备编号查询设备id

    Long selectDogIdByDeviceId(String deviceNumber) throws ServerException;//根据设备编号查询犬id

    List<DogCardRelatedInfo> selectDogInfos(Integer status, Integer orgId, String input, Integer num, Integer size) throws ServerException;//医院查询犬列表

    PageInfo selectDogInfosPage(Integer status, Integer orgId, String input, Integer num, Integer size) throws ServerException;//医院查询犬列表分页总数

    void updateCardDate(Long dogId, Date endDate) throws ServerException;//犬证续期

    List<ElectronicDogCard> selectElectronicDogCard(Long userId) throws ServerException;//查询电子犬证

    List<Conditions> selectConditions(Integer logg) throws ServerException;//查查询条件

    List<String> selectImmuneCardNums(String input) throws ServerException;//查所有的免疫证号

    /**
     * 根据设备编号查询犬息
     *
     * @param deviceNum 设备编号
     * @return 犬信息
     */
    TDogInfo fondDogInfoByDeviceNum(String deviceNum);

    /**
     * 根据犬图id删犬图
     *
     * @param picId
     * @throws ServerException
     */
    void delectPic(Long picId) throws ServerException;

    DogAllInfo selectDogCardInfoByDeviceImei(String imei) throws ServerException;

    List<DogAllInfo> selectDogCardInfoByDeviceImeis(List<String> deviceIds) throws ServerException;

    void dogCardAudit(InertDogCard inertDogCard) throws Exception;

    /**
     * 绑定设备 根据imei
     *
     * @param imei
     * @param dogId
     * @return
     */
    boolean bindDeviceByDeviceId(long deviceId, long dogId);

    /**
     * 查看设备绑定情况
     *
     * @param imei
     * @return
     */
    DeviceRrfDog findDeviceBindInfo(String imei);

    /**
     * 查询犬的信息 参数传其一
     *
     * @param immuneCardNum 免疫证号
     * @param seqId         免疫证id
     * @return
     */
    List<DogAndDogOwnerInfo> findDogAllInfoByImcardNumOrSeqId(String immuneCardNum, Integer seqId);


    /**
     * 根据免疫证号检验并查询相关信息
     *
     * @param immuneCardNum 免疫证号
     * @param dogOwnerName  犬主姓名
     * @param phone         犬主电话
     * @param cardType      证件类型
     * @param cardNum       证件号码
     * @return
     */
    List<DogAndDogOwnerInfo> findAndCheckdCardInfoByImmuneNum(String immuneCardNum, String dogOwnerName, String phone, int cardType, String cardNum) throws GlobalException;

    /**
     * 根据设备imei和犬id绑定设备
     *
     * @param imei
     * @param dogId
     * @return
     */
    boolean bindDeviceByDeviceImei(String imei, long dogId) throws GlobalException;

    boolean bindDeviceByDeviceImei(String imei, long dogId,String devicePwd) throws GlobalException;

    /**
     * 解绑设备
     * @param dogId
     * @param deviceId
     * @return
     */
    boolean unbindDeviceById(long dogId, long deviceId);
}
