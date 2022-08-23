package cn.com.taurus.system.service.impl;

import cn.com.taurus.common.core.service.impl.BaseServiceImpl;
import cn.com.taurus.common.core.domain.entity.SysMenu;
import cn.com.taurus.system.mapper.SysMenuMapper;
import cn.com.taurus.system.service.ISysMenuService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:36
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements
    ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectMenuPermsByUserId(Long userId)
    {
        List<String> perms = sysMenuMapper.selectMenuPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (ObjectUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

}
