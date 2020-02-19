package com.event.bootspringevent;

import com.event.bootspringevent.Listener.MyListener;
import com.event.bootspringevent.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

@SpringBootApplication
@Slf4j
public class BootSpringeventApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootSpringeventApplication.class, args);

    }

}
