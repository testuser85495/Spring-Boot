package com.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Stu;
@Repository
public interface StuRepo extends CrudRepository<Stu ,Integer>{
    
}
