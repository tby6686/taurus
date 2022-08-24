package cn.com.taurus.framework.web.controller;


import cn.com.taurus.common.api.ApiResult;
import cn.com.taurus.common.constant.CacheConstants;
import cn.com.taurus.common.properties.TaurusConfig;
import cn.com.taurus.common.utils.redis.RedisCache;
import cn.com.taurus.common.utils.sign.Base64;
import cn.com.taurus.common.utils.uuid.IdUtils;
import cn.com.taurus.system.service.ISysConfigService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 验证码操作处理
 * 
 * @author tby
 */
@RestController
public class CaptchaController
{
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysConfigService configService;
    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public ApiResult getCode(HttpServletResponse response) throws IOException
    {
        ApiResult ajax = ApiResult.success();

        Map<String,Object> data = new HashMap<>();
        ajax.setData(data);

        boolean captchaEnabled = configService.selectCaptchaOnOff();
        data.put("captchaEnabled", captchaEnabled);
        if (!captchaEnabled)
        {
            return ajax;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.REDIS_CAPTCHA_CODES_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = TaurusConfig.getCaptchaType();
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisCache.setCacheObject(verifyKey, code, CacheConstants.REDIS_CAPTCHA_CODES_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return ApiResult.fail(e.getMessage());
        }

        data.put("uuid", uuid);
        data.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }
}
