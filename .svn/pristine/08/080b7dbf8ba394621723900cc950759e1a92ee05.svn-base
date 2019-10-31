package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDeviceDataWifi;
import com.soholy.dogmanager.entity.TDeviceDataWifiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeviceDataWifiMapper {
    int countByExample(TDeviceDataWifiExample example);

    int deleteByExample(TDeviceDataWifiExample example);

    int deleteByPrimaryKey(String deviceDataWifiId);

    int insert(TDeviceDataWifi record);

    int insertSelective(TDeviceDataWifi record);

    List<TDeviceDataWifi> selectByExample(TDeviceDataWifiExample example);

    TDeviceDataWifi selectByPrimaryKey(String deviceDataWifiId);

    int updateByExampleSelective(@Param("record") TDeviceDataWifi record, @Param("example") TDeviceDataWifiExample example);

    int updateByExample(@Param("record") TDeviceDataWifi record, @Param("example") TDeviceDataWifiExample example);

    int updateByPrimaryKeySelective(TDeviceDataWifi record);

    int updateByPrimaryKey(TDeviceDataWifi record);

    /**
     * @Description (批量插入wifi数据)
     * @param wifiDatas
     * @return
     */
    int saveDeviceWifiDatas(@Param("datas") List<TDeviceDataWifi> wifiDatas);
}