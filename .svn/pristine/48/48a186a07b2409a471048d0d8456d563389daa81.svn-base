package com.soholy.dogmanager.service.dogCard.impl;

import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.mapper.HealthConditionMapper;
import com.soholy.dogmanager.pojo.statistic.HealthConditionVO;
import com.soholy.dogmanager.service.dogCard.HealthConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class HealthConditionServiceImpl implements HealthConditionService {
	@Autowired
	private HealthConditionMapper healthConditionDao;
	
	@Override
	public HealthConditionDO get(Long hId){
		return healthConditionDao.get(hId);
	}
	
	@Override
	public List<HealthConditionVO> list(Map<String, Object> map){
		return healthConditionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return healthConditionDao.count(map);
	}
	
	@Override
	public int save(HealthConditionDO healthCondition){
		return healthConditionDao.save(healthCondition);
	}
	
	@Override
	public int update(HealthConditionDO healthCondition){
		return healthConditionDao.update(healthCondition);
	}
	
	@Override
	public int remove(Long hId){
		return healthConditionDao.remove(hId);
	}
	
	@Override
	public int batchRemove(Long[] hIds){
		return healthConditionDao.batchRemove(hIds);
	}
	
}
