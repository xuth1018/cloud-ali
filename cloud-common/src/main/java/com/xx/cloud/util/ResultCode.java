package com.xx.cloud.util;

public enum  ResultCode {
    SUCCESS(200,"操作成功"),
    FAIL(500,"操作失败");

    private int code;
    private String message;
    ResultCode(int code,String message) {
        this.code = code;
        this.message = message;
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

    public static void main(String[] args) {
        System.out.println(ResultCode.SUCCESS.getCode());
    }
}
