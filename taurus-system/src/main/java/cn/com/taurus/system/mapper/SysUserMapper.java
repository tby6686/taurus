package cn.com.taurus.system.mapper;

import cn.com.taurus.common.core.domain.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:12
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

}
