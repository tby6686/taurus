package cn.com.taurus.system.service;

import cn.com.taurus.common.core.service.BaseService;
import cn.com.taurus.system.entity.SysConfig;

/**
 * @author tby
 * @description
 * @date 2022-08-23 14:35
 */
public interface ISysConfigService extends BaseService<SysConfig> {

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    public String selectConfigByKey(String configKey);

    /**
     * 获取验证码开关
     *
     * @return true开启，false关闭
     */
    public boolean selectCaptchaOnOff();

}
