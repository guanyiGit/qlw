//package com.soholy.dogmanager.shiro.realm;
//
//import org.apache.log4j.Logger;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.DisabledAccountException;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.cache.Cache;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.SimplePrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.soholy.dogmanager.entity.TUsers;
//import com.soholy.dogmanager.login.service.UserService;
//import com.soholy.dogmanager.utils.serializable.MySimpleByteSource;
//
//public class WebRealm extends AuthorizingRealm{
//	
//private static Logger logger = Logger.getLogger(AuthorizingRealm.class);
//
//@Autowired
//private UserService userService;
//
//// 授权
//@Override
//protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//	
//	return null;
//}
//
//// 认证
//@Override
//protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//	System.err.println("shiro web 认证  run...");
//	// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
//	UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//	try {
//		// 通过username查询出当前用户
//		String username = usernamePasswordToken.getUsername();
//		TUsers user = userService.getUserByUserName(username);
//		if (user == null || user.equals("")) {
//			throw new UnknownAccountException("用户名或密码错误！！"); // 用户不存在
//		} 
//		// 判断当前用户是否可用
//		if (user.getuStatus() == 1) {
//			throw new DisabledAccountException("用户已被禁用！！"); // 用户禁用
//		}
//		// 6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回.
//		// 通常使用的实现类为:SimpleAuthenticationInfo
//		// 以下信息是从数据库中获取的.
//		// 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
//		Object principal = user;
//		// 2). credentials: 密码. MD5盐值加密
//		Object credentials = user.getPassword();
//		// 3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
//		String realmName = this.getName();
//		// 4.盐值
//		MySimpleByteSource mySimpleByteSource = new MySimpleByteSource(usernamePasswordToken.getUsername());
//		//ByteSource credentialsSalt = ByteSource.Util.bytes(usernamePasswordToken.getUsername());
//		AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, mySimpleByteSource, realmName);
//		return info;
//	} catch (Exception e) {
//		System.out.println(e.getClass().getName());
//		return null;
//	}
//}
//
// /**
// * 清除所有用户的缓存
// */
//public void clearAuthorizationInfoCache() {
//    Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//    if(cache!=null) {
//        cache.clear();
//    }
//}
//
//
///**
// * 指定principalCollection 清除
// */
//public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
//	SimplePrincipalCollection principals = new SimplePrincipalCollection(
//			principalCollection, getName());
//	super.clearCachedAuthorizationInfo(principals);
//} 
//
//
//}
package com.soholy.dogmanager.shiro.realm;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.pojo.user.RoleRefResources;
import com.soholy.dogmanager.pojo.user.UserRefRoles;
import com.soholy.dogmanager.service.user.RoleService;
import com.soholy.dogmanager.service.user.UserService;
import com.soholy.dogmanager.utils.shiro.serializable.MySimpleByteSource;

public class WebRealm extends AuthorizingRealm {

	private static Logger logger = Logger.getLogger(WebRealm.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 给当前用户授权的权限（功能权限、角色）
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 1.从PrincipalCollection中获取登录信息
		TUsers user = (TUsers) principals.getPrimaryPrincipal();
		// 2.利用登录的用户信息来获取当前用户的角色和权限（需要查询数据库）
		try {
			UserRefRoles userRefRoles = userService.selectByUserId(user.getUserId());
			List<TRoles> roles = userRefRoles.getRoles();
			for (TRoles role : roles) {
				// 根据当前角色id获取该角色所有权限url
				RoleRefResources roleRefResources = roleService.selectByRoleId(role.getRoleId());
				List<TResources> resources = roleRefResources.getResources();
				for (TResources resource : resources) {
					authorizationInfo.addStringPermission(resource.getKeyword());
				}
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return authorizationInfo;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("shiro web 认证  run...");
		// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		// 通过username查询出当前用户
		String username = usernamePasswordToken.getUsername();
		TUsers user = userService.getUserByUserName(username);
		// 6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回.
		// 通常使用的实现类为:SimpleAuthenticationInfo
		// 以下信息是从数据库中获取的.
		// 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
		if (user == null || user.equals("")){
			throw new UnknownAccountException();
		}
		//0禁用，1启用
		if (user.getuStatus() == 0){
			throw new DisabledAccountException();
		}
		Object principal = user;
		// 2). credentials: 密码. MD5盐值加密
		Object credentials = user.getPassword();
		// 3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = this.getName();
		// 4.盐值
		MySimpleByteSource mySimpleByteSource = new MySimpleByteSource(usernamePasswordToken.getUsername());

		AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, mySimpleByteSource, realmName);

		return info;
	}

	 /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
    
    
    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
