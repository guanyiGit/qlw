package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOpinionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOpinionExample() {
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

        public Criteria andOpinionIdIsNull() {
            addCriterion("opinion_id is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIsNotNull() {
            addCriterion("opinion_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionIdEqualTo(Long value) {
            addCriterion("opinion_id =", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotEqualTo(Long value) {
            addCriterion("opinion_id <>", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThan(Long value) {
            addCriterion("opinion_id >", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("opinion_id >=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThan(Long value) {
            addCriterion("opinion_id <", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdLessThanOrEqualTo(Long value) {
            addCriterion("opinion_id <=", value, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdIn(List<Long> values) {
            addCriterion("opinion_id in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotIn(List<Long> values) {
            addCriterion("opinion_id not in", values, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdBetween(Long value1, Long value2) {
            addCriterion("opinion_id between", value1, value2, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionIdNotBetween(Long value1, Long value2) {
            addCriterion("opinion_id not between", value1, value2, "opinionId");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeIsNull() {
            addCriterion("opinion_type is null");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeIsNotNull() {
            addCriterion("opinion_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeEqualTo(Integer value) {
            addCriterion("opinion_type =", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeNotEqualTo(Integer value) {
            addCriterion("opinion_type <>", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeGreaterThan(Integer value) {
            addCriterion("opinion_type >", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opinion_type >=", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeLessThan(Integer value) {
            addCriterion("opinion_type <", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opinion_type <=", value, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeIn(List<Integer> values) {
            addCriterion("opinion_type in", values, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeNotIn(List<Integer> values) {
            addCriterion("opinion_type not in", values, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeBetween(Integer value1, Integer value2) {
            addCriterion("opinion_type between", value1, value2, "opinionType");
            return (Criteria) this;
        }

        public Criteria andOpinionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opinion_type not between", value1, value2, "opinionType");
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

        public Criteria andResStatusIsNull() {
            addCriterion("res_status is null");
            return (Criteria) this;
        }

        public Criteria andResStatusIsNotNull() {
            addCriterion("res_status is not null");
            return (Criteria) this;
        }

        public Criteria andResStatusEqualTo(Integer value) {
            addCriterion("res_status =", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusNotEqualTo(Integer value) {
            addCriterion("res_status <>", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusGreaterThan(Integer value) {
            addCriterion("res_status >", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_status >=", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusLessThan(Integer value) {
            addCriterion("res_status <", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusLessThanOrEqualTo(Integer value) {
            addCriterion("res_status <=", value, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusIn(List<Integer> values) {
            addCriterion("res_status in", values, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusNotIn(List<Integer> values) {
            addCriterion("res_status not in", values, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusBetween(Integer value1, Integer value2) {
            addCriterion("res_status between", value1, value2, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("res_status not between", value1, value2, "resStatus");
            return (Criteria) this;
        }

        public Criteria andResUserIdIsNull() {
            addCriterion("res_user_id is null");
            return (Criteria) this;
        }

        public Criteria andResUserIdIsNotNull() {
            addCriterion("res_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andResUserIdEqualTo(Long value) {
            addCriterion("res_user_id =", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdNotEqualTo(Long value) {
            addCriterion("res_user_id <>", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdGreaterThan(Long value) {
            addCriterion("res_user_id >", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("res_user_id >=", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdLessThan(Long value) {
            addCriterion("res_user_id <", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdLessThanOrEqualTo(Long value) {
            addCriterion("res_user_id <=", value, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdIn(List<Long> values) {
            addCriterion("res_user_id in", values, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdNotIn(List<Long> values) {
            addCriterion("res_user_id not in", values, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdBetween(Long value1, Long value2) {
            addCriterion("res_user_id between", value1, value2, "resUserId");
            return (Criteria) this;
        }

        public Criteria andResUserIdNotBetween(Long value1, Long value2) {
            addCriterion("res_user_id not between", value1, value2, "resUserId");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNull() {
            addCriterion("applicant_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNotNull() {
            addCriterion("applicant_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameEqualTo(String value) {
            addCriterion("applicant_name =", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotEqualTo(String value) {
            addCriterion("applicant_name <>", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThan(String value) {
            addCriterion("applicant_name >", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_name >=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThan(String value) {
            addCriterion("applicant_name <", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_name <=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLike(String value) {
            addCriterion("applicant_name like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotLike(String value) {
            addCriterion("applicant_name not like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIn(List<String> values) {
            addCriterion("applicant_name in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotIn(List<String> values) {
            addCriterion("applicant_name not in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameBetween(String value1, String value2) {
            addCriterion("applicant_name between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotBetween(String value1, String value2) {
            addCriterion("applicant_name not between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNull() {
            addCriterion("applicant_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNotNull() {
            addCriterion("applicant_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneEqualTo(String value) {
            addCriterion("applicant_phone =", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotEqualTo(String value) {
            addCriterion("applicant_phone <>", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThan(String value) {
            addCriterion("applicant_phone >", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_phone >=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThan(String value) {
            addCriterion("applicant_phone <", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThanOrEqualTo(String value) {
            addCriterion("applicant_phone <=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLike(String value) {
            addCriterion("applicant_phone like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotLike(String value) {
            addCriterion("applicant_phone not like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIn(List<String> values) {
            addCriterion("applicant_phone in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotIn(List<String> values) {
            addCriterion("applicant_phone not in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneBetween(String value1, String value2) {
            addCriterion("applicant_phone between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotBetween(String value1, String value2) {
            addCriterion("applicant_phone not between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantDateIsNull() {
            addCriterion("applicant_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicantDateIsNotNull() {
            addCriterion("applicant_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantDateEqualTo(Date value) {
            addCriterion("applicant_date =", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateNotEqualTo(Date value) {
            addCriterion("applicant_date <>", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateGreaterThan(Date value) {
            addCriterion("applicant_date >", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateGreaterThanOrEqualTo(Date value) {
            addCriterion("applicant_date >=", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateLessThan(Date value) {
            addCriterion("applicant_date <", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateLessThanOrEqualTo(Date value) {
            addCriterion("applicant_date <=", value, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateIn(List<Date> values) {
            addCriterion("applicant_date in", values, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateNotIn(List<Date> values) {
            addCriterion("applicant_date not in", values, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateBetween(Date value1, Date value2) {
            addCriterion("applicant_date between", value1, value2, "applicantDate");
            return (Criteria) this;
        }

        public Criteria andApplicantDateNotBetween(Date value1, Date value2) {
            addCriterion("applicant_date not between", value1, value2, "applicantDate");
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