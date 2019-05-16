package com.soholy.dogmanager.common.enums;

/** 
* 
* 项目名称：dogmanager-common 
* 类名称：BlackStatus 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月27日 下午6:59:39 
* 修改人：Administrator 
* 修改时间：2018年8月27日 下午6:59:39 
* 修改备注： 
* 
*/
public enum BlackStatus {
	BLACK_STATUS_REMOVE(0,"移除"),
	BLACK_STATUS_OPEN(1,"开启"),
	;
	private BlackStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
