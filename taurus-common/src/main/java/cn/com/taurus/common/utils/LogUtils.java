package cn.com.taurus.common.utils;

import org.springframework.stereotype.Component;

/**
 * 处理并记录日志文件
 *
 * @author tby
 */
@Component
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
