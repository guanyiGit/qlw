package com.soholy.dogmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDeviceWarn;
import com.soholy.dogmanager.entity.TDeviceWarnExample;

public interface TDeviceWarnMapper {

    int countByExample(TDeviceWarnExample example);

    int deleteByExample(TDeviceWarnExample example);

    int deleteByPrimaryKey(Long deviceWarnId);

    int insert(TDeviceWarn record);

    int insertSelective(TDeviceWarn record);

    List<TDeviceWarn> selectByExample(TDeviceWarnExample example);

    TDeviceWarn selectByPrimaryKey(Long deviceWarnId);

    int updateByExampleSelective(@Param("record") TDeviceWarn record, @Param("example") TDeviceWarnExample example);

    int updateByExample(@Param("record") TDeviceWarn record, @Param("example") TDeviceWarnExample example);

    /**
    * 
    * @Description (查询最后一次告警时间)
    * @param deviceId
    * @return
    */
    TDeviceWarn findDeviceWarnInfoMaxTimeByDevId(@Param("deviceId") Long deviceId);

    int updateByPrimaryKeySelective(TDeviceWarn record);

    int updateByPrimaryKey(TDeviceWarn record);
}
