package com.iecas.test.springboot.jpa.nosql.repo;

import com.iecas.test.springboot.jpa.nosql.mongo.domain.User;
import com.iecas.test.springboot.jpa.nosql.mongo.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongoTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSave(){
        User user=new User(1,"wlj",24,"Man");
        userRepository.save(user);
    }

}
