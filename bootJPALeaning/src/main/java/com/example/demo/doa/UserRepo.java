package com.example.demo.doa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	public List<User> findByStatus(String string);

//	public User fndByCity(String string);

	public Iterable<User> findByCity(String string);

	public User findByName(String string);

	public List<User> findByCityStartingWith(String string);
	
	public List<User> findByCityContaining(String string);


}