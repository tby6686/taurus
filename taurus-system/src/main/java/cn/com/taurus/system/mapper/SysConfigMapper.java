package cn.com.taurus.system.mapper;

import cn.com.taurus.system.entity.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author tby
 * @description
 * @date 2022-08-23 10:12
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
     * 查询参数配置信息
     *
     * @param config 参数配置信息
     * @return 参数配置信息
     */
    public SysConfig selectConfig(SysConfig config);

}
