package cn.com.taurus.common.core.domain.entity;

import cn.com.taurus.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author tby
 * @description
 * @date 2022-08-23 9:20
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUser对象")
public class SysUser extends BaseEntity {

    /** 用户ID */
    @ApiModelProperty("用户ID")
    private Long userId;

    /** 部门ID */
    @ApiModelProperty("部门ID")
    private Long deptId;

    /** 用户账号 */
    @ApiModelProperty("用户账号")
    private String userName;

    /** 用户昵称 */
    @ApiModelProperty("用户昵称")
    private String nickName;

    /** 用户类型（00系统用户） */
    @ApiModelProperty("用户类型（00系统用户）")
    private String userType;

    /** 用户邮箱 */
    @ApiModelProperty("用户邮箱")
    private String email;

    /** 手机号码 */
    @ApiModelProperty("手机号码")
    private String phonenumber;

    /** 用户性别 */
    @ApiModelProperty("用户性别(0男,1女,2未知)")
    private String sex;

    /** 用户头像 */
    @ApiModelProperty("用户头像")
    private String avatar;

    /** 密码 */
    @ApiModelProperty("密码")
    private String password;

    /** 帐号状态（0正常 1停用） */
    @ApiModelProperty("帐号状态(0正常,1停用)")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    private String delFlag;

    /** 最后登录IP */
    @ApiModelProperty("最后登录IP")
    private String loginIp;

    /** 最后登录时间 */
    @ApiModelProperty("最后登录时间")
    private Date loginDate;

    ///////////////////////////////////////
    /** 部门对象 */
    @ApiModelProperty("用户所在部门")
    private SysDept dept;

    /** 角色对象 */
    @ApiModelProperty("用户所在角色列表")
    private List<SysRole> roleList;

    /** 角色组 */
    @ApiModelProperty("用户所在角色id集合")
    private Long[] roleIds;

    /** 岗位对象 */
    @ApiModelProperty("用户所在岗位列表")
    private List<SysPost> postList;

    /** 岗位组 */
    @ApiModelProperty("用户所在岗位id集合")
    private Long[] postIds;

    @ApiIgnore
    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

}
