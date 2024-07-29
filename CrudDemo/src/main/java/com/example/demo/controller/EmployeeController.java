package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService eservice;
	
	@GetMapping("/")
	public  String indexPage() {
		return "index";
	}
	@GetMapping("/home")
	public  ModelAndView homePage() {
		List<Employee> list= eservice.getAllEmployee();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		mv.addObject("employee",list);
		return mv;
//		else we write this
//		return new ModelAndView("home","employee",list);
	}

	@GetMapping("/register")
	public  String registerPage() {
		
		return "register";
		
	}
	
	@PostMapping("/search")
	public String searchByName(@RequestParam("name") String name, Model m) {
//	    List<Employee> emplist = eservice.getByName(name); 
		List<Employee> emplist = eservice.getByName(name); 
	    System.out.println(emplist);
	    m.addAttribute("employee", emplist);
	    return "searchResults";
	}
	
	@PostMapping("/add")
	public  String addEmployee(@ModelAttribute Employee e) {
		System.out.println(e);
		eservice.save(e);
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
		eservice.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String editById(@PathVariable("id") int id,Model m) {
		Employee emp= eservice.getById(id);
		m.addAttribute("employee",emp);
		return "edit";
	}
}
