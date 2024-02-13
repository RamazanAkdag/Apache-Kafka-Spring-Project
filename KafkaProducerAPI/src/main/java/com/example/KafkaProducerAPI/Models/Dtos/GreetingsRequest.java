package com.example.KafkaProducerAPI.Models.Dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GreetingsRequest {
    private String name;

}
