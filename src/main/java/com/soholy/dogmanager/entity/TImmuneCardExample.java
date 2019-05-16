package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TImmuneCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TImmuneCardExample() {
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

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Long value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Long value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Long value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Long value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Long value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Long> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Long> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Long value1, Long value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Long value1, Long value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
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

        public Criteria andMemberCardIdIsNull() {
            addCriterion("member_card_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdIsNotNull() {
            addCriterion("member_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdEqualTo(Long value) {
            addCriterion("member_card_id =", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdNotEqualTo(Long value) {
            addCriterion("member_card_id <>", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdGreaterThan(Long value) {
            addCriterion("member_card_id >", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_card_id >=", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdLessThan(Long value) {
            addCriterion("member_card_id <", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdLessThanOrEqualTo(Long value) {
            addCriterion("member_card_id <=", value, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdIn(List<Long> values) {
            addCriterion("member_card_id in", values, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdNotIn(List<Long> values) {
            addCriterion("member_card_id not in", values, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdBetween(Long value1, Long value2) {
            addCriterion("member_card_id between", value1, value2, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andMemberCardIdNotBetween(Long value1, Long value2) {
            addCriterion("member_card_id not between", value1, value2, "memberCardId");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumIsNull() {
            addCriterion("immune_card_num is null");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumIsNotNull() {
            addCriterion("immune_card_num is not null");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumEqualTo(String value) {
            addCriterion("immune_card_num =", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumNotEqualTo(String value) {
            addCriterion("immune_card_num <>", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumGreaterThan(String value) {
            addCriterion("immune_card_num >", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("immune_card_num >=", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumLessThan(String value) {
            addCriterion("immune_card_num <", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumLessThanOrEqualTo(String value) {
            addCriterion("immune_card_num <=", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumLike(String value) {
            addCriterion("immune_card_num like", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumNotLike(String value) {
            addCriterion("immune_card_num not like", value, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumIn(List<String> values) {
            addCriterion("immune_card_num in", values, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumNotIn(List<String> values) {
            addCriterion("immune_card_num not in", values, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumBetween(String value1, String value2) {
            addCriterion("immune_card_num between", value1, value2, "immuneCardNum");
            return (Criteria) this;
        }

        public Criteria andImmuneCardNumNotBetween(String value1, String value2) {
            addCriterion("immune_card_num not between", value1, value2, "immuneCardNum");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeIsNull() {
            addCriterion("lssue_time is null");
            return (Criteria) this;
        }

        public Criteria andLssueTimeIsNotNull() {
            addCriterion("lssue_time is not null");
            return (Criteria) this;
        }

        public Criteria andLssueTimeEqualTo(Date value) {
            addCriterion("lssue_time =", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeNotEqualTo(Date value) {
            addCriterion("lssue_time <>", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeGreaterThan(Date value) {
            addCriterion("lssue_time >", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lssue_time >=", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeLessThan(Date value) {
            addCriterion("lssue_time <", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeLessThanOrEqualTo(Date value) {
            addCriterion("lssue_time <=", value, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeIn(List<Date> values) {
            addCriterion("lssue_time in", values, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeNotIn(List<Date> values) {
            addCriterion("lssue_time not in", values, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeBetween(Date value1, Date value2) {
            addCriterion("lssue_time between", value1, value2, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueTimeNotBetween(Date value1, Date value2) {
            addCriterion("lssue_time not between", value1, value2, "lssueTime");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdIsNull() {
            addCriterion("lssue_org_id is null");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdIsNotNull() {
            addCriterion("lssue_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdEqualTo(Integer value) {
            addCriterion("lssue_org_id =", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdNotEqualTo(Integer value) {
            addCriterion("lssue_org_id <>", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdGreaterThan(Integer value) {
            addCriterion("lssue_org_id >", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lssue_org_id >=", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdLessThan(Integer value) {
            addCriterion("lssue_org_id <", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("lssue_org_id <=", value, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdIn(List<Integer> values) {
            addCriterion("lssue_org_id in", values, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdNotIn(List<Integer> values) {
            addCriterion("lssue_org_id not in", values, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("lssue_org_id between", value1, value2, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssueOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lssue_org_id not between", value1, value2, "lssueOrgId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdIsNull() {
            addCriterion("lssuer_id is null");
            return (Criteria) this;
        }

        public Criteria andLssuerIdIsNotNull() {
            addCriterion("lssuer_id is not null");
            return (Criteria) this;
        }

        public Criteria andLssuerIdEqualTo(Long value) {
            addCriterion("lssuer_id =", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdNotEqualTo(Long value) {
            addCriterion("lssuer_id <>", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdGreaterThan(Long value) {
            addCriterion("lssuer_id >", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lssuer_id >=", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdLessThan(Long value) {
            addCriterion("lssuer_id <", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdLessThanOrEqualTo(Long value) {
            addCriterion("lssuer_id <=", value, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdIn(List<Long> values) {
            addCriterion("lssuer_id in", values, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdNotIn(List<Long> values) {
            addCriterion("lssuer_id not in", values, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdBetween(Long value1, Long value2) {
            addCriterion("lssuer_id between", value1, value2, "lssuerId");
            return (Criteria) this;
        }

        public Criteria andLssuerIdNotBetween(Long value1, Long value2) {
            addCriterion("lssuer_id not between", value1, value2, "lssuerId");
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