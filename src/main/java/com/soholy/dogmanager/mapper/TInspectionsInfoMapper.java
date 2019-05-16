package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TInspectionsInfo;
import com.soholy.dogmanager.entity.TInspectionsInfoExample;

public interface TInspectionsInfoMapper {
    int countByExample(TInspectionsInfoExample example);

    int deleteByExample(TInspectionsInfoExample example);

    int deleteByPrimaryKey(Long inspectionsId);

    int insert(TInspectionsInfo record);

    int insertSelective(TInspectionsInfo record);

    List<TInspectionsInfo> selectByExampleWithBLOBs(TInspectionsInfoExample example);

    List<TInspectionsInfo> selectByExample(TInspectionsInfoExample example);

    TInspectionsInfo selectByPrimaryKey(Long inspectionsId);

    int updateByExampleSelective(@Param("record") TInspectionsInfo record, @Param("example") TInspectionsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TInspectionsInfo record, @Param("example") TInspectionsInfoExample example);

    int updateByExample(@Param("record") TInspectionsInfo record, @Param("example") TInspectionsInfoExample example);

    int updateByPrimaryKeySelective(TInspectionsInfo record);

    int updateByPrimaryKeyWithBLOBs(TInspectionsInfo record);

    int updateByPrimaryKey(TInspectionsInfo record);
}