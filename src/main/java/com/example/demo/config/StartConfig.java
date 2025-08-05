package com.example.demo.config;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class StartConfig implements CommandLineRunner {

    @Autowired
    private UserRepository user;

    @Autowired
    private PostRepository post;

    @Override
    public void run(String... args) throws Exception {
        user.deleteAll();
        post.deleteAll();

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        User maria = new User("3", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        User bob = new User("1", "Bob Grey", "bob@gmail.com");
        user.saveAll(Arrays.asList(maria,alex,bob));

        LocalDate date1 = LocalDate.parse("30/11/2022",form);
        LocalDate date2 = LocalDate.parse("10/06/2024",form);

        Post p1 = new Post("1","Partiu Viage","Fui Para o Litoral", Date.valueOf(date1),new AuthorDTO(maria));
        Post p2 = new Post("2","Retorno A Escola","Acabou as Ferias",Date.valueOf(date2),new AuthorDTO(maria));

        post.saveAll(Arrays.asList(p1,p2));

        maria.addPosts(p1);
        maria.addPosts(p2);
        maria.addPosts(p2);

        user.save(maria);


    }
}
