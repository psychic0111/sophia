package com.yz.sophia.insight.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitorsFlowrateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitorsFlowrateExample() {
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

        public Criteria andScenicSpotIsNull() {
            addCriterion("scenic_spot is null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIsNotNull() {
            addCriterion("scenic_spot is not null");
            return (Criteria) this;
        }

        public Criteria andScenicSpotEqualTo(String value) {
            addCriterion("scenic_spot =", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNotEqualTo(String value) {
            addCriterion("scenic_spot <>", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotGreaterThan(String value) {
            addCriterion("scenic_spot >", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_spot >=", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotLessThan(String value) {
            addCriterion("scenic_spot <", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotLessThanOrEqualTo(String value) {
            addCriterion("scenic_spot <=", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotLike(String value) {
            addCriterion("scenic_spot like", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNotLike(String value) {
            addCriterion("scenic_spot not like", value, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotIn(List<String> values) {
            addCriterion("scenic_spot in", values, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNotIn(List<String> values) {
            addCriterion("scenic_spot not in", values, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotBetween(String value1, String value2) {
            addCriterion("scenic_spot between", value1, value2, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andScenicSpotNotBetween(String value1, String value2) {
            addCriterion("scenic_spot not between", value1, value2, "scenicSpot");
            return (Criteria) this;
        }

        public Criteria andTrafficDateIsNull() {
            addCriterion("traffic_date is null");
            return (Criteria) this;
        }

        public Criteria andTrafficDateIsNotNull() {
            addCriterion("traffic_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficDateEqualTo(Date value) {
            addCriterion("traffic_date =", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateNotEqualTo(Date value) {
            addCriterion("traffic_date <>", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateGreaterThan(Date value) {
            addCriterion("traffic_date >", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateGreaterThanOrEqualTo(Date value) {
            addCriterion("traffic_date >=", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateLessThan(Date value) {
            addCriterion("traffic_date <", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateLessThanOrEqualTo(Date value) {
            addCriterion("traffic_date <=", value, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateIn(List<Date> values) {
            addCriterion("traffic_date in", values, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateNotIn(List<Date> values) {
            addCriterion("traffic_date not in", values, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateBetween(Date value1, Date value2) {
            addCriterion("traffic_date between", value1, value2, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andTrafficDateNotBetween(Date value1, Date value2) {
            addCriterion("traffic_date not between", value1, value2, "trafficDate");
            return (Criteria) this;
        }

        public Criteria andZeroIsNull() {
            addCriterion("zero is null");
            return (Criteria) this;
        }

        public Criteria andZeroIsNotNull() {
            addCriterion("zero is not null");
            return (Criteria) this;
        }

        public Criteria andZeroEqualTo(String value) {
            addCriterion("zero =", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroNotEqualTo(String value) {
            addCriterion("zero <>", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroGreaterThan(String value) {
            addCriterion("zero >", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroGreaterThanOrEqualTo(String value) {
            addCriterion("zero >=", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroLessThan(String value) {
            addCriterion("zero <", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroLessThanOrEqualTo(String value) {
            addCriterion("zero <=", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroLike(String value) {
            addCriterion("zero like", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroNotLike(String value) {
            addCriterion("zero not like", value, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroIn(List<String> values) {
            addCriterion("zero in", values, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroNotIn(List<String> values) {
            addCriterion("zero not in", values, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroBetween(String value1, String value2) {
            addCriterion("zero between", value1, value2, "zero");
            return (Criteria) this;
        }

        public Criteria andZeroNotBetween(String value1, String value2) {
            addCriterion("zero not between", value1, value2, "zero");
            return (Criteria) this;
        }

        public Criteria andOneIsNull() {
            addCriterion("one is null");
            return (Criteria) this;
        }

        public Criteria andOneIsNotNull() {
            addCriterion("one is not null");
            return (Criteria) this;
        }

        public Criteria andOneEqualTo(String value) {
            addCriterion("one =", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotEqualTo(String value) {
            addCriterion("one <>", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThan(String value) {
            addCriterion("one >", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThanOrEqualTo(String value) {
            addCriterion("one >=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThan(String value) {
            addCriterion("one <", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThanOrEqualTo(String value) {
            addCriterion("one <=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLike(String value) {
            addCriterion("one like", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotLike(String value) {
            addCriterion("one not like", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneIn(List<String> values) {
            addCriterion("one in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotIn(List<String> values) {
            addCriterion("one not in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneBetween(String value1, String value2) {
            addCriterion("one between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotBetween(String value1, String value2) {
            addCriterion("one not between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andTwoIsNull() {
            addCriterion("two is null");
            return (Criteria) this;
        }

        public Criteria andTwoIsNotNull() {
            addCriterion("two is not null");
            return (Criteria) this;
        }

        public Criteria andTwoEqualTo(String value) {
            addCriterion("two =", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotEqualTo(String value) {
            addCriterion("two <>", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThan(String value) {
            addCriterion("two >", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThanOrEqualTo(String value) {
            addCriterion("two >=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThan(String value) {
            addCriterion("two <", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThanOrEqualTo(String value) {
            addCriterion("two <=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLike(String value) {
            addCriterion("two like", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotLike(String value) {
            addCriterion("two not like", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoIn(List<String> values) {
            addCriterion("two in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotIn(List<String> values) {
            addCriterion("two not in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoBetween(String value1, String value2) {
            addCriterion("two between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotBetween(String value1, String value2) {
            addCriterion("two not between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andThreeIsNull() {
            addCriterion("three is null");
            return (Criteria) this;
        }

        public Criteria andThreeIsNotNull() {
            addCriterion("three is not null");
            return (Criteria) this;
        }

        public Criteria andThreeEqualTo(String value) {
            addCriterion("three =", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotEqualTo(String value) {
            addCriterion("three <>", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThan(String value) {
            addCriterion("three >", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThanOrEqualTo(String value) {
            addCriterion("three >=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThan(String value) {
            addCriterion("three <", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThanOrEqualTo(String value) {
            addCriterion("three <=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLike(String value) {
            addCriterion("three like", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotLike(String value) {
            addCriterion("three not like", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeIn(List<String> values) {
            addCriterion("three in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotIn(List<String> values) {
            addCriterion("three not in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeBetween(String value1, String value2) {
            addCriterion("three between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotBetween(String value1, String value2) {
            addCriterion("three not between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andFourIsNull() {
            addCriterion("four is null");
            return (Criteria) this;
        }

        public Criteria andFourIsNotNull() {
            addCriterion("four is not null");
            return (Criteria) this;
        }

        public Criteria andFourEqualTo(String value) {
            addCriterion("four =", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotEqualTo(String value) {
            addCriterion("four <>", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThan(String value) {
            addCriterion("four >", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThanOrEqualTo(String value) {
            addCriterion("four >=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThan(String value) {
            addCriterion("four <", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThanOrEqualTo(String value) {
            addCriterion("four <=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLike(String value) {
            addCriterion("four like", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotLike(String value) {
            addCriterion("four not like", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourIn(List<String> values) {
            addCriterion("four in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotIn(List<String> values) {
            addCriterion("four not in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourBetween(String value1, String value2) {
            addCriterion("four between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotBetween(String value1, String value2) {
            addCriterion("four not between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFiveIsNull() {
            addCriterion("five is null");
            return (Criteria) this;
        }

        public Criteria andFiveIsNotNull() {
            addCriterion("five is not null");
            return (Criteria) this;
        }

        public Criteria andFiveEqualTo(String value) {
            addCriterion("five =", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotEqualTo(String value) {
            addCriterion("five <>", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThan(String value) {
            addCriterion("five >", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThanOrEqualTo(String value) {
            addCriterion("five >=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThan(String value) {
            addCriterion("five <", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThanOrEqualTo(String value) {
            addCriterion("five <=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLike(String value) {
            addCriterion("five like", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotLike(String value) {
            addCriterion("five not like", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveIn(List<String> values) {
            addCriterion("five in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotIn(List<String> values) {
            addCriterion("five not in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveBetween(String value1, String value2) {
            addCriterion("five between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotBetween(String value1, String value2) {
            addCriterion("five not between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andSixIsNull() {
            addCriterion("six is null");
            return (Criteria) this;
        }

        public Criteria andSixIsNotNull() {
            addCriterion("six is not null");
            return (Criteria) this;
        }

        public Criteria andSixEqualTo(String value) {
            addCriterion("six =", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotEqualTo(String value) {
            addCriterion("six <>", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThan(String value) {
            addCriterion("six >", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThanOrEqualTo(String value) {
            addCriterion("six >=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThan(String value) {
            addCriterion("six <", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThanOrEqualTo(String value) {
            addCriterion("six <=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLike(String value) {
            addCriterion("six like", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotLike(String value) {
            addCriterion("six not like", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixIn(List<String> values) {
            addCriterion("six in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotIn(List<String> values) {
            addCriterion("six not in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixBetween(String value1, String value2) {
            addCriterion("six between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotBetween(String value1, String value2) {
            addCriterion("six not between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSevenIsNull() {
            addCriterion("seven is null");
            return (Criteria) this;
        }

        public Criteria andSevenIsNotNull() {
            addCriterion("seven is not null");
            return (Criteria) this;
        }

        public Criteria andSevenEqualTo(String value) {
            addCriterion("seven =", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotEqualTo(String value) {
            addCriterion("seven <>", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThan(String value) {
            addCriterion("seven >", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThanOrEqualTo(String value) {
            addCriterion("seven >=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThan(String value) {
            addCriterion("seven <", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThanOrEqualTo(String value) {
            addCriterion("seven <=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLike(String value) {
            addCriterion("seven like", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotLike(String value) {
            addCriterion("seven not like", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenIn(List<String> values) {
            addCriterion("seven in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotIn(List<String> values) {
            addCriterion("seven not in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenBetween(String value1, String value2) {
            addCriterion("seven between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotBetween(String value1, String value2) {
            addCriterion("seven not between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andEightIsNull() {
            addCriterion("eight is null");
            return (Criteria) this;
        }

        public Criteria andEightIsNotNull() {
            addCriterion("eight is not null");
            return (Criteria) this;
        }

        public Criteria andEightEqualTo(String value) {
            addCriterion("eight =", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotEqualTo(String value) {
            addCriterion("eight <>", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThan(String value) {
            addCriterion("eight >", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThanOrEqualTo(String value) {
            addCriterion("eight >=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThan(String value) {
            addCriterion("eight <", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThanOrEqualTo(String value) {
            addCriterion("eight <=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLike(String value) {
            addCriterion("eight like", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotLike(String value) {
            addCriterion("eight not like", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightIn(List<String> values) {
            addCriterion("eight in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotIn(List<String> values) {
            addCriterion("eight not in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightBetween(String value1, String value2) {
            addCriterion("eight between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotBetween(String value1, String value2) {
            addCriterion("eight not between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andNineIsNull() {
            addCriterion("nine is null");
            return (Criteria) this;
        }

        public Criteria andNineIsNotNull() {
            addCriterion("nine is not null");
            return (Criteria) this;
        }

        public Criteria andNineEqualTo(String value) {
            addCriterion("nine =", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotEqualTo(String value) {
            addCriterion("nine <>", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThan(String value) {
            addCriterion("nine >", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThanOrEqualTo(String value) {
            addCriterion("nine >=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThan(String value) {
            addCriterion("nine <", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThanOrEqualTo(String value) {
            addCriterion("nine <=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLike(String value) {
            addCriterion("nine like", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotLike(String value) {
            addCriterion("nine not like", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineIn(List<String> values) {
            addCriterion("nine in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotIn(List<String> values) {
            addCriterion("nine not in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineBetween(String value1, String value2) {
            addCriterion("nine between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotBetween(String value1, String value2) {
            addCriterion("nine not between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andTenIsNull() {
            addCriterion("ten is null");
            return (Criteria) this;
        }

        public Criteria andTenIsNotNull() {
            addCriterion("ten is not null");
            return (Criteria) this;
        }

        public Criteria andTenEqualTo(String value) {
            addCriterion("ten =", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotEqualTo(String value) {
            addCriterion("ten <>", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThan(String value) {
            addCriterion("ten >", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThanOrEqualTo(String value) {
            addCriterion("ten >=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThan(String value) {
            addCriterion("ten <", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThanOrEqualTo(String value) {
            addCriterion("ten <=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLike(String value) {
            addCriterion("ten like", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotLike(String value) {
            addCriterion("ten not like", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenIn(List<String> values) {
            addCriterion("ten in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotIn(List<String> values) {
            addCriterion("ten not in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenBetween(String value1, String value2) {
            addCriterion("ten between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotBetween(String value1, String value2) {
            addCriterion("ten not between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andElevenIsNull() {
            addCriterion("eleven is null");
            return (Criteria) this;
        }

        public Criteria andElevenIsNotNull() {
            addCriterion("eleven is not null");
            return (Criteria) this;
        }

        public Criteria andElevenEqualTo(String value) {
            addCriterion("eleven =", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotEqualTo(String value) {
            addCriterion("eleven <>", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThan(String value) {
            addCriterion("eleven >", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThanOrEqualTo(String value) {
            addCriterion("eleven >=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThan(String value) {
            addCriterion("eleven <", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThanOrEqualTo(String value) {
            addCriterion("eleven <=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLike(String value) {
            addCriterion("eleven like", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotLike(String value) {
            addCriterion("eleven not like", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenIn(List<String> values) {
            addCriterion("eleven in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotIn(List<String> values) {
            addCriterion("eleven not in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenBetween(String value1, String value2) {
            addCriterion("eleven between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotBetween(String value1, String value2) {
            addCriterion("eleven not between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNull() {
            addCriterion("twelve is null");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNotNull() {
            addCriterion("twelve is not null");
            return (Criteria) this;
        }

        public Criteria andTwelveEqualTo(String value) {
            addCriterion("twelve =", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotEqualTo(String value) {
            addCriterion("twelve <>", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThan(String value) {
            addCriterion("twelve >", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThanOrEqualTo(String value) {
            addCriterion("twelve >=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThan(String value) {
            addCriterion("twelve <", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThanOrEqualTo(String value) {
            addCriterion("twelve <=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLike(String value) {
            addCriterion("twelve like", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotLike(String value) {
            addCriterion("twelve not like", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveIn(List<String> values) {
            addCriterion("twelve in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotIn(List<String> values) {
            addCriterion("twelve not in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveBetween(String value1, String value2) {
            addCriterion("twelve between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotBetween(String value1, String value2) {
            addCriterion("twelve not between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNull() {
            addCriterion("thirteen is null");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNotNull() {
            addCriterion("thirteen is not null");
            return (Criteria) this;
        }

        public Criteria andThirteenEqualTo(String value) {
            addCriterion("thirteen =", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotEqualTo(String value) {
            addCriterion("thirteen <>", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThan(String value) {
            addCriterion("thirteen >", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThanOrEqualTo(String value) {
            addCriterion("thirteen >=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThan(String value) {
            addCriterion("thirteen <", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThanOrEqualTo(String value) {
            addCriterion("thirteen <=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLike(String value) {
            addCriterion("thirteen like", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotLike(String value) {
            addCriterion("thirteen not like", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenIn(List<String> values) {
            addCriterion("thirteen in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotIn(List<String> values) {
            addCriterion("thirteen not in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenBetween(String value1, String value2) {
            addCriterion("thirteen between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotBetween(String value1, String value2) {
            addCriterion("thirteen not between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNull() {
            addCriterion("fourteen is null");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNotNull() {
            addCriterion("fourteen is not null");
            return (Criteria) this;
        }

        public Criteria andFourteenEqualTo(String value) {
            addCriterion("fourteen =", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotEqualTo(String value) {
            addCriterion("fourteen <>", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThan(String value) {
            addCriterion("fourteen >", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThanOrEqualTo(String value) {
            addCriterion("fourteen >=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThan(String value) {
            addCriterion("fourteen <", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThanOrEqualTo(String value) {
            addCriterion("fourteen <=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLike(String value) {
            addCriterion("fourteen like", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotLike(String value) {
            addCriterion("fourteen not like", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIn(List<String> values) {
            addCriterion("fourteen in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotIn(List<String> values) {
            addCriterion("fourteen not in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenBetween(String value1, String value2) {
            addCriterion("fourteen between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotBetween(String value1, String value2) {
            addCriterion("fourteen not between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNull() {
            addCriterion("fifteen is null");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNotNull() {
            addCriterion("fifteen is not null");
            return (Criteria) this;
        }

        public Criteria andFifteenEqualTo(String value) {
            addCriterion("fifteen =", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotEqualTo(String value) {
            addCriterion("fifteen <>", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThan(String value) {
            addCriterion("fifteen >", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThanOrEqualTo(String value) {
            addCriterion("fifteen >=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThan(String value) {
            addCriterion("fifteen <", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThanOrEqualTo(String value) {
            addCriterion("fifteen <=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLike(String value) {
            addCriterion("fifteen like", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotLike(String value) {
            addCriterion("fifteen not like", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIn(List<String> values) {
            addCriterion("fifteen in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotIn(List<String> values) {
            addCriterion("fifteen not in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenBetween(String value1, String value2) {
            addCriterion("fifteen between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotBetween(String value1, String value2) {
            addCriterion("fifteen not between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNull() {
            addCriterion("sixteen is null");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNotNull() {
            addCriterion("sixteen is not null");
            return (Criteria) this;
        }

        public Criteria andSixteenEqualTo(String value) {
            addCriterion("sixteen =", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotEqualTo(String value) {
            addCriterion("sixteen <>", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThan(String value) {
            addCriterion("sixteen >", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThanOrEqualTo(String value) {
            addCriterion("sixteen >=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThan(String value) {
            addCriterion("sixteen <", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThanOrEqualTo(String value) {
            addCriterion("sixteen <=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLike(String value) {
            addCriterion("sixteen like", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotLike(String value) {
            addCriterion("sixteen not like", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIn(List<String> values) {
            addCriterion("sixteen in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotIn(List<String> values) {
            addCriterion("sixteen not in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenBetween(String value1, String value2) {
            addCriterion("sixteen between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotBetween(String value1, String value2) {
            addCriterion("sixteen not between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNull() {
            addCriterion("seventeen is null");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNotNull() {
            addCriterion("seventeen is not null");
            return (Criteria) this;
        }

        public Criteria andSeventeenEqualTo(String value) {
            addCriterion("seventeen =", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotEqualTo(String value) {
            addCriterion("seventeen <>", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThan(String value) {
            addCriterion("seventeen >", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThanOrEqualTo(String value) {
            addCriterion("seventeen >=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThan(String value) {
            addCriterion("seventeen <", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThanOrEqualTo(String value) {
            addCriterion("seventeen <=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLike(String value) {
            addCriterion("seventeen like", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotLike(String value) {
            addCriterion("seventeen not like", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIn(List<String> values) {
            addCriterion("seventeen in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotIn(List<String> values) {
            addCriterion("seventeen not in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenBetween(String value1, String value2) {
            addCriterion("seventeen between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotBetween(String value1, String value2) {
            addCriterion("seventeen not between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNull() {
            addCriterion("eighteen is null");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNotNull() {
            addCriterion("eighteen is not null");
            return (Criteria) this;
        }

        public Criteria andEighteenEqualTo(String value) {
            addCriterion("eighteen =", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotEqualTo(String value) {
            addCriterion("eighteen <>", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThan(String value) {
            addCriterion("eighteen >", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThanOrEqualTo(String value) {
            addCriterion("eighteen >=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThan(String value) {
            addCriterion("eighteen <", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThanOrEqualTo(String value) {
            addCriterion("eighteen <=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLike(String value) {
            addCriterion("eighteen like", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotLike(String value) {
            addCriterion("eighteen not like", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenIn(List<String> values) {
            addCriterion("eighteen in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotIn(List<String> values) {
            addCriterion("eighteen not in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenBetween(String value1, String value2) {
            addCriterion("eighteen between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotBetween(String value1, String value2) {
            addCriterion("eighteen not between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andNineteenIsNull() {
            addCriterion("nineteen is null");
            return (Criteria) this;
        }

        public Criteria andNineteenIsNotNull() {
            addCriterion("nineteen is not null");
            return (Criteria) this;
        }

        public Criteria andNineteenEqualTo(String value) {
            addCriterion("nineteen =", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotEqualTo(String value) {
            addCriterion("nineteen <>", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenGreaterThan(String value) {
            addCriterion("nineteen >", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenGreaterThanOrEqualTo(String value) {
            addCriterion("nineteen >=", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenLessThan(String value) {
            addCriterion("nineteen <", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenLessThanOrEqualTo(String value) {
            addCriterion("nineteen <=", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenLike(String value) {
            addCriterion("nineteen like", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotLike(String value) {
            addCriterion("nineteen not like", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenIn(List<String> values) {
            addCriterion("nineteen in", values, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotIn(List<String> values) {
            addCriterion("nineteen not in", values, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenBetween(String value1, String value2) {
            addCriterion("nineteen between", value1, value2, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotBetween(String value1, String value2) {
            addCriterion("nineteen not between", value1, value2, "nineteen");
            return (Criteria) this;
        }

        public Criteria andTwentyIsNull() {
            addCriterion("twenty is null");
            return (Criteria) this;
        }

        public Criteria andTwentyIsNotNull() {
            addCriterion("twenty is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyEqualTo(String value) {
            addCriterion("twenty =", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotEqualTo(String value) {
            addCriterion("twenty <>", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyGreaterThan(String value) {
            addCriterion("twenty >", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyGreaterThanOrEqualTo(String value) {
            addCriterion("twenty >=", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyLessThan(String value) {
            addCriterion("twenty <", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyLessThanOrEqualTo(String value) {
            addCriterion("twenty <=", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyLike(String value) {
            addCriterion("twenty like", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotLike(String value) {
            addCriterion("twenty not like", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyIn(List<String> values) {
            addCriterion("twenty in", values, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotIn(List<String> values) {
            addCriterion("twenty not in", values, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyBetween(String value1, String value2) {
            addCriterion("twenty between", value1, value2, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotBetween(String value1, String value2) {
            addCriterion("twenty not between", value1, value2, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIsNull() {
            addCriterion("twenty-one is null");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIsNotNull() {
            addCriterion("twenty-one is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyOneEqualTo(String value) {
            addCriterion("twenty-one =", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotEqualTo(String value) {
            addCriterion("twenty-one <>", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneGreaterThan(String value) {
            addCriterion("twenty-one >", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneGreaterThanOrEqualTo(String value) {
            addCriterion("twenty-one >=", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneLessThan(String value) {
            addCriterion("twenty-one <", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneLessThanOrEqualTo(String value) {
            addCriterion("twenty-one <=", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneLike(String value) {
            addCriterion("twenty-one like", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotLike(String value) {
            addCriterion("twenty-one not like", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIn(List<String> values) {
            addCriterion("twenty-one in", values, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotIn(List<String> values) {
            addCriterion("twenty-one not in", values, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneBetween(String value1, String value2) {
            addCriterion("twenty-one between", value1, value2, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotBetween(String value1, String value2) {
            addCriterion("twenty-one not between", value1, value2, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIsNull() {
            addCriterion("twenty-two is null");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIsNotNull() {
            addCriterion("twenty-two is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoEqualTo(String value) {
            addCriterion("twenty-two =", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotEqualTo(String value) {
            addCriterion("twenty-two <>", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoGreaterThan(String value) {
            addCriterion("twenty-two >", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoGreaterThanOrEqualTo(String value) {
            addCriterion("twenty-two >=", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoLessThan(String value) {
            addCriterion("twenty-two <", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoLessThanOrEqualTo(String value) {
            addCriterion("twenty-two <=", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoLike(String value) {
            addCriterion("twenty-two like", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotLike(String value) {
            addCriterion("twenty-two not like", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIn(List<String> values) {
            addCriterion("twenty-two in", values, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotIn(List<String> values) {
            addCriterion("twenty-two not in", values, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoBetween(String value1, String value2) {
            addCriterion("twenty-two between", value1, value2, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotBetween(String value1, String value2) {
            addCriterion("twenty-two not between", value1, value2, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIsNull() {
            addCriterion("twenty-three is null");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIsNotNull() {
            addCriterion("twenty-three is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeEqualTo(String value) {
            addCriterion("twenty-three =", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotEqualTo(String value) {
            addCriterion("twenty-three <>", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeGreaterThan(String value) {
            addCriterion("twenty-three >", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeGreaterThanOrEqualTo(String value) {
            addCriterion("twenty-three >=", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeLessThan(String value) {
            addCriterion("twenty-three <", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeLessThanOrEqualTo(String value) {
            addCriterion("twenty-three <=", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeLike(String value) {
            addCriterion("twenty-three like", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotLike(String value) {
            addCriterion("twenty-three not like", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIn(List<String> values) {
            addCriterion("twenty-three in", values, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotIn(List<String> values) {
            addCriterion("twenty-three not in", values, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeBetween(String value1, String value2) {
            addCriterion("twenty-three between", value1, value2, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotBetween(String value1, String value2) {
            addCriterion("twenty-three not between", value1, value2, "twentyThree");
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