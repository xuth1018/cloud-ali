package com.xx.cloud.util;

public class ResultData<T> {

    private int code;
    private String message;
    private T data;

    public ResultData() {
    }

    public ResultData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultData<T> ok(T data){
        return new ResultData<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }


    public static <T> ResultData<T> err(T data){
        return new ResultData<>(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage(),data);
    }
}
