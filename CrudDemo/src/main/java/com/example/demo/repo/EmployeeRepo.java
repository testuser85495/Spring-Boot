package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	//when you want to search by only name
	List<Employee> findByNameContaining(String name);
	//when we have to search by name and email we have to write Query
	@Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE %:search% OR LOWER(e.email) LIKE %:search%")
    List<Employee> searchByNameOrEmail(@Param("search") String search);

}
