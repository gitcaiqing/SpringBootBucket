package com.caiqing.bootelasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;

@SpringBootApplication
public class BootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootElasticsearchApplication.class, args);
    }



}
