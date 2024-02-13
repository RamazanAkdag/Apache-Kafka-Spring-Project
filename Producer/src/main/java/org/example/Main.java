package org.example;


import org.apache.kafka.common.protocol.types.Field;
import org.example.Kafka.KafkaService;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        KafkaService kafkaService = new KafkaService();

        Random rand = new Random();
        while (true){
            int randomint = rand.nextInt();
            kafkaService.produceMessage(String.valueOf(randomint));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }
}