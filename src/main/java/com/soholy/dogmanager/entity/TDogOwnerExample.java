package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDogOwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDogOwnerExample() {
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

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Long value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Long value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Long value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Long value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Long value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Long value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Long> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Long> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Long value1, Long value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Long value1, Long value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNull() {
            addCriterion("community is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNotNull() {
            addCriterion("community is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityEqualTo(String value) {
            addCriterion("community =", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotEqualTo(String value) {
            addCriterion("community <>", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThan(String value) {
            addCriterion("community >", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("community >=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThan(String value) {
            addCriterion("community <", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThanOrEqualTo(String value) {
            addCriterion("community <=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLike(String value) {
            addCriterion("community like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotLike(String value) {
            addCriterion("community not like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityIn(List<String> values) {
            addCriterion("community in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotIn(List<String> values) {
            addCriterion("community not in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityBetween(String value1, String value2) {
            addCriterion("community between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotBetween(String value1, String value2) {
            addCriterion("community not between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeIsNull() {
            addCriterion("dog_owner_type is null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeIsNotNull() {
            addCriterion("dog_owner_type is not null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeEqualTo(Integer value) {
            addCriterion("dog_owner_type =", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeNotEqualTo(Integer value) {
            addCriterion("dog_owner_type <>", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeGreaterThan(Integer value) {
            addCriterion("dog_owner_type >", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_owner_type >=", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeLessThan(Integer value) {
            addCriterion("dog_owner_type <", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dog_owner_type <=", value, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeIn(List<Integer> values) {
            addCriterion("dog_owner_type in", values, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeNotIn(List<Integer> values) {
            addCriterion("dog_owner_type not in", values, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeBetween(Integer value1, Integer value2) {
            addCriterion("dog_owner_type between", value1, value2, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_owner_type not between", value1, value2, "dogOwnerType");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameIsNull() {
            addCriterion("dog_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameIsNotNull() {
            addCriterion("dog_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameEqualTo(String value) {
            addCriterion("dog_owner_name =", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameNotEqualTo(String value) {
            addCriterion("dog_owner_name <>", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameGreaterThan(String value) {
            addCriterion("dog_owner_name >", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("dog_owner_name >=", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameLessThan(String value) {
            addCriterion("dog_owner_name <", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("dog_owner_name <=", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameLike(String value) {
            addCriterion("dog_owner_name like", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameNotLike(String value) {
            addCriterion("dog_owner_name not like", value, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameIn(List<String> values) {
            addCriterion("dog_owner_name in", values, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameNotIn(List<String> values) {
            addCriterion("dog_owner_name not in", values, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameBetween(String value1, String value2) {
            addCriterion("dog_owner_name between", value1, value2, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerNameNotBetween(String value1, String value2) {
            addCriterion("dog_owner_name not between", value1, value2, "dogOwnerName");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneIsNull() {
            addCriterion("dog_owner_phone is null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneIsNotNull() {
            addCriterion("dog_owner_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneEqualTo(String value) {
            addCriterion("dog_owner_phone =", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneNotEqualTo(String value) {
            addCriterion("dog_owner_phone <>", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneGreaterThan(String value) {
            addCriterion("dog_owner_phone >", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("dog_owner_phone >=", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneLessThan(String value) {
            addCriterion("dog_owner_phone <", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("dog_owner_phone <=", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneLike(String value) {
            addCriterion("dog_owner_phone like", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneNotLike(String value) {
            addCriterion("dog_owner_phone not like", value, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneIn(List<String> values) {
            addCriterion("dog_owner_phone in", values, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneNotIn(List<String> values) {
            addCriterion("dog_owner_phone not in", values, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneBetween(String value1, String value2) {
            addCriterion("dog_owner_phone between", value1, value2, "dogOwnerPhone");
            return (Criteria) this;
        }

        public Criteria andDogOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("dog_owner_phone not between", value1, value2, "dogOwnerPhone");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andEMailIsNull() {
            addCriterion("e_mail is null");
            return (Criteria) this;
        }

        public Criteria andEMailIsNotNull() {
            addCriterion("e_mail is not null");
            return (Criteria) this;
        }

        public Criteria andEMailEqualTo(String value) {
            addCriterion("e_mail =", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotEqualTo(String value) {
            addCriterion("e_mail <>", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThan(String value) {
            addCriterion("e_mail >", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThanOrEqualTo(String value) {
            addCriterion("e_mail >=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThan(String value) {
            addCriterion("e_mail <", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThanOrEqualTo(String value) {
            addCriterion("e_mail <=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLike(String value) {
            addCriterion("e_mail like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotLike(String value) {
            addCriterion("e_mail not like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailIn(List<String> values) {
            addCriterion("e_mail in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotIn(List<String> values) {
            addCriterion("e_mail not in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailBetween(String value1, String value2) {
            addCriterion("e_mail between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotBetween(String value1, String value2) {
            addCriterion("e_mail not between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNull() {
            addCriterion("postal_code is null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNotNull() {
            addCriterion("postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeEqualTo(String value) {
            addCriterion("postal_code =", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotEqualTo(String value) {
            addCriterion("postal_code <>", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThan(String value) {
            addCriterion("postal_code >", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("postal_code >=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThan(String value) {
            addCriterion("postal_code <", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("postal_code <=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLike(String value) {
            addCriterion("postal_code like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotLike(String value) {
            addCriterion("postal_code not like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIn(List<String> values) {
            addCriterion("postal_code in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotIn(List<String> values) {
            addCriterion("postal_code not in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeBetween(String value1, String value2) {
            addCriterion("postal_code between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotBetween(String value1, String value2) {
            addCriterion("postal_code not between", value1, value2, "postalCode");
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

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
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