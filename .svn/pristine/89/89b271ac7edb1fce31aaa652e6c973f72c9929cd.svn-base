package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TCollection;
import com.soholy.dogmanager.entity.TCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCollectionMapper {
    int countByExample(TCollectionExample example);

    int deleteByExample(TCollectionExample example);

    int deleteByPrimaryKey(Long collectionId);

    int insert(TCollection record);

    int insertSelective(TCollection record);

    List<TCollection> selectByExample(TCollectionExample example);

    TCollection selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByExample(@Param("record") TCollection record, @Param("example") TCollectionExample example);

    int updateByPrimaryKeySelective(TCollection record);

    int updateByPrimaryKey(TCollection record);
}