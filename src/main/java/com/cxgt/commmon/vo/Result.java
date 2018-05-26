package com.cxgt.commmon.vo;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
public class Result<T> {

    /**
     * 状态码
     */
    public int code;

    /**
     * 描述
     */
    public String message;

    /**
     * 数据结果集
     */
    public T data;


    public Result() {
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
