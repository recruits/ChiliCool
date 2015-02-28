package com.zzc.netcrawler.beanset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetLogExampleOld {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public NetLogExampleOld() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
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
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
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

        public Criteria andTimeSegmIsNull() {
            addCriterion("time_segm is null");
            return (Criteria) this;
        }

        public Criteria andTimeSegmIsNotNull() {
            addCriterion("time_segm is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSegmEqualTo(Integer value) {
            addCriterion("time_segm =", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmNotEqualTo(Integer value) {
            addCriterion("time_segm <>", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmGreaterThan(Integer value) {
            addCriterion("time_segm >", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_segm >=", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmLessThan(Integer value) {
            addCriterion("time_segm <", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmLessThanOrEqualTo(Integer value) {
            addCriterion("time_segm <=", value, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmIn(List<Integer> values) {
            addCriterion("time_segm in", values, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmNotIn(List<Integer> values) {
            addCriterion("time_segm not in", values, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmBetween(Integer value1, Integer value2) {
            addCriterion("time_segm between", value1, value2, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeSegmNotBetween(Integer value1, Integer value2) {
            addCriterion("time_segm not between", value1, value2, "timeSegm");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIsNull() {
            addCriterion("time_unit is null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIsNotNull() {
            addCriterion("time_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUnitEqualTo(Integer value) {
            addCriterion("time_unit =", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotEqualTo(Integer value) {
            addCriterion("time_unit <>", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitGreaterThan(Integer value) {
            addCriterion("time_unit >", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_unit >=", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitLessThan(Integer value) {
            addCriterion("time_unit <", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitLessThanOrEqualTo(Integer value) {
            addCriterion("time_unit <=", value, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitIn(List<Integer> values) {
            addCriterion("time_unit in", values, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotIn(List<Integer> values) {
            addCriterion("time_unit not in", values, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitBetween(Integer value1, Integer value2) {
            addCriterion("time_unit between", value1, value2, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andTimeUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("time_unit not between", value1, value2, "timeUnit");
            return (Criteria) this;
        }

        public Criteria andAllAmtIsNull() {
            addCriterion("all_amt is null");
            return (Criteria) this;
        }

        public Criteria andAllAmtIsNotNull() {
            addCriterion("all_amt is not null");
            return (Criteria) this;
        }

        public Criteria andAllAmtEqualTo(Integer value) {
            addCriterion("all_amt =", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtNotEqualTo(Integer value) {
            addCriterion("all_amt <>", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtGreaterThan(Integer value) {
            addCriterion("all_amt >", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_amt >=", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtLessThan(Integer value) {
            addCriterion("all_amt <", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtLessThanOrEqualTo(Integer value) {
            addCriterion("all_amt <=", value, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtIn(List<Integer> values) {
            addCriterion("all_amt in", values, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtNotIn(List<Integer> values) {
            addCriterion("all_amt not in", values, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtBetween(Integer value1, Integer value2) {
            addCriterion("all_amt between", value1, value2, "allAmt");
            return (Criteria) this;
        }

        public Criteria andAllAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("all_amt not between", value1, value2, "allAmt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtIsNull() {
            addCriterion("sts10_amt is null");
            return (Criteria) this;
        }

        public Criteria andSts10AmtIsNotNull() {
            addCriterion("sts10_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSts10AmtEqualTo(Integer value) {
            addCriterion("sts10_amt =", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtNotEqualTo(Integer value) {
            addCriterion("sts10_amt <>", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtGreaterThan(Integer value) {
            addCriterion("sts10_amt >", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts10_amt >=", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtLessThan(Integer value) {
            addCriterion("sts10_amt <", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtLessThanOrEqualTo(Integer value) {
            addCriterion("sts10_amt <=", value, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtIn(List<Integer> values) {
            addCriterion("sts10_amt in", values, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtNotIn(List<Integer> values) {
            addCriterion("sts10_amt not in", values, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtBetween(Integer value1, Integer value2) {
            addCriterion("sts10_amt between", value1, value2, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts10AmtNotBetween(Integer value1, Integer value2) {
            addCriterion("sts10_amt not between", value1, value2, "sts10Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtIsNull() {
            addCriterion("sts11_amt is null");
            return (Criteria) this;
        }

        public Criteria andSts11AmtIsNotNull() {
            addCriterion("sts11_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSts11AmtEqualTo(Integer value) {
            addCriterion("sts11_amt =", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtNotEqualTo(Integer value) {
            addCriterion("sts11_amt <>", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtGreaterThan(Integer value) {
            addCriterion("sts11_amt >", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts11_amt >=", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtLessThan(Integer value) {
            addCriterion("sts11_amt <", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtLessThanOrEqualTo(Integer value) {
            addCriterion("sts11_amt <=", value, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtIn(List<Integer> values) {
            addCriterion("sts11_amt in", values, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtNotIn(List<Integer> values) {
            addCriterion("sts11_amt not in", values, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtBetween(Integer value1, Integer value2) {
            addCriterion("sts11_amt between", value1, value2, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts11AmtNotBetween(Integer value1, Integer value2) {
            addCriterion("sts11_amt not between", value1, value2, "sts11Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtIsNull() {
            addCriterion("sts12_amt is null");
            return (Criteria) this;
        }

        public Criteria andSts12AmtIsNotNull() {
            addCriterion("sts12_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSts12AmtEqualTo(Integer value) {
            addCriterion("sts12_amt =", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtNotEqualTo(Integer value) {
            addCriterion("sts12_amt <>", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtGreaterThan(Integer value) {
            addCriterion("sts12_amt >", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts12_amt >=", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtLessThan(Integer value) {
            addCriterion("sts12_amt <", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtLessThanOrEqualTo(Integer value) {
            addCriterion("sts12_amt <=", value, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtIn(List<Integer> values) {
            addCriterion("sts12_amt in", values, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtNotIn(List<Integer> values) {
            addCriterion("sts12_amt not in", values, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtBetween(Integer value1, Integer value2) {
            addCriterion("sts12_amt between", value1, value2, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts12AmtNotBetween(Integer value1, Integer value2) {
            addCriterion("sts12_amt not between", value1, value2, "sts12Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtIsNull() {
            addCriterion("sts13_amt is null");
            return (Criteria) this;
        }

        public Criteria andSts13AmtIsNotNull() {
            addCriterion("sts13_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSts13AmtEqualTo(Integer value) {
            addCriterion("sts13_amt =", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtNotEqualTo(Integer value) {
            addCriterion("sts13_amt <>", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtGreaterThan(Integer value) {
            addCriterion("sts13_amt >", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts13_amt >=", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtLessThan(Integer value) {
            addCriterion("sts13_amt <", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtLessThanOrEqualTo(Integer value) {
            addCriterion("sts13_amt <=", value, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtIn(List<Integer> values) {
            addCriterion("sts13_amt in", values, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtNotIn(List<Integer> values) {
            addCriterion("sts13_amt not in", values, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtBetween(Integer value1, Integer value2) {
            addCriterion("sts13_amt between", value1, value2, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts13AmtNotBetween(Integer value1, Integer value2) {
            addCriterion("sts13_amt not between", value1, value2, "sts13Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtIsNull() {
            addCriterion("sts21_amt is null");
            return (Criteria) this;
        }

        public Criteria andSts21AmtIsNotNull() {
            addCriterion("sts21_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSts21AmtEqualTo(Integer value) {
            addCriterion("sts21_amt =", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtNotEqualTo(Integer value) {
            addCriterion("sts21_amt <>", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtGreaterThan(Integer value) {
            addCriterion("sts21_amt >", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts21_amt >=", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtLessThan(Integer value) {
            addCriterion("sts21_amt <", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtLessThanOrEqualTo(Integer value) {
            addCriterion("sts21_amt <=", value, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtIn(List<Integer> values) {
            addCriterion("sts21_amt in", values, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtNotIn(List<Integer> values) {
            addCriterion("sts21_amt not in", values, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtBetween(Integer value1, Integer value2) {
            addCriterion("sts21_amt between", value1, value2, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andSts21AmtNotBetween(Integer value1, Integer value2) {
            addCriterion("sts21_amt not between", value1, value2, "sts21Amt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtIsNull() {
            addCriterion("all_ext_amt is null");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtIsNotNull() {
            addCriterion("all_ext_amt is not null");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtEqualTo(Integer value) {
            addCriterion("all_ext_amt =", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtNotEqualTo(Integer value) {
            addCriterion("all_ext_amt <>", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtGreaterThan(Integer value) {
            addCriterion("all_ext_amt >", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_ext_amt >=", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtLessThan(Integer value) {
            addCriterion("all_ext_amt <", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtLessThanOrEqualTo(Integer value) {
            addCriterion("all_ext_amt <=", value, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtIn(List<Integer> values) {
            addCriterion("all_ext_amt in", values, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtNotIn(List<Integer> values) {
            addCriterion("all_ext_amt not in", values, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtBetween(Integer value1, Integer value2) {
            addCriterion("all_ext_amt between", value1, value2, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andAllExtAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("all_ext_amt not between", value1, value2, "allExtAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtIsNull() {
            addCriterion("rq_appd_amt is null");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtIsNotNull() {
            addCriterion("rq_appd_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtEqualTo(Integer value) {
            addCriterion("rq_appd_amt =", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtNotEqualTo(Integer value) {
            addCriterion("rq_appd_amt <>", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtGreaterThan(Integer value) {
            addCriterion("rq_appd_amt >", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("rq_appd_amt >=", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtLessThan(Integer value) {
            addCriterion("rq_appd_amt <", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtLessThanOrEqualTo(Integer value) {
            addCriterion("rq_appd_amt <=", value, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtIn(List<Integer> values) {
            addCriterion("rq_appd_amt in", values, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtNotIn(List<Integer> values) {
            addCriterion("rq_appd_amt not in", values, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtBetween(Integer value1, Integer value2) {
            addCriterion("rq_appd_amt between", value1, value2, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andRqAppdAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("rq_appd_amt not between", value1, value2, "rqAppdAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtIsNull() {
            addCriterion("wq_pars_amt is null");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtIsNotNull() {
            addCriterion("wq_pars_amt is not null");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtEqualTo(Integer value) {
            addCriterion("wq_pars_amt =", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtNotEqualTo(Integer value) {
            addCriterion("wq_pars_amt <>", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtGreaterThan(Integer value) {
            addCriterion("wq_pars_amt >", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("wq_pars_amt >=", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtLessThan(Integer value) {
            addCriterion("wq_pars_amt <", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtLessThanOrEqualTo(Integer value) {
            addCriterion("wq_pars_amt <=", value, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtIn(List<Integer> values) {
            addCriterion("wq_pars_amt in", values, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtNotIn(List<Integer> values) {
            addCriterion("wq_pars_amt not in", values, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtBetween(Integer value1, Integer value2) {
            addCriterion("wq_pars_amt between", value1, value2, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andWqParsAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("wq_pars_amt not between", value1, value2, "wqParsAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtIsNull() {
            addCriterion("appd_amt is null");
            return (Criteria) this;
        }

        public Criteria andAppdAmtIsNotNull() {
            addCriterion("appd_amt is not null");
            return (Criteria) this;
        }

        public Criteria andAppdAmtEqualTo(Integer value) {
            addCriterion("appd_amt =", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtNotEqualTo(Integer value) {
            addCriterion("appd_amt <>", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtGreaterThan(Integer value) {
            addCriterion("appd_amt >", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("appd_amt >=", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtLessThan(Integer value) {
            addCriterion("appd_amt <", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtLessThanOrEqualTo(Integer value) {
            addCriterion("appd_amt <=", value, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtIn(List<Integer> values) {
            addCriterion("appd_amt in", values, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtNotIn(List<Integer> values) {
            addCriterion("appd_amt not in", values, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtBetween(Integer value1, Integer value2) {
            addCriterion("appd_amt between", value1, value2, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andAppdAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("appd_amt not between", value1, value2, "appdAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtIsNull() {
            addCriterion("pars_amt is null");
            return (Criteria) this;
        }

        public Criteria andParsAmtIsNotNull() {
            addCriterion("pars_amt is not null");
            return (Criteria) this;
        }

        public Criteria andParsAmtEqualTo(Integer value) {
            addCriterion("pars_amt =", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtNotEqualTo(Integer value) {
            addCriterion("pars_amt <>", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtGreaterThan(Integer value) {
            addCriterion("pars_amt >", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("pars_amt >=", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtLessThan(Integer value) {
            addCriterion("pars_amt <", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtLessThanOrEqualTo(Integer value) {
            addCriterion("pars_amt <=", value, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtIn(List<Integer> values) {
            addCriterion("pars_amt in", values, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtNotIn(List<Integer> values) {
            addCriterion("pars_amt not in", values, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtBetween(Integer value1, Integer value2) {
            addCriterion("pars_amt between", value1, value2, "parsAmt");
            return (Criteria) this;
        }

        public Criteria andParsAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("pars_amt not between", value1, value2, "parsAmt");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_log
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 17 13:06:00 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_log
     *
     * @mbggenerated Mon Mar 17 13:06:00 CST 2014
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