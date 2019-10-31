package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TImmuneCard;
import com.soholy.dogmanager.entity.TImmuneCardExample;

public interface TImmuneCardMapper {
    int countByExample(TImmuneCardExample example);

    int deleteByExample(TImmuneCardExample example);

    int deleteByPrimaryKey(Long seqId);

    int insert(TImmuneCard record);

    int insertSelective(TImmuneCard record);

    List<TImmuneCard> selectByExample(TImmuneCardExample example);

    TImmuneCard selectByPrimaryKey(Long seqId);

    int updateByExampleSelective(@Param("record") TImmuneCard record, @Param("example") TImmuneCardExample example);

    int updateByExample(@Param("record") TImmuneCard record, @Param("example") TImmuneCardExample example);

    int updateByPrimaryKeySelective(TImmuneCard record);

    int updateByPrimaryKey(TImmuneCard record);

    String selectImmunePre();//查免疫证号前缀

    String selectImmuneCardNum();//查最新的免疫证号

    String selectImmuneCardNumById(@Param("dogId") Long dogId);//根据犬只id查免疫证号

}