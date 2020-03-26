package com.event.bootspringevent.event;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @Description 自定义泛型类实现事件调度
 * @Author CQ
 * @Date 2020/2/21 16:27
 **/

public class GenericEventResolvableType<T> implements ResolvableTypeProvider {

    //数据
    private T data;

    //事件类型 0 订单创建 1 登陆成功 2 生成待发货信息
    private Integer type;

    public GenericEventResolvableType(T data, Integer type){
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

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forClass(getData().getClass()));
    }
}
