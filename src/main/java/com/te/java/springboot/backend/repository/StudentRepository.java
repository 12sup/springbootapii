package com.te.java.springboot.backend.repository;

import com.te.java.springboot.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //public abstract List<Student> findByName(String stdName);

}