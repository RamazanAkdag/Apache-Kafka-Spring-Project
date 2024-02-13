package com.example.KafkaProducerAPI.Controllers;

import com.example.KafkaProducerAPI.Helpers.Kafka.MessageProducer;
import com.example.KafkaProducerAPI.Models.Dtos.GreetingsRequest;
import com.example.KafkaProducerAPI.Models.Dtos.GreetingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    @Autowired
    private MessageProducer messageProducer;

    @GetMapping
    public ResponseEntity<GreetingsResponse> greetings(@RequestBody GreetingsRequest req){

        messageProducer.sendMessage("hello" + req.getName());
        return ResponseEntity.ok(new GreetingsResponse("hello " + req.getName()));
    }



}
