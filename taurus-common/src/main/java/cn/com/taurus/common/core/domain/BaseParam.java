package cn.com.taurus.common.core.domain;

import cn.com.taurus.common.core.pagination.BasePageOrderParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author tby
 * @description
 * @date 2022-09-01 16:31
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BaseParam extends BasePageOrderParam {

    /** 时间--开始 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("时间开始(yyyy-MM-dd)")
    private Date beginTime;

    /** 时间--结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("时间结束(开始yyyy-MM-dd)")
    private Date endTime;

}
