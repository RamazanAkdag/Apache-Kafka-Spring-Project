package com.example.KafkaProducerAPI.Helpers.Kafka;

import com.example.KafkaProducerAPI.Config.Kafka.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, message);
    }

}
