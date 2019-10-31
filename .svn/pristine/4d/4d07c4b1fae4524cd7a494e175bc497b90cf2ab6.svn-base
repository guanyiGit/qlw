package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDeviceFactory;
import com.soholy.dogmanager.entity.TDeviceFactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeviceFactoryMapper {
    int countByExample(TDeviceFactoryExample example);

    int deleteByExample(TDeviceFactoryExample example);

    int deleteByPrimaryKey(Integer deviceFactoryId);

    int insert(TDeviceFactory record);

    int insertSelective(TDeviceFactory record);

    List<TDeviceFactory> selectByExample(TDeviceFactoryExample example);

    TDeviceFactory selectByPrimaryKey(Integer deviceFactoryId);

    int updateByExampleSelective(@Param("record") TDeviceFactory record, @Param("example") TDeviceFactoryExample example);

    int updateByExample(@Param("record") TDeviceFactory record, @Param("example") TDeviceFactoryExample example);

    int updateByPrimaryKeySelective(TDeviceFactory record);

    int updateByPrimaryKey(TDeviceFactory record);

    /**
     *  插入记录并返回id
     * @param tDeviceFactory
     * @return
     */
    Integer save(@Param("tDeviceFactory") TDeviceFactory tDeviceFactory);
}