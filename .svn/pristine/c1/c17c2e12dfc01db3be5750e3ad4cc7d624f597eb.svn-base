package com.soholy.dogmanager.controller.shiro;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.pojo.user.UserVo;
import com.soholy.dogmanager.service.user.RoleService;

@Controller
@RequestMapping("/biz/role")
public class RoleController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Value("${pageSize}")
	private String pageSize;

	@Autowired
	private RoleService roleService;
	
	/**
	 * 列表
	 */
	@RequiresPermissions("/role/list") 
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public DogResult seletcRoles(Integer pageNum, Integer status,String query) {
		try {
			if (pageNum == null) {
				pageNum = 1;
			}
			if (query != null) {
//				query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
			}
			List<TRoles> roles = null;
			Page page = PageHelper.startPage(pageNum, Integer.parseInt(pageSize));
			if (status == null) {
				roles = roleService.selectRolesByStatus(query);
			} else {
				roles = roleService.selectRolesByStatus(status,query);
			}
			PageInfo<TRoles> pageInfo = new PageInfo<>(roles);
			pageInfo.setTotal(page.getTotal());
			return DogResult.ok(pageInfo);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}


	/**
	 * 添加
	 */
	//@RequiresPermissions("/role/add")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public DogResult add(@RequestBody TRoles role) {
		return roleService.addRole(role);
	}
	
	/**
	 * 删除 
	 */
	//@RequiresPermissions("/role/delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DogResult delete(Integer roleId) {
		return roleService.deleteRoleById(roleId);
	}
	
	/**
     * 编辑
     */ 
	//@RequiresPermissions("/role/update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public DogResult update(TRoles role) {
		return roleService.updateRole(role);
	}
	
	/**
     * 编辑
     */ 
	@RequiresPermissions("/role/getResourceIds")
	@RequestMapping(value = "/getResourceIds", method = RequestMethod.POST)
	@ResponseBody
	public DogResult selectResourcesIdsByRoleId(Integer roleId){
		try {
			List<Integer> resourcesIds = roleService.selectResourcesIdsByRoleId(roleId);
			return DogResult.ok(resourcesIds);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
	/**
     * 授权
     */
	//@RequiresPermissions("/role/grant")
	@RequestMapping(value = "/grant", method = RequestMethod.POST)
	@ResponseBody
	public DogResult grant(Integer roleId, String resourceIds) {
		return roleService.updateRoleRefResources(roleId, resourceIds);
	}
	
	//#############################################################################################
	/**
	 *@Description 查询所有资源信息，展现在前端。根据角色id查找相应资源信息做到页面回显
	 *@author ZhongZhong
	 *@param Role role
	 *@return resourceList
	 *
	 */
	@RequestMapping("/viewResources")
	public @ResponseBody HashMap<String, Object> viewResources(Integer roleId) {
		
		HashMap<String, Object>map=null;
			if(StringUtils.isEmpty(roleId)){
				logger.warn("传入的roleId对象不能为空");
			}
						
				try {
					map=roleService.findResourceMap(roleId);
				} catch (Exception e) {
					logger.warn("查询权限失败",e);
				}
				 
		return map;
	}
	
	
	/**
	 *@Description 为角色分配权限
	 *@author ZhongZhong
	 *@param Role role 包括 选中的角色id Long roleId,
	 *					获取选中的资源id数组 Long[] resourceIds
	 *@return 
	 */
	@RequestMapping("/assignResources")
	@ResponseBody
	public Result assignResources(Integer[] resourceIds,Integer roleId) {
		logger.info("开始执行assignResources方法");
		Result result=new Result();
		 if(StringUtils.isEmpty(roleId)||StringUtils.isEmpty(resourceIds)){
			logger.error("role对象中的id或者ids不能为空");
		}else{
			try {
				roleService.assignResources(roleId,resourceIds);
				result.setSuccess(true);
				result.setMsg("分配权限成功");
			} catch (Exception e) {
				logger.error("分配权限失败",e);
				result.setMsg(e.getMessage());
			}
		}
		return result;
	}
	
	
	/**
	 *@Description 角色列表
	 *@author ZhongZhong
	 *@param 
	 *	
	 *@return 
	 */
	@RequestMapping("/findRoleAll")
	@ResponseBody
	public Result findRoleAll() {
		Result result=new Result();
			try {
				List<TRoles>roleList=roleService.findRoleAll();
				result.setObj(roleList);
				result.setSuccess(true);
			} catch (Exception e) {
				result.setMsg(e.getMessage());
			}
		return result;
	}
	
}
