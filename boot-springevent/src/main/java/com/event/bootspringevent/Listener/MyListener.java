package com.event.bootspringevent.Listener;

import com.event.bootspringevent.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 事件监听器
 */
@Slf4j
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info("监听MyEvent事件--->:{}, 时间：{}", myEvent, new Date().getTime());
    }
}
