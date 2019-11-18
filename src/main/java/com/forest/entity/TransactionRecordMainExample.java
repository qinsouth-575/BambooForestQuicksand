package com.forest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionRecordMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionRecordMainExample() {
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

        public Criteria andTrmIdIsNull() {
            addCriterion("trm_id is null");
            return (Criteria) this;
        }

        public Criteria andTrmIdIsNotNull() {
            addCriterion("trm_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrmIdEqualTo(Integer value) {
            addCriterion("trm_id =", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdNotEqualTo(Integer value) {
            addCriterion("trm_id <>", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdGreaterThan(Integer value) {
            addCriterion("trm_id >", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trm_id >=", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdLessThan(Integer value) {
            addCriterion("trm_id <", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdLessThanOrEqualTo(Integer value) {
            addCriterion("trm_id <=", value, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdIn(List<Integer> values) {
            addCriterion("trm_id in", values, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdNotIn(List<Integer> values) {
            addCriterion("trm_id not in", values, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdBetween(Integer value1, Integer value2) {
            addCriterion("trm_id between", value1, value2, "trmId");
            return (Criteria) this;
        }

        public Criteria andTrmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trm_id not between", value1, value2, "trmId");
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

        public Criteria andClientIsNull() {
            addCriterion("client is null");
            return (Criteria) this;
        }

        public Criteria andClientIsNotNull() {
            addCriterion("client is not null");
            return (Criteria) this;
        }

        public Criteria andClientEqualTo(Integer value) {
            addCriterion("client =", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotEqualTo(Integer value) {
            addCriterion("client <>", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThan(Integer value) {
            addCriterion("client >", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThanOrEqualTo(Integer value) {
            addCriterion("client >=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThan(Integer value) {
            addCriterion("client <", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThanOrEqualTo(Integer value) {
            addCriterion("client <=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientIn(List<Integer> values) {
            addCriterion("client in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotIn(List<Integer> values) {
            addCriterion("client not in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientBetween(Integer value1, Integer value2) {
            addCriterion("client between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotBetween(Integer value1, Integer value2) {
            addCriterion("client not between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andTotalSumIsNull() {
            addCriterion("total_sum is null");
            return (Criteria) this;
        }

        public Criteria andTotalSumIsNotNull() {
            addCriterion("total_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSumEqualTo(BigDecimal value) {
            addCriterion("total_sum =", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotEqualTo(BigDecimal value) {
            addCriterion("total_sum <>", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumGreaterThan(BigDecimal value) {
            addCriterion("total_sum >", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sum >=", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumLessThan(BigDecimal value) {
            addCriterion("total_sum <", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sum <=", value, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumIn(List<BigDecimal> values) {
            addCriterion("total_sum in", values, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotIn(List<BigDecimal> values) {
            addCriterion("total_sum not in", values, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sum between", value1, value2, "totalSum");
            return (Criteria) this;
        }

        public Criteria andTotalSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sum not between", value1, value2, "totalSum");
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

        public Criteria andActualIncomeIsNull() {
            addCriterion("actual_income is null");
            return (Criteria) this;
        }

        public Criteria andActualIncomeIsNotNull() {
            addCriterion("actual_income is not null");
            return (Criteria) this;
        }

        public Criteria andActualIncomeEqualTo(BigDecimal value) {
            addCriterion("actual_income =", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeNotEqualTo(BigDecimal value) {
            addCriterion("actual_income <>", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeGreaterThan(BigDecimal value) {
            addCriterion("actual_income >", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_income >=", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeLessThan(BigDecimal value) {
            addCriterion("actual_income <", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_income <=", value, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeIn(List<BigDecimal> values) {
            addCriterion("actual_income in", values, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeNotIn(List<BigDecimal> values) {
            addCriterion("actual_income not in", values, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_income between", value1, value2, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andActualIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_income not between", value1, value2, "actualIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeIsNull() {
            addCriterion("not_income is null");
            return (Criteria) this;
        }

        public Criteria andNotIncomeIsNotNull() {
            addCriterion("not_income is not null");
            return (Criteria) this;
        }

        public Criteria andNotIncomeEqualTo(BigDecimal value) {
            addCriterion("not_income =", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeNotEqualTo(BigDecimal value) {
            addCriterion("not_income <>", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeGreaterThan(BigDecimal value) {
            addCriterion("not_income >", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("not_income >=", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeLessThan(BigDecimal value) {
            addCriterion("not_income <", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("not_income <=", value, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeIn(List<BigDecimal> values) {
            addCriterion("not_income in", values, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeNotIn(List<BigDecimal> values) {
            addCriterion("not_income not in", values, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_income between", value1, value2, "notIncome");
            return (Criteria) this;
        }

        public Criteria andNotIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_income not between", value1, value2, "notIncome");
            return (Criteria) this;
        }

        public Criteria andPaymountIsNull() {
            addCriterion("paymount is null");
            return (Criteria) this;
        }

        public Criteria andPaymountIsNotNull() {
            addCriterion("paymount is not null");
            return (Criteria) this;
        }

        public Criteria andPaymountEqualTo(Short value) {
            addCriterion("paymount =", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotEqualTo(Short value) {
            addCriterion("paymount <>", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountGreaterThan(Short value) {
            addCriterion("paymount >", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountGreaterThanOrEqualTo(Short value) {
            addCriterion("paymount >=", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountLessThan(Short value) {
            addCriterion("paymount <", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountLessThanOrEqualTo(Short value) {
            addCriterion("paymount <=", value, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountIn(List<Short> values) {
            addCriterion("paymount in", values, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotIn(List<Short> values) {
            addCriterion("paymount not in", values, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountBetween(Short value1, Short value2) {
            addCriterion("paymount between", value1, value2, "paymount");
            return (Criteria) this;
        }

        public Criteria andPaymountNotBetween(Short value1, Short value2) {
            addCriterion("paymount not between", value1, value2, "paymount");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Short value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Short value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Short value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Short value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Short value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Short value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Short> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Short> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Short value1, Short value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Short value1, Short value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCashierIsNull() {
            addCriterion("cashier is null");
            return (Criteria) this;
        }

        public Criteria andCashierIsNotNull() {
            addCriterion("cashier is not null");
            return (Criteria) this;
        }

        public Criteria andCashierEqualTo(String value) {
            addCriterion("cashier =", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotEqualTo(String value) {
            addCriterion("cashier <>", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThan(String value) {
            addCriterion("cashier >", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierGreaterThanOrEqualTo(String value) {
            addCriterion("cashier >=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThan(String value) {
            addCriterion("cashier <", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLessThanOrEqualTo(String value) {
            addCriterion("cashier <=", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierLike(String value) {
            addCriterion("cashier like", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotLike(String value) {
            addCriterion("cashier not like", value, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierIn(List<String> values) {
            addCriterion("cashier in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotIn(List<String> values) {
            addCriterion("cashier not in", values, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierBetween(String value1, String value2) {
            addCriterion("cashier between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andCashierNotBetween(String value1, String value2) {
            addCriterion("cashier not between", value1, value2, "cashier");
            return (Criteria) this;
        }

        public Criteria andShopAssistantIsNull() {
            addCriterion("shop_assistant is null");
            return (Criteria) this;
        }

        public Criteria andShopAssistantIsNotNull() {
            addCriterion("shop_assistant is not null");
            return (Criteria) this;
        }

        public Criteria andShopAssistantEqualTo(String value) {
            addCriterion("shop_assistant =", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantNotEqualTo(String value) {
            addCriterion("shop_assistant <>", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantGreaterThan(String value) {
            addCriterion("shop_assistant >", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantGreaterThanOrEqualTo(String value) {
            addCriterion("shop_assistant >=", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantLessThan(String value) {
            addCriterion("shop_assistant <", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantLessThanOrEqualTo(String value) {
            addCriterion("shop_assistant <=", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantLike(String value) {
            addCriterion("shop_assistant like", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantNotLike(String value) {
            addCriterion("shop_assistant not like", value, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantIn(List<String> values) {
            addCriterion("shop_assistant in", values, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantNotIn(List<String> values) {
            addCriterion("shop_assistant not in", values, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantBetween(String value1, String value2) {
            addCriterion("shop_assistant between", value1, value2, "shopAssistant");
            return (Criteria) this;
        }

        public Criteria andShopAssistantNotBetween(String value1, String value2) {
            addCriterion("shop_assistant not between", value1, value2, "shopAssistant");
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