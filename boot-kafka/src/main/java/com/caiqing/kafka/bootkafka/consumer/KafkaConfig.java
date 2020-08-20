package com.caiqing.kafka.bootkafka.consumer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/8/5 15:32
 **/
@Component
@Data
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String dataGroupServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String dataGroupConsumerGroupId;

    @Value("${spring.kafka.producer.batch-size}")
    private String batchSize;

}
