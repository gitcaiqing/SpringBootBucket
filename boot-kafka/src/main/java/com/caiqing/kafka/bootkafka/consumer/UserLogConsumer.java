package com.caiqing.kafka.bootkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @Description 用户日志kafka消息消费者
 * @Author CQ
 * @Date 2019/10/30 14:17
 **/
@Component
@Slf4j
public class UserLogConsumer {

    @KafkaListener(topics = {"user_log"})
    public void consumer(ConsumerRecord consumerRecord) {
        Optional kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info("kafka消费者接收到的consumerRecord：{}", kafkaMessage);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("kafka消费的消息：{}", message);
        }
    }

}
