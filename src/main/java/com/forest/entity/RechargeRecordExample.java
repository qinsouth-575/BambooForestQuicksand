package com.forest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechargeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RechargeRecordExample() {
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

        public Criteria andRrIdIsNull() {
            addCriterion("rr_id is null");
            return (Criteria) this;
        }

        public Criteria andRrIdIsNotNull() {
            addCriterion("rr_id is not null");
            return (Criteria) this;
        }

        public Criteria andRrIdEqualTo(Integer value) {
            addCriterion("rr_id =", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdNotEqualTo(Integer value) {
            addCriterion("rr_id <>", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdGreaterThan(Integer value) {
            addCriterion("rr_id >", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rr_id >=", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdLessThan(Integer value) {
            addCriterion("rr_id <", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdLessThanOrEqualTo(Integer value) {
            addCriterion("rr_id <=", value, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdIn(List<Integer> values) {
            addCriterion("rr_id in", values, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdNotIn(List<Integer> values) {
            addCriterion("rr_id not in", values, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdBetween(Integer value1, Integer value2) {
            addCriterion("rr_id between", value1, value2, "rrId");
            return (Criteria) this;
        }

        public Criteria andRrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rr_id not between", value1, value2, "rrId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIsNull() {
            addCriterion("recharge_money is null");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIsNotNull() {
            addCriterion("recharge_money is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyEqualTo(BigDecimal value) {
            addCriterion("recharge_money =", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("recharge_money <>", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThan(BigDecimal value) {
            addCriterion("recharge_money >", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_money >=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThan(BigDecimal value) {
            addCriterion("recharge_money <", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_money <=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIn(List<BigDecimal> values) {
            addCriterion("recharge_money in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("recharge_money not in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_money between", value1, value2, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_money not between", value1, value2, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralIsNull() {
            addCriterion("present_integral is null");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralIsNotNull() {
            addCriterion("present_integral is not null");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralEqualTo(Integer value) {
            addCriterion("present_integral =", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralNotEqualTo(Integer value) {
            addCriterion("present_integral <>", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralGreaterThan(Integer value) {
            addCriterion("present_integral >", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("present_integral >=", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralLessThan(Integer value) {
            addCriterion("present_integral <", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("present_integral <=", value, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralIn(List<Integer> values) {
            addCriterion("present_integral in", values, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralNotIn(List<Integer> values) {
            addCriterion("present_integral not in", values, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralBetween(Integer value1, Integer value2) {
            addCriterion("present_integral between", value1, value2, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andPresentIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("present_integral not between", value1, value2, "presentIntegral");
            return (Criteria) this;
        }

        public Criteria andRechargeWayIsNull() {
            addCriterion("recharge_way is null");
            return (Criteria) this;
        }

        public Criteria andRechargeWayIsNotNull() {
            addCriterion("recharge_way is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeWayEqualTo(Integer value) {
            addCriterion("recharge_way =", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayNotEqualTo(Integer value) {
            addCriterion("recharge_way <>", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayGreaterThan(Integer value) {
            addCriterion("recharge_way >", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("recharge_way >=", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayLessThan(Integer value) {
            addCriterion("recharge_way <", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayLessThanOrEqualTo(Integer value) {
            addCriterion("recharge_way <=", value, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayIn(List<Integer> values) {
            addCriterion("recharge_way in", values, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayNotIn(List<Integer> values) {
            addCriterion("recharge_way not in", values, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayBetween(Integer value1, Integer value2) {
            addCriterion("recharge_way between", value1, value2, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andRechargeWayNotBetween(Integer value1, Integer value2) {
            addCriterion("recharge_way not between", value1, value2, "rechargeWay");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceIsNull() {
            addCriterion("present_balance is null");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceIsNotNull() {
            addCriterion("present_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceEqualTo(BigDecimal value) {
            addCriterion("present_balance =", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceNotEqualTo(BigDecimal value) {
            addCriterion("present_balance <>", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceGreaterThan(BigDecimal value) {
            addCriterion("present_balance >", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("present_balance >=", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceLessThan(BigDecimal value) {
            addCriterion("present_balance <", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("present_balance <=", value, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceIn(List<BigDecimal> values) {
            addCriterion("present_balance in", values, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceNotIn(List<BigDecimal> values) {
            addCriterion("present_balance not in", values, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_balance between", value1, value2, "presentBalance");
            return (Criteria) this;
        }

        public Criteria andPresentBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_balance not between", value1, value2, "presentBalance");
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