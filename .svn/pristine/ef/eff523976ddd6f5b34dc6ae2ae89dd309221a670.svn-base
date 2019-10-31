package com.soholy.dogmanager.mapper;

import java.util.Date;
import java.util.List;

import com.soholy.dogmanager.pojo.fence.FenceRefCoordinate;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TFenceCoordinate;
import com.soholy.dogmanager.entity.TFenceCoordinateExample;

public interface TFenceCoordinateMapper {
    int countByExample(TFenceCoordinateExample example);

    int deleteByExample(TFenceCoordinateExample example);

    int deleteByPrimaryKey(Long eFenceCoordinateId);

    int insert(TFenceCoordinate record);

    int insertSelective(TFenceCoordinate record);

    List<TFenceCoordinate> selectByExample(TFenceCoordinateExample example);

    TFenceCoordinate selectByPrimaryKey(Long eFenceCoordinateId);

    int updateByExampleSelective(@Param("record") TFenceCoordinate record, @Param("example") TFenceCoordinateExample example);

    int updateByExample(@Param("record") TFenceCoordinate record, @Param("example") TFenceCoordinateExample example);

    int updateByPrimaryKeySelective(TFenceCoordinate record);

    int updateByPrimaryKey(TFenceCoordinate record);
    
    //批量添加
    int insertBatch(List<TFenceCoordinate> fenceCoordinates);
    
    //根据fenceId获取围栏坐标
    List<TFenceCoordinate> selectCoordinatesByFenceId(Long fenceId);
    
    //批量删除
    int deleteBatch(List<TFenceCoordinate> fenceCoordinates);
    
    int deleteByFenceId(Long fenceId);

    /**
     * 查围栏详情
     * @param fenceIds
     * @return
     */
    List<FenceRefCoordinate> findDetailByids(@Param("fenceIds") long[] fenceIds);
}