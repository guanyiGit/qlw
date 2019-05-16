package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TVaccineRegister;
import com.soholy.dogmanager.entity.TVaccineRegisterExample;

public interface TVaccineRegisterMapper {
    int countByExample(TVaccineRegisterExample example);

    int deleteByExample(TVaccineRegisterExample example);

    int deleteByPrimaryKey(Long vaccineRegisterId);

    int insert(TVaccineRegister record);

    int insertSelective(TVaccineRegister record);

    List<TVaccineRegister> selectByExample(TVaccineRegisterExample example);

    TVaccineRegister selectByPrimaryKey(Long vaccineRegisterId);

    int updateByExampleSelective(@Param("record") TVaccineRegister record, @Param("example") TVaccineRegisterExample example);

    int updateByExample(@Param("record") TVaccineRegister record, @Param("example") TVaccineRegisterExample example);

    int updateByPrimaryKeySelective(TVaccineRegister record);

    int updateByPrimaryKey(TVaccineRegister record);


}