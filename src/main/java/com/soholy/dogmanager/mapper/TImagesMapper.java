package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TImages;
import com.soholy.dogmanager.entity.TImagesExample;

public interface TImagesMapper {
    int countByExample(TImagesExample example);

    int deleteByExample(TImagesExample example);

    int deleteByPrimaryKey(Long imageId);

    int insert(TImages record);

    int insertSelective(TImages record);

    List<TImages> selectByExample(TImagesExample example);

    TImages selectByPrimaryKey(Long imageId);

    int updateByExampleSelective(@Param("record") TImages record, @Param("example") TImagesExample example);

    int updateByExample(@Param("record") TImages record, @Param("example") TImagesExample example);

    int updateByPrimaryKeySelective(TImages record);

    int updateByPrimaryKey(TImages record);

    int deleteBatch(List<Long> ids);

}