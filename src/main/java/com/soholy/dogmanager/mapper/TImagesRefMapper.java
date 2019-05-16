package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TImagesRef;
import com.soholy.dogmanager.entity.TImagesRefExample;

public interface TImagesRefMapper {
    int countByExample(TImagesRefExample example);

    int deleteByExample(TImagesRefExample example);

    int deleteByPrimaryKey(Long imageRefId);

    int insert(TImagesRef record);

    int insertSelective(TImagesRef record);

    List<TImagesRef> selectByExample(TImagesRefExample example);

    TImagesRef selectByPrimaryKey(Long imageRefId);

    int updateByExampleSelective(@Param("record") TImagesRef record, @Param("example") TImagesRefExample example);

    int updateByExample(@Param("record") TImagesRef record, @Param("example") TImagesRefExample example);

    int updateByPrimaryKeySelective(TImagesRef record);

    int updateByPrimaryKey(TImagesRef record);
    
    //根据服务网点id查询服务网点(类型4)图片
    List<TImagesRef> selectServiceSiteById(Integer orgId);
    
    //查询资讯图片
    List<TImagesRef> selectInformationPic(@Param("informationId")Long informationId);

    List<TImagesRef> slelctByRefIdAndType(@Param("refId")Long refId,@Param("type")Integer type);

    int deletePicture(@Param("refId")Long refId,@Param("type")Integer type);
    
}