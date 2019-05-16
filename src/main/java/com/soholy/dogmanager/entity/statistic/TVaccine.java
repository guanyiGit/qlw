package com.soholy.dogmanager.entity.statistic;

import java.util.Date;

public class TVaccine {

	private Integer dog_id;//狗id
	private Integer org_id;//机构id
	private Integer ref_id;//免疫证id
	private String vaccine_name;//疫苗名称
	private String vaccine_producer;//疫苗厂家
	private String vaccine_num;//疫苗编号这个随便填
	private Date first_injection_date;//第一次时间
	
	
	private Integer vaccine_register_id;//免疫登记id从后台得到
	
	private Date fact_injection_date ;//实际注射时间
	private Date next_injection_date ;//下次注射时间
	private Integer operator_id;//注射人id
	private String remarks;//备注
	
	public Integer getDog_id() {
		return dog_id;
	}
	public void setDog_id(Integer dog_id) {
		this.dog_id = dog_id;
	}
	public Integer getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}
	public Integer getRef_id() {
		return ref_id;
	}
	public void setRef_id(Integer ref_id) {
		this.ref_id = ref_id;
	}
	public String getVaccine_name() {
		return vaccine_name;
	}
	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}
	public String getVaccine_producer() {
		return vaccine_producer;
	}
	public void setVaccine_producer(String vaccine_producer) {
		this.vaccine_producer = vaccine_producer;
	}
	public String getVaccine_num() {
		return vaccine_num;
	}
	public void setVaccine_num(String vaccine_num) {
		this.vaccine_num = vaccine_num;
	}
	public Date getFirst_injection_date() {
		return first_injection_date;
	}
	public void setFirst_injection_date(Date first_injection_date) {
		this.first_injection_date = first_injection_date;
	}
	public Integer getVaccine_register_id() {
		return vaccine_register_id;
	}
	public void setVaccine_register_id(Integer vaccine_register_id) {
		this.vaccine_register_id = vaccine_register_id;
	}
	public Date getFact_injection_date() {
		return fact_injection_date;
	}
	public void setFact_injection_date(Date fact_injection_date) {
		this.fact_injection_date = fact_injection_date;
	}
	public Date getNext_injection_date() {
		return next_injection_date;
	}
	public void setNext_injection_date(Date next_injection_date) {
		this.next_injection_date = next_injection_date;
	}
	public Integer getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(Integer operator_id) {
		this.operator_id = operator_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
