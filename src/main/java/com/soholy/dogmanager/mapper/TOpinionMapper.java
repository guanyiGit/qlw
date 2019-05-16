package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TOpinion;
import com.soholy.dogmanager.entity.TOpinionExample;
import com.soholy.dogmanager.entity.TOpinionWithBLOBs;

public interface TOpinionMapper {
    int countByExample(TOpinionExample example);

    int deleteByExample(TOpinionExample example);

    int deleteByPrimaryKey(Long opinionId);

    int insert(TOpinionWithBLOBs record);

    int insertSelective(TOpinionWithBLOBs record);

    List<TOpinionWithBLOBs> selectByExampleWithBLOBs(TOpinionExample example);

    List<TOpinion> selectByExample(TOpinionExample example);

    TOpinionWithBLOBs selectByPrimaryKey(Long opinionId);

    int updateByExampleSelective(@Param("record") TOpinionWithBLOBs record, @Param("example") TOpinionExample example);

    int updateByExampleWithBLOBs(@Param("record") TOpinionWithBLOBs record, @Param("example") TOpinionExample example);

    int updateByExample(@Param("record") TOpinion record, @Param("example") TOpinionExample example);

    int updateByPrimaryKeySelective(TOpinionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TOpinionWithBLOBs record);

    int updateByPrimaryKey(TOpinion record);
}