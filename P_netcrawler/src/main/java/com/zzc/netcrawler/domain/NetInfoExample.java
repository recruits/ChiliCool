package com.zzc.netcrawler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public NetInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
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
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
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
            addCriterion("NET_ID is null");
            return (Criteria) this;
        }

        public Criteria andNetIdIsNotNull() {
            addCriterion("NET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNetIdEqualTo(Integer value) {
            addCriterion("NET_ID =", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotEqualTo(Integer value) {
            addCriterion("NET_ID <>", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThan(Integer value) {
            addCriterion("NET_ID >", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NET_ID >=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThan(Integer value) {
            addCriterion("NET_ID <", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThanOrEqualTo(Integer value) {
            addCriterion("NET_ID <=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdIn(List<Integer> values) {
            addCriterion("NET_ID in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotIn(List<Integer> values) {
            addCriterion("NET_ID not in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdBetween(Integer value1, Integer value2) {
            addCriterion("NET_ID between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NET_ID not between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNull() {
            addCriterion("ENCODE is null");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNotNull() {
            addCriterion("ENCODE is not null");
            return (Criteria) this;
        }

        public Criteria andEncodeEqualTo(String value) {
            addCriterion("ENCODE =", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotEqualTo(String value) {
            addCriterion("ENCODE <>", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThan(String value) {
            addCriterion("ENCODE >", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENCODE >=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThan(String value) {
            addCriterion("ENCODE <", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThanOrEqualTo(String value) {
            addCriterion("ENCODE <=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLike(String value) {
            addCriterion("ENCODE like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotLike(String value) {
            addCriterion("ENCODE not like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeIn(List<String> values) {
            addCriterion("ENCODE in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotIn(List<String> values) {
            addCriterion("ENCODE not in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeBetween(String value1, String value2) {
            addCriterion("ENCODE between", value1, value2, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotBetween(String value1, String value2) {
            addCriterion("ENCODE not between", value1, value2, "encode");
            return (Criteria) this;
        }

        public Criteria andNetTitleIsNull() {
            addCriterion("NET_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andNetTitleIsNotNull() {
            addCriterion("NET_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andNetTitleEqualTo(String value) {
            addCriterion("NET_TITLE =", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotEqualTo(String value) {
            addCriterion("NET_TITLE <>", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleGreaterThan(String value) {
            addCriterion("NET_TITLE >", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleGreaterThanOrEqualTo(String value) {
            addCriterion("NET_TITLE >=", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLessThan(String value) {
            addCriterion("NET_TITLE <", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLessThanOrEqualTo(String value) {
            addCriterion("NET_TITLE <=", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLike(String value) {
            addCriterion("NET_TITLE like", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotLike(String value) {
            addCriterion("NET_TITLE not like", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleIn(List<String> values) {
            addCriterion("NET_TITLE in", values, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotIn(List<String> values) {
            addCriterion("NET_TITLE not in", values, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleBetween(String value1, String value2) {
            addCriterion("NET_TITLE between", value1, value2, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotBetween(String value1, String value2) {
            addCriterion("NET_TITLE not between", value1, value2, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetKeysIsNull() {
            addCriterion("NET_KEYS is null");
            return (Criteria) this;
        }

        public Criteria andNetKeysIsNotNull() {
            addCriterion("NET_KEYS is not null");
            return (Criteria) this;
        }

        public Criteria andNetKeysEqualTo(String value) {
            addCriterion("NET_KEYS =", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysNotEqualTo(String value) {
            addCriterion("NET_KEYS <>", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysGreaterThan(String value) {
            addCriterion("NET_KEYS >", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysGreaterThanOrEqualTo(String value) {
            addCriterion("NET_KEYS >=", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysLessThan(String value) {
            addCriterion("NET_KEYS <", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysLessThanOrEqualTo(String value) {
            addCriterion("NET_KEYS <=", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysLike(String value) {
            addCriterion("NET_KEYS like", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysNotLike(String value) {
            addCriterion("NET_KEYS not like", value, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysIn(List<String> values) {
            addCriterion("NET_KEYS in", values, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysNotIn(List<String> values) {
            addCriterion("NET_KEYS not in", values, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysBetween(String value1, String value2) {
            addCriterion("NET_KEYS between", value1, value2, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetKeysNotBetween(String value1, String value2) {
            addCriterion("NET_KEYS not between", value1, value2, "netKeys");
            return (Criteria) this;
        }

        public Criteria andNetDescIsNull() {
            addCriterion("NET_DESC is null");
            return (Criteria) this;
        }

        public Criteria andNetDescIsNotNull() {
            addCriterion("NET_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andNetDescEqualTo(String value) {
            addCriterion("NET_DESC =", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotEqualTo(String value) {
            addCriterion("NET_DESC <>", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescGreaterThan(String value) {
            addCriterion("NET_DESC >", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescGreaterThanOrEqualTo(String value) {
            addCriterion("NET_DESC >=", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLessThan(String value) {
            addCriterion("NET_DESC <", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLessThanOrEqualTo(String value) {
            addCriterion("NET_DESC <=", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLike(String value) {
            addCriterion("NET_DESC like", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotLike(String value) {
            addCriterion("NET_DESC not like", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescIn(List<String> values) {
            addCriterion("NET_DESC in", values, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotIn(List<String> values) {
            addCriterion("NET_DESC not in", values, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescBetween(String value1, String value2) {
            addCriterion("NET_DESC between", value1, value2, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotBetween(String value1, String value2) {
            addCriterion("NET_DESC not between", value1, value2, "netDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andResCodeIsNull() {
            addCriterion("RES_CODE is null");
            return (Criteria) this;
        }

        public Criteria andResCodeIsNotNull() {
            addCriterion("RES_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andResCodeEqualTo(String value) {
            addCriterion("RES_CODE =", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotEqualTo(String value) {
            addCriterion("RES_CODE <>", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThan(String value) {
            addCriterion("RES_CODE >", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RES_CODE >=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThan(String value) {
            addCriterion("RES_CODE <", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThanOrEqualTo(String value) {
            addCriterion("RES_CODE <=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLike(String value) {
            addCriterion("RES_CODE like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotLike(String value) {
            addCriterion("RES_CODE not like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeIn(List<String> values) {
            addCriterion("RES_CODE in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotIn(List<String> values) {
            addCriterion("RES_CODE not in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeBetween(String value1, String value2) {
            addCriterion("RES_CODE between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotBetween(String value1, String value2) {
            addCriterion("RES_CODE not between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNull() {
            addCriterion("PARSE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNotNull() {
            addCriterion("PARSE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andParseTimeEqualTo(Integer value) {
            addCriterion("PARSE_TIME =", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotEqualTo(Integer value) {
            addCriterion("PARSE_TIME <>", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThan(Integer value) {
            addCriterion("PARSE_TIME >", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARSE_TIME >=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThan(Integer value) {
            addCriterion("PARSE_TIME <", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("PARSE_TIME <=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeIn(List<Integer> values) {
            addCriterion("PARSE_TIME in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotIn(List<Integer> values) {
            addCriterion("PARSE_TIME not in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeBetween(Integer value1, Integer value2) {
            addCriterion("PARSE_TIME between", value1, value2, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("PARSE_TIME not between", value1, value2, "parseTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_info
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 10 13:47:13 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
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