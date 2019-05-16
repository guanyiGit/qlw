package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTherapyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTherapyExample() {
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

        public Criteria andTherapyIdIsNull() {
            addCriterion("therapy_id is null");
            return (Criteria) this;
        }

        public Criteria andTherapyIdIsNotNull() {
            addCriterion("therapy_id is not null");
            return (Criteria) this;
        }

        public Criteria andTherapyIdEqualTo(Long value) {
            addCriterion("therapy_id =", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdNotEqualTo(Long value) {
            addCriterion("therapy_id <>", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdGreaterThan(Long value) {
            addCriterion("therapy_id >", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("therapy_id >=", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdLessThan(Long value) {
            addCriterion("therapy_id <", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdLessThanOrEqualTo(Long value) {
            addCriterion("therapy_id <=", value, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdIn(List<Long> values) {
            addCriterion("therapy_id in", values, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdNotIn(List<Long> values) {
            addCriterion("therapy_id not in", values, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdBetween(Long value1, Long value2) {
            addCriterion("therapy_id between", value1, value2, "therapyId");
            return (Criteria) this;
        }

        public Criteria andTherapyIdNotBetween(Long value1, Long value2) {
            addCriterion("therapy_id not between", value1, value2, "therapyId");
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

        public Criteria andPhysicianNameIsNull() {
            addCriterion("physician_name is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameIsNotNull() {
            addCriterion("physician_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameEqualTo(String value) {
            addCriterion("physician_name =", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotEqualTo(String value) {
            addCriterion("physician_name <>", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameGreaterThan(String value) {
            addCriterion("physician_name >", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameGreaterThanOrEqualTo(String value) {
            addCriterion("physician_name >=", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLessThan(String value) {
            addCriterion("physician_name <", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLessThanOrEqualTo(String value) {
            addCriterion("physician_name <=", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLike(String value) {
            addCriterion("physician_name like", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotLike(String value) {
            addCriterion("physician_name not like", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameIn(List<String> values) {
            addCriterion("physician_name in", values, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotIn(List<String> values) {
            addCriterion("physician_name not in", values, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameBetween(String value1, String value2) {
            addCriterion("physician_name between", value1, value2, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotBetween(String value1, String value2) {
            addCriterion("physician_name not between", value1, value2, "physicianName");
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

        public Criteria andOperationIdIsNull() {
            addCriterion("operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationIdEqualTo(Long value) {
            addCriterion("operation_id =", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotEqualTo(Long value) {
            addCriterion("operation_id <>", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThan(Long value) {
            addCriterion("operation_id >", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_id >=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThan(Long value) {
            addCriterion("operation_id <", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(Long value) {
            addCriterion("operation_id <=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdIn(List<Long> values) {
            addCriterion("operation_id in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotIn(List<Long> values) {
            addCriterion("operation_id not in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdBetween(Long value1, Long value2) {
            addCriterion("operation_id between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotBetween(Long value1, Long value2) {
            addCriterion("operation_id not between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andDiagnoseIsNull() {
            addCriterion("diagnose is null");
            return (Criteria) this;
        }

        public Criteria andDiagnoseIsNotNull() {
            addCriterion("diagnose is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnoseEqualTo(String value) {
            addCriterion("diagnose =", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseNotEqualTo(String value) {
            addCriterion("diagnose <>", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseGreaterThan(String value) {
            addCriterion("diagnose >", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseGreaterThanOrEqualTo(String value) {
            addCriterion("diagnose >=", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLessThan(String value) {
            addCriterion("diagnose <", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLessThanOrEqualTo(String value) {
            addCriterion("diagnose <=", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLike(String value) {
            addCriterion("diagnose like", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseNotLike(String value) {
            addCriterion("diagnose not like", value, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseIn(List<String> values) {
            addCriterion("diagnose in", values, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseNotIn(List<String> values) {
            addCriterion("diagnose not in", values, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseBetween(String value1, String value2) {
            addCriterion("diagnose between", value1, value2, "diagnose");
            return (Criteria) this;
        }

        public Criteria andDiagnoseNotBetween(String value1, String value2) {
            addCriterion("diagnose not between", value1, value2, "diagnose");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoIsNull() {
            addCriterion("treatment_info is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoIsNotNull() {
            addCriterion("treatment_info is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoEqualTo(String value) {
            addCriterion("treatment_info =", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoNotEqualTo(String value) {
            addCriterion("treatment_info <>", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoGreaterThan(String value) {
            addCriterion("treatment_info >", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoGreaterThanOrEqualTo(String value) {
            addCriterion("treatment_info >=", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoLessThan(String value) {
            addCriterion("treatment_info <", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoLessThanOrEqualTo(String value) {
            addCriterion("treatment_info <=", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoLike(String value) {
            addCriterion("treatment_info like", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoNotLike(String value) {
            addCriterion("treatment_info not like", value, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoIn(List<String> values) {
            addCriterion("treatment_info in", values, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoNotIn(List<String> values) {
            addCriterion("treatment_info not in", values, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoBetween(String value1, String value2) {
            addCriterion("treatment_info between", value1, value2, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andTreatmentInfoNotBetween(String value1, String value2) {
            addCriterion("treatment_info not between", value1, value2, "treatmentInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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