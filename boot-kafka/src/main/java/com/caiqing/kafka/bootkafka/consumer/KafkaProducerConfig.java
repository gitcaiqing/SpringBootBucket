package com.caiqing.kafka.bootkafka.consumer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/8/6 15:35
 **/
@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaConfig kafkaConfig;

    public Map<String, Object> producerFactory(){
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ProducerConfig.ACKS_CONFIG, "0");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getDataGroupServers());
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaConfig.getBatchSize());
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public ProducerFactory<String, String> defaultKafkaProducerFactory(){
        return new DefaultKafkaProducerFactory<>(producerFactory());
    }

    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<String, String>(defaultKafkaProducerFactory());
    }
}
