package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDeviceCommand;
import com.soholy.dogmanager.entity.TDeviceCommandExample;
import com.soholy.dogmanager.entity.device.cmd.CommandInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TDeviceCommandMapper {

    int countByExample(TDeviceCommandExample example);

    int deleteByExample(TDeviceCommandExample example);

    int deleteByPrimaryKey(Long deviceCommandId);

    int insert(TDeviceCommand record);

    int insertSelective(TDeviceCommand record);

    List<TDeviceCommand> selectByExample(TDeviceCommandExample example);

    TDeviceCommand selectByPrimaryKey(Long deviceCommandId);

    int updateByExampleSelective(@Param("record") TDeviceCommand record, @Param("example") TDeviceCommandExample example);

    int updateByExample(@Param("record") TDeviceCommand record, @Param("example") TDeviceCommandExample example);

    int updateByPrimaryKeySelective(TDeviceCommand record);

    int updateByPrimaryKey(TDeviceCommand record);

    /**
     * @param mid
     * @param resultCode
     * @param imei
     * @param rspTime
     * @return
     * @Description (根据设备imei更新设备命令结果信息 [0失败 1成功])
     */
    int modifyDeviceCmdByMidAndDeviceImei(@Param("mid") Integer mid, @Param("resultCode") Integer resultCode,
                                          @Param("imei") String imei, @Param("rspTime") Date rspTime);

    /**
     * @param deviceNum
     * @param status
     * @return
     * @Description (根据设备编码查询设备命令列表)
     */
    List<TDeviceCommand> findCommandByDeviceNum(@Param("deviceNum") String deviceNum, @Param("status") int status);

    /**
     * @param deviceIotId
     * @param status
     * @return
     * @Description (根据设备iot平台编码查询设备命令列表)
     */
    List<TDeviceCommand> findCommandByDeviceIotId(@Param("deviceIotId") String deviceIotId, @Param("status") int status);


    /**
     * @param deviceId
     * @param status
     * @return
     * @Description (根据设备id查询设备命令列表)
     */
    CommandInfo findCommandByDeviceId(@Param("deviceId") long deviceId, @Param("status") int status);


    /**
     * @param tDeviceCommand
     * @return
     * @Description (插入命令记录)
     */
    int saveCommand(TDeviceCommand tDeviceCommand);
}
