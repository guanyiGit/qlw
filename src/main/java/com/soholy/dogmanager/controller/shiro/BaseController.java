package com.soholy.dogmanager.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;

import com.soholy.dogmanager.entity.TUsers;

@Controller
public class BaseController {
	
	 /**
     * 获取当前登录用户对象
     * @return
     */
    public TUsers getCurrentUser() {
        TUsers user = (TUsers) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
	
    /**
     * 获取当前登录用户id
     * @return
     */
    public Long getUserId() {
        return this.getCurrentUser().getUserId();
    }
    
    
    /**
     * 获取当前登录用户名
     * @return
     */
    public String getStaffName() {
        return this.getCurrentUser().getUsername();
    }
    
    /**
     * 获取当前session
     * @return
     */
    public Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
    
   /* *//**
     * @Description:获取当前登录用户所拥有的权限
     * @param:
     * @return：
     *//*
    @RequestMapping("/getpowerList")
    @ResponseBody
    public List<String> powerList(){
    	TUsers user = (TUsers) SecurityUtils.getSubject().getPrincipal();
    	UserVo userVo = userService.getUserVoByUserId(user.getUserId());
		List<TRoles> roles = userVo.getRoles();
		List<String> resources = new ArrayList<>();
		for (TRoles role : roles) {
			//根据当前角色id获取该角色所有权限url
			RoleVo privilegesByRoleId = roleService.getRoleVoByRoleId(role.getRoleId());
			List<TPrivilege> privileges = privilegesByRoleId.getPrivileges();
			for (TPrivilege tPrivilege : privileges) {
				resources.add(tPrivilege.getPrivilegekeyword());
			}
		}
		return resources;
    }*/
    
}
