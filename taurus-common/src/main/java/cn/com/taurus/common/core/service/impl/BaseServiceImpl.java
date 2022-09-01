package cn.com.taurus.common.core.service.impl;

import cn.com.taurus.common.core.service.BaseService;
import cn.com.taurus.common.utils.mybatis.LambdaColumn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 公共Service父类
 *
 * @author tby
 * @date 2018-11-08
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends
    ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 获取对应字段的数据表列名称
     *
     * @param func
     * @return
     */
    public String getLambdaColumn(SFunction<T, ?> func) {
        return new LambdaColumn<T>().get(func);
    }

}
