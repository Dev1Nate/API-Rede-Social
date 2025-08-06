package com.example.demo.resources;

import com.example.demo.entities.Post;
import com.example.demo.resources.util.URLEncoder;
import com.example.demo.services.PostService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findbyid(@PathVariable String id){
        Post x = service.findById(id);
        return ResponseEntity.ok().body(x);

    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findbytittle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URLEncoder.decodeParameter(text);
        List<Post> list = service.findbyTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> findbyIt(@RequestParam(value = "text",defaultValue = "") String text,
                                               @RequestParam(value = "minDate",defaultValue = "") String minDate,
                                               @RequestParam(value = "maxDate",defaultValue = "") String maxDate
                                               ){
        text = URLEncoder.decodeParameter(text);
        LocalDate min = URLEncoder.dateConverted(minDate, LocalDate.of(1970, 1, 1));
        LocalDate max = URLEncoder.dateConverted(minDate, LocalDate.now());

        List<Post> list = service.findbyIt(text,min,max)
        return ResponseEntity.ok().body(list);
    }





}
