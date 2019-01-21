package com.iecas.testspringboot.nosql.mongo.repo;

import com.iecas.testspringboot.nosql.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {
    List<User> findByName(String name);
}
