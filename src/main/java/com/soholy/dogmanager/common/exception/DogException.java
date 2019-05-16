package com.soholy.dogmanager.common.exception;

import com.soholy.dogmanager.common.enums.ResultEnum;

public class DogException extends RuntimeException {
	private Integer code;

	public DogException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code=resultEnum.getCode();
	}

}
