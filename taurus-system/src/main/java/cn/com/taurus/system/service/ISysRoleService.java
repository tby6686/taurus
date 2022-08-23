package cn.com.taurus.system.service;

import cn.com.taurus.common.core.service.BaseService;
import cn.com.taurus.common.core.domain.entity.SysRole;
import java.util.Set;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:35
 */
public interface ISysRoleService extends BaseService<SysRole> {

    /**
     * 根据用户ID查询角色权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

}
