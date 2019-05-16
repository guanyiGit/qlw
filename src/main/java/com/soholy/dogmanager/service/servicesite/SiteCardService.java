package com.soholy.dogmanager.service.servicesite;

import java.rmi.ServerException;
import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.pojo.servicesite.ServiceSiteCard;

public interface SiteCardService {
	
		
	/**
	* @Description: 批量添加证书信息
	* @Title: addSiteCard  
	* @param @param petHospitals
	* @param @return
	* @param @throws Exception    
	* @return int     
	* @throws
	 */
	DogResult addSiteCard(TPetHospital petHospital)throws Exception;
	
	/**
	* @Description: 根据服务站点id查询站点申请材料证书
	* @Title: selectSiteCard  
	* @param @param organizationId
	* @param @return
	* @param @throws Exception    
	* @return List<TPetHospital>     
	* @throws
	 */
	List<ServiceSiteCard> selectSiteCard(Integer organizationId)throws Exception;


	List<TPetHospital> selectPetHCardIds(Integer organizationId) throws ServerException;
}
