package com.learn.learning.controller;

import org.springframework.web.bind.annotation.RestController;

import com.learn.learning.model.User;
import com.learn.learning.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    private UserService us;

    @GetMapping("/users")
    public List<User> getUser() {

        List<User> list = us.getAllUser();
        System.out.println(list);
        return list;
    }
     @GetMapping("/users/{id}")
    public User getSingleUser(@PathVariable("id") int id){
        return this.us.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User u){
        User user = this.us.addUser(u);
        return user; 
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id){
        this.us.deletUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User u,@PathVariable("id") int id){
        this.us.updateUser(u, id);
        return u;
    }
    
    
}
