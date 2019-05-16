package com.soholy.dogmanager.pojo.servicesite;

import com.soholy.dogmanager.entity.TImages;

public class TypeRefImages extends TImages{
		
	private Integer targetType;

    private Long refId;
    
	public Integer getTargetType() {
		return targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

}
