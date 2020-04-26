package com.hanjie.ljtools.common;

import org.springframework.stereotype.Component;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 20:28
 **/

@Component
public class Result<T> {
    //返回错误码
    private Integer code;
    //返回信息
    private String message;
    //返回对象
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
        this.code = ResultStatus.SUCCESS.value();
        this.message = ResultStatus.SUCCESS.getReasonPhrase();
    }

    public Result(ResultStatus resultStatus) {
        this(resultStatus,null);
    }

    public Result(ResultStatus resultStatus, T data) {
        this.data = data;
        this.code = resultStatus.value();
        this.message = resultStatus.getReasonPhrase();
    }

    public void setResult(ResultStatus resultStatus){
        this.code = resultStatus.value();
        this.message = resultStatus.getReasonPhrase();
    }

}
