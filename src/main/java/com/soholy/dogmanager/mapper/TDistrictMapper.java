package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TDistrict;
import com.soholy.dogmanager.entity.TDistrictExample;

public interface TDistrictMapper {
    int countByExample(TDistrictExample example);

    int deleteByExample(TDistrictExample example);

    int deleteByPrimaryKey(Integer districtId);

    int insert(TDistrict record);

    int insertSelective(TDistrict record);

    List<TDistrict> selectByExample(TDistrictExample example);

    TDistrict selectByPrimaryKey(Integer districtId);

    int updateByExampleSelective(@Param("record") TDistrict record, @Param("example") TDistrictExample example);

    int updateByExample(@Param("record") TDistrict record, @Param("example") TDistrictExample example);

    int updateByPrimaryKeySelective(TDistrict record);

    int updateByPrimaryKey(TDistrict record);
}