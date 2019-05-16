package com.soholy.dogmanager.common.enums;

public enum AdoptionDogStatus {
	ADOPTION_DOGSTATUS_PUBLICITY(0,"公示中"),
	ADOPTION_DOGSTATUS_ORDER(1,"预约中"),
	ADOPTION_DOGSTATUS_BYADOPT(2,"被领养"),
	ADOPTION_DOGSTATUS_NOADOPT(3,"未领养"),//已预约未领养
	ADOPTION_DOGSTATUS_OVERDUE(4,"过期"),//未预约过期
	
	;
	private AdoptionDogStatus(Integer code, String msg) {
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
