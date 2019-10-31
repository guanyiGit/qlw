package com.soholy.dogmanager.service.violation;

import java.util.List;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TAdoptionPublicity;
import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.pojo.violation.AdoptionCollectionVO;
import com.soholy.dogmanager.pojo.violation.AdoptionVO;
import com.soholy.dogmanager.pojo.violation.PublishVO;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：AdoptionService 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月24日 下午5:42:44 
* 修改人：Administrator 
* 修改时间：2018年8月24日 下午5:42:44 
* 修改备注： 
* 
*/
public interface AdoptionService {
	//添加到领养平台
	DogResult saveAdoptionPublicity(TAdoptionPublicity tAdoptionPublicity);
	
	//批量添加到领养平台
	DogResult saveAdoptionPublicityBatch(List<Long> collectionIdList);
		
	//查询发布中列表（分页）
	Page<AdoptionCollectionVO> findAdoptablList(int pn,int pageSize,String string);
	
	//查申请已领养列表
	Page<AdoptionVO> findAdoptabledList(int pn,int pageSize,String string,int status,int type);
	
	//撤回到收容平台
	DogResult updateAdoptionCollection(Long adoptionId,Long collectionId);
	
	//批量撤回到收容平台
	DogResult updateAdoptionCollectionBatch(List<PublishVO> PublishVOList);
	
	//查已领养详情
	AdoptionVO findOne(Long adoptionRecordId);
	
	//领养申请
	DogResult AdoptionApplyDog(TAdoptionRecords tAdoptionRecords);
	
	//领养确认
	DogResult AdoptionApplySuer(TAdoptionRecords tAdoptionRecords);
	
	//查询领养申请记录
	List<TAdoptionRecords> findTAdoptionRecordsList(Long adoptionPublicityId);
	
	//重新发布
	DogResult againPublish(List<TAdoptionRecords> AdoptionRecordList);
	

	
}
