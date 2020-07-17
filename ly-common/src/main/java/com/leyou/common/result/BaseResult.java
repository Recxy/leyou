package com.leyou.common.result;

import lombok.Data;
import lombok.ToString;

/**
 * created by fuyd on 2018/8/20
 */
@Data
@ToString
public class BaseResult<T> {

    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MESSAGE = "ok";

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回信息
     */
    private String message;

    public BaseResult(T data) {
        this.data = data;
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
    }

    public BaseResult(T data, String code, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
