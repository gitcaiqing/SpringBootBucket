package com.event.bootspringevent.event;

import com.event.bootspringevent.entity.Order;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义订单创建事件-异步
 */
@Data
public class OrderCreateEventAsync extends ApplicationEvent {

    private Order order;

    public OrderCreateEventAsync(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
