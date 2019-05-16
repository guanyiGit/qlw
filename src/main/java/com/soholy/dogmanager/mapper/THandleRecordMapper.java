package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.THandleRecord;
import com.soholy.dogmanager.entity.THandleRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THandleRecordMapper {
    int countByExample(THandleRecordExample example);

    int deleteByExample(THandleRecordExample example);

    int deleteByPrimaryKey(Long handleId);

    int insert(THandleRecord record);

    int insertSelective(THandleRecord record);

    List<THandleRecord> selectByExample(THandleRecordExample example);

    THandleRecord selectByPrimaryKey(Long handleId);

    int updateByExampleSelective(@Param("record") THandleRecord record, @Param("example") THandleRecordExample example);

    int updateByExample(@Param("record") THandleRecord record, @Param("example") THandleRecordExample example);

    int updateByPrimaryKeySelective(THandleRecord record);

    int updateByPrimaryKey(THandleRecord record);
}