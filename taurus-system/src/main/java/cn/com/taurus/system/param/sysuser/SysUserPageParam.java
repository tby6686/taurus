package cn.com.taurus.system.param.sysuser;

import cn.com.taurus.common.core.domain.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author tby
 * @description
 * @date 2022-09-01 16:18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserPageParam对象", description = "系统用户分页查询参数")
public class SysUserPageParam extends BaseParam {

    /** 部门ID */
    @ApiModelProperty("部门ID")
    private Long deptId;

    /** 用户账号 */
    @ApiModelProperty("用户账号")
    private String userName;

    /** 手机号码 */
    @ApiModelProperty("手机号码")
    private String phonenumber;

    /** 帐号状态（0正常 1停用） */
    @ApiModelProperty("帐号状态(0正常,1停用)")
    private String status;

}
