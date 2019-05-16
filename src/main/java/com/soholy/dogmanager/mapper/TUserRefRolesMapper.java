package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TUserRefRoles;
import com.soholy.dogmanager.entity.TUserRefRolesExample;

public interface TUserRefRolesMapper {
    int countByExample(TUserRefRolesExample example);

    int deleteByExample(TUserRefRolesExample example);

    int deleteByPrimaryKey(Integer userRefRoleId);

    int insert(TUserRefRoles record);

    int insertSelective(TUserRefRoles record);

    List<TUserRefRoles> selectByExample(TUserRefRolesExample example);

    TUserRefRoles selectByPrimaryKey(Integer userRefRoleId);

    int updateByExampleSelective(@Param("record") TUserRefRoles record, @Param("example") TUserRefRolesExample example);

    int updateByExample(@Param("record") TUserRefRoles record, @Param("example") TUserRefRolesExample example);

    int updateByPrimaryKeySelective(TUserRefRoles record);

    int updateByPrimaryKey(TUserRefRoles record);
    
    //添加user与role关联关系
    int addUserRefRole(List<TUserRefRoles> userRefRoles);
    
    //通过userId删除关联关系
    int deleteUserRefRoleByUserId(Long userId);
    
    //通过roleId删除关系
    int deleteUserRefRoleByRoleId(Integer roleId);
    
    //通过userId查询关联关系
    List<TUserRefRoles> selectByUserId(Long userId);
    
    //通过roleId查询关联关系
    List<TUserRefRoles> selectByRoleId(Integer roleId);
    
}