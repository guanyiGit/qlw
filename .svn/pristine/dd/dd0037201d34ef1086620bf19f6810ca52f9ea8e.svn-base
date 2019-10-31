package com.soholy.dogmanager.service.information.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.entity.notice.InforMationDetail;
import com.soholy.dogmanager.mapper.*;
import com.soholy.dogmanager.pojo.Information.Information;
import com.soholy.dogmanager.service.information.InformationService;
import com.soholy.dogmanager.service.notice.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService{

	private static Logger logger = LoggerFactory.getLogger(InformationServiceImpl.class);

	@Autowired
	private TInformationMapper informationMapper;

	@Autowired
	private TDictionaryMapper dictionaryMapper;

	@Autowired
	private TUsersMapper usersMapper;

	@Autowired
	private TImagesRefMapper imagesRefMapper;

	@Autowired
	private TImagesMapper imagesMapper;

	@Autowired
	private NoticeService noticeService;

	@Override
	public DogResult addInformation(TInformation information,List<Long> imageIds) {
		try {
			//补齐information对象
			information.setUpdateTime(new Date());
			information.setCreationTime(new Date());
			//添加informaion
			informationMapper.addInformation(information);
//			if(imageIds !=null){
//				for (Long imageId : imageIds) {
//					TImagesRef imagesRef = new TImagesRef();
//					imagesRef.setImageId(imageId);
//					imagesRef.setRefId(information.getInformationId());
//					//推送信息图片
//					imagesRef.setTargetType(0);
//					imagesRef.setCreationTime(new Date());
//					imagesRefMapper.insertSelective(imagesRef);
//				}
//			}
			return DogResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}

	@Override
    @Transactional
	public DogResult updateInformationForYes(Long informationId,Long notifReceiverId,String infoTitile) {
		try {
			int count = informationMapper.updateInformationForYes(informationId);
			TNotification tNotification =new TNotification() ;
				tNotification.setNotifReceiverId(notifReceiverId);
				tNotification.setNotifType(8);
				tNotification.setNotiContent("您发布的信息<<"+infoTitile+">>已审核通过,您可进入信息发布--已审核列表进行查看!");
				tNotification.setNotifTitle("您发布的信息<<"+infoTitile+">>已审核通过");
			noticeService.addNotice(tNotification);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}

	@Override
	@Transactional
	public DogResult updateInformationForNo(Long informationId,Long notifReceiverId,String infoTitile,String failReason) {
		try {
			int count = informationMapper.updateInformationForNo(informationId,failReason);
			TNotification tNotification =new TNotification() ;
				tNotification.setNotifReceiverId(notifReceiverId);
				tNotification.setNotifType(8);
				tNotification.setNotiContent("您发布的信息<<"+infoTitile+">>没有审核通过,您可进入信息发布--已审核列表进行查看!");
				tNotification.setNotifTitle("您发布的信息<<"+infoTitile+">>没有审核通过");
			noticeService.addNotice(tNotification);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}


	@Override
	@Transactional
	public DogResult updateInformationCount(Long informationId) {
		try {
			int count = informationMapper.updateInformationCount(informationId);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}

	@Override
	public DogResult updateInformation(TInformation information) {
		try {
			information.setUpdateTime(new Date());
			int count = informationMapper.updateInformation(information);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}

	@Override
	public DogResult deleteInformation(Long informationId) {
		try {
			int count = informationMapper.deleteInformation(informationId);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！");
		}
	}

	@Transactional
    @Override
	public InforMationDetail viewinformationbyid(long informationId){
		InforMationDetail info = informationMapper.findInforMationDetailById(informationId);
		if(info!= null){
			//更新热度(每查看一次,热度+1)
			this.updateInformationCount(informationId);
		}
		//返回内容
		return info;
	}

	@Override
	public Information selectInformation(Long informationId) {
		try {
			TInformation tInformation = informationMapper.selectInformation(informationId);
			//获取图片id
			List<TImagesRef> imagesRefs = imagesRefMapper.selectInformationPic(informationId);

			List<TImages> images = new ArrayList<>();
			for (TImagesRef tImagesRef : imagesRefs) {
				TImages image = imagesMapper.selectByPrimaryKey(tImagesRef.getImageId());
				images.add(image);
			}

			//更新热度(每查看一次,热度+1)
			this.updateInformationCount(informationId);
			//创建一个目标对象
			Information information = new Information();
			//将来源对象复制给目标对象
			BeanUtils.copyProperties(tInformation, information);

			List<TDictionary> informationType = dictionaryMapper.selectInformationType(tInformation.getInformationType());
			//添加资讯类型名称
			information.setInformationTypeName(informationType.get(0).getDictionaryDescribe());
			information.setImages(images);

			//通过发布人id获取user
			TUsers user = usersMapper.selectByPrimaryKey(information.getOperatorId());
			String orgName = usersMapper.selectOrgNameById(user.getOrganizationId());
//			List<TDictionary> orgType = dictionaryMapper.selectOrgType(user.getOrgType());
			//将发布人机构存入information中
//			information.setPubishOrg(orgType.get(0).getDictionaryDescribe());
			information.setPubishOrg(orgName);
			return information;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}


	@Override
	public List<Information> selectInformations(Integer TypeNumber, Integer status, String query, Integer mark) {
		List<Information> informations = new ArrayList<>();
		try {
			List<TInformation> list = informationMapper.selectInformations(TypeNumber,status,query, mark);
			System.out.println(JSONObject.toJSONString(list));
			for (TInformation tInformation : list) {
				//创建一个目标对象
				Information information = new Information();
				//将来源对象复制给目标对象
				BeanUtils.copyProperties(tInformation, information);
				//获取图片id
//				List<TImagesRef> imagesRefs = imagesRefMapper.selectInformationPic(information.getInformationId());
//				List<TImages> images = new ArrayList<>();
//				for (TImagesRef tImagesRef : imagesRefs) {
//					TImages image = imagesMapper.selectByPrimaryKey(tImagesRef.getImageId());
//					images.add(image);
//				}

				List<TDictionary> informationType = dictionaryMapper.selectInformationType(tInformation.getInformationType());
				//添加资讯类型名称
				information.setInformationTypeName(informationType.get(0).getDictionaryDescribe());
				//通过发布人id获取user
				TUsers user = usersMapper.selectByPrimaryKey(information.getOperatorId());

				String orgName = usersMapper.selectOrgNameById(user.getOrganizationId());
//				List<TDictionary> orgType = dictionaryMapper.selectOrgType(user.getOrgType());
				//将发布人机构存入information中
//				information.setPubishOrg(orgType.get(0).getDictionaryDescribe());
				information.setPubishOrg(orgName);
//				information.setImages(images);
				informations.add(information);
			}
			return informations;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}

    @Override
    public PageInfo<InforMationDetail> findList(Integer type, String searchkey, Integer mark, Integer pageNum, Integer pageSize) {
        int totalCount = informationMapper.findListTotalCount(type, searchkey, mark);
        List<InforMationDetail> list = informationMapper.findList(type, searchkey, mark, pageNum, pageSize);
        PageInfo<InforMationDetail> page = new PageInfo<>(list);
        page.setTotal(totalCount);
        return page;
    }

}
