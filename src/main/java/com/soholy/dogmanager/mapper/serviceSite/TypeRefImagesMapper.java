package com.soholy.dogmanager.mapper.serviceSite;

import java.util.List;

import com.soholy.dogmanager.pojo.servicesite.TypeRefImages;
import org.apache.ibatis.annotations.Param;

public interface TypeRefImagesMapper {
	
	List<TypeRefImages> selectImagesByTypeAndId(@Param("targetType") Integer targetType, @Param("refId") Long refId);
	
}
