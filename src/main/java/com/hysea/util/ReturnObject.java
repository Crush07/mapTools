package com.hysea.util;

import java.util.Map;

/**
 * @author Nuisance
 * @date 2020/12/23 9:25
 */
public class ReturnObject {
    private int code = 0;
    private String message = "";
    private Object result;
    private Object result2;
    private Object result3;
    private Map<String, Object> map;

    public ReturnObject() {
    }

    public ReturnObject(int code,
                        String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnObject(String message,
                        Object result) {
        this.message = message;
        this.result = result;
    }

    public ReturnObject(String message,
                        Object result,
                        Object result2) {
        this.message = message;
        this.result = result;
        this.result2 = result2;
    }

    public ReturnObject(Object result) {
        this.result = result;
    }

    public ReturnObject(int code,
                        String message,
                        Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ReturnObject(int code,
                        String message,
                        Object result,
                        Object result2) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.result2 = result2;
    }

    public ReturnObject(int code,
                        String message,
                        Object result,
                        Object result2,
                        Object result3) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.result2 = result2;
        this.result3 = result3;
    }

    public ReturnObject(int code,
                        String message,
                        Map result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ReturnObject(int code,
                        String message,
                        Object result,
                        Map<String, Object> map) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.map = map;
    }

    public Object getResult2() {
        return result2;
    }

    public void setResult2(Object result2) {
        this.result2 = result2;
    }

    public Object getResult3() {
        return result3;
    }

    public void setResult3(Object result3) {
        this.result3 = result3;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
