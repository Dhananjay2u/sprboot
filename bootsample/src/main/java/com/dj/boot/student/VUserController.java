package com.dj.boot.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent())
            throw new StudentNotFoundException("Given User not found");
        return userRepository.findById(id).get();
    }
    
    @GetMapping(path="/addUser")
    public User addUser() {
        User user=new User(1,"aaa","aaaa");
//        List<Subject> list=new ArrayList<>();
//        Subject sub=new Subject(1, "java", "java desc");
        //list.add(sub);
        user.addSubject(new Subject(1, "java", "java desc"));
        
        return userRepository.save(user);
    }
    
}
