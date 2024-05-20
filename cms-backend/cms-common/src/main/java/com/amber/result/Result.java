package com.amber.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端返回统一结果
 */
@Data
public class Result<T> implements Serializable {
    private Integer code; // 响应码
    private String message; // 响应消息
    private T data;// 数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 200;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.message = msg;
        result.code = 0;
        return result;
    }
}
