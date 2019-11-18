package com.forest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionRecordDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionRecordDetailsExample() {
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

        public Criteria andTrdIdIsNull() {
            addCriterion("trd_id is null");
            return (Criteria) this;
        }

        public Criteria andTrdIdIsNotNull() {
            addCriterion("trd_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrdIdEqualTo(Integer value) {
            addCriterion("trd_id =", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdNotEqualTo(Integer value) {
            addCriterion("trd_id <>", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdGreaterThan(Integer value) {
            addCriterion("trd_id >", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trd_id >=", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdLessThan(Integer value) {
            addCriterion("trd_id <", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdLessThanOrEqualTo(Integer value) {
            addCriterion("trd_id <=", value, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdIn(List<Integer> values) {
            addCriterion("trd_id in", values, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdNotIn(List<Integer> values) {
            addCriterion("trd_id not in", values, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdBetween(Integer value1, Integer value2) {
            addCriterion("trd_id between", value1, value2, "trdId");
            return (Criteria) this;
        }

        public Criteria andTrdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trd_id not between", value1, value2, "trdId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNoIsNull() {
            addCriterion("article_no is null");
            return (Criteria) this;
        }

        public Criteria andArticleNoIsNotNull() {
            addCriterion("article_no is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNoEqualTo(Integer value) {
            addCriterion("article_no =", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoNotEqualTo(Integer value) {
            addCriterion("article_no <>", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoGreaterThan(Integer value) {
            addCriterion("article_no >", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_no >=", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoLessThan(Integer value) {
            addCriterion("article_no <", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoLessThanOrEqualTo(Integer value) {
            addCriterion("article_no <=", value, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoIn(List<Integer> values) {
            addCriterion("article_no in", values, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoNotIn(List<Integer> values) {
            addCriterion("article_no not in", values, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoBetween(Integer value1, Integer value2) {
            addCriterion("article_no between", value1, value2, "articleNo");
            return (Criteria) this;
        }

        public Criteria andArticleNoNotBetween(Integer value1, Integer value2) {
            addCriterion("article_no not between", value1, value2, "articleNo");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceIsNull() {
            addCriterion("raw_total_price is null");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceIsNotNull() {
            addCriterion("raw_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceEqualTo(BigDecimal value) {
            addCriterion("raw_total_price =", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("raw_total_price <>", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("raw_total_price >", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("raw_total_price >=", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceLessThan(BigDecimal value) {
            addCriterion("raw_total_price <", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("raw_total_price <=", value, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceIn(List<BigDecimal> values) {
            addCriterion("raw_total_price in", values, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("raw_total_price not in", values, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("raw_total_price between", value1, value2, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRawTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("raw_total_price not between", value1, value2, "rawTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
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