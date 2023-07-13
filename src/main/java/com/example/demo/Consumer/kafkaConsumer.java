package com.example.demo.Consumer;

import com.example.demo.Model.User;
import com.example.demo.Repository.KafkaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaConsumer.class);

    @Autowired
    private KafkaDataRepository dbRepository;

    @KafkaListener(topics = "RegistrationDetails", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
        dbRepository.save(user);
    }
}
