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
 * @date 2022-08-23 9:28
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysDept对象")
public class SysDept extends BaseEntity {

    /** 部门ID */
    @ApiModelProperty("部门ID")
    private Long deptId;

    /** 父部门ID */
    @ApiModelProperty("父部门ID")
    private Long parentId;

    /** 祖级列表 */
    @ApiModelProperty("祖级列表")
    private String ancestors;

    /** 部门名称 */
    @ApiModelProperty("部门名称")
    private String deptName;

    /** 显示顺序 */
    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    /** 负责人 */
    @ApiModelProperty("负责人")
    private String leader;

    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;

    /** 邮箱 */
    @ApiModelProperty("邮箱")
    private String email;

    /** 部门状态:0正常,1停用 */
    @ApiModelProperty("部门状态:0正常,1停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    private String delFlag;

    /////////////////////////////////////////////////

    /** 父部门名称 */
    private String parentName;

}
