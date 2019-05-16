package com.soholy.dogmanager.service.user;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TRoleRefResources;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.pojo.user.RoleRefResources;

public interface RoleService {
	
	/**
	* @Description:添加角色
	* @param role
	* @return（展示方法参数和返回值）
	 */
	DogResult addRole(TRoles role);
	
	/**
	* @Description:删除角色
	* @param roleId
	* @return（展示方法参数和返回值）
	 */
	DogResult deleteRoleById(Integer roleId);
	
	/** 默认查询所有状态为启用(status = 1)的角色 */
	List<TRoles> selectRolesByStatus(String query);
	
	/** 根据status查询角色 */
	List<TRoles> selectRolesByStatus(Integer status,String query);
	
	/** 根据id查询角色*/
	DogResult updateRole(TRoles role);
	
	/** 授权 */
	DogResult addRoleRefResources(List<TRoleRefResources> roleRefResources);
	
	/** 授权更新*/
	DogResult updateRoleRefResources(Integer roleId, String resourceIds);
	
	/**
	* @Description:根据roleId查询资源
	* @param roleId
	* @return（展示方法参数和返回值）
	 */
	RoleRefResources selectByRoleId(Integer roleId);
	
	/**
	 *  根据角色id获取所有资源id集合
	 */
	List<Integer> selectResourcesIdsByRoleId(Integer roleId);

	HashMap<String, Object> findResourceMap(Integer roleId);

	void assignResources(Integer roleId, Integer[] resourceIds);

	List<TRoles> findRoleAll();
}
