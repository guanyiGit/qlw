package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDogCard;
import com.soholy.dogmanager.entity.TDogCardExample;

public interface TDogCardMapper {
    int countByExample(TDogCardExample example);

    int deleteByExample(TDogCardExample example);

    int deleteByPrimaryKey(Long seqNum);

    int insert(TDogCard record);

    int insertSelective(TDogCard record);

    List<TDogCard> selectByExample(TDogCardExample example);

    TDogCard selectByPrimaryKey(Long seqNum);

    int updateByExampleSelective(@Param("record") TDogCard record, @Param("example") TDogCardExample example);

    int updateByExample(@Param("record") TDogCard record, @Param("example") TDogCardExample example);

    int updateByPrimaryKeySelective(TDogCard record);

    int updateByPrimaryKey(TDogCard record);
}