package cn.com.taurus.common.core.pagination;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 可排序查询参数对象
 *
 * @author tby
 * @since 2019-08-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasePageOrderParam extends BasePageParam {
    private static final long serialVersionUID = 57714391204790143L;

    @ApiModelProperty(value = "排序项集合",position = 600)
    private List<OrderItem> pageSorts;

    public void defaultPageSort(OrderItem orderItem) {
        this.defaultPageSorts(Arrays.asList(orderItem));
    }

    public void defaultPageSorts(List<OrderItem> pageSorts) {
        if (CollectionUtils.isEmpty(pageSorts)) {
            return;
        }
        this.pageSorts = pageSorts;
    }

}
