package com.soholy.dogmanager.common.enums;

public enum SexType {
	dog_sex_boy(0,"雄"),
	dog_sex_girl(1,"雌"),
	person_sex_boy(0,"男"),
	person_sex_girl(1,"女"),
	;
	private SexType(Integer code, String msg) {
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
