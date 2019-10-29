package com.caiqing.bootjpa.util;

import lombok.Data;

@Data
public class ResultModel<T> {

    private Integer status = 0;

    private Integer resultCode = 200;

    private String message;

    private T data;

    public ResultModel(T data) {
        this.data = data;
    }

    public ResultModel() {

    }

    public ResultModel(Integer resultCode, String message) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public ResultModel(Integer status, Integer resultCode, String message, T data) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }
}
