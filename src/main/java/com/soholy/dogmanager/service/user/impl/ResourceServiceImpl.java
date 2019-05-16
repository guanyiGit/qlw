package com.soholy.dogmanager.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.mapper.TResourcesMapper;
import com.soholy.dogmanager.mapper.TRoleRefResourcesMapper;
import com.soholy.dogmanager.pojo.user.Tree;
import com.soholy.dogmanager.service.user.ResourceService;
import com.soholy.dogmanager.utils.user.BuildTree;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private TResourcesMapper resourcesMapper;

	@Autowired
	private TRoleRefResourcesMapper roleRefResourcesMapper;

	@Override
	public List<TResources> selectResourceByStatus() {
		return this.selectResourceByStatus(1);
	}

	@Override
	public List<TResources> selectResourceByStatus(Integer status) {
		try {
			List<TResources> list = resourcesMapper.selectResourceByStatus(status);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取所有树
	 */
	@Override
	public List<Tree> selectResourcesTree() {
		try {
			List<TResources> resources = this.selectResourceByStatus();
			List<Tree> treeAll = new ArrayList<>();
			for (TResources resource : resources) {
				Tree tree = BuildTree.buildTree(resource);
				treeAll.add(tree);
			}
			// 获取一级父节点
			List<Tree> firstParentTree = new ArrayList<>();
			for (Tree tree : treeAll) {
				if (tree.getPid() == 0) {
					firstParentTree.add(tree);
				}
			}
			List<Tree> treeChild = BuildTree.getTreeChilds(firstParentTree, treeAll);
			return treeChild;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TResources selectResourceByResourceId(Integer resourceId) {
		try {
			TResources resources = resourcesMapper.selectResourceByResourceId(resourceId);
			return resources;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DogResult updateResource(TResources resources) {
		try {
			Integer count = resourcesMapper.updateResource(resources);
			return DogResult.ok(count);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DogResult deleteResourceById(Integer resourcesId) {
		try {
			// 删除资源
			int count = resourcesMapper.deleteResourceById(resourcesId);
			// 删除资源与角色关联关系
			int count1 = roleRefResourcesMapper.deleteRoleRefResourcesByResourcesId(resourcesId);
			if (count > 0 && count1 > 0) {
				return DogResult.ok();
			}
			return DogResult.build(400, "服务器异常！！！");
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常！！！");
		}
	}
	
	@Override
	public DogResult addResource(TResources resources) {
		try {
			int count = resourcesMapper.insertSelective(resources);
			return DogResult.ok(count);
		} catch (Exception e) {
			return DogResult.build(400, "服务器异常！！！");
		}
		
	}
	
	

}
