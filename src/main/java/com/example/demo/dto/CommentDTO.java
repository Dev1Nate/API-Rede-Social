package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CommentDTO implements Serializable {

    private String text;
    private LocalDate date;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String text, LocalDate date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }


}
