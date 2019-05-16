package com.soholy.dogmanager.service.slides;

import java.util.List;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TSlides;

/**
* @ClassName: SlidesService
* @Description: 轮播图管理
* @author py
* @date 2018年8月27日
*
 */
public interface SlidesService {
	
	//添加轮播图
	DogResult addSlides(TSlides slides);
	
	//删除轮播图
	DogResult deleteSlides(Integer slidesId);
	
	/**
	* @Description: 启用轮播图
	* @Title: updateSlidesStatusForYes  
	* @param @param slidesId  
	* @param @param seq(默认为0)  
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateSlidesStatusForYes(Integer slidesId);
	
	DogResult updateSlidesStatusForYes(Integer slidesId,Integer seq);
	
	
	/**
	* @Description: 禁用轮播图(seq默认修改为0)
	* @Title: updateSlidesStatusForNo  
	* @param @param slidesId
	* @param @return    
	* @return DogResult     
	* @throws
	 */
	DogResult updateSlidesStatusForNo(Integer slidesId);
	
	/**
	* @Description: 查询轮播图列表(默认查询所有列表)
	* @Title: selectSlides  
	* @param status()
	* @return List<TSlides>     
	* @throws
	 */
	List<TSlides> selectSlides();
	
	List<TSlides> selectSlides(Integer status);
	
	
	
	
	
}
