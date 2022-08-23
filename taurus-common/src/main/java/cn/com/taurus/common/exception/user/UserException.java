package cn.com.taurus.common.exception.user;


import cn.com.taurus.common.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author tby
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, String defaultMsg, Object[] args)
    {
        super("user", code, args, defaultMsg);
    }
}
