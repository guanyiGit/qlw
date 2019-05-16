package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAppointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAppointmentExample() {
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

        public Criteria andAppointmentIdIsNull() {
            addCriterion("appointment_id is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdIsNotNull() {
            addCriterion("appointment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdEqualTo(Long value) {
            addCriterion("appointment_id =", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdNotEqualTo(Long value) {
            addCriterion("appointment_id <>", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdGreaterThan(Long value) {
            addCriterion("appointment_id >", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("appointment_id >=", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdLessThan(Long value) {
            addCriterion("appointment_id <", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdLessThanOrEqualTo(Long value) {
            addCriterion("appointment_id <=", value, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdIn(List<Long> values) {
            addCriterion("appointment_id in", values, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdNotIn(List<Long> values) {
            addCriterion("appointment_id not in", values, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdBetween(Long value1, Long value2) {
            addCriterion("appointment_id between", value1, value2, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andAppointmentIdNotBetween(Long value1, Long value2) {
            addCriterion("appointment_id not between", value1, value2, "appointmentId");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("biz_type is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(Integer value) {
            addCriterion("biz_type =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(Integer value) {
            addCriterion("biz_type <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(Integer value) {
            addCriterion("biz_type >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("biz_type >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(Integer value) {
            addCriterion("biz_type <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(Integer value) {
            addCriterion("biz_type <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<Integer> values) {
            addCriterion("biz_type in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<Integer> values) {
            addCriterion("biz_type not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(Integer value1, Integer value2) {
            addCriterion("biz_type between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("biz_type not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameIsNull() {
            addCriterion("appointment_name is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameIsNotNull() {
            addCriterion("appointment_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameEqualTo(String value) {
            addCriterion("appointment_name =", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameNotEqualTo(String value) {
            addCriterion("appointment_name <>", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameGreaterThan(String value) {
            addCriterion("appointment_name >", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_name >=", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameLessThan(String value) {
            addCriterion("appointment_name <", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameLessThanOrEqualTo(String value) {
            addCriterion("appointment_name <=", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameLike(String value) {
            addCriterion("appointment_name like", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameNotLike(String value) {
            addCriterion("appointment_name not like", value, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameIn(List<String> values) {
            addCriterion("appointment_name in", values, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameNotIn(List<String> values) {
            addCriterion("appointment_name not in", values, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameBetween(String value1, String value2) {
            addCriterion("appointment_name between", value1, value2, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentNameNotBetween(String value1, String value2) {
            addCriterion("appointment_name not between", value1, value2, "appointmentName");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIsNull() {
            addCriterion("appointment_phone is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIsNotNull() {
            addCriterion("appointment_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneEqualTo(String value) {
            addCriterion("appointment_phone =", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotEqualTo(String value) {
            addCriterion("appointment_phone <>", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneGreaterThan(String value) {
            addCriterion("appointment_phone >", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_phone >=", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLessThan(String value) {
            addCriterion("appointment_phone <", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLessThanOrEqualTo(String value) {
            addCriterion("appointment_phone <=", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneLike(String value) {
            addCriterion("appointment_phone like", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotLike(String value) {
            addCriterion("appointment_phone not like", value, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneIn(List<String> values) {
            addCriterion("appointment_phone in", values, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotIn(List<String> values) {
            addCriterion("appointment_phone not in", values, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneBetween(String value1, String value2) {
            addCriterion("appointment_phone between", value1, value2, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentPhoneNotBetween(String value1, String value2) {
            addCriterion("appointment_phone not between", value1, value2, "appointmentPhone");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelIsNull() {
            addCriterion("appointment_channel is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelIsNotNull() {
            addCriterion("appointment_channel is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelEqualTo(Integer value) {
            addCriterion("appointment_channel =", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelNotEqualTo(Integer value) {
            addCriterion("appointment_channel <>", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelGreaterThan(Integer value) {
            addCriterion("appointment_channel >", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("appointment_channel >=", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelLessThan(Integer value) {
            addCriterion("appointment_channel <", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelLessThanOrEqualTo(Integer value) {
            addCriterion("appointment_channel <=", value, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelIn(List<Integer> values) {
            addCriterion("appointment_channel in", values, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelNotIn(List<Integer> values) {
            addCriterion("appointment_channel not in", values, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelBetween(Integer value1, Integer value2) {
            addCriterion("appointment_channel between", value1, value2, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andAppointmentChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("appointment_channel not between", value1, value2, "appointmentChannel");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIsNull() {
            addCriterion("schedule_time is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIsNotNull() {
            addCriterion("schedule_time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeEqualTo(Date value) {
            addCriterion("schedule_time =", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotEqualTo(Date value) {
            addCriterion("schedule_time <>", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeGreaterThan(Date value) {
            addCriterion("schedule_time >", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("schedule_time >=", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeLessThan(Date value) {
            addCriterion("schedule_time <", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeLessThanOrEqualTo(Date value) {
            addCriterion("schedule_time <=", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIn(List<Date> values) {
            addCriterion("schedule_time in", values, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotIn(List<Date> values) {
            addCriterion("schedule_time not in", values, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeBetween(Date value1, Date value2) {
            addCriterion("schedule_time between", value1, value2, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotBetween(Date value1, Date value2) {
            addCriterion("schedule_time not between", value1, value2, "scheduleTime");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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