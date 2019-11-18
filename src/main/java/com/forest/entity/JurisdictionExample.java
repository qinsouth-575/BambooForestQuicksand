package com.forest.entity;

import java.util.ArrayList;
import java.util.List;

public class JurisdictionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JurisdictionExample() {
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

        public Criteria andJurIdIsNull() {
            addCriterion("jur_id is null");
            return (Criteria) this;
        }

        public Criteria andJurIdIsNotNull() {
            addCriterion("jur_id is not null");
            return (Criteria) this;
        }

        public Criteria andJurIdEqualTo(Integer value) {
            addCriterion("jur_id =", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotEqualTo(Integer value) {
            addCriterion("jur_id <>", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdGreaterThan(Integer value) {
            addCriterion("jur_id >", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jur_id >=", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdLessThan(Integer value) {
            addCriterion("jur_id <", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdLessThanOrEqualTo(Integer value) {
            addCriterion("jur_id <=", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdIn(List<Integer> values) {
            addCriterion("jur_id in", values, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotIn(List<Integer> values) {
            addCriterion("jur_id not in", values, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdBetween(Integer value1, Integer value2) {
            addCriterion("jur_id between", value1, value2, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jur_id not between", value1, value2, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurNameIsNull() {
            addCriterion("jur_name is null");
            return (Criteria) this;
        }

        public Criteria andJurNameIsNotNull() {
            addCriterion("jur_name is not null");
            return (Criteria) this;
        }

        public Criteria andJurNameEqualTo(String value) {
            addCriterion("jur_name =", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotEqualTo(String value) {
            addCriterion("jur_name <>", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameGreaterThan(String value) {
            addCriterion("jur_name >", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameGreaterThanOrEqualTo(String value) {
            addCriterion("jur_name >=", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLessThan(String value) {
            addCriterion("jur_name <", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLessThanOrEqualTo(String value) {
            addCriterion("jur_name <=", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLike(String value) {
            addCriterion("jur_name like", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotLike(String value) {
            addCriterion("jur_name not like", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameIn(List<String> values) {
            addCriterion("jur_name in", values, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotIn(List<String> values) {
            addCriterion("jur_name not in", values, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameBetween(String value1, String value2) {
            addCriterion("jur_name between", value1, value2, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotBetween(String value1, String value2) {
            addCriterion("jur_name not between", value1, value2, "jurName");
            return (Criteria) this;
        }

        public Criteria andParentJurIdIsNull() {
            addCriterion("parent_jur_id is null");
            return (Criteria) this;
        }

        public Criteria andParentJurIdIsNotNull() {
            addCriterion("parent_jur_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentJurIdEqualTo(Integer value) {
            addCriterion("parent_jur_id =", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdNotEqualTo(Integer value) {
            addCriterion("parent_jur_id <>", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdGreaterThan(Integer value) {
            addCriterion("parent_jur_id >", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_jur_id >=", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdLessThan(Integer value) {
            addCriterion("parent_jur_id <", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_jur_id <=", value, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdIn(List<Integer> values) {
            addCriterion("parent_jur_id in", values, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdNotIn(List<Integer> values) {
            addCriterion("parent_jur_id not in", values, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_jur_id between", value1, value2, "parentJurId");
            return (Criteria) this;
        }

        public Criteria andParentJurIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_jur_id not between", value1, value2, "parentJurId");
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