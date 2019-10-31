package com.soholy.dogmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.entity.TPetHospitalExample;

public interface TPetHospitalMapper {
    int countByExample(TPetHospitalExample example);

    int deleteByExample(TPetHospitalExample example);

    int deleteByPrimaryKey(Integer petHCardId);

    int insert(TPetHospital record);

    int insertSelective(TPetHospital record);

    List<TPetHospital> selectByExample(TPetHospitalExample example);

    TPetHospital selectByPrimaryKey(Integer petHCardId);

    int updateByExampleSelective(@Param("record") TPetHospital record, @Param("example") TPetHospitalExample example);

    int updateByExample(@Param("record") TPetHospital record, @Param("example") TPetHospitalExample example);

    int updateByPrimaryKeySelective(TPetHospital record);

    int updateByPrimaryKey(TPetHospital record);
    
    //批量添加医院申请证书
  	int addPetHospital(TPetHospital petHospital);
  	
  	//根据服务站点id查询申请材料证书
  	List<TPetHospital> selectTPetHospital(Integer organizationId);

    List<TPetHospital> selectPetHCardIds(@Param("organizationId") Integer organizationId);
}