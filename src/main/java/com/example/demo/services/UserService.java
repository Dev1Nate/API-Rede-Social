package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }

    public User findOne(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public void delete(String id){
        findOne(id);
        repository.deleteById(id);
    }

    public User insert(User user){
        return repository.save(user);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(),dto.getName(),dto.getEmail());
    }

    public User update(User obj) {
        User newUser = repository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
        updateUser(newUser, obj);
        return repository.save(newUser);
    }

    public void updateUser(User updateUser,User userToUpdate ){
        userToUpdate.setEmail(updateUser.getEmail());
        userToUpdate.setName(updateUser.getName());
    }

    public List<Post> postPerUser(String id){
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
        return user.getPosts();
    }
}
