package cn.com.taurus.system.mapper;

import cn.com.taurus.common.core.domain.entity.SysUser;
import cn.com.taurus.system.param.sysuser.SysUserPageParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:12
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

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
     * @param page
     * @param pageParam
     * @return
     */
    IPage<SysUser> getSysUserPageList(@Param("page") Page page, @Param("param")SysUserPageParam pageParam);


    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

}
