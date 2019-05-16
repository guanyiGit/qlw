package com.soholy.dogmanager.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-02-25 10:08:59
 */
public class HealthConditionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Long hId;
	//犬只id
	private Long dogId;
	//检查时间
	private Date inspectTime;
	//皮肤
	private String skin;
	//肛温
	private String analTemperature;
	//脉搏
	private String pulse;
	//呼吸
	private String breathe;
	//可视粘膜
	private String visibleMucousMembrane;
	//皮温
	private String skinTemperature;
	//体重
	private Double weight;
	//检查机构
	private Integer inspectOrg;
	//操作人
	private Long operator;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	//状态1有效2无效
	private Integer status;
	//过期时间
	private Date expirationTime;
	//下次检查时间
	private Date nextInspectTime;

	/**
	 * 设置：主键id
	 */
	public void setHId(Long hId) {
		this.hId = hId;
	}
	/**
	 * 获取：主键id
	 */
	public Long getHId() {
		return hId;
	}
	/**
	 * 设置：犬只id
	 */
	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}
	/**
	 * 获取：犬只id
	 */
	public Long getDogId() {
		return dogId;
	}
	/**
	 * 设置：检查时间
	 */
	public void setInspectTime(Date inspectTime) {
		this.inspectTime = inspectTime;
	}
	/**
	 * 获取：检查时间
	 */
	public Date getInspectTime() {
		return inspectTime;
	}
	/**
	 * 设置：皮肤
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}
	/**
	 * 获取：皮肤
	 */
	public String getSkin() {
		return skin;
	}
	/**
	 * 设置：肛温
	 */
	public void setAnalTemperature(String analTemperature) {
		this.analTemperature = analTemperature;
	}
	/**
	 * 获取：肛温
	 */
	public String getAnalTemperature() {
		return analTemperature;
	}
	/**
	 * 设置：脉搏
	 */
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	/**
	 * 获取：脉搏
	 */
	public String getPulse() {
		return pulse;
	}
	/**
	 * 设置：呼吸
	 */
	public void setBreathe(String breathe) {
		this.breathe = breathe;
	}
	/**
	 * 获取：呼吸
	 */
	public String getBreathe() {
		return breathe;
	}
	/**
	 * 设置：可视粘膜
	 */
	public void setVisibleMucousMembrane(String visibleMucousMembrane) {
		this.visibleMucousMembrane = visibleMucousMembrane;
	}
	/**
	 * 获取：可视粘膜
	 */
	public String getVisibleMucousMembrane() {
		return visibleMucousMembrane;
	}
	/**
	 * 设置：皮温
	 */
	public void setSkinTemperature(String skinTemperature) {
		this.skinTemperature = skinTemperature;
	}
	/**
	 * 获取：皮温
	 */
	public String getSkinTemperature() {
		return skinTemperature;
	}
	/**
	 * 设置：体重
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * 获取：体重
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * 设置：检查机构
	 */
	public void setInspectOrg(Integer inspectOrg) {
		this.inspectOrg = inspectOrg;
	}
	/**
	 * 获取：检查机构
	 */
	public Integer getInspectOrg() {
		return inspectOrg;
	}
	/**
	 * 设置：操作人
	 */
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作人
	 */
	public Long getOperator() {
		return operator;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：状态1有效2无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态1有效2无效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}
	/**
	 * 设置：下次检查时间
	 */
	public void setNextInspectTime(Date nextInspectTime) {
		this.nextInspectTime = nextInspectTime;
	}
	/**
	 * 获取：下次检查时间
	 */
	public Date getNextInspectTime() {
		return nextInspectTime;
	}
}
