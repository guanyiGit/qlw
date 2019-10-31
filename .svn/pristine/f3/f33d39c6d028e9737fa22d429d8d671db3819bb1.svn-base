package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskLevelIsNull() {
            addCriterion("task_level is null");
            return (Criteria) this;
        }

        public Criteria andTaskLevelIsNotNull() {
            addCriterion("task_level is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLevelEqualTo(Integer value) {
            addCriterion("task_level =", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelNotEqualTo(Integer value) {
            addCriterion("task_level <>", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelGreaterThan(Integer value) {
            addCriterion("task_level >", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_level >=", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelLessThan(Integer value) {
            addCriterion("task_level <", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelLessThanOrEqualTo(Integer value) {
            addCriterion("task_level <=", value, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelIn(List<Integer> values) {
            addCriterion("task_level in", values, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelNotIn(List<Integer> values) {
            addCriterion("task_level not in", values, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelBetween(Integer value1, Integer value2) {
            addCriterion("task_level between", value1, value2, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("task_level not between", value1, value2, "taskLevel");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNull() {
            addCriterion("submit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIsNotNull() {
            addCriterion("submit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdEqualTo(Long value) {
            addCriterion("submit_user_id =", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotEqualTo(Long value) {
            addCriterion("submit_user_id <>", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThan(Long value) {
            addCriterion("submit_user_id >", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("submit_user_id >=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThan(Long value) {
            addCriterion("submit_user_id <", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("submit_user_id <=", value, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdIn(List<Long> values) {
            addCriterion("submit_user_id in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotIn(List<Long> values) {
            addCriterion("submit_user_id not in", values, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdBetween(Long value1, Long value2) {
            addCriterion("submit_user_id between", value1, value2, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andSubmitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("submit_user_id not between", value1, value2, "submitUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdIsNull() {
            addCriterion("comp_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCompUserIdIsNotNull() {
            addCriterion("comp_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompUserIdEqualTo(Long value) {
            addCriterion("comp_user_id =", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdNotEqualTo(Long value) {
            addCriterion("comp_user_id <>", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdGreaterThan(Long value) {
            addCriterion("comp_user_id >", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comp_user_id >=", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdLessThan(Long value) {
            addCriterion("comp_user_id <", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdLessThanOrEqualTo(Long value) {
            addCriterion("comp_user_id <=", value, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdIn(List<Long> values) {
            addCriterion("comp_user_id in", values, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdNotIn(List<Long> values) {
            addCriterion("comp_user_id not in", values, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdBetween(Long value1, Long value2) {
            addCriterion("comp_user_id between", value1, value2, "compUserId");
            return (Criteria) this;
        }

        public Criteria andCompUserIdNotBetween(Long value1, Long value2) {
            addCriterion("comp_user_id not between", value1, value2, "compUserId");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskTitileIsNull() {
            addCriterion("task_titile is null");
            return (Criteria) this;
        }

        public Criteria andTaskTitileIsNotNull() {
            addCriterion("task_titile is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTitileEqualTo(String value) {
            addCriterion("task_titile =", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileNotEqualTo(String value) {
            addCriterion("task_titile <>", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileGreaterThan(String value) {
            addCriterion("task_titile >", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileGreaterThanOrEqualTo(String value) {
            addCriterion("task_titile >=", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileLessThan(String value) {
            addCriterion("task_titile <", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileLessThanOrEqualTo(String value) {
            addCriterion("task_titile <=", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileLike(String value) {
            addCriterion("task_titile like", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileNotLike(String value) {
            addCriterion("task_titile not like", value, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileIn(List<String> values) {
            addCriterion("task_titile in", values, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileNotIn(List<String> values) {
            addCriterion("task_titile not in", values, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileBetween(String value1, String value2) {
            addCriterion("task_titile between", value1, value2, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andTaskTitileNotBetween(String value1, String value2) {
            addCriterion("task_titile not between", value1, value2, "taskTitile");
            return (Criteria) this;
        }

        public Criteria andCompTimeIsNull() {
            addCriterion("comp_time is null");
            return (Criteria) this;
        }

        public Criteria andCompTimeIsNotNull() {
            addCriterion("comp_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompTimeEqualTo(Date value) {
            addCriterion("comp_time =", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeNotEqualTo(Date value) {
            addCriterion("comp_time <>", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeGreaterThan(Date value) {
            addCriterion("comp_time >", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comp_time >=", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeLessThan(Date value) {
            addCriterion("comp_time <", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeLessThanOrEqualTo(Date value) {
            addCriterion("comp_time <=", value, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeIn(List<Date> values) {
            addCriterion("comp_time in", values, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeNotIn(List<Date> values) {
            addCriterion("comp_time not in", values, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeBetween(Date value1, Date value2) {
            addCriterion("comp_time between", value1, value2, "compTime");
            return (Criteria) this;
        }

        public Criteria andCompTimeNotBetween(Date value1, Date value2) {
            addCriterion("comp_time not between", value1, value2, "compTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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