package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Long value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Long value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Long value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Long value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Long value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Long> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Long> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Long value1, Long value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Long value1, Long value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Integer value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Integer value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Integer value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Integer value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<Integer> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Integer> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Integer value1, Integer value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIsNull() {
            addCriterion("device_brand is null");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIsNotNull() {
            addCriterion("device_brand is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandEqualTo(String value) {
            addCriterion("device_brand =", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotEqualTo(String value) {
            addCriterion("device_brand <>", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandGreaterThan(String value) {
            addCriterion("device_brand >", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandGreaterThanOrEqualTo(String value) {
            addCriterion("device_brand >=", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLessThan(String value) {
            addCriterion("device_brand <", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLessThanOrEqualTo(String value) {
            addCriterion("device_brand <=", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLike(String value) {
            addCriterion("device_brand like", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotLike(String value) {
            addCriterion("device_brand not like", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIn(List<String> values) {
            addCriterion("device_brand in", values, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotIn(List<String> values) {
            addCriterion("device_brand not in", values, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandBetween(String value1, String value2) {
            addCriterion("device_brand between", value1, value2, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotBetween(String value1, String value2) {
            addCriterion("device_brand not between", value1, value2, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdIsNull() {
            addCriterion("device_model_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdIsNotNull() {
            addCriterion("device_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdEqualTo(Integer value) {
            addCriterion("device_model_id =", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdNotEqualTo(Integer value) {
            addCriterion("device_model_id <>", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdGreaterThan(Integer value) {
            addCriterion("device_model_id >", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_model_id >=", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdLessThan(Integer value) {
            addCriterion("device_model_id <", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_model_id <=", value, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdIn(List<Integer> values) {
            addCriterion("device_model_id in", values, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdNotIn(List<Integer> values) {
            addCriterion("device_model_id not in", values, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdBetween(Integer value1, Integer value2) {
            addCriterion("device_model_id between", value1, value2, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_model_id not between", value1, value2, "deviceModelId");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNull() {
            addCriterion("production_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNotNull() {
            addCriterion("production_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeEqualTo(Date value) {
            addCriterion("production_time =", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotEqualTo(Date value) {
            addCriterion("production_time <>", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThan(Date value) {
            addCriterion("production_time >", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("production_time >=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThan(Date value) {
            addCriterion("production_time <", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThanOrEqualTo(Date value) {
            addCriterion("production_time <=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIn(List<Date> values) {
            addCriterion("production_time in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotIn(List<Date> values) {
            addCriterion("production_time not in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeBetween(Date value1, Date value2) {
            addCriterion("production_time between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotBetween(Date value1, Date value2) {
            addCriterion("production_time not between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksIsNull() {
            addCriterion("device_remarks is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksIsNotNull() {
            addCriterion("device_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksEqualTo(String value) {
            addCriterion("device_remarks =", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksNotEqualTo(String value) {
            addCriterion("device_remarks <>", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksGreaterThan(String value) {
            addCriterion("device_remarks >", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("device_remarks >=", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksLessThan(String value) {
            addCriterion("device_remarks <", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksLessThanOrEqualTo(String value) {
            addCriterion("device_remarks <=", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksLike(String value) {
            addCriterion("device_remarks like", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksNotLike(String value) {
            addCriterion("device_remarks not like", value, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksIn(List<String> values) {
            addCriterion("device_remarks in", values, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksNotIn(List<String> values) {
            addCriterion("device_remarks not in", values, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksBetween(String value1, String value2) {
            addCriterion("device_remarks between", value1, value2, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceRemarksNotBetween(String value1, String value2) {
            addCriterion("device_remarks not between", value1, value2, "deviceRemarks");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Integer value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Integer value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Integer value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Integer value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Integer> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Integer> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternIsNull() {
            addCriterion("device_work_pattern is null");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternIsNotNull() {
            addCriterion("device_work_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternEqualTo(Integer value) {
            addCriterion("device_work_pattern =", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternNotEqualTo(Integer value) {
            addCriterion("device_work_pattern <>", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternGreaterThan(Integer value) {
            addCriterion("device_work_pattern >", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_work_pattern >=", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternLessThan(Integer value) {
            addCriterion("device_work_pattern <", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternLessThanOrEqualTo(Integer value) {
            addCriterion("device_work_pattern <=", value, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternIn(List<Integer> values) {
            addCriterion("device_work_pattern in", values, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternNotIn(List<Integer> values) {
            addCriterion("device_work_pattern not in", values, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternBetween(Integer value1, Integer value2) {
            addCriterion("device_work_pattern between", value1, value2, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andDeviceWorkPatternNotBetween(Integer value1, Integer value2) {
            addCriterion("device_work_pattern not between", value1, value2, "deviceWorkPattern");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeIsNull() {
            addCriterion("upload_interval_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeIsNotNull() {
            addCriterion("upload_interval_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeEqualTo(Integer value) {
            addCriterion("upload_interval_time =", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeNotEqualTo(Integer value) {
            addCriterion("upload_interval_time <>", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeGreaterThan(Integer value) {
            addCriterion("upload_interval_time >", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_interval_time >=", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeLessThan(Integer value) {
            addCriterion("upload_interval_time <", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeLessThanOrEqualTo(Integer value) {
            addCriterion("upload_interval_time <=", value, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeIn(List<Integer> values) {
            addCriterion("upload_interval_time in", values, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeNotIn(List<Integer> values) {
            addCriterion("upload_interval_time not in", values, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeBetween(Integer value1, Integer value2) {
            addCriterion("upload_interval_time between", value1, value2, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andUploadIntervalTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_interval_time not between", value1, value2, "uploadIntervalTime");
            return (Criteria) this;
        }

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdIsNull() {
            addCriterion("device_factory_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdIsNotNull() {
            addCriterion("device_factory_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdEqualTo(Integer value) {
            addCriterion("device_factory_id =", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdNotEqualTo(Integer value) {
            addCriterion("device_factory_id <>", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdGreaterThan(Integer value) {
            addCriterion("device_factory_id >", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_factory_id >=", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdLessThan(Integer value) {
            addCriterion("device_factory_id <", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_factory_id <=", value, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdIn(List<Integer> values) {
            addCriterion("device_factory_id in", values, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdNotIn(List<Integer> values) {
            addCriterion("device_factory_id not in", values, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdBetween(Integer value1, Integer value2) {
            addCriterion("device_factory_id between", value1, value2, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_factory_id not between", value1, value2, "deviceFactoryId");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNull() {
            addCriterion("verify_code is null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIsNotNull() {
            addCriterion("verify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeEqualTo(String value) {
            addCriterion("verify_code =", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotEqualTo(String value) {
            addCriterion("verify_code <>", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThan(String value) {
            addCriterion("verify_code >", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("verify_code >=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThan(String value) {
            addCriterion("verify_code <", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLessThanOrEqualTo(String value) {
            addCriterion("verify_code <=", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeLike(String value) {
            addCriterion("verify_code like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotLike(String value) {
            addCriterion("verify_code not like", value, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeIn(List<String> values) {
            addCriterion("verify_code in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotIn(List<String> values) {
            addCriterion("verify_code not in", values, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeBetween(String value1, String value2) {
            addCriterion("verify_code between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andVerifyCodeNotBetween(String value1, String value2) {
            addCriterion("verify_code not between", value1, value2, "verifyCode");
            return (Criteria) this;
        }

        public Criteria andPskIsNull() {
            addCriterion("psk is null");
            return (Criteria) this;
        }

        public Criteria andPskIsNotNull() {
            addCriterion("psk is not null");
            return (Criteria) this;
        }

        public Criteria andPskEqualTo(String value) {
            addCriterion("psk =", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskNotEqualTo(String value) {
            addCriterion("psk <>", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskGreaterThan(String value) {
            addCriterion("psk >", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskGreaterThanOrEqualTo(String value) {
            addCriterion("psk >=", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskLessThan(String value) {
            addCriterion("psk <", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskLessThanOrEqualTo(String value) {
            addCriterion("psk <=", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskLike(String value) {
            addCriterion("psk like", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskNotLike(String value) {
            addCriterion("psk not like", value, "psk");
            return (Criteria) this;
        }

        public Criteria andPskIn(List<String> values) {
            addCriterion("psk in", values, "psk");
            return (Criteria) this;
        }

        public Criteria andPskNotIn(List<String> values) {
            addCriterion("psk not in", values, "psk");
            return (Criteria) this;
        }

        public Criteria andPskBetween(String value1, String value2) {
            addCriterion("psk between", value1, value2, "psk");
            return (Criteria) this;
        }

        public Criteria andPskNotBetween(String value1, String value2) {
            addCriterion("psk not between", value1, value2, "psk");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchIsNull() {
            addCriterion("device_batch is null");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchIsNotNull() {
            addCriterion("device_batch is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchEqualTo(String value) {
            addCriterion("device_batch =", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchNotEqualTo(String value) {
            addCriterion("device_batch <>", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchGreaterThan(String value) {
            addCriterion("device_batch >", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchGreaterThanOrEqualTo(String value) {
            addCriterion("device_batch >=", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchLessThan(String value) {
            addCriterion("device_batch <", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchLessThanOrEqualTo(String value) {
            addCriterion("device_batch <=", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchLike(String value) {
            addCriterion("device_batch like", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchNotLike(String value) {
            addCriterion("device_batch not like", value, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchIn(List<String> values) {
            addCriterion("device_batch in", values, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchNotIn(List<String> values) {
            addCriterion("device_batch not in", values, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchBetween(String value1, String value2) {
            addCriterion("device_batch between", value1, value2, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceBatchNotBetween(String value1, String value2) {
            addCriterion("device_batch not between", value1, value2, "deviceBatch");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotIsNull() {
            addCriterion("device_id_iot is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotIsNotNull() {
            addCriterion("device_id_iot is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotEqualTo(String value) {
            addCriterion("device_id_iot =", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotNotEqualTo(String value) {
            addCriterion("device_id_iot <>", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotGreaterThan(String value) {
            addCriterion("device_id_iot >", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotGreaterThanOrEqualTo(String value) {
            addCriterion("device_id_iot >=", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotLessThan(String value) {
            addCriterion("device_id_iot <", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotLessThanOrEqualTo(String value) {
            addCriterion("device_id_iot <=", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotLike(String value) {
            addCriterion("device_id_iot like", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotNotLike(String value) {
            addCriterion("device_id_iot not like", value, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotIn(List<String> values) {
            addCriterion("device_id_iot in", values, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotNotIn(List<String> values) {
            addCriterion("device_id_iot not in", values, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotBetween(String value1, String value2) {
            addCriterion("device_id_iot between", value1, value2, "deviceIdIot");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIotNotBetween(String value1, String value2) {
            addCriterion("device_id_iot not between", value1, value2, "deviceIdIot");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}