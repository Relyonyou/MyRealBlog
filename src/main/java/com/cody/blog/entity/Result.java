package com.cody.blog.entity;

import java.io.Serializable;

/**
 * 前端返回的结果集
 * @author Cody
 * @date 2020/11/3 - 19:23
 */
public class Result implements Serializable {
    public static final long serialVersionUID = 1L;
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;
    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
