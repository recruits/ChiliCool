package com.zzc.hpnote.dao;

import com.zzc.hpnote.domain.ParamDetail;
import com.zzc.hpnote.domain.ParamDetailExample;
import com.zzc.hpnote.domain.ParamDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParamDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int countByExample(ParamDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int deleteByExample(ParamDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int deleteByPrimaryKey(ParamDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int insert(ParamDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int insertSelective(ParamDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    List<ParamDetail> selectByExample(ParamDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    ParamDetail selectByPrimaryKey(ParamDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByExampleSelective(@Param("record") ParamDetail record, @Param("example") ParamDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByExample(@Param("record") ParamDetail record, @Param("example") ParamDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByPrimaryKeySelective(ParamDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table param_detail
     *
     * @mbggenerated Fri May 16 17:10:29 CST 2014
     */
    int updateByPrimaryKey(ParamDetail record);
}