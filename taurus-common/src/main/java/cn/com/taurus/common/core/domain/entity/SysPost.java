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
 * @date 2022-08-23 9:35
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysPost对象")
public class SysPost extends BaseEntity {

    /** 岗位ID */
    @ApiModelProperty("岗位ID")
    private Long postId;

    /** 岗位编码 */
    @ApiModelProperty("岗位编码")
    private String postCode;

    /** 岗位名称 */
    @ApiModelProperty("岗位名称")
    private String postName;

    /** 岗位排序 */
    @ApiModelProperty("岗位排序")
    private String postSort;

    /** 状态（0正常 1停用） */
    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

}
