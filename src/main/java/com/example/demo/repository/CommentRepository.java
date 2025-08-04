package com.example.demo.repository;

import com.example.demo.entities.Comment;
import com.example.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
}
