package com.soholy.dogmanager.service.user;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TUserRefRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.entity.user.EditRoleAndOrg;
import com.soholy.dogmanager.pojo.user.UserInfo;
import com.soholy.dogmanager.pojo.user.UserRefRoles;
import com.soholy.dogmanager.pojo.user.UserVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    /**
     * @param phone
     * @return
     * @Description:检查电话是否可用
     * @（展示方法参数和返回值）
     */
    DogResult checkPhone(String phone);


    DogResult checkUserName(String username);

    /**
     * @param email
     * @return
     * @Description:检查email是否存在
     * @（展示方法参数和返回值）
     */
    DogResult checkEmail(String email);

    /**
     * 添加用户(包含角色)
     *
     * @param @param  user
     * @param @return
     * @param @
     * @return DogResult
     * @throws
     * @Title: addUser
     */

    DogResult addUser(UserVo userVo);

    /**
     * 第三方登陆添加用户
     * @param userVo
     * @return
     */
    DogResult thirdAddUser(UserVo userVo);



    void saveUser(UserVo userVo);


    /**
     * @param userId
     * @param roleIds
     * @Description:为用户分配角色
     * @return（展示方法参数和返回值）
     */
    DogResult assignRole(List<TUserRefRoles> list);


    /**
     * @return
     * @Description:查询所有用户(默认查询状态为1 = 正常用户)
     * @（展示方法参数和返回值）
     */
    List<TUsers> selectUsers();

    /**
     * @param status
     * @return
     * @Description:根据status查询用户
     * @（展示方法参数和返回值）
     */
    List<TUsers> selectUsersByStatus(Integer status);

    /**
     * @param type
     * @return
     * @Description:根据orgtype查询用户
     * @（展示方法参数和返回值）
     */
    List<TUsers> selectUsersByOrgType(Integer type);

    /**
     * 根据主键查询user
     *
     * @param userId
     * @param
     * @param Exception
     * @return DogResult
     * @throws
     * @Title: getUserById
     */
    TUsers getUserById(Long userId);

    /**
     * @param userId
     * @Description:获取userInfo信息
     * @return（展示方法参数和返回值）
     */
    UserInfo getUserInfo(Long userId) throws Exception;

    /**
     * 根据username获取user
     *
     * @param @param  username
     * @param @return
     * @param @
     * @return TUsers
     * @throws
     * @Title: getUserByUserName
     */
    TUsers getUserByUserName(String username);


    /**
     * @param userId
     * @Description:重置密码
     * @return（展示方法参数和返回值）
     */
    DogResult resetPassWord(Long userId);

    /**
     * 修改密码
     *
     * @param @param  userId
     * @param @param  oldPassword
     * @param @param  newPassword
     * @param @return
     * @param @
     * @return DogResult
     * @throws
     * @Title: updateUserPassword
     */
    DogResult updateUserPassword(Long userId, String oldPassword, String newPassword);

    /**
     * 编辑用户信息
     *
     * @param @param  user
     * @param @return
     * @param @
     * @return DogResult
     * @throws
     * @Title: updateUser
     */
    DogResult updateUser(TUsers user, String roleIds);


    /**
     * 更改登录次数
     *
     * @param @return
     * @param @
     * @return DogResult
     * @throws
     * @Title: updateLoginNum
     */
    DogResult updateLoginNum(Long userId);

    /**
     * 删除用户
     *
     * @param @param  userId
     * @param @return
     * @param @
     * @return DogResult
     * @throws
     * @Title: deleteUser
     */
    DogResult deleteUser(Long userId);


    /**
     * @param userId
     * @return
     * @Description:根据userid查询角色信息
     * @（展示方法参数和返回值）
     */
    UserRefRoles selectByUserId(Long userId);

    /**
     * @Description:查询角色列表(默认status=1)
     * @return（展示方法参数和返回值）
     */
    List<UserRefRoles> selectUserRefRoles();

    /**
     * @Description:查询角色列表
     * @return（展示方法参数和返回值）
     */
    List<UserRefRoles> selectUserRefRoles(Integer status);


    /**
     * @param status
     * @Description:根据状态查询用户信息(默认查询启用状态的用户(status = 1))
     * @return（展示方法参数和返回值）
     */
    List<UserVo> selectUserVo(String query);

    /**
     * @param status
     * @Description:根据状态查询用户信息
     * @return（展示方法参数和返回值）
     */
    List<UserVo> selectUserVo(Integer status, String query);

    /**
     * @param userId
     * @param status
     * @Description:修改用户状态
     * @return（展示方法参数和返回值）
     */
    DogResult updataStatus(Long userId, Integer status);

    /**
     * 修改用戶登陸后的登陸信息
     *
     * @param user 用戶信息  用戶id不能爲空不能爲空
     * @return
     */
    boolean modifyUserLoginInfoById(TUsers user);

    /**
     * 修改用户信息
     * @param tUserss
     * @return
     */
    boolean editByIds(List<TUsers> tUserss);


    DogResult updatePhone(Long userId,String phone);


    DogResult editRoleAndOrg(EditRoleAndOrg editRoleAndOrg);

    DogResult retrievePwd(String username,String newPassword);


}

