package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDeviceRefDog;
import com.soholy.dogmanager.entity.TDeviceRefDogExample;

public interface TDeviceRefDogMapper {
    int countByExample(TDeviceRefDogExample example);

    int deleteByExample(TDeviceRefDogExample example);

    int deleteByPrimaryKey(Long deviceRefDogId);

    int insert(TDeviceRefDog record);

    int insertSelective(TDeviceRefDog record);

    List<TDeviceRefDog> selectByExample(TDeviceRefDogExample example);

    TDeviceRefDog selectByPrimaryKey(Long deviceRefDogId);

    int updateByExampleSelective(@Param("record") TDeviceRefDog record, @Param("example") TDeviceRefDogExample example);

    int updateByExample(@Param("record") TDeviceRefDog record, @Param("example") TDeviceRefDogExample example);

    int updateByPrimaryKeySelective(TDeviceRefDog record);

    int updateByPrimaryKey(TDeviceRefDog record);

    /**
     * 查看设备绑定情况
     * @param imei
     * @return
     */
    List<TDeviceRefDog> findDeviceBindInfo(String imei);

    /**
     * 更具imei号查询设备id
     * @param imei
     * @return
     */
    String selectDeviceIdByImmi(@Param("imei") String imei);
}