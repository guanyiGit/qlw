package com.soholy.dogmanager.service.information;

import com.github.pagehelper.PageInfo;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TInformation;
import com.soholy.dogmanager.entity.notice.InforMationDetail;
import com.soholy.dogmanager.pojo.Information.Information;

import java.util.List;

public interface InformationService {
	
	/**
	* @Description: 添加资讯信息
	* @Title: addInformation  
	* @param information  
	* @return DogResult     
	* @throws
	 */
	DogResult addInformation(TInformation information,List<Long> imageIds);
	
	
	/**
	* @Description:审核通过
	* @Title: updateInformationForYes  
	* @param @param informationId
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateInformationForYes(Long informationId,Long notifReceiverId,String infoTitile);
	
	/**
	* @Description: 审核不通过(添加失败原因)
	* @Title: updateInformationForNo  
	* @param @param informationId
	* @param @param failReason
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateInformationForNo(Long informationId,Long notifReceiverId,String infoTitile,String failReason);
	
	/**
	* @Description: 更新浏览次数(+1)
	* @Title: updateInformationCount  
	* @param @param informationId
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateInformationCount(Long informationId);
	
	/**
	* @Description: 编辑修改资讯信息
	* @Title: updateInformation  
	* @param @param information
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateInformation(TInformation information);
	
	/**
	* @Description: 删除资讯信息
	* @Title: deleteInformation  
	* @param @param informationId
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult deleteInformation(Long informationId);


	/**
	 * 查看资讯详情
	 * @param informationId
	 * @return
	 */
	InforMationDetail viewinformationbyid(long informationId);

	/**
	* @Description:查看资讯(根据informationId)
	* @Title: selectInformation  
	* @param @param informationId
	* @param @return    
	* @return TInformation     
	* @throws
	 */
	Information selectInformation(Long informationId);
	
	/**
	* @Description: 根据资讯类型和资讯状态查询资讯列表(默认展示已审核上架的资讯分页)
	* @Title: selectInformationsByType  
	* @param @param TypeNumber
	* @param @return
	* @param mark  审核状态 ：0待审核，1审核通过，2审核不通过
     * @return List<TInformation>
	* @throws
	 */
	List<Information> selectInformations(Integer TypeNumber, Integer status, String query, Integer mark);


	/**
	 *查资讯列表
	 * @param type       资讯类型
	 *                   0政策法规
	 *                   1动态资讯
	 *                   2养犬宣传
	 *                   3服务指南
	 * @param searchkey titile搜索
	 * @param mark 0审核中，1上架，2下架
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<InforMationDetail> findList(Integer type, String searchkey, Integer mark, Integer pageNum, Integer pageSize);
}
