package com.soholy.dogmanager.mapper.statistic;

import java.util.HashMap;
import java.util.List;

import com.soholy.dogmanager.entity.statistic.DogInspection;

public interface DogInspectionMapper {
	/**
	 * 根据免疫证号查询犬只信息,犬主信息,犬证号
	 * @author ZhongZhong
	 * @param immuneCardNum
	 * @return
	 */
	DogInspection findDogInspectionByImmuneCode(String immuneCardNum);
	
	/**
	 * 查看年检记录详情 
	 * @author ZhongZhong
	 * @param inspectionsId
	 * @return
	 */
	DogInspection findDogInspectionDetail(Integer inspectionsId);

	
	/**
	 * 查看年检列表
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	List<DogInspection> findDogInspectionList(HashMap<String, Object>map);

	/**
	 * 统计年总记录数
	 * @author ZhongZhong
	 * @param map
	 * @return
	 */
	Integer findDogInspectionListRecord(HashMap<String, Object> map);
	
	/**
	 * 插入年检信息
	 * @param dogInspection
	 * @return
	 */
	int insertDogInspectionSelective(DogInspection dogInspection);
	
	
}
