package com.soholy.dogmanager.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.controller.shiro.RoleController;
import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.entity.TRoleRefResources;
import com.soholy.dogmanager.entity.TRoleRefResourcesExample;
import com.soholy.dogmanager.entity.TRoleRefResourcesExample.Criteria;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.mapper.TResourcesMapper;
import com.soholy.dogmanager.mapper.TRoleRefResourcesMapper;
import com.soholy.dogmanager.mapper.TRolesMapper;
import com.soholy.dogmanager.mapper.TUserRefRolesMapper;
import com.soholy.dogmanager.mapper.user.RoleRefResourcesMapper;
import com.soholy.dogmanager.pojo.user.RoleRefResources;
import com.soholy.dogmanager.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private TRolesMapper rolesMapper;

	@Autowired
	private TUserRefRolesMapper userRefRolesMapper;

	@Autowired
	private TRoleRefResourcesMapper tRoleRefResourcesMapper;

	@Autowired
	private RoleRefResourcesMapper roleRefResourcesMapper;
	
	@Autowired
	private TResourcesMapper resourceMapper;
	
	@Autowired
	private TRoleRefResourcesMapper refMapper;

	@Override
	public DogResult addRole(TRoles role) {
		role.setCreationTime(new Date());
		try {
			int count = rolesMapper.insertRole(role);
			return DogResult.ok(count);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常！！！");
		}
	}

	@Override
	public DogResult deleteRoleById(Integer roleId) {
		try {
			// 根据roleId删除role
			int count = rolesMapper.deleteByRoleId(roleId);
			// 根据roleId删除userRefRoles
			int count1 = userRefRolesMapper.deleteUserRefRoleByRoleId(roleId);
			// 根据roleId删除userRefRoles
			int count2 = tRoleRefResourcesMapper.deleteRoleRefResourcesByRoleId(roleId);
			if (count > 0 && count1 > 0 && count2 > 2) {
				return DogResult.ok();
			}
			return DogResult.build(400, "服务器异常！！！");
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常！！！");
		}

	}

	@Override
	public List<TRoles> selectRolesByStatus(String query) {
		return this.selectRolesByStatus(1,query);
	}

	@Override
	public List<TRoles> selectRolesByStatus(Integer status,String query) {
		try {
			List<TRoles> list = rolesMapper.selectRolesByStatus(status,query);
			return list;
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	@Override
	public DogResult updateRole(TRoles role) {
		try {
			int count = rolesMapper.updateRole(role);
			return DogResult.ok(count);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DogResult addRoleRefResources(List<TRoleRefResources> roleRefResources) {
		for (TRoleRefResources tRoleRefResources : roleRefResources) {
			tRoleRefResources.setCreationTime(new Date());
		}
		try {
			int count = tRoleRefResourcesMapper.addRoleRefResources(roleRefResources);
			return DogResult.ok(count);
		} catch (Exception e) {
			return null;
		}
	}

	/** 授权更新 */
	@Override
	public DogResult updateRoleRefResources(Integer roleId, String resourceIds) {
		try {
			// 先删除原来关系，再添加
			List<TRoleRefResources> roleRefResourcesList = tRoleRefResourcesMapper.selectByRoleId(roleId);
			if (roleRefResourcesList != null && roleRefResourcesList.size() > 0) {
				tRoleRefResourcesMapper.deleteRoleRefResources(roleRefResourcesList);
			}
			List<TRoleRefResources> list = new ArrayList<TRoleRefResources>();
			String[] resourceId = resourceIds.split(",");
			for (String string : resourceId) {
				TRoleRefResources roleRefResources = new TRoleRefResources();
				roleRefResources.setRoleId(roleId);
				roleRefResources.setResourcesId(Integer.parseInt(string));
				roleRefResources.setCreationTime(new Date());
				list.add(roleRefResources);
			}
			int count = tRoleRefResourcesMapper.addRoleRefResources(list);
			return DogResult.ok(count);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常！！！");
		}
	}

	@Override
	public RoleRefResources selectByRoleId(Integer roleId) {
		try {
			RoleRefResources roleRefResources = roleRefResourcesMapper.roleRefResources(roleId);
			return roleRefResources;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Integer> selectResourcesIdsByRoleId(Integer roleId) {
		try {
			List<Integer> resourceIds = rolesMapper.selectResourcesIdsByRoleId(roleId);
			return resourceIds;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public HashMap<String, Object> findResourceMap(Integer roleId) {
		HashMap<String, Object>map=Maps.newHashMap();
		//1.查找所有资源信息
	List<TResources> resourceAll = resourceMapper.selectByExample(null);
		
	//2.根据角色id查找所属资源信息
	TRoleRefResourcesExample example=new TRoleRefResourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<TRoleRefResources> selectByExample = refMapper.selectByExample(example);
		map.put("resourceAll", resourceAll);
	map.put("roleResource", selectByExample);
	return map;
	}

	@Override
	public void assignResources(Integer roleId, Integer[] resourceIds) {
		//根据角色id删除相应的权限信息
		refMapper.deleteRoleRefResourcesByRoleId(roleId);
		//循环遍历插入
		for(Integer resourceId : resourceIds){
			TRoleRefResources record=new TRoleRefResources();
					record.setCreationTime(new Date());
					record.setRoleId(roleId);
					record.setResourcesId(resourceId);
			refMapper.insertSelective(record);
		}
		
	}

	@Override
	public List<TRoles> findRoleAll() {
		return rolesMapper.selectByExample(null);
	}
	
}
