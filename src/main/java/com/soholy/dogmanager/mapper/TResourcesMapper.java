package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.entity.TResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TResourcesMapper {
    int countByExample(TResourcesExample example);

    int deleteByExample(TResourcesExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(TResources record);

    int insertSelective(TResources record);

    List<TResources> selectByExample(TResourcesExample example);

    TResources selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") TResources record, @Param("example") TResourcesExample example);

    int updateByExample(@Param("record") TResources record, @Param("example") TResourcesExample example);

    int updateByPrimaryKeySelective(TResources record);

    int updateByPrimaryKey(TResources record);
    
    /**
     * @Description:根据状态获取资源
     * @param status
     * @return（展示方法参数和返回值）
      */
     List<TResources> selectResourceByStatus(Integer status);
     

 	/**
 	 * @Description:根据resourceId查询资源
 	 * @param resourceId
 	 * @return（展示方法参数和返回值）
 	 */
 	TResources selectResourceByResourceId(Integer resourceId);

 	/**
 	 * @Description:更新资源内容
 	 * @param resourceId
 	 * @return（展示方法参数和返回值）
 	 */
 	int updateResource(TResources resources);

 	/**
 	 * @Description:删除资源
 	 * @param resourceId
 	 * @return（展示方法参数和返回值）
 	 */
 	int deleteResourceById(Integer resourceId);
}