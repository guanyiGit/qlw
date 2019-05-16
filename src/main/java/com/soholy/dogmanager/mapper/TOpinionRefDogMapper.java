package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TOpinionRefDog;
import com.soholy.dogmanager.entity.TOpinionRefDogExample;

public interface TOpinionRefDogMapper {
    int countByExample(TOpinionRefDogExample example);

    int deleteByExample(TOpinionRefDogExample example);

    int deleteByPrimaryKey(Integer opinionRefDogId);

    int insert(TOpinionRefDog record);

    int insertSelective(TOpinionRefDog record);

    List<TOpinionRefDog> selectByExample(TOpinionRefDogExample example);

    TOpinionRefDog selectByPrimaryKey(Integer opinionRefDogId);

    int updateByExampleSelective(@Param("record") TOpinionRefDog record, @Param("example") TOpinionRefDogExample example);

    int updateByExample(@Param("record") TOpinionRefDog record, @Param("example") TOpinionRefDogExample example);

    int updateByPrimaryKeySelective(TOpinionRefDog record);

    int updateByPrimaryKey(TOpinionRefDog record);
}