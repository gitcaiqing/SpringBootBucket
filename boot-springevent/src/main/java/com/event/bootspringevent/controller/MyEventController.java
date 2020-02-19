package com.event.bootspringevent.controller;

import com.event.bootspringevent.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@Slf4j
public class MyEventController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ApplicationEventPublisher publisher;

    //子
    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/publish")
    public String publishEvent(){
        MyEvent myEvent = new MyEvent("myEvent");
        //事件广播器

        //发布1次
        publisher.publishEvent(myEvent);

        //发布2次
        //applicationContext.publishEvent(myEvent);
        log.info("事件MyEvent发布成功");
        return "事件MyEvent发布成功";
    }
}
