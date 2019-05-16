package com.soholy.dogmanager.mapper.violation;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.pojo.violation.AdoptionCollectionVO;
import com.soholy.dogmanager.pojo.violation.AdoptionVO;
import com.soholy.dogmanager.pojo.violation.CollectionVO;
import com.soholy.dogmanager.pojo.violation.HandleCollection2VO;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：CollectionMapper 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月23日 下午7:28:27 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午7:28:27 
* 修改备注： 
* 
*/
public interface CollectionMapper {
	
	//查看收容中列表
	List<CollectionVO> findCollectionList(HashMap<String , Object> map);
	int findCollectionListCount(HashMap<String , Object> map);
	//查看详情
	CollectionVO findCollectionById(Long collectionId);
	
	//查看发布中列表
	List<AdoptionCollectionVO> findAdoptionCollectionVOList(HashMap<String, Object> map);
	int findAdoptionCollectionVOListCount(HashMap<String, Object> map);
	
	//查询（申请）已领养列表
	List<AdoptionVO> findAdoptionVOList(HashMap<String, Object> map);
	int findAdoptionVOListCount(HashMap<String, Object> map);
	//查询（申请）已领养详情
	AdoptionVO findAdoptionVOByAdoptionRecordsId(Long adoptionRecordsId);
	
	//认领处理列表
	List<HandleCollection2VO> findHandleCollectionList(HashMap<String, Object> map);
	int findHandleCollectionListCount(HashMap<String, Object> map);
	//认领处理详情
	HandleCollection2VO findHandleCollectionByHandId(Long handleId);
	
	//查看爱心领养平台列表
	List<CollectionVO> findAdoptionCollectionVOs(HashMap<String, Object> map);
	int findAdoptionCollectionVOsCount(HashMap<String, Object> map);
	
	
}
