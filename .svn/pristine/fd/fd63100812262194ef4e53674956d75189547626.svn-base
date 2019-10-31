package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDogOwnerCard;
import com.soholy.dogmanager.entity.TDogOwnerCardExample;

public interface TDogOwnerCardMapper {
    int countByExample(TDogOwnerCardExample example);

    int deleteByExample(TDogOwnerCardExample example);

    int deleteByPrimaryKey(Long dogOwnerCardId);

    int insert(TDogOwnerCard record);

    int insertSelective(TDogOwnerCard record);

    List<TDogOwnerCard> selectByExample(TDogOwnerCardExample example);

    TDogOwnerCard selectByPrimaryKey(Long dogOwnerCardId);

    int updateByExampleSelective(@Param("record") TDogOwnerCard record, @Param("example") TDogOwnerCardExample example);

    int updateByExample(@Param("record") TDogOwnerCard record, @Param("example") TDogOwnerCardExample example);

    int updateByPrimaryKeySelective(TDogOwnerCard record);

    int updateByPrimaryKey(TDogOwnerCard record);

}