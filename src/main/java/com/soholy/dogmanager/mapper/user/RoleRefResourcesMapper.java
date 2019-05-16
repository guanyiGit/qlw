package com.soholy.dogmanager.mapper.user;

import com.soholy.dogmanager.pojo.user.RoleRefResources;
import org.apache.ibatis.annotations.Param;

public interface RoleRefResourcesMapper {
	
	/**
	* @Description:根据角色
	* @param roleId
	* @return（展示方法参数和返回值）
	 */
	RoleRefResources roleRefResources(@Param("roleId") Integer roleId);
	
}
