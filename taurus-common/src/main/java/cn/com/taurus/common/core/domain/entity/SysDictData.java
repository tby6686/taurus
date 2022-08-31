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
@ApiModel(value = "SysDictData对象")
public class SysDictData extends BaseEntity {

    /** 字典编码 */
    @ApiModelProperty("字典编码")
    private Long dictCode;

    /** 字典排序 */
    @ApiModelProperty("字典排序")
    private Long dictSort;

    /** 字典标签 */
    @ApiModelProperty("字典标签")
    private String dictLabel;

    /** 字典键值 */
    @ApiModelProperty("字典键值")
    private String dictValue;

    /** 字典类型 */
    @ApiModelProperty("字典类型")
    private String dictType;

    /** 样式属性（其他样式扩展） */
    @ApiModelProperty("样式属性（其他样式扩展）")
    private String cssClass;

    /** 表格字典样式 */
    @ApiModelProperty("表格字典样式")
    private String listClass;

    /** 是否默认（Y是 N否） */
    @ApiModelProperty("是否默认（Y是 N否）")
    private String isDefault;

    /** 状态（0正常 1停用） */
    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

}
