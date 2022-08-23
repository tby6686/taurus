package cn.com.taurus.system.service;

import cn.com.taurus.common.core.service.BaseService;
import cn.com.taurus.system.entity.SysUser;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:28
 */
public interface ISysUserService extends BaseService<SysUser> {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);

}
