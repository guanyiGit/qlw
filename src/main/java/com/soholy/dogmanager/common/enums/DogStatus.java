package com.soholy.dogmanager.common.enums;

public enum DogStatus {
	DOG_STATUS_NORMAL(0,"正常"),
	DOG_STATUS_ACCEPT(1,"收容中"),
	DOG_STATUS_HANDLE(2,"已处理"),
	;
	private DogStatus(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private Integer code;
	private String msg;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
