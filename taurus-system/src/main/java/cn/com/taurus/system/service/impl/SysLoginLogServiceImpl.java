package cn.com.taurus.system.service.impl;

import cn.com.taurus.common.core.service.impl.BaseServiceImpl;
import cn.com.taurus.system.entity.SysLoginLog;
import cn.com.taurus.system.mapper.SysLoginLogMapper;
import cn.com.taurus.system.service.ISysLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:36
 */
@Slf4j
@Service
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogMapper, SysLoginLog> implements
    ISysLoginLogService {

}
