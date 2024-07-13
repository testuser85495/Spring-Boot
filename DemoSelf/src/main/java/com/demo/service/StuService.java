package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.Repo.StuRepo;
import com.demo.model.Stu;

@Component
public class StuService {

	@Autowired
	private StuRepo sturepo;

	public Stu save(Stu s) {
		this.sturepo.save(s);
		return s;
	}

	public List<Stu> getAllStu() {
		return (List<Stu>) sturepo.findAll();
	}

//    public List<Stu> getAllEmployee() {
//		// TODO Auto-generated method stub
//		
//		return sturepo.findAll();
//	}

	public void deletestu(int id) {
		sturepo.deleteById(id);
	}

	public Stu getById(int id) {
		// TODO Auto-generated method stub
		System.out.println(sturepo.findById(id));
		Stu stu = sturepo.findById(id).get();
		System.out.println(stu);
		return stu;
	}
	
	public void updateUser(Stu user,int id) {
		user.setId(id);
		this.sturepo.save(user);
	}
}
