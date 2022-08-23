package cn.com.taurus.common.constant;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:32
 */
public class Constants {

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    //////////////////////token相关////////////////////////

    /**
     * 令牌前缀(TOKEN CLAIMS载体)
     */
    public static final String TOKEN_CLAIMS_KEY = "login_user_key";

    /**
     * 令牌前缀(请求)
     */
    public static final String TOKEN_REQUEST_PREFIX = "Bearer ";


    /**
     * 登录用户 redis key
     */
    public static final String REDIS_TOKEN_KEY = "login_tokens:";

    /**
     * 参数管理 cache key
     */
    public static final String REDIS_SYS_KEY = "sys_config:";

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
