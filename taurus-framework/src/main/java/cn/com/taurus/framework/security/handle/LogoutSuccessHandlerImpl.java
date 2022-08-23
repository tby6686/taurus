package cn.com.taurus.framework.security.handle;

import cn.com.taurus.common.api.ApiCode;
import cn.com.taurus.common.api.ApiResult;
import cn.com.taurus.common.constant.Constants;
import cn.com.taurus.common.utils.ServletUtils;
import cn.com.taurus.framework.manager.AsyncManager;
import cn.com.taurus.framework.manager.factory.AsyncFactory;
import cn.com.taurus.framework.web.domain.LoginUser;
import cn.com.taurus.framework.web.service.TokenService;
import com.alibaba.fastjson2.JSON;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 自定义退出处理类 返回成功
 *
 * @author tby
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (ObjectUtils.isNotEmpty(loginUser))
        {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLoginLog(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(ApiResult.result(ApiCode.SUCCESS, "退出成功")));
    }
}
