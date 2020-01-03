package com.dj.boot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dj.boot.student.repository.UserRepository;

@RestController
public class VUserController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping(path="/getUser/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }
    
    @PostMapping(path="/addUser")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
}
