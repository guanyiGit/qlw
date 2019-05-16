package com.soholy.dogmanager.common.enums;

public enum IsCollection {
	YES(0,"是"),
	NO(1,"否"),
	;
	private IsCollection(Integer code, String msg) {
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
