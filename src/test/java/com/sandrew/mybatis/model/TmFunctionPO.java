package com.sandrew.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class TmFunctionPO implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FUNCTION_ID
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer functionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FUNCTION_CODE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private String functionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FUNCTION_NAME
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private String functionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FATHER_FUNC
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer fatherFunc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FUNCTION_STATUS
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer functionStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.ACCESS_URL
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private String accessUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.FUNCTION_ORDER
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer functionOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.CREATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.CREATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.UPDATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Integer updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_function.UPDATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FUNCTION_ID
     *
     * @return the value of tm_function.FUNCTION_ID
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getFunctionId() {
        return functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FUNCTION_ID
     *
     * @param functionId the value for tm_function.FUNCTION_ID
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FUNCTION_CODE
     *
     * @return the value of tm_function.FUNCTION_CODE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FUNCTION_CODE
     *
     * @param functionCode the value for tm_function.FUNCTION_CODE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FUNCTION_NAME
     *
     * @return the value of tm_function.FUNCTION_NAME
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FUNCTION_NAME
     *
     * @param functionName the value for tm_function.FUNCTION_NAME
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FATHER_FUNC
     *
     * @return the value of tm_function.FATHER_FUNC
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getFatherFunc() {
        return fatherFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FATHER_FUNC
     *
     * @param fatherFunc the value for tm_function.FATHER_FUNC
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFatherFunc(Integer fatherFunc) {
        this.fatherFunc = fatherFunc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FUNCTION_STATUS
     *
     * @return the value of tm_function.FUNCTION_STATUS
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getFunctionStatus() {
        return functionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FUNCTION_STATUS
     *
     * @param functionStatus the value for tm_function.FUNCTION_STATUS
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFunctionStatus(Integer functionStatus) {
        this.functionStatus = functionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.ACCESS_URL
     *
     * @return the value of tm_function.ACCESS_URL
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public String getAccessUrl() {
        return accessUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.ACCESS_URL
     *
     * @param accessUrl the value for tm_function.ACCESS_URL
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.FUNCTION_ORDER
     *
     * @return the value of tm_function.FUNCTION_ORDER
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getFunctionOrder() {
        return functionOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.FUNCTION_ORDER
     *
     * @param functionOrder the value for tm_function.FUNCTION_ORDER
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setFunctionOrder(Integer functionOrder) {
        this.functionOrder = functionOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.CREATE_BY
     *
     * @return the value of tm_function.CREATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.CREATE_BY
     *
     * @param createBy the value for tm_function.CREATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.CREATE_DATE
     *
     * @return the value of tm_function.CREATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.CREATE_DATE
     *
     * @param createDate the value for tm_function.CREATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.UPDATE_BY
     *
     * @return the value of tm_function.UPDATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.UPDATE_BY
     *
     * @param updateBy the value for tm_function.UPDATE_BY
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_function.UPDATE_DATE
     *
     * @return the value of tm_function.UPDATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_function.UPDATE_DATE
     *
     * @param updateDate the value for tm_function.UPDATE_DATE
     *
     * @mbggenerated Sat Apr 16 13:49:44 CST 2016
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}