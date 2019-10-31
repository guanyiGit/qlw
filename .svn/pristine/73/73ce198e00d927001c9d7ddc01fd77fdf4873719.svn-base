package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCollectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCollectionExample() {
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

        public Criteria andDogCodeIsNull() {
            addCriterion("dog_code is null");
            return (Criteria) this;
        }

        public Criteria andDogCodeIsNotNull() {
            addCriterion("dog_code is not null");
            return (Criteria) this;
        }

        public Criteria andDogCodeEqualTo(String value) {
            addCriterion("dog_code =", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeNotEqualTo(String value) {
            addCriterion("dog_code <>", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeGreaterThan(String value) {
            addCriterion("dog_code >", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dog_code >=", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeLessThan(String value) {
            addCriterion("dog_code <", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeLessThanOrEqualTo(String value) {
            addCriterion("dog_code <=", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeLike(String value) {
            addCriterion("dog_code like", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeNotLike(String value) {
            addCriterion("dog_code not like", value, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeIn(List<String> values) {
            addCriterion("dog_code in", values, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeNotIn(List<String> values) {
            addCriterion("dog_code not in", values, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeBetween(String value1, String value2) {
            addCriterion("dog_code between", value1, value2, "dogCode");
            return (Criteria) this;
        }

        public Criteria andDogCodeNotBetween(String value1, String value2) {
            addCriterion("dog_code not between", value1, value2, "dogCode");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeIsNull() {
            addCriterion("signboard_code is null");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeIsNotNull() {
            addCriterion("signboard_code is not null");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeEqualTo(String value) {
            addCriterion("signboard_code =", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeNotEqualTo(String value) {
            addCriterion("signboard_code <>", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeGreaterThan(String value) {
            addCriterion("signboard_code >", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("signboard_code >=", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeLessThan(String value) {
            addCriterion("signboard_code <", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeLessThanOrEqualTo(String value) {
            addCriterion("signboard_code <=", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeLike(String value) {
            addCriterion("signboard_code like", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeNotLike(String value) {
            addCriterion("signboard_code not like", value, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeIn(List<String> values) {
            addCriterion("signboard_code in", values, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeNotIn(List<String> values) {
            addCriterion("signboard_code not in", values, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeBetween(String value1, String value2) {
            addCriterion("signboard_code between", value1, value2, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andSignboardCodeNotBetween(String value1, String value2) {
            addCriterion("signboard_code not between", value1, value2, "signboardCode");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeIsNull() {
            addCriterion("coll_dog_type is null");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeIsNotNull() {
            addCriterion("coll_dog_type is not null");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeEqualTo(Integer value) {
            addCriterion("coll_dog_type =", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeNotEqualTo(Integer value) {
            addCriterion("coll_dog_type <>", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeGreaterThan(Integer value) {
            addCriterion("coll_dog_type >", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coll_dog_type >=", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeLessThan(Integer value) {
            addCriterion("coll_dog_type <", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coll_dog_type <=", value, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeIn(List<Integer> values) {
            addCriterion("coll_dog_type in", values, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeNotIn(List<Integer> values) {
            addCriterion("coll_dog_type not in", values, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeBetween(Integer value1, Integer value2) {
            addCriterion("coll_dog_type between", value1, value2, "collDogType");
            return (Criteria) this;
        }

        public Criteria andCollDogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coll_dog_type not between", value1, value2, "collDogType");
            return (Criteria) this;
        }

        public Criteria andDogNameIsNull() {
            addCriterion("dog_name is null");
            return (Criteria) this;
        }

        public Criteria andDogNameIsNotNull() {
            addCriterion("dog_name is not null");
            return (Criteria) this;
        }

        public Criteria andDogNameEqualTo(String value) {
            addCriterion("dog_name =", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotEqualTo(String value) {
            addCriterion("dog_name <>", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameGreaterThan(String value) {
            addCriterion("dog_name >", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameGreaterThanOrEqualTo(String value) {
            addCriterion("dog_name >=", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLessThan(String value) {
            addCriterion("dog_name <", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLessThanOrEqualTo(String value) {
            addCriterion("dog_name <=", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameLike(String value) {
            addCriterion("dog_name like", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotLike(String value) {
            addCriterion("dog_name not like", value, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameIn(List<String> values) {
            addCriterion("dog_name in", values, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotIn(List<String> values) {
            addCriterion("dog_name not in", values, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameBetween(String value1, String value2) {
            addCriterion("dog_name between", value1, value2, "dogName");
            return (Criteria) this;
        }

        public Criteria andDogNameNotBetween(String value1, String value2) {
            addCriterion("dog_name not between", value1, value2, "dogName");
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

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collection_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collection_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Date value) {
            addCriterion("collection_time =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Date value) {
            addCriterion("collection_time <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Date value) {
            addCriterion("collection_time >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collection_time >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Date value) {
            addCriterion("collection_time <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("collection_time <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Date> values) {
            addCriterion("collection_time in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Date> values) {
            addCriterion("collection_time not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Date value1, Date value2) {
            addCriterion("collection_time between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("collection_time not between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumIsNull() {
            addCriterion("doghouse_num is null");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumIsNotNull() {
            addCriterion("doghouse_num is not null");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumEqualTo(String value) {
            addCriterion("doghouse_num =", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumNotEqualTo(String value) {
            addCriterion("doghouse_num <>", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumGreaterThan(String value) {
            addCriterion("doghouse_num >", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumGreaterThanOrEqualTo(String value) {
            addCriterion("doghouse_num >=", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumLessThan(String value) {
            addCriterion("doghouse_num <", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumLessThanOrEqualTo(String value) {
            addCriterion("doghouse_num <=", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumLike(String value) {
            addCriterion("doghouse_num like", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumNotLike(String value) {
            addCriterion("doghouse_num not like", value, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumIn(List<String> values) {
            addCriterion("doghouse_num in", values, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumNotIn(List<String> values) {
            addCriterion("doghouse_num not in", values, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumBetween(String value1, String value2) {
            addCriterion("doghouse_num between", value1, value2, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andDoghouseNumNotBetween(String value1, String value2) {
            addCriterion("doghouse_num not between", value1, value2, "doghouseNum");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNull() {
            addCriterion("result_type is null");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNotNull() {
            addCriterion("result_type is not null");
            return (Criteria) this;
        }

        public Criteria andResultTypeEqualTo(Integer value) {
            addCriterion("result_type =", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotEqualTo(Integer value) {
            addCriterion("result_type <>", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThan(Integer value) {
            addCriterion("result_type >", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_type >=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThan(Integer value) {
            addCriterion("result_type <", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThanOrEqualTo(Integer value) {
            addCriterion("result_type <=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeIn(List<Integer> values) {
            addCriterion("result_type in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotIn(List<Integer> values) {
            addCriterion("result_type not in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeBetween(Integer value1, Integer value2) {
            addCriterion("result_type between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("result_type not between", value1, value2, "resultType");
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

        public Criteria andDogGenderIsNull() {
            addCriterion("dog_gender is null");
            return (Criteria) this;
        }

        public Criteria andDogGenderIsNotNull() {
            addCriterion("dog_gender is not null");
            return (Criteria) this;
        }

        public Criteria andDogGenderEqualTo(Integer value) {
            addCriterion("dog_gender =", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderNotEqualTo(Integer value) {
            addCriterion("dog_gender <>", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderGreaterThan(Integer value) {
            addCriterion("dog_gender >", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_gender >=", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderLessThan(Integer value) {
            addCriterion("dog_gender <", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderLessThanOrEqualTo(Integer value) {
            addCriterion("dog_gender <=", value, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderIn(List<Integer> values) {
            addCriterion("dog_gender in", values, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderNotIn(List<Integer> values) {
            addCriterion("dog_gender not in", values, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderBetween(Integer value1, Integer value2) {
            addCriterion("dog_gender between", value1, value2, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_gender not between", value1, value2, "dogGender");
            return (Criteria) this;
        }

        public Criteria andDogCharacterIsNull() {
            addCriterion("dog_character is null");
            return (Criteria) this;
        }

        public Criteria andDogCharacterIsNotNull() {
            addCriterion("dog_character is not null");
            return (Criteria) this;
        }

        public Criteria andDogCharacterEqualTo(String value) {
            addCriterion("dog_character =", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterNotEqualTo(String value) {
            addCriterion("dog_character <>", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterGreaterThan(String value) {
            addCriterion("dog_character >", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("dog_character >=", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterLessThan(String value) {
            addCriterion("dog_character <", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterLessThanOrEqualTo(String value) {
            addCriterion("dog_character <=", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterLike(String value) {
            addCriterion("dog_character like", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterNotLike(String value) {
            addCriterion("dog_character not like", value, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterIn(List<String> values) {
            addCriterion("dog_character in", values, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterNotIn(List<String> values) {
            addCriterion("dog_character not in", values, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterBetween(String value1, String value2) {
            addCriterion("dog_character between", value1, value2, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogCharacterNotBetween(String value1, String value2) {
            addCriterion("dog_character not between", value1, value2, "dogCharacter");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeIsNull() {
            addCriterion("dog_breed_type is null");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeIsNotNull() {
            addCriterion("dog_breed_type is not null");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeEqualTo(Integer value) {
            addCriterion("dog_breed_type =", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeNotEqualTo(Integer value) {
            addCriterion("dog_breed_type <>", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeGreaterThan(Integer value) {
            addCriterion("dog_breed_type >", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_breed_type >=", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeLessThan(Integer value) {
            addCriterion("dog_breed_type <", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dog_breed_type <=", value, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeIn(List<Integer> values) {
            addCriterion("dog_breed_type in", values, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeNotIn(List<Integer> values) {
            addCriterion("dog_breed_type not in", values, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeBetween(Integer value1, Integer value2) {
            addCriterion("dog_breed_type between", value1, value2, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogBreedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_breed_type not between", value1, value2, "dogBreedType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeIsNull() {
            addCriterion("dog_color_type is null");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeIsNotNull() {
            addCriterion("dog_color_type is not null");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeEqualTo(Integer value) {
            addCriterion("dog_color_type =", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeNotEqualTo(Integer value) {
            addCriterion("dog_color_type <>", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeGreaterThan(Integer value) {
            addCriterion("dog_color_type >", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_color_type >=", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeLessThan(Integer value) {
            addCriterion("dog_color_type <", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dog_color_type <=", value, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeIn(List<Integer> values) {
            addCriterion("dog_color_type in", values, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeNotIn(List<Integer> values) {
            addCriterion("dog_color_type not in", values, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeBetween(Integer value1, Integer value2) {
            addCriterion("dog_color_type between", value1, value2, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andDogColorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_color_type not between", value1, value2, "dogColorType");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andDogAgeIsNull() {
            addCriterion("dog_age is null");
            return (Criteria) this;
        }

        public Criteria andDogAgeIsNotNull() {
            addCriterion("dog_age is not null");
            return (Criteria) this;
        }

        public Criteria andDogAgeEqualTo(Integer value) {
            addCriterion("dog_age =", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotEqualTo(Integer value) {
            addCriterion("dog_age <>", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeGreaterThan(Integer value) {
            addCriterion("dog_age >", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_age >=", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeLessThan(Integer value) {
            addCriterion("dog_age <", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeLessThanOrEqualTo(Integer value) {
            addCriterion("dog_age <=", value, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeIn(List<Integer> values) {
            addCriterion("dog_age in", values, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotIn(List<Integer> values) {
            addCriterion("dog_age not in", values, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeBetween(Integer value1, Integer value2) {
            addCriterion("dog_age between", value1, value2, "dogAge");
            return (Criteria) this;
        }

        public Criteria andDogAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_age not between", value1, value2, "dogAge");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIsNull() {
            addCriterion("health_status is null");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIsNotNull() {
            addCriterion("health_status is not null");
            return (Criteria) this;
        }

        public Criteria andHealthStatusEqualTo(Integer value) {
            addCriterion("health_status =", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotEqualTo(Integer value) {
            addCriterion("health_status <>", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusGreaterThan(Integer value) {
            addCriterion("health_status >", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("health_status >=", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusLessThan(Integer value) {
            addCriterion("health_status <", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusLessThanOrEqualTo(Integer value) {
            addCriterion("health_status <=", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIn(List<Integer> values) {
            addCriterion("health_status in", values, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotIn(List<Integer> values) {
            addCriterion("health_status not in", values, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusBetween(Integer value1, Integer value2) {
            addCriterion("health_status between", value1, value2, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("health_status not between", value1, value2, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeIsNull() {
            addCriterion("handling_time is null");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeIsNotNull() {
            addCriterion("handling_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeEqualTo(Date value) {
            addCriterion("handling_time =", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeNotEqualTo(Date value) {
            addCriterion("handling_time <>", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeGreaterThan(Date value) {
            addCriterion("handling_time >", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handling_time >=", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeLessThan(Date value) {
            addCriterion("handling_time <", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeLessThanOrEqualTo(Date value) {
            addCriterion("handling_time <=", value, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeIn(List<Date> values) {
            addCriterion("handling_time in", values, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeNotIn(List<Date> values) {
            addCriterion("handling_time not in", values, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeBetween(Date value1, Date value2) {
            addCriterion("handling_time between", value1, value2, "handlingTime");
            return (Criteria) this;
        }

        public Criteria andHandlingTimeNotBetween(Date value1, Date value2) {
            addCriterion("handling_time not between", value1, value2, "handlingTime");
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