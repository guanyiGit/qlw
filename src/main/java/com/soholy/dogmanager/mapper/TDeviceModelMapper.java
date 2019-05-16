package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDeviceModel;
import com.soholy.dogmanager.entity.TDeviceModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeviceModelMapper {
    int countByExample(TDeviceModelExample example);

    int deleteByExample(TDeviceModelExample example);

    int deleteByPrimaryKey(Integer deviceModelId);

    int insert(TDeviceModel record);

    int insertSelective(TDeviceModel record);

    List<TDeviceModel> selectByExample(TDeviceModelExample example);

    TDeviceModel selectByPrimaryKey(Integer deviceModelId);

    int updateByExampleSelective(@Param("record") TDeviceModel record, @Param("example") TDeviceModelExample example);

    int updateByExample(@Param("record") TDeviceModel record, @Param("example") TDeviceModelExample example);

    int updateByPrimaryKeySelective(TDeviceModel record);

    int updateByPrimaryKey(TDeviceModel record);

    /**
     * 插入设备信息并返回主键
     * @param tDeviceModel
     * @return
     */
    Integer save(@Param("tDeviceModel") TDeviceModel tDeviceModel);
    /**
     *  批量修改设备激活状态
     * @param deviceIds
     * @param status
     * @return
     */
    int modifyDeviceStatusByids(@Param("deviceIds") List<Long> deviceIds, @Param("status") Integer status);
}