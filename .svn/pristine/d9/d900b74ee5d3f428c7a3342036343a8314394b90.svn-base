package com.soholy.dogmanager.mapper.violation;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.pojo.violation.DeviceDogVo;
import com.soholy.dogmanager.pojo.violation.DogInfo2VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish3VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish4VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunishVO;

public interface PunishMapper {
	//查询详情
	ViolationPunish3VO findViolationById(Long violationId);
	//查询列表
	List<ViolationPunish3VO> findViolationLists(HashMap<String, Object> map);
	int findViolationListsCount(HashMap<String, Object> map);
	
	//根据标识号查犬信息
	DeviceDogVo findDeviceDogVoByDeviceCode(String code);
	
	//根据犬id查违法记录
	List<ViolationPunishVO> findViolationPunishListByDogId(Long dogId);
	
	//最近扣分列表
	List<ViolationPunish4VO> findViolationPunish4VOListBydogOwnerId(Long OwnerId);
	
	//累计扣分
	List<DogInfo2VO> findtotalCountBydogOwnerId(Long OwnerId);
	
}
