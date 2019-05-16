package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDogInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDogInfoExample() {
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

        public Criteria andBirthTimeIsNull() {
            addCriterion("birth_time is null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIsNotNull() {
            addCriterion("birth_time is not null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeEqualTo(Date value) {
            addCriterion("birth_time =", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotEqualTo(Date value) {
            addCriterion("birth_time <>", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThan(Date value) {
            addCriterion("birth_time >", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_time >=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThan(Date value) {
            addCriterion("birth_time <", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThanOrEqualTo(Date value) {
            addCriterion("birth_time <=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIn(List<Date> values) {
            addCriterion("birth_time in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotIn(List<Date> values) {
            addCriterion("birth_time not in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeBetween(Date value1, Date value2) {
            addCriterion("birth_time between", value1, value2, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotBetween(Date value1, Date value2) {
            addCriterion("birth_time not between", value1, value2, "birthTime");
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

        public Criteria andCancellationReasonIsNull() {
            addCriterion("cancellation_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonIsNotNull() {
            addCriterion("cancellation_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonEqualTo(String value) {
            addCriterion("cancellation_reason =", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonNotEqualTo(String value) {
            addCriterion("cancellation_reason <>", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonGreaterThan(String value) {
            addCriterion("cancellation_reason >", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancellation_reason >=", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonLessThan(String value) {
            addCriterion("cancellation_reason <", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonLessThanOrEqualTo(String value) {
            addCriterion("cancellation_reason <=", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonLike(String value) {
            addCriterion("cancellation_reason like", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonNotLike(String value) {
            addCriterion("cancellation_reason not like", value, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonIn(List<String> values) {
            addCriterion("cancellation_reason in", values, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonNotIn(List<String> values) {
            addCriterion("cancellation_reason not in", values, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonBetween(String value1, String value2) {
            addCriterion("cancellation_reason between", value1, value2, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationReasonNotBetween(String value1, String value2) {
            addCriterion("cancellation_reason not between", value1, value2, "cancellationReason");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeIsNull() {
            addCriterion("cancellation_time is null");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeIsNotNull() {
            addCriterion("cancellation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeEqualTo(Date value) {
            addCriterion("cancellation_time =", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeNotEqualTo(Date value) {
            addCriterion("cancellation_time <>", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeGreaterThan(Date value) {
            addCriterion("cancellation_time >", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancellation_time >=", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeLessThan(Date value) {
            addCriterion("cancellation_time <", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancellation_time <=", value, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeIn(List<Date> values) {
            addCriterion("cancellation_time in", values, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeNotIn(List<Date> values) {
            addCriterion("cancellation_time not in", values, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeBetween(Date value1, Date value2) {
            addCriterion("cancellation_time between", value1, value2, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andCancellationTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancellation_time not between", value1, value2, "cancellationTime");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIsNull() {
            addCriterion("deduction_sum is null");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIsNotNull() {
            addCriterion("deduction_sum is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionSumEqualTo(Double value) {
            addCriterion("deduction_sum =", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotEqualTo(Double value) {
            addCriterion("deduction_sum <>", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumGreaterThan(Double value) {
            addCriterion("deduction_sum >", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_sum >=", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumLessThan(Double value) {
            addCriterion("deduction_sum <", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumLessThanOrEqualTo(Double value) {
            addCriterion("deduction_sum <=", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIn(List<Double> values) {
            addCriterion("deduction_sum in", values, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotIn(List<Double> values) {
            addCriterion("deduction_sum not in", values, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumBetween(Double value1, Double value2) {
            addCriterion("deduction_sum between", value1, value2, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotBetween(Double value1, Double value2) {
            addCriterion("deduction_sum not between", value1, value2, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNull() {
            addCriterion("father_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNotNull() {
            addCriterion("father_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdEqualTo(Long value) {
            addCriterion("father_id =", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotEqualTo(Long value) {
            addCriterion("father_id <>", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThan(Long value) {
            addCriterion("father_id >", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("father_id >=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThan(Long value) {
            addCriterion("father_id <", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThanOrEqualTo(Long value) {
            addCriterion("father_id <=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdIn(List<Long> values) {
            addCriterion("father_id in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotIn(List<Long> values) {
            addCriterion("father_id not in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdBetween(Long value1, Long value2) {
            addCriterion("father_id between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotBetween(Long value1, Long value2) {
            addCriterion("father_id not between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdIsNull() {
            addCriterion("mother_id is null");
            return (Criteria) this;
        }

        public Criteria andMotherIdIsNotNull() {
            addCriterion("mother_id is not null");
            return (Criteria) this;
        }

        public Criteria andMotherIdEqualTo(Long value) {
            addCriterion("mother_id =", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdNotEqualTo(Long value) {
            addCriterion("mother_id <>", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdGreaterThan(Long value) {
            addCriterion("mother_id >", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mother_id >=", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdLessThan(Long value) {
            addCriterion("mother_id <", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdLessThanOrEqualTo(Long value) {
            addCriterion("mother_id <=", value, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdIn(List<Long> values) {
            addCriterion("mother_id in", values, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdNotIn(List<Long> values) {
            addCriterion("mother_id not in", values, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdBetween(Long value1, Long value2) {
            addCriterion("mother_id between", value1, value2, "motherId");
            return (Criteria) this;
        }

        public Criteria andMotherIdNotBetween(Long value1, Long value2) {
            addCriterion("mother_id not between", value1, value2, "motherId");
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