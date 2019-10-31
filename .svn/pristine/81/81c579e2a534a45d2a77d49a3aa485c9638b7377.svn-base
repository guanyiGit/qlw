package com.soholy.dogmanager.service.violation;

import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TBlacklist;

/** 
* 
* 项目名称：generatorSqlmapCustom 
* 类名称：BlankService 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月23日 下午2:55:19 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午2:55:19 
* 修改备注： 
* 
*/
public interface BlankService {
	//添加
	DogResult save(TBlacklist tBlacklist) throws Exception;
	//移除黑名单
	DogResult update(TBlacklist tBlacklist);
	
	//批量移除
	DogResult removeBatch(List<Long> blackIdList);
	
	//查看黑名单列表
	Page<TBlacklist> findAll(int pn,int pageSize,String string);

	//查看详情
	TBlacklist findOne(Long blackId);
	
	//根据姓名或身份证检查黑名单是否存在
	TBlacklist checkBlackList(String string);
	
}
