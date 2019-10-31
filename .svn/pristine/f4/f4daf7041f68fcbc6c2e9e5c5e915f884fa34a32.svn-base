package com.soholy.dogmanager.mapper;

import java.util.List;

import com.soholy.dogmanager.pojo.statistic.DogInfoVO;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.TDogInfoExample;

public interface TDogInfoMapper {
    int countByExample(TDogInfoExample example);

    int deleteByExample(TDogInfoExample example);

    int deleteByPrimaryKey(Long dogId);

    int insert(TDogInfo record);

    int insertSelective(TDogInfo record);

    List<TDogInfo> selectByExampleWithBLOBs(TDogInfoExample example);

    List<TDogInfo> selectByExample(TDogInfoExample example);

    TDogInfo selectByPrimaryKey(Long dogId);

    int updateByExampleSelective(@Param("record") TDogInfo record, @Param("example") TDogInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TDogInfo record, @Param("example") TDogInfoExample example);

    int updateByExample(@Param("record") TDogInfo record, @Param("example") TDogInfoExample example);

    int updateByPrimaryKeySelective(TDogInfo record);

    int updateByPrimaryKeyWithBLOBs(TDogInfo record);

    int updateByPrimaryKey(TDogInfo record);

    DogInfoVO findDogInfoVOById(Long dogId);
}