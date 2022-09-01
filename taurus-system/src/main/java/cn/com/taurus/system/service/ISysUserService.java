package cn.com.taurus.system.service;

import cn.com.taurus.common.core.domain.entity.SysUser;
import cn.com.taurus.common.core.pagination.Paging;
import cn.com.taurus.common.core.service.BaseService;
import cn.com.taurus.system.param.sysuser.SysUserPageParam;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:28
 */
public interface ISysUserService extends BaseService<SysUser> {

    /**
     * 通过用户名查询用户(spring security)
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);


    /**
     * 查询分页数据
     *
     * @param pageParam
     * @return
     */
    Paging<SysUser> getSysUserPageList(SysUserPageParam pageParam);


    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserProfile(SysUser user);

}
