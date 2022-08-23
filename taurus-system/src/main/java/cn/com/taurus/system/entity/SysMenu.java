package cn.com.taurus.system.entity;

import cn.com.taurus.common.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author tby
 * @description
 * @date 2022-08-23 9:44
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysMenu对象")
public class SysMenu extends BaseEntity {

    /** 菜单ID */
    @ApiModelProperty("菜单ID")
    private Long menuId;

    /** 菜单名称 */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /** 父菜单ID */
    @ApiModelProperty("父菜单ID")
    private Long parentId;

    /** 父菜单名称 */
    private String parentName;

    /** 显示顺序 */
    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    /** 路由地址 */
    @ApiModelProperty("路由地址")
    private String path;

    /** 组件路径 */
    @ApiModelProperty("组件路径")
    private String component;

    /** 路由参数 */
    @ApiModelProperty("路由参数")
    private String query;

    /** 是否为框架（0否 1是） */
    @ApiModelProperty("是否为外链（0否 1是）")
    private String isFrame;

    /** 是否缓存（0不缓存 1缓存） */
    @ApiModelProperty("是否缓存（0不缓存 1缓存）")
    private String isCache;

    /** 菜单类型（M目录 C菜单 F按钮） */
    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    /** 显示状态（0隐藏 1显示） */
    @ApiModelProperty("显示状态（0隐藏 1显示）")
    private String visible;

    /** 菜单状态（0正常 1停用） */
    @ApiModelProperty("菜单状态（0正常 1停用）")
    private String status;

    /** 权限字符串 */
    @ApiModelProperty("权限字符串")
    private String perms;

    /** 菜单图标 */
    @ApiModelProperty("菜单图标")
    private String icon;

    //////////////////////////////////////////////////////

    /** 子菜单 */
    private List<SysMenu> children = new ArrayList<SysMenu>();

}
