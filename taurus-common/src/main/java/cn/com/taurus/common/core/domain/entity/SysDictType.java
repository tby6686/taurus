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
@ApiModel(value = "SysDictType对象")
public class SysDictType extends BaseEntity {

    /** 字典主键 */
    @ApiModelProperty("字典主键")
    private Long dictId;

    /** 字典名称 */
    @ApiModelProperty("字典名称")
    private String dictName;

    /** 字典类型 */
    @ApiModelProperty("字典类型")
    private String dictType;

    /** 状态（0正常 1停用） */
    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

}
