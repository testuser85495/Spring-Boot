package com.crud.crud_demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.crud.crud_demo.doa.StuRepo;
import com.crud.crud_demo.model.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		ApplicationContext con= SpringApplication.run(CrudDemoApplication.class, args);
		StuRepo sturepo= con.getBean(StuRepo.class);

		Student s=new Student();
		s.setName("sarthak");
		s.setGender("male");
		s.setAddress("maninagar");

		// sturepo.save(s);

		List<Student> stulist = sturepo.findByAddress("Anand");
		System.out.println();

		System.out.println("Find By Address ---------->>>>>>>>>>>>");
		stulist.forEach(stu-> System.out.println(stu));
		System.out.println();
	}


}
