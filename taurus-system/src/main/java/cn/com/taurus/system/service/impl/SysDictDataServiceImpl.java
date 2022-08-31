package cn.com.taurus.system.service.impl;

import cn.com.taurus.common.core.domain.entity.SysDictData;
import cn.com.taurus.common.core.service.impl.BaseServiceImpl;
import cn.com.taurus.common.utils.DictUtils;
import cn.com.taurus.system.mapper.SysDictDataMapper;
import cn.com.taurus.system.service.ISysDictDataService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:36
 */
@Slf4j
@Service
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataMapper, SysDictData> implements
    ISysDictDataService {

    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (CollectionUtils.isNotEmpty(dictDatas)) {
            return dictDatas;
        }
        dictDatas = baseMapper.selectDictDataByType(dictType);
        if (CollectionUtils.isNotEmpty(dictDatas)) {
            DictUtils.setDictCache(dictType, dictDatas);
            return dictDatas;
        }
        return null;
    }
}
