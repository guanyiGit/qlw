package com.soholy.dogmanager.service.statistic;

import java.util.List;
import java.util.Map;

import com.soholy.dogmanager.common.pojo.DogResult;
import org.apache.ibatis.annotations.Param;

public interface TVaccineService {

	/**
	 * 得到免疫登记总数量
	 * @param input
	 * @return
	 */
	int getTVaccineCount(String input,Integer org_id);
	/**
	 * 得到免疫登记列表
	 * @param num
	 * @param size
	 * @param input
	 * @return
	 */
	Object tVaccineList(Integer num,Integer size,String input,Integer org_id);
	/**
	 * 得到喂药列表
	 * @param num
	 * @param size
	 * @param input
	 * @return
	 */
	Object tVaccineListWY(Integer num,Integer size,String input,Integer org_id);
	/**
	 * 得到病历列表
	 * @param num
	 * @param size
	 * @param input
	 * @return
	 */
	Map getTherapyList(Integer num,Integer size,Integer org_id);
	/**
	 * 添加免疫登录
	 * @param map
	 * @return
	 */
	boolean addTVaccine(Map map);
	/**
	 * 添加免疫记录
	 */
	int addVaccineInjection(Map map);
	/**
	 * 根据id得到免疫记录
	 * @param id
	 * @return
	 */
	Object getTVaccineId(Integer id,Integer num,Integer size);
	/**
	 * 根据狗id得到狗信息和喂药记录
	 * @param id
	 * @return
	 */
	Object getDrugRecords(Integer id,Integer num,Integer size,Integer org_id);
	/**
	 * 根据狗id机构id得到喂药记录
	 * @param id
	 * @return
	 */
	Object getDrugRecord(Integer org_id,Integer dog_id,Integer size,Integer num);
	/**
	 * 添加喂药登记
	 * @param map
	 * @return
	 */
	boolean addDrugRecords(Map map);
	/**
	 * 添加喂药记录
	 * @param map
	 * @return
	 */
	int addDrugRecord(Map map);
	/**
	 * 添加无证喂药
	 * @param map
	 * @return
	 */
	boolean addWZDrugRecord(Map map);
	/**
	 * 根据狗id得到狗信息和免疫记录信息
	 * @param id
	 * @return
	 */
	Object getDogInfoImm(Integer id,Integer pageNum,Integer pageSize,Integer org_id);
	/**
	 * 根据狗id和机构id得到狗信息和病历记录
	 * @param dogId
	 * @return
	 */
	Map getTherapyDetails(Integer dogId,Integer orgId,Integer num,Integer size);

	/**
	 * 根据免疫登记列表免疫证id得到对象
	 */
	String getIdRefId(Integer ref_id,String vaccine_name);
	/**
	 * 添加无证免疫登记
	 */
	boolean addWZVaccine(Map map);
	/**
	 * 添加病历记录
	 * @param map
	 * @return
	 */
	int addTherapy(Map map);
	/**
	 * 添加无证病历记录
	 * @param map
	 * @return
	 */
	int addWZTherapy(Map map);
	/**
	 * 根据犬主名或者手机查找狗集合
	 * @param input
	 * @return
	 */
	Object getDogInfoPhone(String input,Integer pageNum,Integer pageSize);
	/**
	 * 通知犬主喂药（距离下次喂药时间7天内的）
	 * @return
	 */
	List<Map>getDrugTZ();
	/**
	 * 添加消息通知
	 */
	int addNotification(List<Map>list);
	/**
	 * 通知犬主免疫登记（距离下次喂药时间7天内的）
	 * @return
	 */
	List<Map>getInjectionTZ();
	/**
	 * 修改喂药发送状态为1
	 * @param list
	 * @return
	 */
	 int updDrugRecord(List<Long>list);
	/**
	 * 修改免疫发送状态为1
	 * @param list
	 * @return
	 */
	 int updInjection(List<Long>list);
	 /**
	  * 修改密码
	  * @param map
	  * @return
	  */
	 int updPwd(Map map);
	 /**
	  *根据犬主手机得到犬主
	  * @param phone
	  * @return
	  */
	 Map getDogOwner(String phone);
	 /**
	  * 根据犬主id和犬名得到犬
	  * @param id
	  * @param dogName
	  * @return
	  */
	 Map getDog(Integer id,String dogName);
	 /**
	  * 根据病历记录id得到病历记录详情
	  * @return
	  */
	 Map getTherapes(Integer id);
	 /**
	  * 得到除传入的服务网点id所有服务网点集合
	  * @param id
	  * @return
	  */
	 List <Map>getHospitalList(Integer id);
	 /**
	  * 根据犬id得到犬和犬主
	  */
	 Map getDogDogOwner(Integer id);
	//根据狗id得到健康状态集合
	List<Map>getHealthConditionList(Integer dogId);
	//根据犬主姓名/免疫证号/电话号码精确得到犬，犬主信息
	Object getDogList(String input,Integer num,Integer size);
	//添加犬
	DogResult addDogInfo(Map map);
}
