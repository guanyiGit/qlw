package com.soholy.dogmanager.service.device;

import com.soholy.dogmanager.entity.TDevice;
import com.soholy.dogmanager.entity.TDeviceFactory;
import com.soholy.dogmanager.entity.TDeviceModel;
import com.soholy.dogmanager.entity.device.DeviceRefModelInfo;
import com.soholy.dogmanager.entity.device.DeviceRefOrg;
import com.soholy.dogmanager.pojo.device.DogRefDevice;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * @author guanY
 * @version 1.0.0
 * @ClassName DeviceService
 * @Description (设备相关)
 * @Date 2018年8月20日 下午2:07:12
 */
public interface DeviceService {

    /**
     * @param deviceStatus 设备状态（0禁用，1启用,2注销）
     * @param deviceType   设备类型（0RF，1项圈）
     * @param serchKey     搜索关键字（设备编号或设备品牌）
     * @return
     * @Description (根据设备状态和关键字查询设备列表)
     */
    public abstract List<DeviceRefModelInfo> findDeviceListByStatusAndKeyWord(Integer deviceStatus, Integer deviceType,
                                                                              String serchKey);

    /**
     * @param deviceNum
     * @return
     * @Description (根据设备编号查询设备信息)
     */
    TDevice findDeviceByNum(String deviceNum);

    /**
     * @Description (根据设备imei查询设备信息)
     */
    public abstract TDevice findDeviceByIMEI(String imei);

    /**
     * @param deviceIdList
     * @return
     * @Description (根据设备id查询设备信息)
     */
    public abstract List<TDevice> findDeviceListByIds(List<Long> deviceIdList);

    /**
     * @param is     文件流
     * @param userId 机构id
     * @return
     * @throws Exception
     * @Description (导入设备文件)
     */
    boolean addDeviceByImprot(InputStream is, long orgId) throws Exception;

    /**
     * @param deviceId 设备id
     * @param status   设备状态
     * @return
     * @throws Exception
     * @Description (修改设备状态)
     */
    public abstract boolean modifyDeviceStatusByid(long deviceId, int status);

    /**
     * @param tDevice
     * @return
     * @Description (根据id修改设备信息)
     */
    public abstract boolean modifyByid(TDevice tDevice);

    /**
     * @param dogOwnerId
     * @Description (根据犬主id查询设备信息)
     */
    public abstract List<TDevice> findDeviceByDogOwnerId(Long dogOwnerId);

    public abstract List<TDevice> findAll();

    /**
     * @param DogId
     * @Description 根据dogid查询设备
     */
    public DogRefDevice findDeviceByDogId(Long DogId);

    /**
     * 生成设备信息excel
     *
     * @param deviceRefModelInfo
     * @return
     */
    Workbook generateExcel(List<DeviceRefModelInfo> deviceRefModelInfo);

    /**
     * 查询厂商编号，没有则添加，否则直接返回
     *
     * @return
     */
    TDeviceFactory saveAndFandDeviceFactoryByNum(String deviceFactoryNum);

    /**
     * 查询设备编号，没有则添加，否则直接返回
     *
     * @return
     */
    TDeviceModel saveAndFandDeviceModelByNum(String deviceModelNum);

    /**
     * 批量修改设备激活状态
     *
     * @param deviceIds
     * @param status
     * @return
     */
    boolean modifyDeviceStatusByids(List<Long> deviceIds, Integer status);

    /**
     * @param imei
     * @param deviceBrand 品牌信息 可没有
     * @param deviceBatch 批次信息 可没有
     * @return
     * @throws Exception
     */
    TDevice register(String imei, String deviceBrand, String deviceBatch) throws Exception;

    /**
     * 设备删除
     *
     * @param deviceIdIot
     * @return
     */
    boolean deleteDeviceByIotId(String deviceIdIot);

    /**
     * 根据设备编号模糊查询设备列表
     *
     * @param keyWord  设备编号  like
     * @param isActive 是否只查未注册的设备
     */
    List<DeviceRefOrg> findDevicesLikeDeviceNum(String keyWord, boolean isActive);

    /**
     * 查询设备数据
     *
     * @param imei
     * @return
     */
    List<Map<String, String>> findDatasByImei(String imei);

    /**
     * e根据设备id查询设备厂商和型号信息设备
     *
     * @param deviceId
     * @return
     */
    DeviceRefModelInfo findDeviceOtherInfoByid(long deviceId);
}
