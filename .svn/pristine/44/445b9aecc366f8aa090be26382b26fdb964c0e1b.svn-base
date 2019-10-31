package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.entity.TAdoptionRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdoptionRecordsMapper {
    int countByExample(TAdoptionRecordsExample example);

    int deleteByExample(TAdoptionRecordsExample example);

    int deleteByPrimaryKey(Long adoptionRecordsId);

    int insert(TAdoptionRecords record);

    int insertSelective(TAdoptionRecords record);

    List<TAdoptionRecords> selectByExample(TAdoptionRecordsExample example);

    TAdoptionRecords selectByPrimaryKey(Long adoptionRecordsId);

    int updateByExampleSelective(@Param("record") TAdoptionRecords record, @Param("example") TAdoptionRecordsExample example);

    int updateByExample(@Param("record") TAdoptionRecords record, @Param("example") TAdoptionRecordsExample example);

    int updateByPrimaryKeySelective(TAdoptionRecords record);

    int updateByPrimaryKey(TAdoptionRecords record);

    String selectOrgName(@Param("userId") Long userId);//查询操作人所在机构名称

    String selectPhone(@Param("adoptionRecordsId") Long adoptionRecordsId);//查询领养人电话
}