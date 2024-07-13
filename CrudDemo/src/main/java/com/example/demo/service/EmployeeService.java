package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepo eRepo;

	public void save(Employee e) {
		System.out.println(e);

		System.out.println(eRepo.save(e));
//		eRepo.save(e);
	}

	public List<Employee> getAllEmployee() {
		return eRepo.findAll();
	}

	public void deleteById(int id) {
		eRepo.deleteById(id);
	}

	public Employee getById(int id) {
		return eRepo.findById(id).get();
	}

}
