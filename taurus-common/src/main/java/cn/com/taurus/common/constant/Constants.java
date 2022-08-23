package cn.com.taurus.common.constant;

import cn.com.taurus.common.enums.BusinessStatus;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:32
 */
public class Constants {

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = BusinessStatus.SUCCESS.getCode()+"";

    /**
     * 通用失败标识
     */
    public static final String FAIL = BusinessStatus.FAIL.getCode()+"";

    //////////////////////token相关////////////////////////

    /**
     * 令牌前缀(TOKEN CLAIMS载体)
     */
    public static final String TOKEN_CLAIMS_KEY = "login_user_key";

    /**
     * 令牌前缀(请求头中)
     */
    public static final String TOKEN_REQUEST_PREFIX = "Bearer ";


    //////////////////////////////////////////////////

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";





}
