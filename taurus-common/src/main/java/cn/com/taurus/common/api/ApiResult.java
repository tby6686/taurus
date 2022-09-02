package cn.com.taurus.common.api;

import cn.com.taurus.common.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * REST API 返回结果
 * </p>
 *
 * @author tby
 * @since 2018-11-08
 */
@Data
@Accessors(chain = true)
@Builder
@ApiModel(value = "ApiResult对象",description = "Api返回结果")
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 8004487252556526569L;

    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private int code;

    /**
     * 是否成功
     */
    @ApiModelProperty("是否成功")
    private boolean success;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String message;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    /**
     * 时间
     */
    @ApiModelProperty("响应时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;


    public static <T> ApiResult<T> result(ApiCode apiCode, String message, T data) {
        boolean success = false;
        if (apiCode.getCode() == ApiCode.SUCCESS.getCode()) {
            success = true;
        }
        String apiMessage = apiCode.getMessage();
        if (StringUtils.isNotBlank(apiMessage)) {
            message = apiMessage;
        }
        return (ApiResult<T>) ApiResult.builder()
            .code(apiCode.getCode())
            .message(message)
            .data(data)
            .success(success)
            .time(new Date())
            .build();
    }


    public static ApiResult result(ApiCode apiCode, String message) {
        return result(apiCode, message, null);
    }

    public static <T> ApiResult<T> result(ApiCode apiCode, T data) {
        return result(apiCode, null, data);
    }

    public static ApiResult result(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static ApiResult success(){
        return result(ApiCode.SUCCESS);
    }

    public static ApiResult fail(){
        return result(ApiCode.FAIL);
    }

    ////////////////////成功消息///////////////////////////////////
    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> ApiResult<T> success(String msg, T data){
        return result(ApiCode.SUCCESS, msg, data);
    }

    public static ApiResult success(String msg){
        return success(msg,null);
    }

    public static <T> ApiResult<T> success(T data){
        return success(null, data);
    }

    ////////////////////失败消息///////////////////////////////////


    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 失败消息
     */
    public static <T> ApiResult<T> fail(String msg, T data){
        return result(ApiCode.FAIL, msg, data);
    }

    public static ApiResult fail(String msg){
        return fail(msg,null);
    }

    public static <T> ApiResult<T> fail(T data){
        return fail(null, data);
    }

}
