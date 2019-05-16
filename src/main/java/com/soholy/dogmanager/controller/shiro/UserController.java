package com.soholy.dogmanager.controller.shiro;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.entity.TUserRefRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.entity.user.EditRoleAndOrg;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/biz/user")
public class UserController {

    @Value("${pageSize}")
    private String pageSize;

    @Autowired
    private UserService userService;

    /**
     * @return
     * @Description:用户列表
     */
    @RequiresPermissions("/user/list") // 添加权限控制
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DogResult selectUsers(Integer pageNum, Integer pageSize, Integer status, String query) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
//            if (query != null) {getServiceSitesforAdmin
//                query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
//            }
            List<UserVo> selectUserVo = null;
            if (pageSize == null) {
                pageSize = Integer.parseInt(this.pageSize);
            }
            Page page = PageHelper.startPage(pageNum, pageSize);
            if (status != null) {
                selectUserVo = userService.selectUserVo(status, query);
            } else {
                selectUserVo = userService.selectUserVo(query);
            }
            PageInfo<UserVo> pageInfo = new PageInfo<>(selectUserVo);
            pageInfo.setTotal(page.getTotal());
            return DogResult.ok(pageInfo);
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param user    user对象
     * @param roleIds 角色id (多个角色id用“,”隔开) @return（展示方法参数和返回值）
     * @Description:添加用户
     */
    @RequiresPermissions("/user/add") // 添加权限控制
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DogResult addUser(UserVo userVo) {
        try {
            if (StringUtils.isBlank(userVo.getPhone())) {
                return DogResult.build(400, "电话不能为空");
            }
            if (StringUtils.isBlank(userVo.getEmail())) {
                return DogResult.build(400, "邮箱不能为空");
            }
            DogResult dogResult = userService.addUser(userVo);
            return dogResult;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * 修改用户信息
     * @param tUserss
     * @return
     */
    @RequestMapping(value = "/edits",method = RequestMethod.PUT)
    @ResponseBody
    public String edits(@RequestBody List<TUsers> tUserss){
        return new GlobalResult().boolResultJSON(userService.editByIds(tUserss));
    }


    @RequiresPermissions("/user/assignRole") // 添加权限控制
    @RequestMapping(value = "/assignRole", method = RequestMethod.POST)
    @ResponseBody
    public DogResult assignRole(@RequestBody List<TUserRefRoles> list) {
        try {
            DogResult dogResult = userService.assignRole(list);
            return DogResult.ok();
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常，请稍后处理！！！");
        }
    }

    /**
     * @param user
     * @param roleIds
     * @Description:用户编辑
     * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/user/update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DogResult updateUser(TUsers user, String roleIds) {
        return userService.updateUser(user, roleIds);
    }

    /**
     * @param userId
     * @Description:删除用户
     * @return（展示方法参数和返回值）
     */
    @RequiresPermissions("/user/delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public DogResult deleteUser(Long userId) {
        return userService.deleteUser(userId);
    }


    /**
     * @param userIds
     * @Description:删除用户 批量
     * @return（展示方法参数和返回值）
     */
    @RequiresPermissions("/user/deletes")
    @RequestMapping(value = "/deletes", method = RequestMethod.POST)
    @ResponseBody
    public DogResult deleteUser(@RequestParam("userIds") List<Long> userIds) {

        try {
            userIds.stream()
                    .forEach(x -> userService.deleteUser(x));
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
        return DogResult.ok();
    }

    /**
     * 重置密码
     */
    //@RequiresPermissions("/user/resetPassword")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public DogResult resetPassword(Long userId) {
        DogResult resetPassWord = userService.resetPassWord(userId);
        //清空之前缓存的AuthenticationInfo
        return resetPassWord;
    }

    /**
     * 更改密码
     */
    //@RequiresPermissions("/user/updatePwd")
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public DogResult updatePwd(Long userId, String oldPwd, String newPwd) {
        return userService.updateUserPassword(userId, oldPwd, newPwd);
    }

    /**
     * 找回密码
     */
    //@RequiresPermissions("/user/retrievePwd")
    @RequestMapping(value = "/retrievePwd/{username}/{newPassword}")
    @ResponseBody
    public DogResult retrievePwd(@PathVariable("username")String username,@PathVariable("newPassword")String newPassword){
        DogResult dogResult = userService.retrievePwd(username, newPassword);
        return dogResult;
    }


    /**
     * 修改用户状态
     */
    @RequiresPermissions("/user/updateStatus")
    @RequestMapping("/updateStatus")
    @ResponseBody
    public DogResult updateStatus(Long userId, Integer status) {
        return userService.updataStatus(userId, status);
    }


    /**
     * 修改用户状态  批量
     *
     * @param userIds
     * @param status
     * @return
     */
    @RequiresPermissions("/user/updateStatuss")
    @RequestMapping("/updateStatuss")
    @ResponseBody
    public DogResult updateStatus(@RequestParam("userIds") List<Long> userIds, Integer status) {
        try {
            userIds.stream().forEach(x -> userService.updataStatus(x, status));
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }
        return DogResult.ok();
    }

    @RequiresPermissions("/user/editRoleAndOrg")
    @RequestMapping("/editRoleAndOrg")
    @ResponseBody
    public DogResult editRoleAndOrg(@RequestBody EditRoleAndOrg editRoleAndOrg) {
        try {
            DogResult dogResult = userService.editRoleAndOrg(editRoleAndOrg);
            return dogResult;
        } catch (Exception e) {
            return DogResult.build(400, "服务器异常！！！");
        }

    }

//    @RequiresPermissions("/user/selectUserByUserName")
    @RequestMapping("/selectUserByUserName/{username}")
    @ResponseBody
    public DogResult selectUserByUserName(@PathVariable("username") String username){
        try {
            TUsers userByUserName = userService.getUserByUserName(username);
            if (userByUserName == null || userByUserName.equals("")){
                return DogResult.build(401,"用户名不存在！");
            }
            return DogResult.ok(userByUserName);
        } catch (Exception e) {
            return DogResult.build(400,"服务器异常,请稍后再试");
        }
    }


}
