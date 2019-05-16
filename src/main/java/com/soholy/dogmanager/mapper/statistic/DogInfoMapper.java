package com.soholy.dogmanager.mapper.statistic;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.entity.TDogInfo;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TTherapy;
import com.soholy.dogmanager.entity.statistic.DogInfo;

public interface DogInfoMapper {

	/**
	 * 病历列表
	 * @param map
	 * @return
	 */
	 List<DogInfo>findTherapyList(HashMap<String, Object> map);

	 /**
	  * 统计病历总记录数
	  * @param map
	  * @return
	  */
	Integer findTherapyListRecord(HashMap<String, Object> map);
	
	/**
	 * 根据犬只id查找病历详情
	 * @param dogId
	 * @return
	 */
	DogInfo findTherapyDetail(@Param("dogId")Long dogId,@Param("orgId")Integer orgId);
	
	/**
	 * 插入病历信息
	 * @param tTherapy
	 * @return
	 */
	int insertSelective(TTherapy tTherapy);
	
	/**
	 * 免疫证列表
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<DogInfo>findImmuneCardList(HashMap<String, Object> map);
	
	/**
	 * 免疫证总记录数
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	Integer findImmuneListRecord(HashMap<String, Object> map);
	
	/**
	 * 查看免疫证详情
	 * @author ZhongZhong
	 * @param dogId
	 * @return
	 */
	DogInfo findImmuneDetail(Long dogId);
	/**
	 * 根据设备编号查询犬息
	 * @param deviceNum 设备编号
	 * @return 犬信息
	 */
    TDogInfo fondDogInfoByDeviceNum(String deviceNum);
    List<String> getImmuneCardNumsList(@Param("input") String input);//查所有的免疫证号
}
