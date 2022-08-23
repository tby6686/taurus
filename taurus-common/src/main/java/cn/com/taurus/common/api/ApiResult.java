/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.taurus.common.api;

import cn.com.taurus.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * REST API 返回结果
 * </p>
 *
 * @author geekidea
 * @since 2018-11-08
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 8004487252556526569L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 时间
     */
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
