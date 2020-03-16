package com.yz.sophia.insight.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelInsightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TravelInsightExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDelayTnumIsNull() {
            addCriterion("delay_tnum is null");
            return (Criteria) this;
        }

        public Criteria andDelayTnumIsNotNull() {
            addCriterion("delay_tnum is not null");
            return (Criteria) this;
        }

        public Criteria andDelayTnumEqualTo(Integer value) {
            addCriterion("delay_tnum =", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumNotEqualTo(Integer value) {
            addCriterion("delay_tnum <>", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumGreaterThan(Integer value) {
            addCriterion("delay_tnum >", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("delay_tnum >=", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumLessThan(Integer value) {
            addCriterion("delay_tnum <", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumLessThanOrEqualTo(Integer value) {
            addCriterion("delay_tnum <=", value, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumIn(List<Integer> values) {
            addCriterion("delay_tnum in", values, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumNotIn(List<Integer> values) {
            addCriterion("delay_tnum not in", values, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumBetween(Integer value1, Integer value2) {
            addCriterion("delay_tnum between", value1, value2, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andDelayTnumNotBetween(Integer value1, Integer value2) {
            addCriterion("delay_tnum not between", value1, value2, "delayTnum");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayIsNull() {
            addCriterion("extensive_delay is null");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayIsNotNull() {
            addCriterion("extensive_delay is not null");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayEqualTo(Integer value) {
            addCriterion("extensive_delay =", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayNotEqualTo(Integer value) {
            addCriterion("extensive_delay <>", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayGreaterThan(Integer value) {
            addCriterion("extensive_delay >", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("extensive_delay >=", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayLessThan(Integer value) {
            addCriterion("extensive_delay <", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayLessThanOrEqualTo(Integer value) {
            addCriterion("extensive_delay <=", value, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayIn(List<Integer> values) {
            addCriterion("extensive_delay in", values, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayNotIn(List<Integer> values) {
            addCriterion("extensive_delay not in", values, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayBetween(Integer value1, Integer value2) {
            addCriterion("extensive_delay between", value1, value2, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andExtensiveDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("extensive_delay not between", value1, value2, "extensiveDelay");
            return (Criteria) this;
        }

        public Criteria andOutActionNumIsNull() {
            addCriterion("out_action_num is null");
            return (Criteria) this;
        }

        public Criteria andOutActionNumIsNotNull() {
            addCriterion("out_action_num is not null");
            return (Criteria) this;
        }

        public Criteria andOutActionNumEqualTo(Integer value) {
            addCriterion("out_action_num =", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumNotEqualTo(Integer value) {
            addCriterion("out_action_num <>", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumGreaterThan(Integer value) {
            addCriterion("out_action_num >", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_action_num >=", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumLessThan(Integer value) {
            addCriterion("out_action_num <", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumLessThanOrEqualTo(Integer value) {
            addCriterion("out_action_num <=", value, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumIn(List<Integer> values) {
            addCriterion("out_action_num in", values, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumNotIn(List<Integer> values) {
            addCriterion("out_action_num not in", values, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumBetween(Integer value1, Integer value2) {
            addCriterion("out_action_num between", value1, value2, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andOutActionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("out_action_num not between", value1, value2, "outActionNum");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainIsNull() {
            addCriterion("fut_delay_train is null");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainIsNotNull() {
            addCriterion("fut_delay_train is not null");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainEqualTo(Integer value) {
            addCriterion("fut_delay_train =", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainNotEqualTo(Integer value) {
            addCriterion("fut_delay_train <>", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainGreaterThan(Integer value) {
            addCriterion("fut_delay_train >", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainGreaterThanOrEqualTo(Integer value) {
            addCriterion("fut_delay_train >=", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainLessThan(Integer value) {
            addCriterion("fut_delay_train <", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainLessThanOrEqualTo(Integer value) {
            addCriterion("fut_delay_train <=", value, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainIn(List<Integer> values) {
            addCriterion("fut_delay_train in", values, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainNotIn(List<Integer> values) {
            addCriterion("fut_delay_train not in", values, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainBetween(Integer value1, Integer value2) {
            addCriterion("fut_delay_train between", value1, value2, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andFutDelayTrainNotBetween(Integer value1, Integer value2) {
            addCriterion("fut_delay_train not between", value1, value2, "futDelayTrain");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameIsNull() {
            addCriterion("train_today_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameIsNotNull() {
            addCriterion("train_today_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameEqualTo(String value) {
            addCriterion("train_today_name =", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameNotEqualTo(String value) {
            addCriterion("train_today_name <>", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameGreaterThan(String value) {
            addCriterion("train_today_name >", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameGreaterThanOrEqualTo(String value) {
            addCriterion("train_today_name >=", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameLessThan(String value) {
            addCriterion("train_today_name <", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameLessThanOrEqualTo(String value) {
            addCriterion("train_today_name <=", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameLike(String value) {
            addCriterion("train_today_name like", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameNotLike(String value) {
            addCriterion("train_today_name not like", value, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameIn(List<String> values) {
            addCriterion("train_today_name in", values, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameNotIn(List<String> values) {
            addCriterion("train_today_name not in", values, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameBetween(String value1, String value2) {
            addCriterion("train_today_name between", value1, value2, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNameNotBetween(String value1, String value2) {
            addCriterion("train_today_name not between", value1, value2, "trainTodayName");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumIsNull() {
            addCriterion("train_today_num is null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumIsNotNull() {
            addCriterion("train_today_num is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumEqualTo(Integer value) {
            addCriterion("train_today_num =", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumNotEqualTo(Integer value) {
            addCriterion("train_today_num <>", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumGreaterThan(Integer value) {
            addCriterion("train_today_num >", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("train_today_num >=", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumLessThan(Integer value) {
            addCriterion("train_today_num <", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumLessThanOrEqualTo(Integer value) {
            addCriterion("train_today_num <=", value, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumIn(List<Integer> values) {
            addCriterion("train_today_num in", values, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumNotIn(List<Integer> values) {
            addCriterion("train_today_num not in", values, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumBetween(Integer value1, Integer value2) {
            addCriterion("train_today_num between", value1, value2, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayNumNotBetween(Integer value1, Integer value2) {
            addCriterion("train_today_num not between", value1, value2, "trainTodayNum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumIsNull() {
            addCriterion("train_today_tnum is null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumIsNotNull() {
            addCriterion("train_today_tnum is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumEqualTo(String value) {
            addCriterion("train_today_tnum =", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumNotEqualTo(String value) {
            addCriterion("train_today_tnum <>", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumGreaterThan(String value) {
            addCriterion("train_today_tnum >", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumGreaterThanOrEqualTo(String value) {
            addCriterion("train_today_tnum >=", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumLessThan(String value) {
            addCriterion("train_today_tnum <", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumLessThanOrEqualTo(String value) {
            addCriterion("train_today_tnum <=", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumLike(String value) {
            addCriterion("train_today_tnum like", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumNotLike(String value) {
            addCriterion("train_today_tnum not like", value, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumIn(List<String> values) {
            addCriterion("train_today_tnum in", values, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumNotIn(List<String> values) {
            addCriterion("train_today_tnum not in", values, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumBetween(String value1, String value2) {
            addCriterion("train_today_tnum between", value1, value2, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayTnumNotBetween(String value1, String value2) {
            addCriterion("train_today_tnum not between", value1, value2, "trainTodayTnum");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateIsNull() {
            addCriterion("train_today_delay_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateIsNotNull() {
            addCriterion("train_today_delay_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateEqualTo(String value) {
            addCriterion("train_today_delay_date =", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateNotEqualTo(String value) {
            addCriterion("train_today_delay_date <>", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateGreaterThan(String value) {
            addCriterion("train_today_delay_date >", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateGreaterThanOrEqualTo(String value) {
            addCriterion("train_today_delay_date >=", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateLessThan(String value) {
            addCriterion("train_today_delay_date <", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateLessThanOrEqualTo(String value) {
            addCriterion("train_today_delay_date <=", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateLike(String value) {
            addCriterion("train_today_delay_date like", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateNotLike(String value) {
            addCriterion("train_today_delay_date not like", value, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateIn(List<String> values) {
            addCriterion("train_today_delay_date in", values, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateNotIn(List<String> values) {
            addCriterion("train_today_delay_date not in", values, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateBetween(String value1, String value2) {
            addCriterion("train_today_delay_date between", value1, value2, "trainTodayDelayDate");
            return (Criteria) this;
        }

        public Criteria andTrainTodayDelayDateNotBetween(String value1, String value2) {
            addCriterion("train_today_delay_date not between", value1, value2, "trainTodayDelayDate");
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