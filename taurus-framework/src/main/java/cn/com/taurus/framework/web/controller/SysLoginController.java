package cn.com.taurus.framework.web.controller;


import cn.com.taurus.common.api.ApiResult;
import cn.com.taurus.common.constant.Constants;
import cn.com.taurus.common.core.domain.entity.SysMenu;
import cn.com.taurus.common.core.domain.entity.SysUser;
import cn.com.taurus.common.core.domain.model.LoginBody;
import cn.com.taurus.common.utils.SecurityUtils;
import cn.com.taurus.framework.web.service.SysLoginService;
import cn.com.taurus.framework.web.service.SysPermissionService;
import cn.com.taurus.framework.web.service.RouterService;
import cn.com.taurus.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private  RouterService routerService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;



    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public ApiResult login(@RequestBody LoginBody loginBody)
    {
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());

        //返回token
        Map<String,String> data = new HashMap<>();
        data.put(Constants.TOKEN, token);

        return ApiResult.success(data);
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public ApiResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);

        Map<String,Object> data = new HashMap<>();
        data.put("user", user);
        data.put("roles", roles);
        data.put("permissions", permissions);
        return ApiResult.success(data);
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public ApiResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return ApiResult.success(routerService.buildMenus(menus));
    }
}
