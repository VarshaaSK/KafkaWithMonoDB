package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KafkaDataRepository extends MongoRepository<User, Integer> {
}
