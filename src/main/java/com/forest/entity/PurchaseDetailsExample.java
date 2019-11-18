package com.forest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseDetailsExample() {
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

        public Criteria andPdIdIsNull() {
            addCriterion("pd_id is null");
            return (Criteria) this;
        }

        public Criteria andPdIdIsNotNull() {
            addCriterion("pd_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdIdEqualTo(Integer value) {
            addCriterion("pd_id =", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotEqualTo(Integer value) {
            addCriterion("pd_id <>", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThan(Integer value) {
            addCriterion("pd_id >", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_id >=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThan(Integer value) {
            addCriterion("pd_id <", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThanOrEqualTo(Integer value) {
            addCriterion("pd_id <=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdIn(List<Integer> values) {
            addCriterion("pd_id in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotIn(List<Integer> values) {
            addCriterion("pd_id not in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdBetween(Integer value1, Integer value2) {
            addCriterion("pd_id between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_id not between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPmIdIsNull() {
            addCriterion("pm_id is null");
            return (Criteria) this;
        }

        public Criteria andPmIdIsNotNull() {
            addCriterion("pm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPmIdEqualTo(Integer value) {
            addCriterion("pm_id =", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotEqualTo(Integer value) {
            addCriterion("pm_id <>", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdGreaterThan(Integer value) {
            addCriterion("pm_id >", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pm_id >=", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdLessThan(Integer value) {
            addCriterion("pm_id <", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdLessThanOrEqualTo(Integer value) {
            addCriterion("pm_id <=", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdIn(List<Integer> values) {
            addCriterion("pm_id in", values, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotIn(List<Integer> values) {
            addCriterion("pm_id not in", values, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdBetween(Integer value1, Integer value2) {
            addCriterion("pm_id between", value1, value2, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pm_id not between", value1, value2, "pmId");
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

        public Criteria andTitalDecimalIsNull() {
            addCriterion("tital_decimal is null");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalIsNotNull() {
            addCriterion("tital_decimal is not null");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalEqualTo(BigDecimal value) {
            addCriterion("tital_decimal =", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalNotEqualTo(BigDecimal value) {
            addCriterion("tital_decimal <>", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalGreaterThan(BigDecimal value) {
            addCriterion("tital_decimal >", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tital_decimal >=", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalLessThan(BigDecimal value) {
            addCriterion("tital_decimal <", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tital_decimal <=", value, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalIn(List<BigDecimal> values) {
            addCriterion("tital_decimal in", values, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalNotIn(List<BigDecimal> values) {
            addCriterion("tital_decimal not in", values, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tital_decimal between", value1, value2, "titalDecimal");
            return (Criteria) this;
        }

        public Criteria andTitalDecimalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tital_decimal not between", value1, value2, "titalDecimal");
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