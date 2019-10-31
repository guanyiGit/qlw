package com.soholy.dogmanager.mapper.serviceSite;

import com.soholy.dogmanager.pojo.servicesite.ServiceSite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceSiteMapper {

	// 条件查询服务网点(分页)
	List<ServiceSite> selectServiceSite(@Param("provinceId") Integer provinceId,
										@Param("ownedCityId") Integer ownedCityId, @Param("districtId") Integer districtId, @Param("status") Integer status,
										@Param("orgtype") Integer orgtype, @Param("power") Integer power,@Param("searchKey") String searchKey,@Param("tType") Integer tType);

	// 根据站点id查询站点
	ServiceSite selectServiceSiteById(Integer organizationId);


	/**
	 * 查询最近的服务网点信息
	 * @param lat
	 * @param lng
	 * @param provinceId
	 * @param ownedCityId
	 * @param districtId
	 * @param status
	 * @param orgtype
	 * @param power
	 * @param searchKey
	 * @return
	 */
	List<ServiceSite> selectServiceSiteByDistance(@Param("lat") double lat,
												  @Param("lng") double lng,
												  @Param("provinceId") Integer provinceId,
												  @Param("ownedCityId") Integer ownedCityId,
												  @Param("districtId") Integer districtId,
												  @Param("status") Integer status,
												  @Param("orgtype") Integer orgtype,
												  @Param("power") Integer power,
												  @Param("searchKey") String searchKey);

	/**
	 * 更改服务网点
	 * @param site
	 * @return
	 */
	int updateSite(ServiceSite site);


}
