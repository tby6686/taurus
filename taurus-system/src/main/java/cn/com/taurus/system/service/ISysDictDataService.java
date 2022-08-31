package cn.com.taurus.system.service;

import cn.com.taurus.common.core.domain.entity.SysDictData;
import cn.com.taurus.common.core.service.BaseService;
import java.util.List;

/**
 * 字典 业务层
 *
 * @author tby
 */
public interface ISysDictDataService extends BaseService<SysDictData> {


    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);
}
