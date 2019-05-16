package com.soholy.dogmanager.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.pojo.user.UserRefRoles;
import com.soholy.dogmanager.pojo.user.UserVo;

public interface UserRefRolesMapper {
	
	/**
	* @Description:通过userId获取角色
	* @param userId
	* @return（展示方法参数和返回值）
	 */
	UserRefRoles selectRolesByUserId(@Param("userId")Long userId);
	
	/**
	* @Description:查询角色列表
	* @return（展示方法参数和返回值）
	 */
	List<UserRefRoles> selectUserRefRoles(Integer status);
	
	/**
	* @Description:根据状态查询用户信息
	* @param status
	* @return（展示方法参数和返回值）
	 */
	List<UserVo> selectUserVo(@Param("status")Integer status,@Param("query")String query);
	
	
	
}
