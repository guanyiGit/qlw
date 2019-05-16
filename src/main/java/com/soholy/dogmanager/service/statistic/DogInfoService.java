package com.soholy.dogmanager.service.statistic;

import java.io.UnsupportedEncodingException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.common.pojo.TableSplitResult;
import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.entity.TDogInfo;
import com.soholy.dogmanager.entity.TDogOwner;
import com.soholy.dogmanager.entity.TTherapy;
import com.soholy.dogmanager.entity.dogCard.DogIdAndOwnerId;
import com.soholy.dogmanager.entity.dogCard.DogAllInfo;
import com.soholy.dogmanager.entity.dogCard.DogOwners;
import com.soholy.dogmanager.entity.statistic.DogInfo;
import com.soholy.dogmanager.entity.statistic.DogInspection;
import com.soholy.dogmanager.exception.SubmitRepeatException;
import com.soholy.dogmanager.pojo.statistic.DogInfoVO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerDTO;
import com.soholy.dogmanager.pojo.statistic.DogOwnerVO2;
import com.soholy.dogmanager.pojo.statistic.ImmuneRegister;
import com.soholy.dogmanager.pojo.violation.DogOwnerVO;

public interface DogInfoService {
	/**
	 * 病历列表
	 * @param pageNumber
	 * @param pageSize
	 * @param searchKey
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Object findTherapyList(Integer index,Integer pageSize,String searchKey,Integer orgId) throws UnsupportedEncodingException;

	/**
	 * 根据犬只id查找病历详情
	 * @param dogId
	 * @return
	 */
	DogInfo findTherapyDetail(Long dogId,Integer orgId);
	
	/**
	 * 插入病历记录
	 * @param tTherapy
	 * @return
	 */
	int insertTherapyRecord(TTherapy tTherapy);
	
	/**
	 * 免疫证列表
	 * @author ZhongZhong
	 * @param pageNumber
	 * @param pageSize
	 * @param searchKey
	 * @param orgId
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	TableSplitResult<List<DogInfo>> findImmuneCardList(Integer index,Integer pageSize,Integer orgId,String searchKey) throws UnsupportedEncodingException;
	
	/**
	 * 查看免疫证详情
	 * @author ZhongZhong
	 * @param dogId
	 * @return
	 */
	DogInfo findImmuneDetail(Long dogId);
	
//	/**
////	 * 免疫证办理插入信息
////	 */
////	Long insertImmuneMsg(DogInfo dogInfo) throws SubmitRepeatException;

	/**
	 * 免疫登记插入信息
	 */
	DogIdAndOwnerId insertImmuneMsg(DogInfo dogInfo);
	/**
	 * 根据免疫证号查询犬只信息,犬主信息,犬证号
	 * @author ZhongZhong
	 * @param immuneCardNum
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	DogInspection findDogInspectionByImmuneCode(String immuneCardNum) throws UnsupportedEncodingException;
	
	/**
	 * 查看年检记录详情 
	 * @author ZhongZhong
	 * @param inspectionsId
	 * @return
	 */
	DogInspection findDogInspectionDetail(Integer inspectionsId);
	
	
	/**
	 * 查看年检列表
	 * @param pageNumber 页码
	 * @param pageSize 页面大小
	 * @param searchKey 搜索关键字
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	HashMap<String, Object>findDogInspectionList(Integer pageNumber,Integer pageSize,String searchKey,Integer orgId,Integer orgType) throws UnsupportedEncodingException;
	
	/**
	 * 插入年检信息
	 * @author ZhongZhong
	 * @param dogInspection
	 */
	int insertInspection(DogInspection dogInspection);

	/**
	 * @author ZhongZhong
	 * 查看犬只品种，犬只颜色，和犬主区域
	 * @return
	 */
	public HashMap<String, Object> findBreedColorDistrict();

	/**
	 * 查看详情中的病历列表
	 * @param dogId
	 * @param orgId
	 * @return
	 */
	public List<TTherapy> findDetailTherapyList(Integer dogId, Integer orgId);
	List<String> getImmuneCardNumsList(String input) throws ServerException;//查所有的免疫证号


	/**
	 * 免疫登记
	 * 添加犬只犬主生成免疫证
	 * */
	DogResult saveImmuneRegister(ImmuneRegister immuneRegister);



	/**
	 * 免疫登记
	 * 添加犬只健康状况
	 * */
	DogResult saveHealthCondition(HealthConditionDO healthConditionDO);

	/**
	 * 免疫登记
	 * 添加免疫记录
	 * */
	DogResult saveImmuneRecord(ImmuneRegister immuneRegister);

	/**
	 * 编辑免疫登记信息
	 * @param dogInfo
	 * @return
	 */
	DogResult updateDogImmune(DogInfo dogInfo) throws Exception;


	DogOwners findDogOwnerByPhone(String phone);

	/**
	 * 添加犬主
	 * 生成用户
	 */
	DogResult saveDogOwner(DogOwnerDTO dogOwnerDTO);
	/**
	 * 添加犬主(微信小程序)
	 * 生成用户
	 */
	DogResult addDogOwner(DogOwnerDTO dogOwnerDTO);
	/**
	 * 修改密码(微信小程序)
	 */
	DogResult updPassword(DogOwnerDTO dogOwnerDTO);
	/**
	 * 犬主列表
	 */
	Page<DogOwnerDTO> findDogOwnerList(HashMap<String,Object> map);
	/**
	 * 犬主详情
	 */
	DogOwnerDTO findDogOwnerById(Long dogOwnerId);
	/**
	 * 修改犬主
	 */
	DogResult updateDogOwner(DogOwnerVO2 dogOwnerVO2);
	/**
	 * 犬只详情
	 */
	DogInfoVO findDogInfoVOById(Long dogId);
	/**
	 * 添加犬只
	 */
	void saveDog(TDogInfo dogInfo);
	/**
	 * 修改犬只
	 */
	void updateDog(TDogInfo dogInfo);

	//删除图片
	void deletePic(Long fid);

}
