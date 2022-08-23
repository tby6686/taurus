package cn.com.taurus.framework.web.service;

import cn.com.taurus.common.constant.CacheConstants;
import cn.com.taurus.common.constant.Constants;
import cn.com.taurus.common.core.domain.entity.SysUser;
import cn.com.taurus.common.core.domain.model.LoginUser;
import cn.com.taurus.common.exception.ServiceException;
import cn.com.taurus.common.exception.user.CaptchaException;
import cn.com.taurus.common.exception.user.CaptchaExpireException;
import cn.com.taurus.common.exception.user.UserPasswordNotMatchException;
import cn.com.taurus.common.utils.DateUtils;
import cn.com.taurus.common.utils.MessageUtils;
import cn.com.taurus.common.utils.ServletUtils;
import cn.com.taurus.common.utils.StringUtils;
import cn.com.taurus.common.utils.ip.IpUtils;
import cn.com.taurus.common.utils.redis.RedisCache;
import cn.com.taurus.framework.manager.AsyncManager;
import cn.com.taurus.framework.manager.factory.AsyncFactory;
import cn.com.taurus.system.service.ISysConfigService;
import cn.com.taurus.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author tby
 */
@Component
public class SysLoginService
{
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid)
    {
        boolean captchaOnOff = configService.selectCaptchaOnOff();
        // 验证码开关
        if (captchaOnOff)
        {
            validateCaptcha(username, code, uuid);
        }
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                UserPasswordNotMatchException excep = new UserPasswordNotMatchException();
                AsyncManager.me().execute(
                    AsyncFactory.recordLoginLog(username, Constants.LOGIN_FAIL, excep.getMessage()));
                throw excep;
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLoginLog(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        String recordMessage = MessageUtils.message("user.login.success");
        if(StringUtils.isEmpty(recordMessage)){
            recordMessage = "登录成功";
        }
        AsyncManager.me().execute(AsyncFactory.recordLoginLog(username, Constants.LOGIN_SUCCESS, recordMessage));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.REDIS_CAPTCHA_CODES_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {

            CaptchaExpireException excep = new CaptchaExpireException();
            AsyncManager.me().execute(AsyncFactory.recordLoginLog(username, Constants.LOGIN_FAIL, excep.getMessage()));
            throw excep;
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            CaptchaException excep = new CaptchaException();
            AsyncManager.me().execute(AsyncFactory.recordLoginLog(username, Constants.LOGIN_FAIL, excep.getMessage()));
            throw excep;
        }
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }
}
