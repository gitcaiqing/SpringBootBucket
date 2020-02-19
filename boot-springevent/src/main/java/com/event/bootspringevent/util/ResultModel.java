package com.event.bootspringevent.util;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ResultModel<T> {

    private Integer status = 0;

    private Integer resultCode = 200;

    private String message;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp = new Date();

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
