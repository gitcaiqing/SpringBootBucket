package com.event.bootspringevent.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 自定义泛型类实现事件调度
 * @Author CQ
 * @Date 2020/2/21 16:27
 **/

public class GenericEvent<T> {

    //数据
    private T data;

    //事件类型 0 订单创建 1 登陆成功 2 生成待发货信息
    private Integer type;

    public GenericEvent(T data, Integer type){
        this.data = data;
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
