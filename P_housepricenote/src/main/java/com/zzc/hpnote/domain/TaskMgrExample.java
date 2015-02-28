package com.zzc.hpnote.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMgrExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public TaskMgrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("T_ID is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("T_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("T_ID =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("T_ID <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("T_ID >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("T_ID >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("T_ID <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("T_ID <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("T_ID like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("T_ID not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("T_ID in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("T_ID not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("T_ID between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("T_ID not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTStateIsNull() {
            addCriterion("T_STATE is null");
            return (Criteria) this;
        }

        public Criteria andTStateIsNotNull() {
            addCriterion("T_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andTStateEqualTo(String value) {
            addCriterion("T_STATE =", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateNotEqualTo(String value) {
            addCriterion("T_STATE <>", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateGreaterThan(String value) {
            addCriterion("T_STATE >", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateGreaterThanOrEqualTo(String value) {
            addCriterion("T_STATE >=", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateLessThan(String value) {
            addCriterion("T_STATE <", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateLessThanOrEqualTo(String value) {
            addCriterion("T_STATE <=", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateLike(String value) {
            addCriterion("T_STATE like", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateNotLike(String value) {
            addCriterion("T_STATE not like", value, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateIn(List<String> values) {
            addCriterion("T_STATE in", values, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateNotIn(List<String> values) {
            addCriterion("T_STATE not in", values, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateBetween(String value1, String value2) {
            addCriterion("T_STATE between", value1, value2, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateNotBetween(String value1, String value2) {
            addCriterion("T_STATE not between", value1, value2, "tState");
            return (Criteria) this;
        }

        public Criteria andTStateTimeIsNull() {
            addCriterion("T_STATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTStateTimeIsNotNull() {
            addCriterion("T_STATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTStateTimeEqualTo(Date value) {
            addCriterion("T_STATE_TIME =", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeNotEqualTo(Date value) {
            addCriterion("T_STATE_TIME <>", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeGreaterThan(Date value) {
            addCriterion("T_STATE_TIME >", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("T_STATE_TIME >=", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeLessThan(Date value) {
            addCriterion("T_STATE_TIME <", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeLessThanOrEqualTo(Date value) {
            addCriterion("T_STATE_TIME <=", value, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeIn(List<Date> values) {
            addCriterion("T_STATE_TIME in", values, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeNotIn(List<Date> values) {
            addCriterion("T_STATE_TIME not in", values, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeBetween(Date value1, Date value2) {
            addCriterion("T_STATE_TIME between", value1, value2, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andTStateTimeNotBetween(Date value1, Date value2) {
            addCriterion("T_STATE_TIME not between", value1, value2, "tStateTime");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("USER is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("USER is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("USER =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("USER <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("USER >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("USER >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("USER <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("USER <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("USER like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("USER not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("USER in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("USER not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("USER between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("USER not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("REG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("REG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("REG_TIME =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("REG_TIME <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("REG_TIME >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REG_TIME >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("REG_TIME <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("REG_TIME <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("REG_TIME in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("REG_TIME not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("REG_TIME between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("REG_TIME not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNull() {
            addCriterion("TASK_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNotNull() {
            addCriterion("TASK_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumEqualTo(Integer value) {
            addCriterion("TASK_NUM =", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotEqualTo(Integer value) {
            addCriterion("TASK_NUM <>", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThan(Integer value) {
            addCriterion("TASK_NUM >", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUM >=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThan(Integer value) {
            addCriterion("TASK_NUM <", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUM <=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumIn(List<Integer> values) {
            addCriterion("TASK_NUM in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotIn(List<Integer> values) {
            addCriterion("TASK_NUM not in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUM between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUM not between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumIsNull() {
            addCriterion("SUCC_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSuccNumIsNotNull() {
            addCriterion("SUCC_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSuccNumEqualTo(Integer value) {
            addCriterion("SUCC_NUM =", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumNotEqualTo(Integer value) {
            addCriterion("SUCC_NUM <>", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumGreaterThan(Integer value) {
            addCriterion("SUCC_NUM >", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUCC_NUM >=", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumLessThan(Integer value) {
            addCriterion("SUCC_NUM <", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumLessThanOrEqualTo(Integer value) {
            addCriterion("SUCC_NUM <=", value, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumIn(List<Integer> values) {
            addCriterion("SUCC_NUM in", values, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumNotIn(List<Integer> values) {
            addCriterion("SUCC_NUM not in", values, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumBetween(Integer value1, Integer value2) {
            addCriterion("SUCC_NUM between", value1, value2, "succNum");
            return (Criteria) this;
        }

        public Criteria andSuccNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SUCC_NUM not between", value1, value2, "succNum");
            return (Criteria) this;
        }

        public Criteria andFailNumIsNull() {
            addCriterion("FAIL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFailNumIsNotNull() {
            addCriterion("FAIL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFailNumEqualTo(Integer value) {
            addCriterion("FAIL_NUM =", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotEqualTo(Integer value) {
            addCriterion("FAIL_NUM <>", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumGreaterThan(Integer value) {
            addCriterion("FAIL_NUM >", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAIL_NUM >=", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumLessThan(Integer value) {
            addCriterion("FAIL_NUM <", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumLessThanOrEqualTo(Integer value) {
            addCriterion("FAIL_NUM <=", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumIn(List<Integer> values) {
            addCriterion("FAIL_NUM in", values, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotIn(List<Integer> values) {
            addCriterion("FAIL_NUM not in", values, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumBetween(Integer value1, Integer value2) {
            addCriterion("FAIL_NUM between", value1, value2, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotBetween(Integer value1, Integer value2) {
            addCriterion("FAIL_NUM not between", value1, value2, "failNum");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdIsNull() {
            addCriterion("BEG_TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdIsNotNull() {
            addCriterion("BEG_TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdEqualTo(String value) {
            addCriterion("BEG_TASK_ID =", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdNotEqualTo(String value) {
            addCriterion("BEG_TASK_ID <>", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdGreaterThan(String value) {
            addCriterion("BEG_TASK_ID >", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("BEG_TASK_ID >=", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdLessThan(String value) {
            addCriterion("BEG_TASK_ID <", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdLessThanOrEqualTo(String value) {
            addCriterion("BEG_TASK_ID <=", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdLike(String value) {
            addCriterion("BEG_TASK_ID like", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdNotLike(String value) {
            addCriterion("BEG_TASK_ID not like", value, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdIn(List<String> values) {
            addCriterion("BEG_TASK_ID in", values, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdNotIn(List<String> values) {
            addCriterion("BEG_TASK_ID not in", values, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdBetween(String value1, String value2) {
            addCriterion("BEG_TASK_ID between", value1, value2, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andBegTaskIdNotBetween(String value1, String value2) {
            addCriterion("BEG_TASK_ID not between", value1, value2, "begTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdIsNull() {
            addCriterion("END_TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdIsNotNull() {
            addCriterion("END_TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdEqualTo(String value) {
            addCriterion("END_TASK_ID =", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdNotEqualTo(String value) {
            addCriterion("END_TASK_ID <>", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdGreaterThan(String value) {
            addCriterion("END_TASK_ID >", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("END_TASK_ID >=", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdLessThan(String value) {
            addCriterion("END_TASK_ID <", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdLessThanOrEqualTo(String value) {
            addCriterion("END_TASK_ID <=", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdLike(String value) {
            addCriterion("END_TASK_ID like", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdNotLike(String value) {
            addCriterion("END_TASK_ID not like", value, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdIn(List<String> values) {
            addCriterion("END_TASK_ID in", values, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdNotIn(List<String> values) {
            addCriterion("END_TASK_ID not in", values, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdBetween(String value1, String value2) {
            addCriterion("END_TASK_ID between", value1, value2, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andEndTaskIdNotBetween(String value1, String value2) {
            addCriterion("END_TASK_ID not between", value1, value2, "endTaskId");
            return (Criteria) this;
        }

        public Criteria andExecMilIsNull() {
            addCriterion("EXEC_MIL is null");
            return (Criteria) this;
        }

        public Criteria andExecMilIsNotNull() {
            addCriterion("EXEC_MIL is not null");
            return (Criteria) this;
        }

        public Criteria andExecMilEqualTo(Integer value) {
            addCriterion("EXEC_MIL =", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilNotEqualTo(Integer value) {
            addCriterion("EXEC_MIL <>", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilGreaterThan(Integer value) {
            addCriterion("EXEC_MIL >", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXEC_MIL >=", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilLessThan(Integer value) {
            addCriterion("EXEC_MIL <", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilLessThanOrEqualTo(Integer value) {
            addCriterion("EXEC_MIL <=", value, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilIn(List<Integer> values) {
            addCriterion("EXEC_MIL in", values, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilNotIn(List<Integer> values) {
            addCriterion("EXEC_MIL not in", values, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilBetween(Integer value1, Integer value2) {
            addCriterion("EXEC_MIL between", value1, value2, "execMil");
            return (Criteria) this;
        }

        public Criteria andExecMilNotBetween(Integer value1, Integer value2) {
            addCriterion("EXEC_MIL not between", value1, value2, "execMil");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_mgr
     *
     * @mbggenerated do_not_delete_during_merge Wed May 28 10:07:41 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_mgr
     *
     * @mbggenerated Wed May 28 10:07:41 CST 2014
     */
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