package cn.com.taurus.framework.exception;

import cn.com.taurus.common.api.ApiCode;
import cn.com.taurus.common.api.ApiResult;
import cn.com.taurus.common.exception.BusinessException;
import cn.com.taurus.common.exception.DaoException;
import cn.com.taurus.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author tby
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 权限校验异常
     */
    /*@ExceptionHandler(AccessDeniedException.class)
    public ApiResult handleAccessDeniedException(AccessDeniedException e,
        HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return ApiResult.result(ApiCode.FORBIDDEN, "没有权限，请联系管理员授权");
    }*/

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
        HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return ApiResult
            .result(ApiCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION, e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ApiResult handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Integer code = e.getErrorCode();
        return StringUtils.isNotNull(code) ? ApiResult
            .result(ApiCode.getApiCode(code), e.getMessage())
            : ApiResult.result(ApiCode.BUSINESS_EXCEPTION, e.getMessage());
    }

    /**
     * 数据库处理异常
     */
    @ExceptionHandler(DaoException.class)
    public ApiResult handleDaoException(DaoException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Integer code = e.getErrorCode();
        return StringUtils.isNotNull(code) ? ApiResult
            .result(ApiCode.getApiCode(code), e.getMessage())
            : ApiResult.result(ApiCode.DAO_EXCEPTION, e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ApiResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return ApiResult.result(ApiCode.RUNTIME_EXCEPTION, e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return ApiResult.result(ApiCode.SYSTEM_EXCEPTION, e.getMessage());
    }
}
