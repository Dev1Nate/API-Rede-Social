package com.example.demo.config;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
public class StartConfig implements CommandLineRunner {

    @Autowired
    private UserRepository user;

    @Override
    public void run(String... args) throws Exception {
        user.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        user.saveAll(Arrays.asList(maria,alex,bob));



    }
}
