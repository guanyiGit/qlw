package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TViolation;
import com.soholy.dogmanager.entity.TViolationExample;

public interface TViolationMapper {
    int countByExample(TViolationExample example);

    int deleteByExample(TViolationExample example);

    int deleteByPrimaryKey(Long violationId);

    int insert(TViolation record);

    int insertSelective(TViolation record);

    List<TViolation> selectByExampleWithBLOBs(TViolationExample example);

    List<TViolation> selectByExample(TViolationExample example);

    TViolation selectByPrimaryKey(Long violationId);

    int updateByExampleSelective(@Param("record") TViolation record, @Param("example") TViolationExample example);

    int updateByExampleWithBLOBs(@Param("record") TViolation record, @Param("example") TViolationExample example);

    int updateByExample(@Param("record") TViolation record, @Param("example") TViolationExample example);

    int updateByPrimaryKeySelective(TViolation record);

    int updateByPrimaryKeyWithBLOBs(TViolation record);

    int updateByPrimaryKey(TViolation record);
}