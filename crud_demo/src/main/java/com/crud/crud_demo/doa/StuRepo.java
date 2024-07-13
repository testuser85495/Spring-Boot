package com.crud.crud_demo.doa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crud.crud_demo.model.Student;

public interface StuRepo extends CrudRepository<Student,Integer>{

    public List<Student> findByAddress(String string);
    
}
