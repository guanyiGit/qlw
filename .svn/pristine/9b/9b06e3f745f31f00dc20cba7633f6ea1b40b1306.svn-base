package com.soholy.dogmanager.service.violation;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TAdoptionRecords;
import com.soholy.dogmanager.entity.TCollection;
import com.soholy.dogmanager.pojo.violation.CollectionVO;
import com.soholy.dogmanager.pojo.violation.HandleCollection2VO;
import com.soholy.dogmanager.pojo.violation.HandleCollectionVO;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：CollectionService 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月23日 下午7:06:58 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午7:06:58 
* 修改备注： 
* 
*/
public interface CollectionService {
	
	//检查犬只编号是否存在
	DogResult checkDogCode(String dogCode);
	
	//添加收容记录（无主流浪犬）
	DogResult save(TCollection collection);
	
	//修改
	DogResult update(TCollection collection);
	
	//查看收容中列表
	Page<CollectionVO> findCollectionList(int pn,int pageSize,String string,int status);
	
	//查看收容详情
	CollectionVO findCollectionByCollectionId(Long collectionId);
	
	//认领登记
	DogResult claimMyDog(HandleCollectionVO handleCollectionVO);
	
	//处理登记
	DogResult handleDog(HandleCollectionVO handleCollectionVO);
	
	//领养登记
	DogResult AdoptionPubDog(TAdoptionRecords tAdoptionRecords);
	
	//认领处理列表
	Page<HandleCollection2VO> findHandleCollectionVOList(int pn,int pageSize,String string,int type);
	
	//认领处理详情
	HandleCollection2VO findHandleCollectionByHandleId(Long handleId);
	
	//查看爱心领养平台列表
	Page<CollectionVO> findAdoptionCollectionVOs(int pn,int pageSize,String string,int status);
	
	
		
	
}
