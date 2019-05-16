package com.soholy.dogmanager.service.dogCard;


import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.pojo.statistic.HealthConditionVO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 10:08:59
 */
public interface HealthConditionService {
	
	HealthConditionDO get(Long hId);
	
	List<HealthConditionVO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HealthConditionDO healthCondition);
	
	int update(HealthConditionDO healthCondition);
	
	int remove(Long hId);
	
	int batchRemove(Long[] hIds);
}
