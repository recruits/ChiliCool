package com.zzc.hpnote.domain;

public class ParamDetail extends ParamDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_detail.PARAM_VALUE_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private String paramValueName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_detail.IDX
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private Integer idx;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_detail.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_detail.PARAM_VALUE_NAME
     *
     * @return the value of param_detail.PARAM_VALUE_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public String getParamValueName() {
        return paramValueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_detail.PARAM_VALUE_NAME
     *
     * @param paramValueName the value for param_detail.PARAM_VALUE_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setParamValueName(String paramValueName) {
        this.paramValueName = paramValueName == null ? null : paramValueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_detail.IDX
     *
     * @return the value of param_detail.IDX
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public Integer getIdx() {
        return idx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_detail.IDX
     *
     * @param idx the value for param_detail.IDX
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_detail.REMARK
     *
     * @return the value of param_detail.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_detail.REMARK
     *
     * @param remark the value for param_detail.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}