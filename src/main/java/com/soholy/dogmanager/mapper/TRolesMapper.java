package com.soholy.dogmanager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.entity.TRolesExample;

public interface TRolesMapper {
    int countByExample(TRolesExample example);

    int deleteByExample(TRolesExample example);

   

    int insert(TRoles record);

    
    List<TRoles> selectByExample(TRolesExample example);

    TRoles selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") TRoles record, @Param("example") TRolesExample example);

    int updateByExample(@Param("record") TRoles record, @Param("example") TRolesExample example);

    int updateByPrimaryKey(TRoles record);
    
    /**
    * @Description:添加role
    * @param record
    * @return（展示方法参数和返回值）
     */
    int insertRole(TRoles record);
    
    /**
    * @Description:根据roleId删除role
    * @param roleId
    * @return（展示方法参数和返回值）
     */
    
    int deleteByRoleId(Integer roleId);
    
	/** 根据status查询角色 */
	List<TRoles> selectRolesByStatus(@Param("status")Integer status,@Param("query")String query);
    
	/** 编辑角色 */
	int updateRole(TRoles role);
	
	/**
	 *  根据角色id获取所有资源id集合
	 */
	List<Integer> selectResourcesIdsByRoleId(Integer roleId);
}