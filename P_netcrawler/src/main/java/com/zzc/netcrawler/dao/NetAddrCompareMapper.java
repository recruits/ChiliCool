package com.zzc.netcrawler.dao;

import com.zzc.netcrawler.beanset.NetAddrCompare;
import com.zzc.netcrawler.beanset.NetAddrCompareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NetAddrCompareMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int countByExample(NetAddrCompareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByExample(NetAddrCompareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByPrimaryKey(String netUrlCmp);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insert(NetAddrCompare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insertSelective(NetAddrCompare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    List<NetAddrCompare> selectByExample(NetAddrCompareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    NetAddrCompare selectByPrimaryKey(String netUrlCmp);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExampleSelective(@Param("record") NetAddrCompare record, @Param("example") NetAddrCompareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExample(@Param("record") NetAddrCompare record, @Param("example") NetAddrCompareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKeySelective(NetAddrCompare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_compare
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKey(NetAddrCompare record);
}