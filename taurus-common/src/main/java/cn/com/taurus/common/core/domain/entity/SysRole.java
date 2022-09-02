package cn.com.taurus.common.core.domain.entity;

import cn.com.taurus.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author tby
 * @description
 * @date 2022-08-23 9:37
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRole对象")
public class SysRole extends BaseEntity {

    /** 角色ID */
    @ApiModelProperty("角色ID")
    private Long roleId;

    /** 角色名称 */
    @ApiModelProperty("角色名称")
    private String roleName;

    /** 角色权限 */
    @ApiModelProperty("角色权限")
    private String roleKey;

    /** 角色排序 */
    @ApiModelProperty("角色排序")
    private String roleSort;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限） */
    @ApiModelProperty("数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）")
    private String dataScope;

    /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
    @ApiModelProperty("菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）")
    private boolean menuCheckStrictly;

    /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
    @ApiModelProperty("部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）")
    private boolean deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    @ApiModelProperty("角色状态（0正常 1停用）")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    private String delFlag;

    /////////////////////////////////////////////

    /** 菜单组 */
    @ApiModelProperty("菜单组id集合")
    private Long[] menuIds;

    /** 部门组（数据权限） */
    @ApiModelProperty("部门组id集合")
    private Long[] deptIds;

}
