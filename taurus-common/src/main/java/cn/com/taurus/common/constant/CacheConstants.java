package cn.com.taurus.common.constant;

public class CacheConstants {
    /**
     * 登录用户 redis key
     */
    public static final String REDIS_LOGIN_TOKENS_KEY = "login_tokens:";
    /**
     * 参数管理 cache key
     */
    public static final String REDIS_SYS_CONFIG_KEY = "sys_config:";
    /**
     * 验证码 redis key
     */
    public static final String REDIS_CAPTCHA_CODES_KEY = "captcha_codes:";
    /**
     * 验证码有效期（分钟）
     */
    public static final Integer REDIS_CAPTCHA_CODES_EXPIRATION = 2;

    /**
     * 字典管理 cache key
     */
    public static final String REDIS_SYS_DICT_KEY = "sys_dict:";
}
