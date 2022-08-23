package cn.com.taurus.system.service;

import cn.com.taurus.common.core.domain.entity.SysMenu;
import cn.com.taurus.common.core.service.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:35
 */
public interface ISysMenuService extends BaseService<SysMenu> {

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据用户ID查询菜单树信息
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);


}
