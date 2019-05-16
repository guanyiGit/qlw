package com.soholy.dogmanager.service.servicesite;

import java.util.Date;
import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.pojo.servicesite.ServiceSite;

/**
 * @ClassName: ServiceSiteService
 * @Description: 网点服务
 * @author py
 * @date 2018年8月23日
 *
 */
public interface ServiceSiteService {

	/**
	 * 
	* @Description:添加服务网点申请(status = 0,org_type = 2)
	* @param organization
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	DogResult addServiceSite(TOrganization organization,List<TPetHospital> petHospitals) throws Exception;

	/**
	 *
	 * @Description:添加服务网点申请(status = 0,org_type = 2)
	 * @param organization
	 * @return
	 * @throws Exception（展示方法参数和返回值）
	 */
	DogResult addServiceSite1(TOrganization organization,List<TPetHospital> petHospitals) throws Exception;
	/**
	 * 
	* @Description:服务网点申请成功(status = 1,org_type = 2)
	* @param organizationId
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	DogResult updateServiceSiteForYes(Integer organizationId,Integer power,Date approvalTime) throws Exception;

	/**
	 * 
	* @Description:服务网点申请失败(status = 2,org_type = 2)
	* @param organizationId
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	DogResult updateServiceSiteForNo(Integer organizationId,String failreason,Date approvalTime) throws Exception;

	/**
	* @Description:删除服务网点
	* @param organizationId
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	DogResult deleteServiceSite(Integer organizationId) throws Exception;

	/**
	 * @Description:根据区域id查询出所有服务网点(默认查询宠物医院)
	 * @param provinceId
	 *            所属省份id
	 * @param ownedCityId
	 *            所属城市id
	 * @param districtId
	 *            所属区域id
	 * @param orgtype
	 *            机构类型
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception（展示方法参数和返回值）
	 */
	List<ServiceSite> selectServiceSite(Integer provinceId, Integer ownedCityId, Integer districtId, Integer orgtype,
			Integer pageNum, Integer pageSize,Double ALon, Double ALat,Integer status,Integer power,String searchKey,Integer tType) throws Exception;

	/**
	* @Description:根据服务网点id查询服务网点
	* @param organizationId
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	ServiceSite selectServiceSite(Integer organizationId) throws Exception;
	
	/**
	* @Description:根据犬主当前位置查询附近所有网点(距离自定)
	* @param ALon
	* @param ALat
	* @return
	* @throws Exception（展示方法参数和返回值）
	 */
	List<ServiceSite> SelectNearServiceSite(Double ALon, Double ALat)throws Exception;
	
	//查询机构列表
    List<TOrganization> selectOrganizationList(Integer orgType);

	/**
	 * 更改服务网点
	 * @param site
	 * @return
	 */
	int updateSite(ServiceSite site);

}
