package com.soholy.dogmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.entity.TDictionaryExample;

public interface TDictionaryMapper {
    int countByExample(TDictionaryExample example);

    int deleteByExample(TDictionaryExample example);

    int deleteByPrimaryKey(Integer dictionaryId);

    int insert(TDictionary record);

    int insertSelective(TDictionary record);

    List<TDictionary> selectByExample(TDictionaryExample example);

    TDictionary selectByPrimaryKey(Integer dictionaryId);

    int updateByExampleSelective(@Param("record") TDictionary record, @Param("example") TDictionaryExample example);

    int updateByExample(@Param("record") TDictionary record, @Param("example") TDictionaryExample example);

    int updateByPrimaryKeySelective(TDictionary record);

    int updateByPrimaryKey(TDictionary record);
    
   
    //查询申请材料证书类型
    List<TDictionary>  selectPetHospital(@Param("typeNumber")Integer typeNumber);
    
    //查询某一中的资讯类型
    List<TDictionary>  selectInformationType(@Param("typeNumber")Integer typeNumber);
    /**
     * 
     * @Description (查询预约业务类型)
     * @return
     */
    List<TDictionary> findBizTypes(@Param("dictionaryField")String dictionaryField);
    
    //查询机构类型
    List<TDictionary>  selectOrgType(@Param("typeNumber")Integer typeNumber);
    
    //查询犬主身份证件类型
    List<TDictionary> selectOwnCardType(@Param("typeNumber")Integer typeNumber);
    
    //查询预约渠道
    List<TDictionary> selectAppointment_channel(@Param("typeNumber")Integer typeNumber);

    //查询图片类型
    List<TDictionary> selectPictureType(@Param("typeNumber")Integer typeNumber);


    /**
     * 插入返回主键
     * @param tDictionary
     * @return
     */
    Integer save(@Param("_parameter") TDictionary tDictionary);
}