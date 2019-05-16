package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDeviceFactoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDeviceFactoryExample() {
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

        public Criteria andDeviceFactoryNameIsNull() {
            addCriterion("device_factory_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameIsNotNull() {
            addCriterion("device_factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameEqualTo(String value) {
            addCriterion("device_factory_name =", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameNotEqualTo(String value) {
            addCriterion("device_factory_name <>", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameGreaterThan(String value) {
            addCriterion("device_factory_name >", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_factory_name >=", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameLessThan(String value) {
            addCriterion("device_factory_name <", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("device_factory_name <=", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameLike(String value) {
            addCriterion("device_factory_name like", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameNotLike(String value) {
            addCriterion("device_factory_name not like", value, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameIn(List<String> values) {
            addCriterion("device_factory_name in", values, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameNotIn(List<String> values) {
            addCriterion("device_factory_name not in", values, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameBetween(String value1, String value2) {
            addCriterion("device_factory_name between", value1, value2, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNameNotBetween(String value1, String value2) {
            addCriterion("device_factory_name not between", value1, value2, "deviceFactoryName");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumIsNull() {
            addCriterion("device_factory_num is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumIsNotNull() {
            addCriterion("device_factory_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumEqualTo(String value) {
            addCriterion("device_factory_num =", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumNotEqualTo(Integer value) {
            addCriterion("device_factory_num <>", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumGreaterThan(Integer value) {
            addCriterion("device_factory_num >", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_factory_num >=", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumLessThan(Integer value) {
            addCriterion("device_factory_num <", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumLessThanOrEqualTo(Integer value) {
            addCriterion("device_factory_num <=", value, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumIn(List<Integer> values) {
            addCriterion("device_factory_num in", values, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumNotIn(List<Integer> values) {
            addCriterion("device_factory_num not in", values, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumBetween(Integer value1, Integer value2) {
            addCriterion("device_factory_num between", value1, value2, "deviceFactoryNum");
            return (Criteria) this;
        }

        public Criteria andDeviceFactoryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("device_factory_num not between", value1, value2, "deviceFactoryNum");
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