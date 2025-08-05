package com.example.demo.repository;

import com.example.demo.entities.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    @Query("{ 'title': {$regex: ?0, $options:'i' } }")
    List<Post> findbytittle(String title);
    List<Post> findByTitleContainingIgnoreCase(String title);
}
