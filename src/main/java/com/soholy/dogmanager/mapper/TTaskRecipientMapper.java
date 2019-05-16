package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TTaskRecipient;
import com.soholy.dogmanager.entity.TTaskRecipientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskRecipientMapper {
    int countByExample(TTaskRecipientExample example);

    int deleteByExample(TTaskRecipientExample example);

    int deleteByPrimaryKey(Integer tTaskRecipientId);

    int insert(TTaskRecipient record);

    int insertSelective(TTaskRecipient record);

    List<TTaskRecipient> selectByExample(TTaskRecipientExample example);

    TTaskRecipient selectByPrimaryKey(Integer tTaskRecipientId);

    int updateByExampleSelective(@Param("record") TTaskRecipient record, @Param("example") TTaskRecipientExample example);

    int updateByExample(@Param("record") TTaskRecipient record, @Param("example") TTaskRecipientExample example);

    int updateByPrimaryKeySelective(TTaskRecipient record);

    int updateByPrimaryKey(TTaskRecipient record);
}