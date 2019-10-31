package com.soholy.dogmanager.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.entity.TUsersExample;

public interface TUsersMapper {
	int countByExample(TUsersExample example);

	int deleteByExample(TUsersExample example);

	int deleteByPrimaryKey(Long userId);

	int insertSelective(TUsers record);

	List<TUsers> selectByExample(TUsersExample example);

	TUsers selectByPrimaryKey(Long userId);

	int updateByExampleSelective(@Param("record") TUsers record, @Param("example") TUsersExample example);

	int updateByExample(@Param("record") TUsers record, @Param("example") TUsersExample example);

	int updateByPrimaryKeySelective(TUsers record);

	TUsers getUserByPhone(String phone);
	
	/**
	 * @Description:重置密码
	 * @param userId
	 * @param password（展示方法参数和返回值）
	 */
    int resetPassWord(@Param("userId")Long userId,@Param("password")String password);
	
	int updateByPrimaryKey(TUsers record);

	int updateUserPwdById(@Param("userId") Long userId, @Param("newPassword") String newPassword);

	// 添加用户
	int insertUser(@Param("user") TUsers user);

	// 根据电话查询
	TUsers selectUserByUserName(String usernName) throws Exception;

	// 根据电话查询
	List<TUsers> selectUserByPhone(String phone);

	// 根据email查询
	List<TUsers> selectUserByEmail(String email) throws Exception;

	// 根据status查询用户
	List<TUsers> selectUsersByStatus(Integer status) throws Exception;

	// 根据orgtype查询用户
	List<TUsers> selectUsersByOrgType(Integer orgType) throws Exception;
	
	/**
	* @Description:修改用户状态
	* @param userId
	* @param status
	* @return（展示方法参数和返回值）
	 */
	Integer updataStatus(@Param("userId")Long userId,@Param("status")Integer status);

	/**
	 *  根据设备id查询用户信息
	 * @param deviceId
	 * @return
	 */
	TUsers findUserInfoByDeviceId(Long deviceId);

	/**
	 * 修改登录信息 登录记录表
	 * @param userId
	 * @param recentLoginDate
	 * @param recentLogoutDate
	 * @return
	 */
    int modifyLoginInfo(@Param("userId") Long userId,@Param("recentLoginDate")  Date recentLoginDate, @Param("recentLogoutDate") Date recentLogoutDate);

	/**
	 * 插入登录信息
	 * @param userId
	 * @param recentLoginDate
	 * @param recentLogoutDate
	 * @return
	 */
	int saveLoginInfo(@Param("userId") Long userId,@Param("recentLoginDate")  Date recentLoginDate, @Param("recentLogoutDate") Date recentLogoutDate);

    /**
     * 根据犬主id查询用户信息
     * @param ownerId
     * @return
     */
    TUsers getUserByOwnerId(Long ownerId);


	//根据userName修改用户
	int updateUserByName(@Param("newUserName") String userName,
					@Param("passWord") String passWord,
					@Param("oldUserName") String oldUserName);


	String selectOrgNameById(@Param("orgId") Integer orgId);
	//根据登陆名称查询对象
	TUsers getTUserByUserName(String userName);
	//根据手机号查询对象
	TUsers getTUserByPhone(String phone);
	//根据id修改密码
	int updPasswordById(@Param("id")Integer id,@Param("password")String password);
}