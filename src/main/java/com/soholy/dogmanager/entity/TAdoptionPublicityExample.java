package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAdoptionPublicityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAdoptionPublicityExample() {
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

        public Criteria andAdoptionPublicityIdIsNull() {
            addCriterion("adoption_publicity_id is null");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdIsNotNull() {
            addCriterion("adoption_publicity_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdEqualTo(Long value) {
            addCriterion("adoption_publicity_id =", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdNotEqualTo(Long value) {
            addCriterion("adoption_publicity_id <>", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdGreaterThan(Long value) {
            addCriterion("adoption_publicity_id >", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("adoption_publicity_id >=", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdLessThan(Long value) {
            addCriterion("adoption_publicity_id <", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdLessThanOrEqualTo(Long value) {
            addCriterion("adoption_publicity_id <=", value, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdIn(List<Long> values) {
            addCriterion("adoption_publicity_id in", values, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdNotIn(List<Long> values) {
            addCriterion("adoption_publicity_id not in", values, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdBetween(Long value1, Long value2) {
            addCriterion("adoption_publicity_id between", value1, value2, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andAdoptionPublicityIdNotBetween(Long value1, Long value2) {
            addCriterion("adoption_publicity_id not between", value1, value2, "adoptionPublicityId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(Long value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(Long value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(Long value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(Long value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(Long value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<Long> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<Long> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(Long value1, Long value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(Long value1, Long value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("expire_date is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterion("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterion("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterion("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterion("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Date> values) {
            addCriterion("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterion("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterion("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("expire_date not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdIsNull() {
            addCriterion("publish_org_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdIsNotNull() {
            addCriterion("publish_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdEqualTo(Integer value) {
            addCriterion("publish_org_id =", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdNotEqualTo(Integer value) {
            addCriterion("publish_org_id <>", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdGreaterThan(Integer value) {
            addCriterion("publish_org_id >", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publish_org_id >=", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdLessThan(Integer value) {
            addCriterion("publish_org_id <", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("publish_org_id <=", value, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdIn(List<Integer> values) {
            addCriterion("publish_org_id in", values, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdNotIn(List<Integer> values) {
            addCriterion("publish_org_id not in", values, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("publish_org_id between", value1, value2, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andPublishOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publish_org_id not between", value1, value2, "publishOrgId");
            return (Criteria) this;
        }

        public Criteria andDogStatusIsNull() {
            addCriterion("dog_status is null");
            return (Criteria) this;
        }

        public Criteria andDogStatusIsNotNull() {
            addCriterion("dog_status is not null");
            return (Criteria) this;
        }

        public Criteria andDogStatusEqualTo(Integer value) {
            addCriterion("dog_status =", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotEqualTo(Integer value) {
            addCriterion("dog_status <>", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusGreaterThan(Integer value) {
            addCriterion("dog_status >", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_status >=", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusLessThan(Integer value) {
            addCriterion("dog_status <", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusLessThanOrEqualTo(Integer value) {
            addCriterion("dog_status <=", value, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusIn(List<Integer> values) {
            addCriterion("dog_status in", values, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotIn(List<Integer> values) {
            addCriterion("dog_status not in", values, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusBetween(Integer value1, Integer value2) {
            addCriterion("dog_status between", value1, value2, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andDogStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_status not between", value1, value2, "dogStatus");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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