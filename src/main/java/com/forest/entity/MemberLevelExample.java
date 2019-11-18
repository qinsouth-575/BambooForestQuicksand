package com.forest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MemberLevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberLevelExample() {
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

        public Criteria andMlIdIsNull() {
            addCriterion("ml_id is null");
            return (Criteria) this;
        }

        public Criteria andMlIdIsNotNull() {
            addCriterion("ml_id is not null");
            return (Criteria) this;
        }

        public Criteria andMlIdEqualTo(Short value) {
            addCriterion("ml_id =", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotEqualTo(Short value) {
            addCriterion("ml_id <>", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdGreaterThan(Short value) {
            addCriterion("ml_id >", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ml_id >=", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdLessThan(Short value) {
            addCriterion("ml_id <", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdLessThanOrEqualTo(Short value) {
            addCriterion("ml_id <=", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdIn(List<Short> values) {
            addCriterion("ml_id in", values, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotIn(List<Short> values) {
            addCriterion("ml_id not in", values, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdBetween(Short value1, Short value2) {
            addCriterion("ml_id between", value1, value2, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotBetween(Short value1, Short value2) {
            addCriterion("ml_id not between", value1, value2, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlNameIsNull() {
            addCriterion("ml_name is null");
            return (Criteria) this;
        }

        public Criteria andMlNameIsNotNull() {
            addCriterion("ml_name is not null");
            return (Criteria) this;
        }

        public Criteria andMlNameEqualTo(String value) {
            addCriterion("ml_name =", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameNotEqualTo(String value) {
            addCriterion("ml_name <>", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameGreaterThan(String value) {
            addCriterion("ml_name >", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameGreaterThanOrEqualTo(String value) {
            addCriterion("ml_name >=", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameLessThan(String value) {
            addCriterion("ml_name <", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameLessThanOrEqualTo(String value) {
            addCriterion("ml_name <=", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameLike(String value) {
            addCriterion("ml_name like", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameNotLike(String value) {
            addCriterion("ml_name not like", value, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameIn(List<String> values) {
            addCriterion("ml_name in", values, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameNotIn(List<String> values) {
            addCriterion("ml_name not in", values, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameBetween(String value1, String value2) {
            addCriterion("ml_name between", value1, value2, "mlName");
            return (Criteria) this;
        }

        public Criteria andMlNameNotBetween(String value1, String value2) {
            addCriterion("ml_name not between", value1, value2, "mlName");
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

        public Criteria andUpgradeIsNull() {
            addCriterion("upgrade is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeIsNotNull() {
            addCriterion("upgrade is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeEqualTo(Integer value) {
            addCriterion("upgrade =", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeNotEqualTo(Integer value) {
            addCriterion("upgrade <>", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeGreaterThan(Integer value) {
            addCriterion("upgrade >", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("upgrade >=", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeLessThan(Integer value) {
            addCriterion("upgrade <", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeLessThanOrEqualTo(Integer value) {
            addCriterion("upgrade <=", value, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeIn(List<Integer> values) {
            addCriterion("upgrade in", values, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeNotIn(List<Integer> values) {
            addCriterion("upgrade not in", values, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeBetween(Integer value1, Integer value2) {
            addCriterion("upgrade between", value1, value2, "upgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("upgrade not between", value1, value2, "upgrade");
            return (Criteria) this;
        }

        public Criteria andValidityIsNull() {
            addCriterion("validity is null");
            return (Criteria) this;
        }

        public Criteria andValidityIsNotNull() {
            addCriterion("validity is not null");
            return (Criteria) this;
        }

        public Criteria andValidityEqualTo(Integer value) {
            addCriterion("validity =", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotEqualTo(Integer value) {
            addCriterion("validity <>", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThan(Integer value) {
            addCriterion("validity >", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("validity >=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThan(Integer value) {
            addCriterion("validity <", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThanOrEqualTo(Integer value) {
            addCriterion("validity <=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityIn(List<Integer> values) {
            addCriterion("validity in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotIn(List<Integer> values) {
            addCriterion("validity not in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityBetween(Integer value1, Integer value2) {
            addCriterion("validity between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("validity not between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleIsNull() {
            addCriterion("upgrade_rule is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleIsNotNull() {
            addCriterion("upgrade_rule is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleEqualTo(BigDecimal value) {
            addCriterion("upgrade_rule =", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleNotEqualTo(BigDecimal value) {
            addCriterion("upgrade_rule <>", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleGreaterThan(BigDecimal value) {
            addCriterion("upgrade_rule >", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("upgrade_rule >=", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleLessThan(BigDecimal value) {
            addCriterion("upgrade_rule <", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("upgrade_rule <=", value, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleIn(List<BigDecimal> values) {
            addCriterion("upgrade_rule in", values, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleNotIn(List<BigDecimal> values) {
            addCriterion("upgrade_rule not in", values, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upgrade_rule between", value1, value2, "upgradeRule");
            return (Criteria) this;
        }

        public Criteria andUpgradeRuleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upgrade_rule not between", value1, value2, "upgradeRule");
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