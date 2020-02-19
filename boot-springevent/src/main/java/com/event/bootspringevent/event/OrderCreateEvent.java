package com.event.bootspringevent.event;

import com.event.bootspringevent.entity.Order;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义订单创建事件
 */
@Data
public class OrderCreateEvent extends ApplicationEvent {

    private Order order;

    public OrderCreateEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
