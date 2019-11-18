package com.forest.entity;

import java.util.ArrayList;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andSetIdIsNull() {
            addCriterion("set_id is null");
            return (Criteria) this;
        }

        public Criteria andSetIdIsNotNull() {
            addCriterion("set_id is not null");
            return (Criteria) this;
        }

        public Criteria andSetIdEqualTo(Short value) {
            addCriterion("set_id =", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotEqualTo(Short value) {
            addCriterion("set_id <>", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThan(Short value) {
            addCriterion("set_id >", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdGreaterThanOrEqualTo(Short value) {
            addCriterion("set_id >=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThan(Short value) {
            addCriterion("set_id <", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdLessThanOrEqualTo(Short value) {
            addCriterion("set_id <=", value, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdIn(List<Short> values) {
            addCriterion("set_id in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotIn(List<Short> values) {
            addCriterion("set_id not in", values, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdBetween(Short value1, Short value2) {
            addCriterion("set_id between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andSetIdNotBetween(Short value1, Short value2) {
            addCriterion("set_id not between", value1, value2, "setId");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("property_name =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("property_name >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("property_name <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLike(String value) {
            addCriterion("property_name like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("property_name not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("property_name in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIsNull() {
            addCriterion("property_value is null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIsNotNull() {
            addCriterion("property_value is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueEqualTo(String value) {
            addCriterion("property_value =", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotEqualTo(String value) {
            addCriterion("property_value <>", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueGreaterThan(String value) {
            addCriterion("property_value >", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueGreaterThanOrEqualTo(String value) {
            addCriterion("property_value >=", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLessThan(String value) {
            addCriterion("property_value <", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLessThanOrEqualTo(String value) {
            addCriterion("property_value <=", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueLike(String value) {
            addCriterion("property_value like", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotLike(String value) {
            addCriterion("property_value not like", value, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIn(List<String> values) {
            addCriterion("property_value in", values, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotIn(List<String> values) {
            addCriterion("property_value not in", values, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueBetween(String value1, String value2) {
            addCriterion("property_value between", value1, value2, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPropertyValueNotBetween(String value1, String value2) {
            addCriterion("property_value not between", value1, value2, "propertyValue");
            return (Criteria) this;
        }

        public Criteria andPrev1IsNull() {
            addCriterion("prev1 is null");
            return (Criteria) this;
        }

        public Criteria andPrev1IsNotNull() {
            addCriterion("prev1 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev1EqualTo(String value) {
            addCriterion("prev1 =", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1NotEqualTo(String value) {
            addCriterion("prev1 <>", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1GreaterThan(String value) {
            addCriterion("prev1 >", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1GreaterThanOrEqualTo(String value) {
            addCriterion("prev1 >=", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1LessThan(String value) {
            addCriterion("prev1 <", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1LessThanOrEqualTo(String value) {
            addCriterion("prev1 <=", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1Like(String value) {
            addCriterion("prev1 like", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1NotLike(String value) {
            addCriterion("prev1 not like", value, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1In(List<String> values) {
            addCriterion("prev1 in", values, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1NotIn(List<String> values) {
            addCriterion("prev1 not in", values, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1Between(String value1, String value2) {
            addCriterion("prev1 between", value1, value2, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev1NotBetween(String value1, String value2) {
            addCriterion("prev1 not between", value1, value2, "prev1");
            return (Criteria) this;
        }

        public Criteria andPrev2IsNull() {
            addCriterion("prev2 is null");
            return (Criteria) this;
        }

        public Criteria andPrev2IsNotNull() {
            addCriterion("prev2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev2EqualTo(String value) {
            addCriterion("prev2 =", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2NotEqualTo(String value) {
            addCriterion("prev2 <>", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2GreaterThan(String value) {
            addCriterion("prev2 >", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2GreaterThanOrEqualTo(String value) {
            addCriterion("prev2 >=", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2LessThan(String value) {
            addCriterion("prev2 <", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2LessThanOrEqualTo(String value) {
            addCriterion("prev2 <=", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2Like(String value) {
            addCriterion("prev2 like", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2NotLike(String value) {
            addCriterion("prev2 not like", value, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2In(List<String> values) {
            addCriterion("prev2 in", values, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2NotIn(List<String> values) {
            addCriterion("prev2 not in", values, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2Between(String value1, String value2) {
            addCriterion("prev2 between", value1, value2, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev2NotBetween(String value1, String value2) {
            addCriterion("prev2 not between", value1, value2, "prev2");
            return (Criteria) this;
        }

        public Criteria andPrev3IsNull() {
            addCriterion("prev3 is null");
            return (Criteria) this;
        }

        public Criteria andPrev3IsNotNull() {
            addCriterion("prev3 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev3EqualTo(String value) {
            addCriterion("prev3 =", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3NotEqualTo(String value) {
            addCriterion("prev3 <>", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3GreaterThan(String value) {
            addCriterion("prev3 >", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3GreaterThanOrEqualTo(String value) {
            addCriterion("prev3 >=", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3LessThan(String value) {
            addCriterion("prev3 <", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3LessThanOrEqualTo(String value) {
            addCriterion("prev3 <=", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3Like(String value) {
            addCriterion("prev3 like", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3NotLike(String value) {
            addCriterion("prev3 not like", value, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3In(List<String> values) {
            addCriterion("prev3 in", values, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3NotIn(List<String> values) {
            addCriterion("prev3 not in", values, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3Between(String value1, String value2) {
            addCriterion("prev3 between", value1, value2, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev3NotBetween(String value1, String value2) {
            addCriterion("prev3 not between", value1, value2, "prev3");
            return (Criteria) this;
        }

        public Criteria andPrev4IsNull() {
            addCriterion("prev4 is null");
            return (Criteria) this;
        }

        public Criteria andPrev4IsNotNull() {
            addCriterion("prev4 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev4EqualTo(String value) {
            addCriterion("prev4 =", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4NotEqualTo(String value) {
            addCriterion("prev4 <>", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4GreaterThan(String value) {
            addCriterion("prev4 >", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4GreaterThanOrEqualTo(String value) {
            addCriterion("prev4 >=", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4LessThan(String value) {
            addCriterion("prev4 <", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4LessThanOrEqualTo(String value) {
            addCriterion("prev4 <=", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4Like(String value) {
            addCriterion("prev4 like", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4NotLike(String value) {
            addCriterion("prev4 not like", value, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4In(List<String> values) {
            addCriterion("prev4 in", values, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4NotIn(List<String> values) {
            addCriterion("prev4 not in", values, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4Between(String value1, String value2) {
            addCriterion("prev4 between", value1, value2, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev4NotBetween(String value1, String value2) {
            addCriterion("prev4 not between", value1, value2, "prev4");
            return (Criteria) this;
        }

        public Criteria andPrev5IsNull() {
            addCriterion("prev5 is null");
            return (Criteria) this;
        }

        public Criteria andPrev5IsNotNull() {
            addCriterion("prev5 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev5EqualTo(String value) {
            addCriterion("prev5 =", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5NotEqualTo(String value) {
            addCriterion("prev5 <>", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5GreaterThan(String value) {
            addCriterion("prev5 >", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5GreaterThanOrEqualTo(String value) {
            addCriterion("prev5 >=", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5LessThan(String value) {
            addCriterion("prev5 <", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5LessThanOrEqualTo(String value) {
            addCriterion("prev5 <=", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5Like(String value) {
            addCriterion("prev5 like", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5NotLike(String value) {
            addCriterion("prev5 not like", value, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5In(List<String> values) {
            addCriterion("prev5 in", values, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5NotIn(List<String> values) {
            addCriterion("prev5 not in", values, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5Between(String value1, String value2) {
            addCriterion("prev5 between", value1, value2, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev5NotBetween(String value1, String value2) {
            addCriterion("prev5 not between", value1, value2, "prev5");
            return (Criteria) this;
        }

        public Criteria andPrev6IsNull() {
            addCriterion("prev6 is null");
            return (Criteria) this;
        }

        public Criteria andPrev6IsNotNull() {
            addCriterion("prev6 is not null");
            return (Criteria) this;
        }

        public Criteria andPrev6EqualTo(String value) {
            addCriterion("prev6 =", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6NotEqualTo(String value) {
            addCriterion("prev6 <>", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6GreaterThan(String value) {
            addCriterion("prev6 >", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6GreaterThanOrEqualTo(String value) {
            addCriterion("prev6 >=", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6LessThan(String value) {
            addCriterion("prev6 <", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6LessThanOrEqualTo(String value) {
            addCriterion("prev6 <=", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6Like(String value) {
            addCriterion("prev6 like", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6NotLike(String value) {
            addCriterion("prev6 not like", value, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6In(List<String> values) {
            addCriterion("prev6 in", values, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6NotIn(List<String> values) {
            addCriterion("prev6 not in", values, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6Between(String value1, String value2) {
            addCriterion("prev6 between", value1, value2, "prev6");
            return (Criteria) this;
        }

        public Criteria andPrev6NotBetween(String value1, String value2) {
            addCriterion("prev6 not between", value1, value2, "prev6");
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