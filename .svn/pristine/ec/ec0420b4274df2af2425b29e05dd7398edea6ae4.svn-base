package com.soholy.dogmanager.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TSlides;
import com.soholy.dogmanager.entity.TSlidesExample;

public interface TSlidesMapper {
    int countByExample(TSlidesExample example);

    int deleteByExample(TSlidesExample example);

    int deleteByPrimaryKey(Integer slidesId);

    int insert(TSlides record);

    int insertSelective(TSlides record);

    List<TSlides> selectByExample(TSlidesExample example);

    TSlides selectByPrimaryKey(Integer slidesId);

    int updateByExampleSelective(@Param("record") TSlides record, @Param("example") TSlidesExample example);

    int updateByExample(@Param("record") TSlides record, @Param("example") TSlidesExample example);

    int updateByPrimaryKeySelective(TSlides record);

    int updateByPrimaryKey(TSlides record);
    
    
    //添加轮播图
  	int addSlides(TSlides slides);
  	
  	//删除轮播图
  	int deleteSlides(Integer slidesId);
  	
  	/**
  	* @Description: 启用轮播图
  	* @Title: updateSlidesStatusForYes  
  	* @param @param slidesId  
  	* @param @param seq(默认为轮播中图片数量+1)  
  	* @param @return    
  	* @return DogResult     
  	* @throws
  	 */
  	int updateSlidesStatusForYes(@Param("slidesId")Integer slidesId,@Param("seq")Integer seq,@Param("startDate")Date startDate);
  	
  	/**
  	* @Description: 禁用轮播图(seq默认修改为0)
  	* @Title: updateSlidesStatusForNo  
  	* @param @param slidesId
  	* @param @return    
  	* @return DogResult     
  	* @throws
  	 */
  	int updateSlidesStatusForNo(@Param("slidesId")Integer slidesId,@Param("endDate")Date endDate);
  	
  	/**
	* @Description: 查询轮播图列表(默认查询所有列表)
	* @Title: selectSlides  
	* @param status()
	* @return List<TSlides>     
	* @throws
	 */
	List<TSlides> selectSlides(@Param("status")Integer status);

    
}