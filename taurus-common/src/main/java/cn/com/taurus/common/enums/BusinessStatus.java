package cn.com.taurus.common.enums;

/**
 * 操作状态
 * 
 * @author tby
 *
 */
public enum BusinessStatus
{

    SUCCESS(0, "成功"), FAIL(1, "失败");

    private final Integer code;
    private final String info;

    BusinessStatus(Integer code, String info)
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
