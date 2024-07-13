package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.doa.UserRepo;
import com.example.demo.model.User;


@SpringBootApplication
public class BootJpaLeaningApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootJpaLeaningApplication.class, args);
		System.out.println("started");
		UserRepo userRepo = context.getBean(UserRepo.class);

//		User u = new User();
//		u.setName("abc");
//		u.setCity("Anand");
//		u.setStatus("True");
////		userRepo.save(u);
//
//		User u1 = new User();
//		u1.setName("xyz");
//		u1.setCity("Surat");
//		u1.setStatus("false");
////		userRepo.save(u1);
//		
//		User u2 = new User();
//		u2.setName("xyz");
//		u2.setCity("Mumbai");
//		u2.setStatus("false");
////		userRepo.save(u2);
//
//		List<User> list = List.of(u, u1,u2);
//		System.out.println(list);
//		userRepo.saveAll(list);

//		User u = new User();
//		u.setName("rst");
//		u.setCity("Delhi");
//		u.setStatus("false");
//		userRepo.save(u);
//		
		Iterable<User> iterable = userRepo.findAll();
		// standard way
//		Iterator<User> itr = iterable.iterator();
//		while(itr.hasNext()) {
//			User u = itr.next();
//			System.out.println(u);
//		}
		// by lambda
		iterable.forEach(u -> System.out.println(u));

//		System.out.println(userRepo.findAll());
		System.out.println(userRepo.findById(202));
		System.out.println(userRepo.findByCity("Surat"));

		Iterable<User> City = userRepo.findByCity("Anand");
		City.forEach(u -> System.out.println(u));

		System.out.println(userRepo.findByStatus("true"));

		System.out.println();
		System.out.println(userRepo.findByName("pqr"));

//		Delete Method
		userRepo.deleteById(502);
		System.out.println("\nDelete");

		iterable.forEach(u -> System.out.println(u));

		List<User> list = userRepo.findByCityStartingWith("d");
		System.out.println("\nCity Start By D");
		list.forEach(u -> System.out.println(u));

		
//		findByCityContaining
		List<User> list1 = userRepo.findByCityContaining("d");
		System.out.println("\nCity Contains D");
		list1.forEach(u -> System.out.println(u));

	}

}
