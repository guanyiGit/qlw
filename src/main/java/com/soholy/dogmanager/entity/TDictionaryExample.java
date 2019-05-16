package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDictionaryExample() {
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

        public Criteria andDictionaryIdIsNull() {
            addCriterion("dictionary_id is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIsNotNull() {
            addCriterion("dictionary_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdEqualTo(Integer value) {
            addCriterion("dictionary_id =", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotEqualTo(Integer value) {
            addCriterion("dictionary_id <>", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThan(Integer value) {
            addCriterion("dictionary_id >", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictionary_id >=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThan(Integer value) {
            addCriterion("dictionary_id <", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThanOrEqualTo(Integer value) {
            addCriterion("dictionary_id <=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIn(List<Integer> values) {
            addCriterion("dictionary_id in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotIn(List<Integer> values) {
            addCriterion("dictionary_id not in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_id between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_id not between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldIsNull() {
            addCriterion("dictionary_field is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldIsNotNull() {
            addCriterion("dictionary_field is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldEqualTo(String value) {
            addCriterion("dictionary_field =", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldNotEqualTo(String value) {
            addCriterion("dictionary_field <>", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldGreaterThan(String value) {
            addCriterion("dictionary_field >", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_field >=", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldLessThan(String value) {
            addCriterion("dictionary_field <", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldLessThanOrEqualTo(String value) {
            addCriterion("dictionary_field <=", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldLike(String value) {
            addCriterion("dictionary_field like", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldNotLike(String value) {
            addCriterion("dictionary_field not like", value, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldIn(List<String> values) {
            addCriterion("dictionary_field in", values, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldNotIn(List<String> values) {
            addCriterion("dictionary_field not in", values, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldBetween(String value1, String value2) {
            addCriterion("dictionary_field between", value1, value2, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryFieldNotBetween(String value1, String value2) {
            addCriterion("dictionary_field not between", value1, value2, "dictionaryField");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIsNull() {
            addCriterion("dictionary_value is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIsNotNull() {
            addCriterion("dictionary_value is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueEqualTo(Integer value) {
            addCriterion("dictionary_value =", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotEqualTo(Integer value) {
            addCriterion("dictionary_value <>", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueGreaterThan(Integer value) {
            addCriterion("dictionary_value >", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictionary_value >=", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueLessThan(Integer value) {
            addCriterion("dictionary_value <", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueLessThanOrEqualTo(Integer value) {
            addCriterion("dictionary_value <=", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIn(List<Integer> values) {
            addCriterion("dictionary_value in", values, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotIn(List<Integer> values) {
            addCriterion("dictionary_value not in", values, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_value between", value1, value2, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_value not between", value1, value2, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIsNull() {
            addCriterion("dictionary_describe is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIsNotNull() {
            addCriterion("dictionary_describe is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeEqualTo(String value) {
            addCriterion("dictionary_describe =", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotEqualTo(String value) {
            addCriterion("dictionary_describe <>", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeGreaterThan(String value) {
            addCriterion("dictionary_describe >", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_describe >=", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLessThan(String value) {
            addCriterion("dictionary_describe <", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLessThanOrEqualTo(String value) {
            addCriterion("dictionary_describe <=", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLike(String value) {
            addCriterion("dictionary_describe like", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotLike(String value) {
            addCriterion("dictionary_describe not like", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIn(List<String> values) {
            addCriterion("dictionary_describe in", values, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotIn(List<String> values) {
            addCriterion("dictionary_describe not in", values, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeBetween(String value1, String value2) {
            addCriterion("dictionary_describe between", value1, value2, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotBetween(String value1, String value2) {
            addCriterion("dictionary_describe not between", value1, value2, "dictionaryDescribe");
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