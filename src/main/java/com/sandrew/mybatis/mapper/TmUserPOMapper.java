package com.sandrew.mybatis.mapper;

import com.sandrew.mybatis.model.TmUserPO;

public interface TmUserPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    int insert(TmUserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    int insertSelective(TmUserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    TmUserPO selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    int updateByPrimaryKeySelective(TmUserPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_user
     *
     * @mbggenerated Fri Apr 08 21:56:42 CST 2016
     */
    int updateByPrimaryKey(TmUserPO record);
}