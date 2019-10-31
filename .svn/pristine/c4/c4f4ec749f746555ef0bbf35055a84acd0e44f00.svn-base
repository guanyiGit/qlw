package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TFence;
import com.soholy.dogmanager.entity.TFenceExample;

public interface TFenceMapper {
    int countByExample(TFenceExample example);

    int deleteByExample(TFenceExample example);

    int deleteByPrimaryKey(Long fenceId);

    int insert(TFence record);

    int insertSelective(TFence record);

    List<TFence> selectByExample(TFenceExample example);

    TFence selectByPrimaryKey(Long fenceId);

    int updateByExampleSelective(@Param("record") TFence record, @Param("example") TFenceExample example);

    int updateByExample(@Param("record") TFence record, @Param("example") TFenceExample example);

    int updateByPrimaryKeySelective(TFence record);

    int updateByPrimaryKey(TFence record);
    
    //获取所有的围栏
    List<TFence> selectFences(@Param("operatorId")Long operatorId)throws Exception;
    
}