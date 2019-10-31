package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TPunish;
import com.soholy.dogmanager.entity.TPunishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPunishMapper {
    int countByExample(TPunishExample example);

    int deleteByExample(TPunishExample example);

    int deleteByPrimaryKey(Long punishId);

    int insert(TPunish record);

    int insertSelective(TPunish record);

    List<TPunish> selectByExample(TPunishExample example);

    TPunish selectByPrimaryKey(Long punishId);

    int updateByExampleSelective(@Param("record") TPunish record, @Param("example") TPunishExample example);

    int updateByExample(@Param("record") TPunish record, @Param("example") TPunishExample example);

    int updateByPrimaryKeySelective(TPunish record);

    int updateByPrimaryKey(TPunish record);
}