package com.zzc.netcrawler.dao;

import com.zzc.netcrawler.domain.NetInfo;
import com.zzc.netcrawler.domain.NetInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NetInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int countByExample(NetInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int deleteByExample(NetInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int deleteByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int insert(NetInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int insertSelective(NetInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    List<NetInfo> selectByExample(NetInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    NetInfo selectByPrimaryKey(Integer netId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int updateByExampleSelective(@Param("record") NetInfo record, @Param("example") NetInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int updateByExample(@Param("record") NetInfo record, @Param("example") NetInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int updateByPrimaryKeySelective(NetInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table net_info
     *
     * @mbggenerated Tue Jun 10 13:47:13 CST 2014
     */
    int updateByPrimaryKey(NetInfo record);
}