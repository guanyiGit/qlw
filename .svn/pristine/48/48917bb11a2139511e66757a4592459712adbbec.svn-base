package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TTherapy;
import com.soholy.dogmanager.entity.TTherapyExample;

public interface TTherapyMapper {
    int countByExample(TTherapyExample example);

    int deleteByExample(TTherapyExample example);

    int deleteByPrimaryKey(Long therapyId);

    int insert(TTherapy record);

    int insertSelective(TTherapy record);

    List<TTherapy> selectByExampleWithBLOBs(TTherapyExample example);

    List<TTherapy> selectByExample(TTherapyExample example);

    TTherapy selectByPrimaryKey(Long therapyId);

    int updateByExampleSelective(@Param("record") TTherapy record, @Param("example") TTherapyExample example);

    int updateByExampleWithBLOBs(@Param("record") TTherapy record, @Param("example") TTherapyExample example);

    int updateByExample(@Param("record") TTherapy record, @Param("example") TTherapyExample example);

    int updateByPrimaryKeySelective(TTherapy record);

    int updateByPrimaryKeyWithBLOBs(TTherapy record);

    int updateByPrimaryKey(TTherapy record);
}