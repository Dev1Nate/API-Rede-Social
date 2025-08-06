package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public List<Post> findbyTitle(String title){
        return repository.findbytittle(title);
    }

    public List<Post> findbyIt(String text, LocalDate mindDate,LocalDate maxDate){
        maxDate = maxDate.plusDays(1);
        return repository.findbyIt(text,mindDate,maxDate);
    }
}
