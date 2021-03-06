package com.zzc.netcrawler.beanset;

import java.sql.Timestamp;

public class NetAddr {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.net_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private Integer netId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.net_url
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private String netUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.sts_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private Integer stsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.exec_msg
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private String execMsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.create_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private Timestamp createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column net_addr.update_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    private Timestamp updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.net_id
     *
     * @return the value of net_addr.net_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public Integer getNetId() {
        return netId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.net_id
     *
     * @param netId the value for net_addr.net_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setNetId(Integer netId) {
        this.netId = netId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.net_url
     *
     * @return the value of net_addr.net_url
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public String getNetUrl() {
        return netUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.net_url
     *
     * @param netUrl the value for net_addr.net_url
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl == null ? null : netUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.sts_id
     *
     * @return the value of net_addr.sts_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public Integer getStsId() {
        return stsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.sts_id
     *
     * @param stsId the value for net_addr.sts_id
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setStsId(Integer stsId) {
        this.stsId = stsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.exec_msg
     *
     * @return the value of net_addr.exec_msg
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public String getExecMsg() {
        return execMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.exec_msg
     *
     * @param execMsg the value for net_addr.exec_msg
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setExecMsg(String execMsg) {
        this.execMsg = execMsg == null ? null : execMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.create_time
     *
     * @return the value of net_addr.create_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.create_time
     *
     * @param createTime the value for net_addr.create_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column net_addr.update_time
     *
     * @return the value of net_addr.update_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column net_addr.update_time
     *
     * @param updateTime the value for net_addr.update_time
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
	public String toString() {
		return "[netId=" + (null == netId ? 0 : netId) + ",netUrl="
				+ (null == netUrl ? "" : netUrl) + ",stsId="
				+ (null == stsId ? 0 : stsId) + ",execMsg="
				+ (null == execMsg ? "" : execMsg) + ",createTime="
				+ (null == createTime ? "" : createTime) + ",updateTime="
				+ (null == updateTime ? "" : updateTime) + "]";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode() * 47 ^ 31;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NetAddr && null != obj ? obj.toString().equals(this.toString()) : false;
	}
}