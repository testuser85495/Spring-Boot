package com.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Stu;
import com.demo.service.StuService;



@RestController
public class StuController {

    @Autowired
    private StuService stuservice;

    
    @GetMapping("/stu")
	public List<Stu> getUsers() {
		return this.stuservice.getAllStu();
	}
    
    @GetMapping("/stu/{id}")
	public Stu getUserById(@PathVariable("id") int id) {
		 Stu user = this.stuservice.getById(id);
		 return user;
	}
    
    @PostMapping("/stu")
	public List<Stu> addUser(@RequestBody Stu u) {
		Stu user = this.stuservice.save(u);
		return stuservice.getAllStu();
	}
    
    @DeleteMapping("/stu/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		this.stuservice.deletestu(id);
	}

    @PutMapping("/stu/{id}")
	public void updateUser(@PathVariable("id") int id, @RequestBody Stu u) {
		this.stuservice.updateUser(u, id);
	}
}
