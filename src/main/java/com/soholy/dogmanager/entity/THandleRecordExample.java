package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THandleRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public THandleRecordExample() {
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

        public Criteria andHandleIdIsNull() {
            addCriterion("handle_id is null");
            return (Criteria) this;
        }

        public Criteria andHandleIdIsNotNull() {
            addCriterion("handle_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandleIdEqualTo(Long value) {
            addCriterion("handle_id =", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotEqualTo(Long value) {
            addCriterion("handle_id <>", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdGreaterThan(Long value) {
            addCriterion("handle_id >", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("handle_id >=", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdLessThan(Long value) {
            addCriterion("handle_id <", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdLessThanOrEqualTo(Long value) {
            addCriterion("handle_id <=", value, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdIn(List<Long> values) {
            addCriterion("handle_id in", values, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotIn(List<Long> values) {
            addCriterion("handle_id not in", values, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdBetween(Long value1, Long value2) {
            addCriterion("handle_id between", value1, value2, "handleId");
            return (Criteria) this;
        }

        public Criteria andHandleIdNotBetween(Long value1, Long value2) {
            addCriterion("handle_id not between", value1, value2, "handleId");
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

        public Criteria andClaimNameIsNull() {
            addCriterion("claim_name is null");
            return (Criteria) this;
        }

        public Criteria andClaimNameIsNotNull() {
            addCriterion("claim_name is not null");
            return (Criteria) this;
        }

        public Criteria andClaimNameEqualTo(String value) {
            addCriterion("claim_name =", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameNotEqualTo(String value) {
            addCriterion("claim_name <>", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameGreaterThan(String value) {
            addCriterion("claim_name >", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameGreaterThanOrEqualTo(String value) {
            addCriterion("claim_name >=", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameLessThan(String value) {
            addCriterion("claim_name <", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameLessThanOrEqualTo(String value) {
            addCriterion("claim_name <=", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameLike(String value) {
            addCriterion("claim_name like", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameNotLike(String value) {
            addCriterion("claim_name not like", value, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameIn(List<String> values) {
            addCriterion("claim_name in", values, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameNotIn(List<String> values) {
            addCriterion("claim_name not in", values, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameBetween(String value1, String value2) {
            addCriterion("claim_name between", value1, value2, "claimName");
            return (Criteria) this;
        }

        public Criteria andClaimNameNotBetween(String value1, String value2) {
            addCriterion("claim_name not between", value1, value2, "claimName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andCardNumIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("card_num =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("card_num <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("card_num >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("card_num <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("card_num like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("card_num not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("card_num in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("card_num not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andHandleReasonIsNull() {
            addCriterion("handle_reason is null");
            return (Criteria) this;
        }

        public Criteria andHandleReasonIsNotNull() {
            addCriterion("handle_reason is not null");
            return (Criteria) this;
        }

        public Criteria andHandleReasonEqualTo(String value) {
            addCriterion("handle_reason =", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonNotEqualTo(String value) {
            addCriterion("handle_reason <>", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonGreaterThan(String value) {
            addCriterion("handle_reason >", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonGreaterThanOrEqualTo(String value) {
            addCriterion("handle_reason >=", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonLessThan(String value) {
            addCriterion("handle_reason <", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonLessThanOrEqualTo(String value) {
            addCriterion("handle_reason <=", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonLike(String value) {
            addCriterion("handle_reason like", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonNotLike(String value) {
            addCriterion("handle_reason not like", value, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonIn(List<String> values) {
            addCriterion("handle_reason in", values, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonNotIn(List<String> values) {
            addCriterion("handle_reason not in", values, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonBetween(String value1, String value2) {
            addCriterion("handle_reason between", value1, value2, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleReasonNotBetween(String value1, String value2) {
            addCriterion("handle_reason not between", value1, value2, "handleReason");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIsNull() {
            addCriterion("handle_type is null");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIsNotNull() {
            addCriterion("handle_type is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTypeEqualTo(Integer value) {
            addCriterion("handle_type =", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotEqualTo(Integer value) {
            addCriterion("handle_type <>", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeGreaterThan(Integer value) {
            addCriterion("handle_type >", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("handle_type >=", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeLessThan(Integer value) {
            addCriterion("handle_type <", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("handle_type <=", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIn(List<Integer> values) {
            addCriterion("handle_type in", values, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotIn(List<Integer> values) {
            addCriterion("handle_type not in", values, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeBetween(Integer value1, Integer value2) {
            addCriterion("handle_type between", value1, value2, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("handle_type not between", value1, value2, "handleType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Integer value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Integer value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Integer value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Integer value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Integer> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Integer> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Integer value1, Integer value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andHandleWayIsNull() {
            addCriterion("handle_way is null");
            return (Criteria) this;
        }

        public Criteria andHandleWayIsNotNull() {
            addCriterion("handle_way is not null");
            return (Criteria) this;
        }

        public Criteria andHandleWayEqualTo(String value) {
            addCriterion("handle_way =", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayNotEqualTo(String value) {
            addCriterion("handle_way <>", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayGreaterThan(String value) {
            addCriterion("handle_way >", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayGreaterThanOrEqualTo(String value) {
            addCriterion("handle_way >=", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayLessThan(String value) {
            addCriterion("handle_way <", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayLessThanOrEqualTo(String value) {
            addCriterion("handle_way <=", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayLike(String value) {
            addCriterion("handle_way like", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayNotLike(String value) {
            addCriterion("handle_way not like", value, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayIn(List<String> values) {
            addCriterion("handle_way in", values, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayNotIn(List<String> values) {
            addCriterion("handle_way not in", values, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayBetween(String value1, String value2) {
            addCriterion("handle_way between", value1, value2, "handleWay");
            return (Criteria) this;
        }

        public Criteria andHandleWayNotBetween(String value1, String value2) {
            addCriterion("handle_way not between", value1, value2, "handleWay");
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