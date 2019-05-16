package com.soholy.dogmanager.controller.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.entity.TUsers;
import com.soholy.dogmanager.pojo.user.RoleRefResources;
import com.soholy.dogmanager.pojo.user.Tree;
import com.soholy.dogmanager.pojo.user.UserRefRoles;
import com.soholy.dogmanager.service.user.ResourceService;
import com.soholy.dogmanager.service.user.RoleService;
import com.soholy.dogmanager.service.user.UserService;

@Controller
@RequestMapping("/biz/resource")
public class ResourcesController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(ResourcesController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	* @Description:根据当前登录用户获取其对应角色
	* @return（展示方法参数和返回值）
	 */
	//@RequiresPermissions("/resource/getResources")
	@RequestMapping(value="/getResources")
	@ResponseBody
	public DogResult getResources(){
		try {
			TUsers user = getCurrentUser();
			UserRefRoles userRefRoles = userService.selectByUserId(user.getUserId());
			List<TRoles> roles = userRefRoles.getRoles();
			List<TResources> resources = null;
			for (TRoles tRoles : roles) {
				RoleRefResources roleRefResources = roleService.selectByRoleId(tRoles.getRoleId());
				resources = roleRefResources.getResources();
			}
			return DogResult.ok(resources);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
	
	/**
	* @Description:获取权限树
	* @param roleId
	* @return（展示方法参数和返回值）
	 */
	//@RequiresPermissions("/resource/resourcesTree")
	@RequestMapping(value="/resourcesTree",method=RequestMethod.POST)
	@ResponseBody
    public DogResult resourcesTree(Integer roleId){
    	try {
        	//获取资源树
        	List<Tree> selectResourcesTree = resourceService.selectResourcesTree();
        	if (selectResourcesTree == null) {
    			throw new Exception();
    		}
        	//获取角色资源id集合
        	List<Integer> resourcesId = roleService.selectResourcesIdsByRoleId(roleId);
        	if (resourcesId == null) {
    			throw new Exception();
    		}
        	Map<String, Object> data = new HashMap<>();
        	data.put("selectResourcesTree", selectResourcesTree);
        	data.put("resourcesId", resourcesId);
        	return DogResult.ok(data);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
    }
	
	
	
	/**
     * 添加资源
     * @param resource
     * @return
     */
    //@RequiresPermissions("/resource/add")
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    @ResponseBody
	public DogResult add(TResources resources){
		return resourceService.addResource(resources);
	}
	
    /**
     * 根据resourcesId查询resources
     * @param resourcesId
     * @return
     */
    //@RequiresPermissions("/resource/selectResources")
    @RequestMapping(value = "/selectResources",method=RequestMethod.POST)
    @ResponseBody
    public DogResult selectResources(Integer  resourcesId){
    	try {
    		TResources resources = resourceService.selectResourceByResourceId(resourcesId);
    		if (resources == null) {
				throw new Exception();
			}
    		return DogResult.ok(resources);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常，请稍后处理！！！");
		}
	}
    
    /**
    * @Description:编辑资源
    * @param resources
    * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/resource/updateResources")
    @RequestMapping(value = "/updateResources",method=RequestMethod.POST)
    @ResponseBody
    public DogResult updateResources(TResources resources){
    	return resourceService.updateResource(resources);
    }
    
    /**
    * @Description:删除资源
    * @param resourcesId
    * @return（展示方法参数和返回值）
     */
    //@RequiresPermissions("/resource/deleteResources")
    @RequestMapping(value = "/deleteResources",method=RequestMethod.POST)
    @ResponseBody
    public DogResult deleteResources(Integer resourcesId){
    	return resourceService.deleteResourceById(resourcesId);
    }
    
}
