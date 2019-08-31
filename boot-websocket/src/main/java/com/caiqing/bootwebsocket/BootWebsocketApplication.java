package com.caiqing.bootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class BootWebsocketApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootWebsocketApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder  configure(SpringApplicationBuilder builder) {
        return builder.sources(BootWebsocketApplication.class);
    }
}
