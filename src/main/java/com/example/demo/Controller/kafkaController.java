package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Producer.kafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finalKafka")
public class kafkaController {
    private kafkaProducer producer;

    public kafkaController(kafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        producer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
