package com.event.bootspringevent.event;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/4/8 11:20
 **/
@Component
@Slf4j
public class ContextRefreshedEventCustom extends ContextRefreshedEvent {
    /**
     * Create a new ContextRefreshedEvent.
     *
     * @param source the {@code ApplicationContext} that has been initialized
     *               or refreshed (must not be {@code null})
     */
    public ContextRefreshedEventCustom(ApplicationContext source) {
        super(source);
        try {
            log.info("睡一觉................................" + new Date());
            Thread.sleep(2);
            log.info("醒来.................................." + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
