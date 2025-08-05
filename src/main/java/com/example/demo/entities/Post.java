package com.example.demo.entities;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Document
public class Post implements Serializable,Comparable<Post> {

    @Id
    private String id;
    @NotBlank(message = "Titulo Nao Pode Ser Vazio")
    private String title;
    private String body;
    private LocalDate date;
    @NotBlank(message = "Author Nao Pode Ser Nulo")
    private AuthorDTO author;

    List<CommentDTO> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String id, String title, String body, LocalDate date, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public LocalDate  getDate() {
        return date;
    }

    public void setDate(LocalDate  date) {
        this.date = date;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void addComments(CommentDTO comments) {
        this.comments.add(comments);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Post o) {
        return id.compareTo(o.getId());
    }
}
