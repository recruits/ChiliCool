package com.zzc.netcrawler.dao;

import com.zzc.netcrawler.beanset.NetAddrExt;
import com.zzc.netcrawler.beanset.NetAddrExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NetAddrExtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int countByExample(NetAddrExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByExample(NetAddrExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int deleteByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insert(NetAddrExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int insertSelective(NetAddrExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    List<NetAddrExt> selectByExample(NetAddrExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    NetAddrExt selectByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExampleSelective(@Param("record") NetAddrExt record, @Param("example") NetAddrExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByExample(@Param("record") NetAddrExt record, @Param("example") NetAddrExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKeySelective(NetAddrExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_addr_ext
     *
     * @mbggenerated Mon Mar 17 12:36:46 CST 2014
     */
    int updateByPrimaryKey(NetAddrExt record);
}