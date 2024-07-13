package com.learn.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.learn.learning.model.User;

public class UserService {
    private static List<User> list = new ArrayList<>();
    static {
        list.add(new User(1, "Arkan", 1234l, "Anand"));
        list.add(new User(2, "ABC", 1234675l, "Delhi"));
        list.add(new User(3, "xyz", 1234675l, "Delhi"));
    }

    public List<User> getAllUser() {
        System.out.println("list------------->>>>>>>>>> " + list);
        return list;
    }

    public User getUserById(int id) {
        return list.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public User addUser(User u) {
        list.add(u);
        return u;
    }

    public void deletUserById(int id) {
        list.stream().filter(u -> u.getId() != id).collect(Collectors.toList());
    }

    public void updateUser(User u, int id) {
        list = list.stream().map(b ->{
            if (b.getId()==id) {
                b.setName(u.getName());
                b.setContact(u.getContact());
                b.setAddress(u.getAddress());
                
            }
            return b;
        }).collect(Collectors.toList());

    }

}
