package com.soholy.dogmanager.mapper;


import java.util.List;
import java.util.Map;
import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.pojo.statistic.HealthConditionVO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 10:08:59
 */

public interface HealthConditionMapper {

	HealthConditionDO get(Long hId);
	
	List<HealthConditionVO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(HealthConditionDO healthCondition);
	
	int update(HealthConditionDO healthCondition);
	
	int remove(Long h_id);
	
	int batchRemove(Long[] hIds);
}
