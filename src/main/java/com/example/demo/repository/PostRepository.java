package com.example.demo.repository;

import com.example.demo.entities.Post;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    @Query("{ 'title': {$regex: ?0, $options:'i' } }")
    List<Post> findbytittle(String title);
    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> findbyIt(String text, LocalDate min, LocalDate max);
}
