package org.example.Kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.Log4j.Log4jService;

import java.util.Properties;

public class KafkaService {
    private KafkaProducer<String, String> kafkaProducer;

    public KafkaService(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        kafkaProducer = new KafkaProducer<>(properties);
    }

    public void produceMessage(String message){
        ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstants.TOPIC_NAME, message);
        kafkaProducer.send(record);
        kafkaProducer.flush();
        Log4jService.logger.info("producer sended message: " + message);

    }

}
