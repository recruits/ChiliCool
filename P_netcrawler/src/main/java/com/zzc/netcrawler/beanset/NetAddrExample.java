package com.zzc.netcrawler.beanset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetAddrExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected List<Criteria> oredCriteria;

    protected String limitClause;
    public String getLimitClause() {
		return limitClause;
	}
	private void setLimitClause(String limitClause) {
		this.limitClause = " limit " + limitClause;
	}
	public void setLimitClause(int limitClause) {
		setLimitClause(limitClause + "");
	}
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public NetAddrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
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
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
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

        public Criteria andNetIdIsNull() {
            addCriterion("net_id is null");
            return (Criteria) this;
        }

        public Criteria andNetIdIsNotNull() {
            addCriterion("net_id is not null");
            return (Criteria) this;
        }

        public Criteria andNetIdEqualTo(Integer value) {
            addCriterion("net_id =", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotEqualTo(Integer value) {
            addCriterion("net_id <>", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThan(Integer value) {
            addCriterion("net_id >", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_id >=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThan(Integer value) {
            addCriterion("net_id <", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThanOrEqualTo(Integer value) {
            addCriterion("net_id <=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdIn(List<Integer> values) {
            addCriterion("net_id in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotIn(List<Integer> values) {
            addCriterion("net_id not in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdBetween(Integer value1, Integer value2) {
            addCriterion("net_id between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("net_id not between", value1, value2, "netId");
            return (Criteria) this;
        }
        
        public Criteria andNetIdModEquals(Integer value1, Integer value2) {
            addCriterion("net_id%"+value1+" =", value2, "netId");
            return (Criteria) this;
        }

        public Criteria andNetUrlIsNull() {
            addCriterion("net_url is null");
            return (Criteria) this;
        }

        public Criteria andNetUrlIsNotNull() {
            addCriterion("net_url is not null");
            return (Criteria) this;
        }

        public Criteria andNetUrlEqualTo(String value) {
            addCriterion("net_url =", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlNotEqualTo(String value) {
            addCriterion("net_url <>", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlGreaterThan(String value) {
            addCriterion("net_url >", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("net_url >=", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlLessThan(String value) {
            addCriterion("net_url <", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlLessThanOrEqualTo(String value) {
            addCriterion("net_url <=", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlLike(String value) {
            addCriterion("net_url like", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlNotLike(String value) {
            addCriterion("net_url not like", value, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlIn(List<String> values) {
            addCriterion("net_url in", values, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlNotIn(List<String> values) {
            addCriterion("net_url not in", values, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlBetween(String value1, String value2) {
            addCriterion("net_url between", value1, value2, "netUrl");
            return (Criteria) this;
        }

        public Criteria andNetUrlNotBetween(String value1, String value2) {
            addCriterion("net_url not between", value1, value2, "netUrl");
            return (Criteria) this;
        }

        public Criteria andStsIdIsNull() {
            addCriterion("sts_id is null");
            return (Criteria) this;
        }

        public Criteria andStsIdIsNotNull() {
            addCriterion("sts_id is not null");
            return (Criteria) this;
        }

        public Criteria andStsIdEqualTo(Integer value) {
            addCriterion("sts_id =", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdNotEqualTo(Integer value) {
            addCriterion("sts_id <>", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdGreaterThan(Integer value) {
            addCriterion("sts_id >", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts_id >=", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdLessThan(Integer value) {
            addCriterion("sts_id <", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdLessThanOrEqualTo(Integer value) {
            addCriterion("sts_id <=", value, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdIn(List<Integer> values) {
            addCriterion("sts_id in", values, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdNotIn(List<Integer> values) {
            addCriterion("sts_id not in", values, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdBetween(Integer value1, Integer value2) {
            addCriterion("sts_id between", value1, value2, "stsId");
            return (Criteria) this;
        }

        public Criteria andStsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sts_id not between", value1, value2, "stsId");
            return (Criteria) this;
        }

        public Criteria andExecMsgIsNull() {
            addCriterion("exec_msg is null");
            return (Criteria) this;
        }

        public Criteria andExecMsgIsNotNull() {
            addCriterion("exec_msg is not null");
            return (Criteria) this;
        }

        public Criteria andExecMsgEqualTo(String value) {
            addCriterion("exec_msg =", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgNotEqualTo(String value) {
            addCriterion("exec_msg <>", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgGreaterThan(String value) {
            addCriterion("exec_msg >", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgGreaterThanOrEqualTo(String value) {
            addCriterion("exec_msg >=", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgLessThan(String value) {
            addCriterion("exec_msg <", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgLessThanOrEqualTo(String value) {
            addCriterion("exec_msg <=", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgLike(String value) {
            addCriterion("exec_msg like", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgNotLike(String value) {
            addCriterion("exec_msg not like", value, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgIn(List<String> values) {
            addCriterion("exec_msg in", values, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgNotIn(List<String> values) {
            addCriterion("exec_msg not in", values, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgBetween(String value1, String value2) {
            addCriterion("exec_msg between", value1, value2, "execMsg");
            return (Criteria) this;
        }

        public Criteria andExecMsgNotBetween(String value1, String value2) {
            addCriterion("exec_msg not between", value1, value2, "execMsg");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_addr
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 17 12:36:46 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
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