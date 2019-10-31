package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TRoleRefResources;
import com.soholy.dogmanager.entity.TRoleRefResourcesExample;
import com.soholy.dogmanager.entity.TUserRefRoles;

public interface TRoleRefResourcesMapper {
    int countByExample(TRoleRefResourcesExample example);

    int deleteByExample(TRoleRefResourcesExample example);

    int deleteByPrimaryKey(Integer roleRefResourcesId);

    int insert(TRoleRefResources record);

    int insertSelective(TRoleRefResources record);

    List<TRoleRefResources> selectByExample(TRoleRefResourcesExample example);

    TRoleRefResources selectByPrimaryKey(Integer roleRefResourcesId);

    int updateByExampleSelective(@Param("record") TRoleRefResources record, @Param("example") TRoleRefResourcesExample example);

    int updateByExample(@Param("record") TRoleRefResources record, @Param("example") TRoleRefResourcesExample example);

    int updateByPrimaryKeySelective(TRoleRefResources record);

    int updateByPrimaryKey(TRoleRefResources record);
    
    //添加role与resources关联关系
    int addRoleRefResources(List<TRoleRefResources> roleRefResources);
    
    //通过userId删除关联关系
    int deleteRoleRefResourcesByRoleId(Integer roleId);
    
    //通过resourcesId删除关系
    int deleteRoleRefResourcesByResourcesId(Integer resourcesId);
    
    //通过userId查询关联关系
    List<TRoleRefResources> selectByRoleId(Integer roleId);
    
    //通过roleId查询关联关系
    List<TRoleRefResources> selectByResourcesId(Integer resourcesId);
    
    //批量删除RoleRefResources关联关系
    int deleteRoleRefResources(List<TRoleRefResources> roleRefResources);
    
    
}