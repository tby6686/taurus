package cn.com.taurus.common.core.pagination;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 查询参数
 *
 * @author tby
 * @since 2018-11-08
 */
@Data
public abstract class BasePageParam implements Serializable {
    private static final long serialVersionUID = -3263921252635611410L;

    @ApiModelProperty(value = "页码,默认为1", example = "1",position = 700)
    private Long pageIndex = 1L;

    @ApiModelProperty(value = "页大小,默认为10", example = "10",position = 701)
    private Long pageSize = 10L;

    @ApiModelProperty(value = "搜索字符串", example = "",position = 702)
    private String keyword;

    public void setPageIndex(Long pageIndex) {
        if (pageIndex == null || pageIndex <= 0) {

        } else {
            this.pageIndex = pageIndex;
        }
    }

    public void setPageSize(Long pageSize) {
        if (pageSize == null || pageSize <= 0) {

        } else {
            this.pageSize = pageSize;
        }
    }

}
