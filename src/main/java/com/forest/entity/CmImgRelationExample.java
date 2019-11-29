package com.forest.entity;

import java.util.ArrayList;
import java.util.List;

public class CmImgRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmImgRelationExample() {
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

        public Criteria andCirIdIsNull() {
            addCriterion("cir_Id is null");
            return (Criteria) this;
        }

        public Criteria andCirIdIsNotNull() {
            addCriterion("cir_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCirIdEqualTo(Integer value) {
            addCriterion("cir_Id =", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdNotEqualTo(Integer value) {
            addCriterion("cir_Id <>", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdGreaterThan(Integer value) {
            addCriterion("cir_Id >", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cir_Id >=", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdLessThan(Integer value) {
            addCriterion("cir_Id <", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdLessThanOrEqualTo(Integer value) {
            addCriterion("cir_Id <=", value, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdIn(List<Integer> values) {
            addCriterion("cir_Id in", values, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdNotIn(List<Integer> values) {
            addCriterion("cir_Id not in", values, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdBetween(Integer value1, Integer value2) {
            addCriterion("cir_Id between", value1, value2, "cirId");
            return (Criteria) this;
        }

        public Criteria andCirIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cir_Id not between", value1, value2, "cirId");
            return (Criteria) this;
        }

        public Criteria andCmIdIsNull() {
            addCriterion("cm_id is null");
            return (Criteria) this;
        }

        public Criteria andCmIdIsNotNull() {
            addCriterion("cm_id is not null");
            return (Criteria) this;
        }

        public Criteria andCmIdEqualTo(Integer value) {
            addCriterion("cm_id =", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdNotEqualTo(Integer value) {
            addCriterion("cm_id <>", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdGreaterThan(Integer value) {
            addCriterion("cm_id >", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_id >=", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdLessThan(Integer value) {
            addCriterion("cm_id <", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdLessThanOrEqualTo(Integer value) {
            addCriterion("cm_id <=", value, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdIn(List<Integer> values) {
            addCriterion("cm_id in", values, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdNotIn(List<Integer> values) {
            addCriterion("cm_id not in", values, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdBetween(Integer value1, Integer value2) {
            addCriterion("cm_id between", value1, value2, "cmId");
            return (Criteria) this;
        }

        public Criteria andCmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_id not between", value1, value2, "cmId");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(Integer value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(Integer value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(Integer value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(Integer value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(Integer value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<Integer> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<Integer> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(Integer value1, Integer value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andIsMainIsNull() {
            addCriterion("is_main is null");
            return (Criteria) this;
        }

        public Criteria andIsMainIsNotNull() {
            addCriterion("is_main is not null");
            return (Criteria) this;
        }

        public Criteria andIsMainEqualTo(Integer value) {
            addCriterion("is_main =", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotEqualTo(Integer value) {
            addCriterion("is_main <>", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainGreaterThan(Integer value) {
            addCriterion("is_main >", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_main >=", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainLessThan(Integer value) {
            addCriterion("is_main <", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainLessThanOrEqualTo(Integer value) {
            addCriterion("is_main <=", value, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainIn(List<Integer> values) {
            addCriterion("is_main in", values, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotIn(List<Integer> values) {
            addCriterion("is_main not in", values, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainBetween(Integer value1, Integer value2) {
            addCriterion("is_main between", value1, value2, "isMain");
            return (Criteria) this;
        }

        public Criteria andIsMainNotBetween(Integer value1, Integer value2) {
            addCriterion("is_main not between", value1, value2, "isMain");
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