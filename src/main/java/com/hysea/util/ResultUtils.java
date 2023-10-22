package com.hysea.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * 30000~40000为参数错误
 * 40000~50000为用户错误
 * 50000~60000为接口异常
 *
 * @author Hysea
 * @date 2021/4/28 15:56
 * 请求返回封装 类
 */
public class ResultUtils {


    /**
     * 成功 状态码：200 携带 提示、返回值
     *
     * @param message 提示信息
     * @param result  返回结果
     * @return String
     */
    public static String MESSAGE(Integer code,
                                 String message,
                                 Object result) {
        return JSONObject.toJSONString(new ReturnObject(code, message, result));
    }
    /**
     * 成功 状态码：200 携带 提示、返回值
     *
     * @param message 提示信息
     * @param result  返回结果
     * @return String
     */
    public static String MESSAGE(String code) {
        return JSONObject.toJSONString(new ReturnObject(code));
    }

    /**
     * 成功 状态码：200 携带 提示、返回值
     *
     * @param message 提示信息
     * @param result  返回结果
     * @return String
     */
    public static String SUCCESS(String message,
                          Object result) {
        return JSONObject.toJSONString(new ReturnObject(200, message, result));
    }

    /**
     * 成功 状态码：200 携带 提示、返回值
     *
     * @param message 提示信息
     * @param result  返回结果
     * @return String
     */
    public static String SUCCESS(String message,
                          Object result,
                          Object result1) {
        return JSONObject.toJSONString(new ReturnObject(200, message, result, result1));
    }

    /**
     * 成功 状态码：200 携带 提示、返回值
     *
     * @param message 提示信息
     * @param result  返回结果
     * @return String
     */
    public static String SUCCESS(String message,
                          Object result,
                          Object result1,
                          Object result2) {
        return JSONObject.toJSONString(new ReturnObject(200, message, result, result1, result2));
    }

    public static String SUCCESS(String message) {
        return JSONObject.toJSONString(new ReturnObject(200, message));
    }

    public static String LOGIN_WARNING(String message) {
        return JSONObject.toJSONString(new ReturnObject(400, message));
    }

    public static String SESSION_CLOSE() {
        return JSONObject.toJSONString(new ReturnObject(401, "会话已关闭 请刷新网页"));
    }

    public static String UNAUTHORIZED(String message) {
        return JSONObject.toJSONString(new ReturnObject(401, message));
    }

    public static String NON_EXECUTION(String message) {
        return JSONObject.toJSONString(new ReturnObject(403, message));
    }

    public static String WARNING(String message) {
        return JSONObject.toJSONString(new ReturnObject(500, message));
    }


    //算法调用的返回

    public static String IMAGE_IS_TOO_BIG() {
        return JSONObject.toJSONString(new ReturnObject(40001, "图片太大"));
    }

    public static String REPAIR() {
        return JSONObject.toJSONString(new ReturnObject(50001, "该功能正在修复，暂未启用"));
    }

    public static String UN_KNOW() {
        return JSONObject.toJSONString(new ReturnObject(50002, "未知的错误"));
    }

    public static String FILE_NO_FIND() {
        return JSONObject.toJSONString(new ReturnObject(50003, "没有该文件"));
    }
}
