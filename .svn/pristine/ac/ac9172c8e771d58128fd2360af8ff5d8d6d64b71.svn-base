package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDeviceExample;
import com.soholy.dogmanager.entity.device.DeviceRefModelInfo;
import com.soholy.dogmanager.entity.device.DeviceRefOrg;
import com.soholy.dogmanager.pojo.device.DogRefDevice;
import com.soholy.dogmanager.pojo.dogCard.DeviceRefDog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDeviceMapper {

    int countByExample(TDeviceExample example);

    int deleteByExample(TDeviceExample example);

    int deleteByPrimaryKey(Long deviceId);

    int insert(TDevice record);

    int insertSelective(TDevice record);

    List<TDevice> selectByExample(TDeviceExample example);

    TDevice selectByPrimaryKey(Long deviceId);

    int updateByExampleSelective(@Param("record") TDevice record, @Param("example") TDeviceExample example);

    int updateByExample(@Param("record") TDevice record, @Param("example") TDeviceExample example);

    int updateByPrimaryKeySelective(TDevice record);

    int updateByPrimaryKey(TDevice record);

    /**
     * @param deviceStatus 设备状态（0禁用，1启用,2注销）
     * @param deviceType   设备类型（0RF，1项圈）
     * @param serchKey     搜索关键字（设备编号或设备品牌）
     * @return
     * @Description (根据设备状态和关键字查询设备列表)
     */
    List<DeviceRefModelInfo> findDeviceListByStatusAndKeyWord(@Param(value = "deviceStatus") Integer deviceStatus,
                                                              @Param(value = "deviceType") Integer deviceType, @Param(value = "serchKey") String serchKey);

    /**
     * @param deviceIdList
     * @return
     * @Description (根据设备id查询设备信息)
     */
    List<TDevice> findDeviceListByIds(@Param("deviceIdList") List<Long> deviceIdList);

    /**
     * @param tdeviceList
     * @return
     * @Description (批量插入设备信息)
     */
    int saveDeviceList(@Param("tdeviceList") List<TDevice> tdeviceList);

    /**
     * @param dogOwnerId
     * @return
     * @Description (根据犬主id查询设备信息)
     */
    List<TDevice> findDeviceByDogOwnerId(@Param("dogOwnerId") Long dogOwnerId);

    /**
     * @param dogId
     * @Description 根据dogid查询设备
     */
    public DogRefDevice findDeviceByDogId(Long dogId);

    /**
     * 根据设备验证码获取设备信息
     *
     * @param deviceIdIot
     * @return
     */
    public abstract List<TDevice> findDeviceInfoByDeviceidIot(String deviceIdIot);

    /**
     * 根据设备编号模糊查询设备列表
     *
     * @param keyWord  设备编号  like
     * @param isActive 是否只查未注册的设备
     */
    List<DeviceRefOrg> findDevicesLikeDeviceNum(@Param("keyWord") String keyWord, @Param("isActive") boolean isActive);


    /**
     * 根据设备id查询设备厂商和型号信息设备
     *
     * @param deviceId
     * @return
     */
    DeviceRefModelInfo findDeviceOtherInfoByid(long deviceId);

    /**
     * 根据设备查询设备绑定情况
     *
     * @param imei
     * @return
     */
    List<DeviceRefDog> findDeviceRefDogByDeviceImei(@Param("imei") String imei);
}
