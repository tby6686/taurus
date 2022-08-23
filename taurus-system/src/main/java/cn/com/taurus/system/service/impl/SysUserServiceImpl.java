package cn.com.taurus.system.service.impl;

import cn.com.taurus.common.core.service.impl.BaseServiceImpl;
import cn.com.taurus.system.entity.SysUser;
import cn.com.taurus.system.mapper.SysUserMapper;
import cn.com.taurus.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:30
 */
@Slf4j
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }
}
