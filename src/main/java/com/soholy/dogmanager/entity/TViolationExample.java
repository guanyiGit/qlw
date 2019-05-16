package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TViolationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TViolationExample() {
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

        public Criteria andViolationIdIsNull() {
            addCriterion("violation_id is null");
            return (Criteria) this;
        }

        public Criteria andViolationIdIsNotNull() {
            addCriterion("violation_id is not null");
            return (Criteria) this;
        }

        public Criteria andViolationIdEqualTo(Long value) {
            addCriterion("violation_id =", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdNotEqualTo(Long value) {
            addCriterion("violation_id <>", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdGreaterThan(Long value) {
            addCriterion("violation_id >", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("violation_id >=", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdLessThan(Long value) {
            addCriterion("violation_id <", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdLessThanOrEqualTo(Long value) {
            addCriterion("violation_id <=", value, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdIn(List<Long> values) {
            addCriterion("violation_id in", values, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdNotIn(List<Long> values) {
            addCriterion("violation_id not in", values, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdBetween(Long value1, Long value2) {
            addCriterion("violation_id between", value1, value2, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationIdNotBetween(Long value1, Long value2) {
            addCriterion("violation_id not between", value1, value2, "violationId");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIsNull() {
            addCriterion("violation_type is null");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIsNotNull() {
            addCriterion("violation_type is not null");
            return (Criteria) this;
        }

        public Criteria andViolationTypeEqualTo(Integer value) {
            addCriterion("violation_type =", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotEqualTo(Integer value) {
            addCriterion("violation_type <>", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeGreaterThan(Integer value) {
            addCriterion("violation_type >", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("violation_type >=", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeLessThan(Integer value) {
            addCriterion("violation_type <", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("violation_type <=", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIn(List<Integer> values) {
            addCriterion("violation_type in", values, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotIn(List<Integer> values) {
            addCriterion("violation_type not in", values, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeBetween(Integer value1, Integer value2) {
            addCriterion("violation_type between", value1, value2, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("violation_type not between", value1, value2, "violationType");
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

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andDogIdIsNull() {
            addCriterion("dog_id is null");
            return (Criteria) this;
        }

        public Criteria andDogIdIsNotNull() {
            addCriterion("dog_id is not null");
            return (Criteria) this;
        }

        public Criteria andDogIdEqualTo(Long value) {
            addCriterion("dog_id =", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotEqualTo(Long value) {
            addCriterion("dog_id <>", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThan(Long value) {
            addCriterion("dog_id >", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dog_id >=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThan(Long value) {
            addCriterion("dog_id <", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThanOrEqualTo(Long value) {
            addCriterion("dog_id <=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdIn(List<Long> values) {
            addCriterion("dog_id in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotIn(List<Long> values) {
            addCriterion("dog_id not in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdBetween(Long value1, Long value2) {
            addCriterion("dog_id between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotBetween(Long value1, Long value2) {
            addCriterion("dog_id not between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdIsNull() {
            addCriterion("dog_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdIsNotNull() {
            addCriterion("dog_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdEqualTo(Long value) {
            addCriterion("dog_owner_id =", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdNotEqualTo(Long value) {
            addCriterion("dog_owner_id <>", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdGreaterThan(Long value) {
            addCriterion("dog_owner_id >", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dog_owner_id >=", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdLessThan(Long value) {
            addCriterion("dog_owner_id <", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdLessThanOrEqualTo(Long value) {
            addCriterion("dog_owner_id <=", value, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdIn(List<Long> values) {
            addCriterion("dog_owner_id in", values, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdNotIn(List<Long> values) {
            addCriterion("dog_owner_id not in", values, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdBetween(Long value1, Long value2) {
            addCriterion("dog_owner_id between", value1, value2, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andDogOwnerIdNotBetween(Long value1, Long value2) {
            addCriterion("dog_owner_id not between", value1, value2, "dogOwnerId");
            return (Criteria) this;
        }

        public Criteria andViolationDateIsNull() {
            addCriterion("violation_date is null");
            return (Criteria) this;
        }

        public Criteria andViolationDateIsNotNull() {
            addCriterion("violation_date is not null");
            return (Criteria) this;
        }

        public Criteria andViolationDateEqualTo(Date value) {
            addCriterion("violation_date =", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateNotEqualTo(Date value) {
            addCriterion("violation_date <>", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateGreaterThan(Date value) {
            addCriterion("violation_date >", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("violation_date >=", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateLessThan(Date value) {
            addCriterion("violation_date <", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateLessThanOrEqualTo(Date value) {
            addCriterion("violation_date <=", value, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateIn(List<Date> values) {
            addCriterion("violation_date in", values, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateNotIn(List<Date> values) {
            addCriterion("violation_date not in", values, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateBetween(Date value1, Date value2) {
            addCriterion("violation_date between", value1, value2, "violationDate");
            return (Criteria) this;
        }

        public Criteria andViolationDateNotBetween(Date value1, Date value2) {
            addCriterion("violation_date not between", value1, value2, "violationDate");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Integer value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Integer value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Integer value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Integer value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Integer> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Integer> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Integer value1, Integer value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceIsNull() {
            addCriterion("violation_place is null");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceIsNotNull() {
            addCriterion("violation_place is not null");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceEqualTo(String value) {
            addCriterion("violation_place =", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceNotEqualTo(String value) {
            addCriterion("violation_place <>", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceGreaterThan(String value) {
            addCriterion("violation_place >", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("violation_place >=", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceLessThan(String value) {
            addCriterion("violation_place <", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceLessThanOrEqualTo(String value) {
            addCriterion("violation_place <=", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceLike(String value) {
            addCriterion("violation_place like", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceNotLike(String value) {
            addCriterion("violation_place not like", value, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceIn(List<String> values) {
            addCriterion("violation_place in", values, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceNotIn(List<String> values) {
            addCriterion("violation_place not in", values, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceBetween(String value1, String value2) {
            addCriterion("violation_place between", value1, value2, "violationPlace");
            return (Criteria) this;
        }

        public Criteria andViolationPlaceNotBetween(String value1, String value2) {
            addCriterion("violation_place not between", value1, value2, "violationPlace");
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