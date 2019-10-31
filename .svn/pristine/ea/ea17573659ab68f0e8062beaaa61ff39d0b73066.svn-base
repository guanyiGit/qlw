package com.soholy.dogmanager.service.user;

import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.pojo.user.Tree;

public interface ResourceService {

	/**
	 * 
	 * @Description:默认查询状态为启用的资源
	 * @return（展示方法参数和返回值）
	 */
	List<TResources> selectResourceByStatus();

	/**
	 * @Description:根据资源状态查询资源
	 * @param status
	 * @return（展示方法参数和返回值）
	 */
	List<TResources> selectResourceByStatus(Integer status);

	/**
	 * @Description: 查询所有树(需做递归处理)
	 * @author: PY
	 * @param: @return：
	 */
	List<Tree> selectResourcesTree();

	/**
	 * @Description:根据resourceId查询资源
	 * @param resourceId
	 * @return（展示方法参数和返回值）
	 */
	TResources selectResourceByResourceId(Integer resourcesId);

	/**
	 * @Description:更新资源内容
	 * @param resourceId
	 * @return（展示方法参数和返回值）
	 */
	DogResult updateResource(TResources resources);

	/**
	 * @Description:删除资源
	 * @param resourceId
	 * @return（展示方法参数和返回值）
	 */
	DogResult deleteResourceById(Integer resourcesId);
	
	/**
	* @Description:添加资源
	* @param resources
	* @return（展示方法参数和返回值）
	 */
	DogResult addResource(TResources resources);
	
}
