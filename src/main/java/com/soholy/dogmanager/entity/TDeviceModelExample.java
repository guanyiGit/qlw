package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDeviceModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDeviceModelExample() {
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

        public Criteria andDeviceModelNameIsNull() {
            addCriterion("device_model_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameIsNotNull() {
            addCriterion("device_model_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameEqualTo(String value) {
            addCriterion("device_model_name =", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameNotEqualTo(String value) {
            addCriterion("device_model_name <>", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameGreaterThan(String value) {
            addCriterion("device_model_name >", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_model_name >=", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameLessThan(String value) {
            addCriterion("device_model_name <", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameLessThanOrEqualTo(String value) {
            addCriterion("device_model_name <=", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameLike(String value) {
            addCriterion("device_model_name like", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameNotLike(String value) {
            addCriterion("device_model_name not like", value, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameIn(List<String> values) {
            addCriterion("device_model_name in", values, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameNotIn(List<String> values) {
            addCriterion("device_model_name not in", values, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameBetween(String value1, String value2) {
            addCriterion("device_model_name between", value1, value2, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNameNotBetween(String value1, String value2) {
            addCriterion("device_model_name not between", value1, value2, "deviceModelName");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberIsNull() {
            addCriterion("device_model_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberIsNotNull() {
            addCriterion("device_model_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberEqualTo(String value) {
            addCriterion("device_model_number =", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberNotEqualTo(Integer value) {
            addCriterion("device_model_number <>", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberGreaterThan(Integer value) {
            addCriterion("device_model_number >", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_model_number >=", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberLessThan(Integer value) {
            addCriterion("device_model_number <", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("device_model_number <=", value, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberIn(List<Integer> values) {
            addCriterion("device_model_number in", values, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberNotIn(List<Integer> values) {
            addCriterion("device_model_number not in", values, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberBetween(Integer value1, Integer value2) {
            addCriterion("device_model_number between", value1, value2, "deviceModelNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("device_model_number not between", value1, value2, "deviceModelNumber");
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