package com.skyline.logging.util;

import java.util.HashMap;

/**
 * 接口返回JSON数据的封装类
 *
 * @author zhangkepeng
 * @email skyline_1993@163.com
 * @date 2019/5/13
 */
public class R extends HashMap<String, Object> {

    /**
     * 返回的状态码
     */
    public static final String RETURN_CODE = "code";
    /**
     * 返回的消息
     */
    public static final String RETURN_MESSAGE = "message";
    /**
     * 成功
     */
    public static final String SUCCESS = "success";
    /**
     * 失败
     */
    public static final String FAILED = "failed";
    /**
     * 状态码0
     */
    public static final int SUCCESS_CODE = 0;
    /**
     * 状态码500
     */
    public static final int FAILED_CODE = 500;

    public R() {
        put(RETURN_CODE, SUCCESS_CODE);
        put(RETURN_MESSAGE, SUCCESS);
    }

    public R(int code, String message) {
        put(RETURN_CODE, code);
        put(RETURN_MESSAGE, message);
    }

    /**
     * 成功时默认的返回格式
     *
     * @return
     */
    public static R ok() {
        return new R();
    }

    /**
     * 成功时自定义消息返回
     *
     * @param message
     * @return
     */
    public static R ok(String message) {
        return new R().put(RETURN_MESSAGE, message);
    }

    /**
     * 成功时自定义状态码与消息返回
     *
     * @param code
     * @param message
     * @return
     */
    public static R ok(int code, String message) {
        return new R(code, message);
    }

    /**
     * 失败时默认返回
     *
     * @return
     */
    public static R error() {
        return new R(FAILED_CODE, FAILED);
    }

    /**
     * 失败时自定义消息返回
     *
     * @param message
     * @return
     */
    public static R error(String message) {
        return new R(FAILED_CODE, message);
    }

    /**
     * 失败时自定义状态码与消息返回
     *
     * @param code
     * @param message
     * @return
     */
    public static R error(int code, String message) {
        return new R(code, message);
    }

    /**
     * 添加返回数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
