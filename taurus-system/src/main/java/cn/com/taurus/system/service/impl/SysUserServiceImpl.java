package cn.com.taurus.system.service.impl;

import cn.com.taurus.common.core.domain.entity.SysUser;
import cn.com.taurus.common.core.pagination.PageInfo;
import cn.com.taurus.common.core.pagination.Paging;
import cn.com.taurus.common.core.service.impl.BaseServiceImpl;
import cn.com.taurus.system.mapper.SysUserMapper;
import cn.com.taurus.system.param.sysuser.SysUserPageParam;
import cn.com.taurus.system.service.ISysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public Paging<SysUser> getSysUserPageList(SysUserPageParam pageParam) {
        Page<SysUser> page = new PageInfo<>(pageParam, OrderItem.desc(getLambdaColumn(SysUser::getCreateTime)));
        IPage<SysUser> iPage = sysUserMapper.getSysUserPageList(page, pageParam);

        return new Paging(iPage);
    }

    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserProfile(SysUser user)
    {
        return sysUserMapper.updateUser(user);
    }
}
