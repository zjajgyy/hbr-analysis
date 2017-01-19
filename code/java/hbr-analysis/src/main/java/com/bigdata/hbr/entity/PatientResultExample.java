package com.bigdata.hbr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientResultExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andSd1IsNull() {
            addCriterion("sd1 is null");
            return (Criteria) this;
        }

        public Criteria andSd1IsNotNull() {
            addCriterion("sd1 is not null");
            return (Criteria) this;
        }

        public Criteria andSd1EqualTo(Double value) {
            addCriterion("sd1 =", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1NotEqualTo(Double value) {
            addCriterion("sd1 <>", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1GreaterThan(Double value) {
            addCriterion("sd1 >", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1GreaterThanOrEqualTo(Double value) {
            addCriterion("sd1 >=", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1LessThan(Double value) {
            addCriterion("sd1 <", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1LessThanOrEqualTo(Double value) {
            addCriterion("sd1 <=", value, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1In(List<Double> values) {
            addCriterion("sd1 in", values, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1NotIn(List<Double> values) {
            addCriterion("sd1 not in", values, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1Between(Double value1, Double value2) {
            addCriterion("sd1 between", value1, value2, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd1NotBetween(Double value1, Double value2) {
            addCriterion("sd1 not between", value1, value2, "sd1");
            return (Criteria) this;
        }

        public Criteria andSd2IsNull() {
            addCriterion("sd2 is null");
            return (Criteria) this;
        }

        public Criteria andSd2IsNotNull() {
            addCriterion("sd2 is not null");
            return (Criteria) this;
        }

        public Criteria andSd2EqualTo(Double value) {
            addCriterion("sd2 =", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2NotEqualTo(Double value) {
            addCriterion("sd2 <>", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2GreaterThan(Double value) {
            addCriterion("sd2 >", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2GreaterThanOrEqualTo(Double value) {
            addCriterion("sd2 >=", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2LessThan(Double value) {
            addCriterion("sd2 <", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2LessThanOrEqualTo(Double value) {
            addCriterion("sd2 <=", value, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2In(List<Double> values) {
            addCriterion("sd2 in", values, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2NotIn(List<Double> values) {
            addCriterion("sd2 not in", values, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2Between(Double value1, Double value2) {
            addCriterion("sd2 between", value1, value2, "sd2");
            return (Criteria) this;
        }

        public Criteria andSd2NotBetween(Double value1, Double value2) {
            addCriterion("sd2 not between", value1, value2, "sd2");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIsNull() {
            addCriterion("health_status is null");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIsNotNull() {
            addCriterion("health_status is not null");
            return (Criteria) this;
        }

        public Criteria andHealthStatusEqualTo(String value) {
            addCriterion("health_status =", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotEqualTo(String value) {
            addCriterion("health_status <>", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusGreaterThan(String value) {
            addCriterion("health_status >", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusGreaterThanOrEqualTo(String value) {
            addCriterion("health_status >=", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusLessThan(String value) {
            addCriterion("health_status <", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusLessThanOrEqualTo(String value) {
            addCriterion("health_status <=", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusLike(String value) {
            addCriterion("health_status like", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotLike(String value) {
            addCriterion("health_status not like", value, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusIn(List<String> values) {
            addCriterion("health_status in", values, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotIn(List<String> values) {
            addCriterion("health_status not in", values, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusBetween(String value1, String value2) {
            addCriterion("health_status between", value1, value2, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andHealthStatusNotBetween(String value1, String value2) {
            addCriterion("health_status not between", value1, value2, "healthStatus");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
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