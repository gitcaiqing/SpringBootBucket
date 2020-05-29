package com.caiqing.kafka.bootkafka.producer;

import com.alibaba.fastjson.JSON;
import com.caiqing.kafka.bootkafka.entity.UserLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

/**
 * @Description 用户日志生产者
 * @Author CQ
 * @Date 2019/10/30 14:13
 **/
@Component
@Slf4j
public class UserLogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendLog(String userId) {

        try {
            for (int i = 0; i < 1000; i++) {
                UserLog userLog = new UserLog("kafkaTest" + i, userId + i, "0");
                log.info("kafka发送的数据:{}", userLog);
                ListenableFuture listenableFuture = kafkaTemplate.send("user_log", JSON.toJSONString(userLog));
                log.info("listenableFuture:{}", listenableFuture.toString());
                SettableListenableFuture settableListenableFuture = (SettableListenableFuture) listenableFuture;
                log.info("settableListenableFuture:{}", settableListenableFuture.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
