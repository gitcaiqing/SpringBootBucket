package com.event.bootspringevent.Exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private Integer code = 201;

    private String message;

    public BusinessException() {
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
