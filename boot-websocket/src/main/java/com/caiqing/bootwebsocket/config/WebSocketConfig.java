package com.caiqing.bootwebsocket.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 首先注入一个ServerEndpointExporterBean,
 * 该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
 */
@Configurable
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
