package cn.com.taurus.common.enums;

/**
 * 操作人类别
 * 
 * @author tby
 */
public enum OperatorType
{
    /**
     * 其它
     */
    OTHER(0,"其它"),

    /**
     * 后台用户
     */
    MANAGE(1,"后台用户"),

    /**
     * 手机端用户
     */
    MOBILE(2,"手机端用户");

    private final Integer code;
    private final String info;

    OperatorType(Integer code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
