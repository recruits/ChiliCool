package com.zzc.hpnote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzc.hpnote.domain.BaseInfo;
import com.zzc.hpnote.domain.BaseInfoExample;

public interface BaseInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int countByExample(BaseInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int deleteByExample(BaseInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int insert(BaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int insertSelective(BaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    List<BaseInfo> selectByExample(BaseInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    BaseInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByExampleSelective(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByExample(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByPrimaryKeySelective(BaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_info
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByPrimaryKey(BaseInfo record);
    
    List<String> selectAllHid();
}