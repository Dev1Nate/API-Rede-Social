package com.example.demo.config;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class StartConfig implements CommandLineRunner {

    @Autowired
    private UserRepository user;

    @Autowired
    private PostRepository post;

    @Autowired
    private CommentRepository comment;

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

        LocalDate date3 = LocalDate.parse("10/12/2022",form);
        LocalDate date4 = LocalDate.parse("24/06/2024",form);

        Post p1 = new Post("1","Partiu Viage","Fui Para o Litoral", date1,new AuthorDTO(maria));
        Post p2 = new Post("2","Retorno A Escola","Acabou as Ferias",date2,new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa Viagem",date3,new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Meus Pesames",date4,new AuthorDTO(bob));



        maria.addPosts(p1);
        maria.addPosts(p2);
        maria.addPosts(p2);

        p1.addComments(c1);
        p2.addComments(c2);

        post.saveAll(Arrays.asList(p1,p2));
        user.save(maria);


    }
}
