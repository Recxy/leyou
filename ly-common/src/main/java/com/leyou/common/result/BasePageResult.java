package com.leyou.common.result;

import lombok.Data;
import lombok.ToString;

/**
 * created by fuyd on 2018/9/25
 */
@Data
@ToString
public class BasePageResult<T> {

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

    private Long totalSize;

    public BasePageResult(){}

    public BasePageResult(T data, Long totalSize) {
        this.data = data;
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
        this.totalSize = totalSize;
    }

    public BasePageResult(T data, String code, String message, Long totalSize) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.totalSize = totalSize;
    }
}
