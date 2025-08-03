package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Post implements Serializable,Comparable<Post> {

    private String id;
    private String title;
    private String body;
    private Date date;
    private User author;

    Set<Comment> comments = new TreeSet<>();

    public Post() {
    }

    public Post(String id, String title, String body, Date date, User author) {
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
