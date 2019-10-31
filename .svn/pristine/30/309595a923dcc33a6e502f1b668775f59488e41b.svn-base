package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TBlacklist;
import com.soholy.dogmanager.entity.TBlacklistExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBlacklistMapper {
    int countByExample(TBlacklistExample example);

    int deleteByExample(TBlacklistExample example);

    int deleteByPrimaryKey(Long blackId);

    int insert(TBlacklist record);

    int insertSelective(TBlacklist record);

    List<TBlacklist> selectByExample(TBlacklistExample example);

    TBlacklist selectByPrimaryKey(Long blackId);

    int updateByExampleSelective(@Param("record") TBlacklist record, @Param("example") TBlacklistExample example);

    int updateByExample(@Param("record") TBlacklist record, @Param("example") TBlacklistExample example);

    int updateByPrimaryKeySelective(TBlacklist record);

    int updateByPrimaryKey(TBlacklist record);
    
    //根据姓名或身份证或电话检查黑名单是否存在
  	TBlacklist checkBlackList(String string);
  	
  	//批量移除
  	void  removeBatch(List<TBlacklist> blackLists);
  	
  	List<TBlacklist> findTBlacklistAll(HashMap<String, Object> map);
  	int findTBlacklistAllCount(HashMap<String, Object> map);
    
}