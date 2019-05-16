package com.soholy.dogmanager.mapper.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TVaccineMapper {
	/**
	 * 得到免疫总数量
	 * @return
	 */
	int getTVaccineCount(@Param("input")String input,@Param("org_id")Integer org_id);
	/**
	 * 得到免疫登记列表
	 * @return
	 */
	List<Object> tVaccineList(@Param("start")Integer start,@Param("size")Integer size
			,@Param("input")String input,@Param("org_id")Integer org_id);
	//得到免疫总数量(喂药)
	int getTVaccineCountWY(@Param("input")String input,@Param("org_id")Integer org_id);
	//得到免疫登记列表(喂药)
	List<Object> tVaccineListWY(@Param("start")Integer start,@Param("size")Integer size
			,@Param("input")String input,@Param("org_id")Integer org_id);
	//得到病历总数量
	int getTherapyListCount(@Param("org_id")Integer org_id);
	//得到病历列表
	List<Map> getTherapyList(@Param("start")Integer start,@Param("size")Integer size
			,@Param("org_id")Integer org_id);
	//根据狗id和机构id得到病历记录总数
	int getTherapeListCount(Map map);
	//根据狗id和机构id得到病历记录
	List<Map> getTherapeList(Map map);
	/**
	 * 添加免疫登记
	 * @param map
	 * @return
	 */
	int addTVaccine(Map map);
	/**
	 * 添加免疫记录
	 * @param map
	 * @return
	 */
	int addVaccineInjection(Map map);
	/**
	 * 得到喂药登记列表
	 * @return
	 */
	List<Object> getDrugList(@Param("start")Integer start,@Param("size")Integer size
			,@Param("input")String input,@Param("org_id")Integer org_id);
	/**
	 * 根据狗id和机构id得到喂药记录详情集合总数量
	 * @param id
	 * @return
	 */
	int getDrugRccordListDogIdCount(@Param("id")Integer id,@Param("org_id")Integer org_id);
	/**
	 * 根据狗id得到喂药记录详情集合
	 * @param id
	 * @return
	 */
	List<Object>getDrugRccordListDogId(@Param("id")Integer id
			,@Param("start")Integer start,@Param("size")Integer size,@Param("org_id")Integer org_id);
	/**
	 * 根据狗id得到喂药记录集合总数量
	 * @param id
	 * @return
	 */
	int getDrugRecordListCount(@Param("org_id")Integer org_id,@Param("dog_id")Integer dog_id);
	/**
	 * 根据狗id得到喂药记录集合
	 * @param id
	 * @return
	 */
	List<Object>getDrugRecordList(@Param("org_id")Integer org_id,@Param("dog_id")Integer dog_id
			,@Param("start")Integer num,@Param("size")Integer size);
	/**
	 * 添加喂药记录
	 * @param map
	 * @return
	 */
	int addDrugRecord(Map map);
	
	/**
	 * 根据狗id得到狗信息
	 */
	Object getDogInfoImm(Integer id);
	/**
	 * 根据狗id得到免疫记录集合总数量
	 */
	int getInjectionListDogIDCount(@Param("id")Integer id,@Param("org_id")Integer org_id);
	/**
	 * 根据狗id得到免疫记录集合
	 */
	List<Object> getInjectionListDogID(@Param("id")Integer id
			,@Param("start")Integer start,@Param("pageSize")Integer pageSize,@Param("org_id")Integer org_id);
	/**
	 * 根据免疫登记id得到狗详情
	 */
	HashMap<String,Object> getTVaccineId(Integer id);

	List<HashMap<String,Object>> findDogPic(@Param("dogId") Long dogId,@Param("type") Integer type);

	/**
	 * 根据免疫登记id得到免疫记录集合全部数量
	 * @param id
	 * @return
	 */
	int getInjectionCount(Integer id);
	/**
	 * 根据免疫登记id得到免疫记录集合
	 * @param id
	 * @return
	 */
	List<Object>getInjectionList(@Param("id")Integer id
			,@Param("start")Integer start,@Param("size")Integer size);

	/**
	 * 根据免疫登录表的refid得到数量
	 */
	int getRefIdTVaccineCount(@Param("ref_id")Integer ref_id);
	/**
	 * 得到免疫登记表自增最大id值
	 */
	int getVaccineRegisterId();
	/**
	 * 根据免疫证id和免疫项目名称得到免疫登记id
	 */
	String getIdRefId(@Param("ref_id")Integer ref_id,@Param("vaccine_name")String vaccine_name);
	/**
	 * 根据犬主电话得到犬主id
	 * @return
	 */
	Integer getDogOwnerID(String phone);
	/**
	 * 根据犬主id和犬名得到犬id
	 */
	Integer getDogIds(@Param("dogOwnerId") Integer dogOwnerId,@Param("dogName") String dogName);
	/**
	 * 添加犬主
	 */
	int addDogOwner(Map map);
	/**
	 * 添加犬
	 */
	int addDogInfo(Map map);
	/**
	 * 添加病历记录
	 * @return
	 */
	int addTherapy(Map map);
	/**
	 * 根据犬主电话或者姓名得到狗集合数量
	 * @param input
	 * @return
	 */
	int getDogInfoPhoneCount(@Param("input")String input);
	/**
	 * 根据犬主电话或者姓名得到狗集合
	 * @param input
	 * @return
	 */
	List<Object> getDogInfoPhone(@Param("input")String input
			,@Param("start")Integer start,@Param("pageSize")Integer pageSize);
	/**
	 * 得到下次喂药时间7天内的喂药信息
	 * @return
	 */
	List<Map>getDrugTZ();
	/**
	 * 得到下次喂药时间7天内的下次免疫信息
	 * @return
	 */
	List<Map>getInjectionTZ();
	/**
	 * 根据狗id和机构id得到免疫登记id
	 * @param id
	 * @return
	 */
	Integer getVaccineRegisterIds(@Param("id")Integer id,@Param("org_id")Integer org_id);
	/**
	 * 添加消息通知一次添加多条
	 * @param map
	 * @return
	 */
	int addNotification(@Param("list")List<Map>list);
	/**
	 * 修改喂药发送状态为1
	 * @param list
	 * @return
	 */
	 int updDrugRecord(@Param("list")List<Long>list);
	/**
	 * 修改免疫发送状态为1
	 * @param list
	 * @return
	 */
	 int updInjection(@Param("list")List<Long>list);
	 //修改密码
	 int updPwd(Map map);
	 //修改密码前判断原密码是否正确（根据原用户id，用户名，密码返回数量）
	 int boolPwd(Map map);
	 //根据犬主电话得到犬主
	 Map getDogOwner(String phone);
	 //根据犬主id和犬名得到犬
	 Map getDog(@Param("id")Integer id,@Param("dogName")String dogName);
	 //添加身份证
	 int addDogOwnerCard(Map map);
	 //根据病历记录id得到病历记录详情
	 Map getTherapes(Integer id);
	 //根据id和图片类型14得到图片集合（病历记录图片）
	 List <Map>getTherapeLists(Integer id);
	 //得到除传入的服务网点id所有服务网点集合
	 List <Map>getHospitalList(Integer id);
	 //根据狗id得到健康状态集合
	 List<Map>getHealthConditionList(@Param("dogId")Integer dogId);
	 //根据狗id得到狗，犬主，信息（喂药）
	Object getDogDowOwner(@Param("id")Integer id);
	//根据犬主姓名/免疫证号/电话号码精确得到犬，犬主信息总数量
	int getDogListCount(@Param("input")String input);
	//根据犬主姓名/免疫证号/电话号码精确得到犬，犬主信息
	List<Map> getDogList(@Param("input")String input,@Param("start")Integer start,@Param("size")Integer size);
}
