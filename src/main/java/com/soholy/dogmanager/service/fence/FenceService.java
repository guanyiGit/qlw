package com.soholy.dogmanager.service.fence;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TFence;
import com.soholy.dogmanager.entity.TFenceCoordinate;
import com.soholy.dogmanager.pojo.fence.FenceRefCoordinate;

import java.util.List;

/**
* @ClassName: FenceService
* @Description: 电子围栏设定服务
* @author py
* @date 2018年8月21日
*
 */
public interface FenceService {

	 /**
	 * @Description: 批量添加围栏坐标
	 * @Title: addCoordinate
	 * @param @param coordinates
	 * @param @return
	 * @param @throws Exception
	 * @return DogResult
	 * @throws
	  */
	 DogResult addCoordinate(List<TFenceCoordinate> coordinates)throws Exception;

	 /**
	 * @Description: 设定围栏,同事生成围栏具体坐标记录
	 * @Title: addFence
	 * @param @return
	 * @param @throws Exception
	 * @param newFenceId
	  * @return DogResult
	 * @throws
	  */
	 DogResult addFence(TFence fence, List<TFenceCoordinate> coordinates, Long newFenceId);

	 /**
	 * @Description: 根据fenceId删除fence
	 * @Title: deleteFenceById
	 * @param @param fenceId
	 * @param @return
	 * @param @throws Exception
	 * @return DogResult
	 * @throws
	  */
	 DogResult deleteFenceById(Long fenceId);

	 /**
	 * @Description: 根据fenceId删除坐标
	 * @Title: deleteCoordinateByFenceId
	 * @param @param fenceId
	 * @param @return
	 * @param @throws Exception
	 * @return DogResult
	 * @throws
	  */
	 DogResult deleteCoordinateByFenceId(Long fenceId)throws Exception;

	 /**
	 * @Description: 批量删除coordinates
	 * @Title: deleteCoordinates
	 * @param @param coordinates
	 * @param @return
	 * @param @throws Exception
	 * @return DogResult
	 * @throws
	  */
	 DogResult deleteCoordinates(List<TFenceCoordinate> coordinates)throws Exception;
	 /**
	 * @Description: 根据fenceId查询围栏坐标(注意坐标排序)
	 * @Title: selectCoordinatesByFenceId
	 * @param @param fenceId
	 * @param @return
	 * @param @throws Exception
	 * @return List<TFenceCoordinate>
	 * @throws
	  */
	 List<TFenceCoordinate> selectCoordinatesByFenceId(Long fenceId)throws Exception;


	 /**
	 * @Description: 获取所有的围栏
	 * @Title: selectFences
	 * @param @return
	 * @param @throws Exception
	 * @return List<TFence>
	 * @throws
	  */
	 List<TFence> selectFences()throws Exception;

	 /**
	 * @Description: 根据添加人获取围栏
	 * @param operatorId
	 * @return
	 * @throws Exception（展示方法参数和返回值）
	  */
	 List<TFence> selectFences(Long operatorId)throws Exception;

	 /**
	 * @Description:获取
	 * @param id
	  * @param operatorId
      * @return（展示方法参数和返回值）
	  */
	 List<FenceRefCoordinate> selectFenceRefCoordinate(Long operatorId,Long fenceId)throws Exception;

	 /**
	 * @Description: 判断一个点是否在围栏范围内(如果为false,则向犬主发送短信提醒并通知到犬主小程序信息列表)
	 * @Title: isPtInPoly
	 * @param  ALon
	 * @param  ALat
	 * @param  ps
	 * @throws Exception
	 * @return FenceRefCoordinate
	  */
	 FenceRefCoordinate  isPtInPoly(Double ALon, Double ALat)throws Exception;


	/**
	 * 修改围栏信息
	 *
	 * @param fenceId
	 * @param tFenceCoordinates
	 * @return
	 */
    boolean modifyById(long fenceId, List<TFenceCoordinate> tFenceCoordinates);

	/**
	 * 查询围栏详细
	 * @param fenceIds
	 * @return
	 */
	Object findDetailByids(long[] fenceIds);

}
