package com.zzc.hpnote.domain;

public class ParamDefine {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_define.ID
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_define.PARAM_CODE
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private String paramCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_define.PARAM_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private String paramName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column param_define.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_define.ID
     *
     * @return the value of param_define.ID
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_define.ID
     *
     * @param id the value for param_define.ID
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_define.PARAM_CODE
     *
     * @return the value of param_define.PARAM_CODE
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_define.PARAM_CODE
     *
     * @param paramCode the value for param_define.PARAM_CODE
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_define.PARAM_NAME
     *
     * @return the value of param_define.PARAM_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_define.PARAM_NAME
     *
     * @param paramName the value for param_define.PARAM_NAME
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column param_define.REMARK
     *
     * @return the value of param_define.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column param_define.REMARK
     *
     * @param remark the value for param_define.REMARK
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}