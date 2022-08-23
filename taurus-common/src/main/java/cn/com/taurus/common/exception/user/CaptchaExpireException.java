package cn.com.taurus.common.exception.user;

/**
 * 验证码失效异常类
 * 
 * @author tby
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire","验证码已失效", null);
    }
}
