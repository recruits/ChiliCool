package com.zzc.netcrawler.dao;

import com.zzc.netcrawler.beanset.NetAddr;
import com.zzc.netcrawler.beanset.NetAddrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NetAddrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int countByExample(NetAddrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByExample(NetAddrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insert(NetAddr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insertSelective(NetAddr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    List<NetAddr> selectByExample(NetAddrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    NetAddr selectByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExampleSelective(@Param("record") NetAddr record, @Param("example") NetAddrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExample(@Param("record") NetAddr record, @Param("example") NetAddrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKeySelective(NetAddr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKey(NetAddr record);
}