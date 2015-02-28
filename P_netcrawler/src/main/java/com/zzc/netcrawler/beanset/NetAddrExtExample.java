package com.zzc.netcrawler.beanset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetAddrExtExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public NetAddrExtExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
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
     * This method corresponds to the database table net_addr_ext
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
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
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
     * This class corresponds to the database table net_addr_ext
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

        public Criteria andResCodeIsNull() {
            addCriterion("res_code is null");
            return (Criteria) this;
        }

        public Criteria andResCodeIsNotNull() {
            addCriterion("res_code is not null");
            return (Criteria) this;
        }

        public Criteria andResCodeEqualTo(String value) {
            addCriterion("res_code =", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotEqualTo(String value) {
            addCriterion("res_code <>", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThan(String value) {
            addCriterion("res_code >", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThanOrEqualTo(String value) {
            addCriterion("res_code >=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThan(String value) {
            addCriterion("res_code <", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThanOrEqualTo(String value) {
            addCriterion("res_code <=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLike(String value) {
            addCriterion("res_code like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotLike(String value) {
            addCriterion("res_code not like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeIn(List<String> values) {
            addCriterion("res_code in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotIn(List<String> values) {
            addCriterion("res_code not in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeBetween(String value1, String value2) {
            addCriterion("res_code between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotBetween(String value1, String value2) {
            addCriterion("res_code not between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNull() {
            addCriterion("encode is null");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNotNull() {
            addCriterion("encode is not null");
            return (Criteria) this;
        }

        public Criteria andEncodeEqualTo(String value) {
            addCriterion("encode =", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotEqualTo(String value) {
            addCriterion("encode <>", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThan(String value) {
            addCriterion("encode >", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThanOrEqualTo(String value) {
            addCriterion("encode >=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThan(String value) {
            addCriterion("encode <", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThanOrEqualTo(String value) {
            addCriterion("encode <=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLike(String value) {
            addCriterion("encode like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotLike(String value) {
            addCriterion("encode not like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeIn(List<String> values) {
            addCriterion("encode in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotIn(List<String> values) {
            addCriterion("encode not in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeBetween(String value1, String value2) {
            addCriterion("encode between", value1, value2, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotBetween(String value1, String value2) {
            addCriterion("encode not between", value1, value2, "encode");
            return (Criteria) this;
        }

        public Criteria andNetTitleIsNull() {
            addCriterion("net_title is null");
            return (Criteria) this;
        }

        public Criteria andNetTitleIsNotNull() {
            addCriterion("net_title is not null");
            return (Criteria) this;
        }

        public Criteria andNetTitleEqualTo(String value) {
            addCriterion("net_title =", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotEqualTo(String value) {
            addCriterion("net_title <>", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleGreaterThan(String value) {
            addCriterion("net_title >", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleGreaterThanOrEqualTo(String value) {
            addCriterion("net_title >=", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLessThan(String value) {
            addCriterion("net_title <", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLessThanOrEqualTo(String value) {
            addCriterion("net_title <=", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleLike(String value) {
            addCriterion("net_title like", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotLike(String value) {
            addCriterion("net_title not like", value, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleIn(List<String> values) {
            addCriterion("net_title in", values, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotIn(List<String> values) {
            addCriterion("net_title not in", values, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleBetween(String value1, String value2) {
            addCriterion("net_title between", value1, value2, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetTitleNotBetween(String value1, String value2) {
            addCriterion("net_title not between", value1, value2, "netTitle");
            return (Criteria) this;
        }

        public Criteria andNetKeyIsNull() {
            addCriterion("net_key is null");
            return (Criteria) this;
        }

        public Criteria andNetKeyIsNotNull() {
            addCriterion("net_key is not null");
            return (Criteria) this;
        }

        public Criteria andNetKeyEqualTo(String value) {
            addCriterion("net_key =", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyNotEqualTo(String value) {
            addCriterion("net_key <>", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyGreaterThan(String value) {
            addCriterion("net_key >", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyGreaterThanOrEqualTo(String value) {
            addCriterion("net_key >=", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyLessThan(String value) {
            addCriterion("net_key <", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyLessThanOrEqualTo(String value) {
            addCriterion("net_key <=", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyLike(String value) {
            addCriterion("net_key like", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyNotLike(String value) {
            addCriterion("net_key not like", value, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyIn(List<String> values) {
            addCriterion("net_key in", values, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyNotIn(List<String> values) {
            addCriterion("net_key not in", values, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyBetween(String value1, String value2) {
            addCriterion("net_key between", value1, value2, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetKeyNotBetween(String value1, String value2) {
            addCriterion("net_key not between", value1, value2, "netKey");
            return (Criteria) this;
        }

        public Criteria andNetDescIsNull() {
            addCriterion("net_desc is null");
            return (Criteria) this;
        }

        public Criteria andNetDescIsNotNull() {
            addCriterion("net_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNetDescEqualTo(String value) {
            addCriterion("net_desc =", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotEqualTo(String value) {
            addCriterion("net_desc <>", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescGreaterThan(String value) {
            addCriterion("net_desc >", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescGreaterThanOrEqualTo(String value) {
            addCriterion("net_desc >=", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLessThan(String value) {
            addCriterion("net_desc <", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLessThanOrEqualTo(String value) {
            addCriterion("net_desc <=", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescLike(String value) {
            addCriterion("net_desc like", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotLike(String value) {
            addCriterion("net_desc not like", value, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescIn(List<String> values) {
            addCriterion("net_desc in", values, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotIn(List<String> values) {
            addCriterion("net_desc not in", values, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescBetween(String value1, String value2) {
            addCriterion("net_desc between", value1, value2, "netDesc");
            return (Criteria) this;
        }

        public Criteria andNetDescNotBetween(String value1, String value2) {
            addCriterion("net_desc not between", value1, value2, "netDesc");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNull() {
            addCriterion("parse_time is null");
            return (Criteria) this;
        }

        public Criteria andParseTimeIsNotNull() {
            addCriterion("parse_time is not null");
            return (Criteria) this;
        }

        public Criteria andParseTimeEqualTo(Integer value) {
            addCriterion("parse_time =", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotEqualTo(Integer value) {
            addCriterion("parse_time <>", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThan(Integer value) {
            addCriterion("parse_time >", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("parse_time >=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThan(Integer value) {
            addCriterion("parse_time <", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("parse_time <=", value, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeIn(List<Integer> values) {
            addCriterion("parse_time in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotIn(List<Integer> values) {
            addCriterion("parse_time not in", values, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeBetween(Integer value1, Integer value2) {
            addCriterion("parse_time between", value1, value2, "parseTime");
            return (Criteria) this;
        }

        public Criteria andParseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("parse_time not between", value1, value2, "parseTime");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table net_addr_ext
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
     * This class corresponds to the database table net_addr_ext
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