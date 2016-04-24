package com.god.dream.common.response;

import com.god.dream.common.exception.StatusCode;

/**
 * Created by Administrator on 2016/4/24.
 */
public class Response<T> {

    private int code = StatusCode.STATUS_SUCCESS;
    private String message = StatusCode.message(StatusCode.STATUS_SUCCESS);

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.message = StatusCode.message(code);
    }

    public void setCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
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
}
