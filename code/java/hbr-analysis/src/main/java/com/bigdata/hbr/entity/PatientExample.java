package com.bigdata.hbr.entity;

import java.util.ArrayList;
import java.util.List;

public class PatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameIsNull() {
            addCriterion("doctor_login_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameIsNotNull() {
            addCriterion("doctor_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameEqualTo(String value) {
            addCriterion("doctor_login_name =", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameNotEqualTo(String value) {
            addCriterion("doctor_login_name <>", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameGreaterThan(String value) {
            addCriterion("doctor_login_name >", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_login_name >=", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameLessThan(String value) {
            addCriterion("doctor_login_name <", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_login_name <=", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameLike(String value) {
            addCriterion("doctor_login_name like", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameNotLike(String value) {
            addCriterion("doctor_login_name not like", value, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameIn(List<String> values) {
            addCriterion("doctor_login_name in", values, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameNotIn(List<String> values) {
            addCriterion("doctor_login_name not in", values, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameBetween(String value1, String value2) {
            addCriterion("doctor_login_name between", value1, value2, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andDoctorLoginNameNotBetween(String value1, String value2) {
            addCriterion("doctor_login_name not between", value1, value2, "doctorLoginName");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierIsNull() {
            addCriterion("heart_identifier is null");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierIsNotNull() {
            addCriterion("heart_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierEqualTo(String value) {
            addCriterion("heart_identifier =", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierNotEqualTo(String value) {
            addCriterion("heart_identifier <>", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierGreaterThan(String value) {
            addCriterion("heart_identifier >", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("heart_identifier >=", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierLessThan(String value) {
            addCriterion("heart_identifier <", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierLessThanOrEqualTo(String value) {
            addCriterion("heart_identifier <=", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierLike(String value) {
            addCriterion("heart_identifier like", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierNotLike(String value) {
            addCriterion("heart_identifier not like", value, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierIn(List<String> values) {
            addCriterion("heart_identifier in", values, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierNotIn(List<String> values) {
            addCriterion("heart_identifier not in", values, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierBetween(String value1, String value2) {
            addCriterion("heart_identifier between", value1, value2, "heartIdentifier");
            return (Criteria) this;
        }

        public Criteria andHeartIdentifierNotBetween(String value1, String value2) {
            addCriterion("heart_identifier not between", value1, value2, "heartIdentifier");
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

        public Criteria andTreatStatusIsNull() {
            addCriterion("treat_status is null");
            return (Criteria) this;
        }

        public Criteria andTreatStatusIsNotNull() {
            addCriterion("treat_status is not null");
            return (Criteria) this;
        }

        public Criteria andTreatStatusEqualTo(String value) {
            addCriterion("treat_status =", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusNotEqualTo(String value) {
            addCriterion("treat_status <>", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusGreaterThan(String value) {
            addCriterion("treat_status >", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusGreaterThanOrEqualTo(String value) {
            addCriterion("treat_status >=", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusLessThan(String value) {
            addCriterion("treat_status <", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusLessThanOrEqualTo(String value) {
            addCriterion("treat_status <=", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusLike(String value) {
            addCriterion("treat_status like", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusNotLike(String value) {
            addCriterion("treat_status not like", value, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusIn(List<String> values) {
            addCriterion("treat_status in", values, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusNotIn(List<String> values) {
            addCriterion("treat_status not in", values, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusBetween(String value1, String value2) {
            addCriterion("treat_status between", value1, value2, "treatStatus");
            return (Criteria) this;
        }

        public Criteria andTreatStatusNotBetween(String value1, String value2) {
            addCriterion("treat_status not between", value1, value2, "treatStatus");
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