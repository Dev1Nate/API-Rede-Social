package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try {
            repository.deleteById(id);
        }catch (IllegalArgumentException e){
            throw new ObjectNotFoundException("Object Not Found");
        }
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(),dto.getName(),dto.getEmail());
    }
}
