package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDeviceData;
import com.soholy.dogmanager.entity.TDeviceDataExample;
import com.soholy.dogmanager.entity.device.DeviceRefModelInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TDeviceDataMapper {

    int countByExample(TDeviceDataExample example);

    int deleteByExample(TDeviceDataExample example);

    int deleteByPrimaryKey(String deviceDateId);

    int insert(TDeviceData record);

    int insertSelective(TDeviceData record);

    List<TDeviceData> selectByExample(TDeviceDataExample example);

    TDeviceData selectByPrimaryKey(String deviceDateId);

    int updateByExampleSelective(@Param("record") TDeviceData record, @Param("example") TDeviceDataExample example);

    int updateByExample(@Param("record") TDeviceData record, @Param("example") TDeviceDataExample example);

    int updateByPrimaryKeySelective(TDeviceData record);

    int updateByPrimaryKey(TDeviceData record);

    /**
     * 根据时间获取当天所有坐标记录
     * 根据seq排序
     */
    List<TDeviceData> selectDeviceDatasByDate(@Param("deviceId") Long deviceId, @Param("date") String date);

    /**
     * 根据时间段获取该时间段坐标记录
     * 根据seq排序
     */
    List<TDeviceData> selectDeviceDatasByTimes(@Param("deviceId") Long deviceId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * @param date
     * @Description:根据时间查询所有当前时间设备数据
     * @return（展示方法参数和返回值）
     */
    List<TDeviceData> getDeviceDatasByDate(String date);

    /**
     * 批量保存数据
     */
    public int saveDatas(@Param("datas") List<TDeviceData> tDeviceData);

    /**
     * 查询设备数据
     * @param imei
     * @return
     */
    List<Map<String, String>>  findDatasByImei(@Param("imei") String imei);

    /**
     * 查询某天的设备在线总数
     * @param date 要查的日期
     * @return
     */
    long findDayDeviceActiveCount(Date date);

}
