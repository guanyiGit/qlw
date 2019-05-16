package com.soholy.dogmanager.service.violation;

import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.pojo.violation.DeviceDogVo;
import com.soholy.dogmanager.pojo.violation.DogInfo2VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish2VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish3VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunish4VO;
import com.soholy.dogmanager.pojo.violation.ViolationPunishVO;

/** 
* 
* 项目名称：dogmanager-violation 
* 类名称：OpinionService 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月23日 下午4:43:20 
* 修改人：Administrator 
* 修改时间：2018年8月23日 下午4:43:20 
* 修改备注： 
* 
*/
public interface PunishService {
	
	Page<ViolationPunish3VO> findAll(int pn,int pageSize,String string);
	ViolationPunish3VO findOne(Long violationId);
	
	//添加违规记录
	DogResult save(ViolationPunish2VO violationPunish2VO) throws Exception;
	
	//根据标识号查犬信息
	DeviceDogVo findDeviceDogVoByDeviceCode(String code);
	
	//根据犬id查违法记录
	List<ViolationPunishVO> findViolationPunishListByDogId(Long dogId);
	
	//最近扣分
	List<ViolationPunish4VO> findViolationPunish4VOListBydogOwnerId(Long OwnerId);
	
	//年度扣分
	List<DogInfo2VO> findtotalCountBydogOwnerId(Long OwnerId);

	/**
	 * 违法行为查询
	 * @return
	 */
    List<TDictionary> findTypes();
}
