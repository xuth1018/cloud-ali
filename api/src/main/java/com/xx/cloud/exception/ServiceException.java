package com.xx.cloud.exception;

public class ServiceException extends RuntimeException{

    private int code;

    public ServiceException() {
    }

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum,String message) {
        super(message);
        this.code = serviceExceptionEnum.getCode();
    }

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code = serviceExceptionEnum.getCode();
    }

    public int getCode() {
        return code;
    }
}
