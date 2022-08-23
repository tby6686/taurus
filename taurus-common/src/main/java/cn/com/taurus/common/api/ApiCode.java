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

/**
 * <p>
 * REST API 响应码
 * </p>
 *
 * @author tby
 * @since 2018-11-08
 */
public enum ApiCode {

    /**
     * 操作成功
     **/
    SUCCESS(200, "操作成功"),

    /**
     * 对象创建成功
     **/
    CREATED(201, "对象创建成功"),

    /**
     * 请求已经被接受
     **/
    ACCEPTED(202, "请求已经被接受"),

    /**
     * 操作已经执行成功，但是没有返回数据
     **/
    NO_CONTENT(204, "操作已经执行成功，但是没有返回数据"),

    /**
     * 资源已被移除
     **/
    MOVED_PERM(301, "资源已被移除"),

    /**
     * 资源重定向
     **/
    SEE_OTHER(303, "资源重定向"),

    /**
     * 资源没有被修改
     **/
    NOT_MODIFIED(304, "资源没有被修改"),

    /**
     * 参数列表错误（缺少，格式不匹配）
     **/
    BAD_REQUEST(400, "参数列表错误（缺少，格式不匹配）"),

    /**
     * 未授权
     **/
    UNAUTHORIZED(401, "未授权"),

    /**
     * 访问受限，授权过期
     **/
    FORBIDDEN(403, "访问受限，授权过期"),

    /**
     * 资源，服务未找到
     **/
    NOT_FOUND(404, "资源，服务未找到"),

    /**
     *  不允许的http方法
     **/
    BAD_METHOD(405, "不允许的http方法"),

    /**
     *  资源冲突，或者资源被锁
     **/
    CONFLICT(409, "资源冲突，或者资源被锁"),

    /**
     *  不支持的数据，媒体类型
     **/
    UNSUPPORTED_TYPE(415, "不支持的数据，媒体类型"),

    /**
     * 系统内部错误/操作失败
     **/
    FAIL(500, "系统内部错误"),

    /**
     * 接口未实现
     **/
    NOT_IMPLEMENTED(501, "接口未实现");


    private final int code;
    private final String message;

    ApiCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiCode getApiCode(int code) {
        ApiCode[] ecs = ApiCode.values();
        for (ApiCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
