package com.soholy.dogmanager.service.servicesite.impl;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jsqlparser.schema.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.entity.TPetHospital;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import com.soholy.dogmanager.mapper.TPetHospitalMapper;
import com.soholy.dogmanager.mapper.serviceSite.TypeRefImagesMapper;
import com.soholy.dogmanager.pojo.servicesite.ServiceSiteCard;
import com.soholy.dogmanager.pojo.servicesite.TypeRefImages;
import com.soholy.dogmanager.service.servicesite.SiteCardService;

@Service
public class SiteCardServiceImpl implements SiteCardService{
	
	private static Logger logger = LoggerFactory.getLogger(SiteCardServiceImpl.class);
	
	@Autowired
	private TPetHospitalMapper tPetHospitalMapper;
	
	@Autowired
	private TDictionaryMapper  dictionaryMapper;
	
	@Autowired
	private TypeRefImagesMapper typeRefImagesMapper;
	
	
	@Override
	public DogResult addSiteCard(TPetHospital petHospital) throws Exception {
		try {
			tPetHospitalMapper.addPetHospital(petHospital);
			return DogResult.ok(petHospital.getPetHCardId());
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！！");
		}
	}
	
	@Override
	public List<ServiceSiteCard> selectSiteCard(Integer organizationId) throws Exception {
		List<ServiceSiteCard> serviceSiteCards = new ArrayList<>();
		try {
			//获取服务站点所有申请材料证书
			List<TPetHospital> tPetHospitals = tPetHospitalMapper.selectTPetHospital(organizationId);
			for (TPetHospital tPetHospital : tPetHospitals) {
				ServiceSiteCard serviceSiteCard = new ServiceSiteCard();
				//查询证书关联图片(picture_type == 5)
				
			 	//获取ServiceSiteCard(对应类型5)对应的图片
				List<TypeRefImages> images = typeRefImagesMapper.selectImagesByTypeAndId(8,
						Integer.valueOf(tPetHospital.getPetHCardId()).longValue());
				serviceSiteCard.setImages(images);
				//通过字典表查询证书类型
				List<TDictionary> petHospitalType = dictionaryMapper.selectPetHospital(tPetHospital.getPetHCardType());
				serviceSiteCard.setPetHCardId(tPetHospital.getPetHCardId());
				serviceSiteCard.setOrganizationId(tPetHospital.getOrganizationId());
				serviceSiteCard.setCardType(tPetHospital.getPetHCardType());
				serviceSiteCard.setCardTypeName(petHospitalType.get(0).getDictionaryDescribe());
				serviceSiteCard.setPetHCardNum(tPetHospital.getPetHCardNum());
				serviceSiteCard.setStartTime(tPetHospital.getStartTime());
				serviceSiteCard.setEndTime(tPetHospital.getEndTime());
				serviceSiteCard.setCreationTime(tPetHospital.getCreationTime());
				serviceSiteCards.add(serviceSiteCard);
			}
			return serviceSiteCards;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public List<TPetHospital> selectPetHCardIds(Integer organizationId) throws ServerException {
		List<TPetHospital> list = null;
		try {
			list=tPetHospitalMapper.selectPetHCardIds(organizationId);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			String log="查询网点证书id失败！";
			throw new ServerException(log,e);
		}
		return list;
	}
}
