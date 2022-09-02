package cn.com.taurus.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统登录日志
 *
 * @author tby
 * @since 2020-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 日志主键 */
    private Long infoId;

    /** 用户账号 */
    private String userName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地点 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 登录状态 0成功 1失败 */
    private String status;

    /** 提示消息 */
    private String msg;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

}
