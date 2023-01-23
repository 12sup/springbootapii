package com.te.java.springboot.backend.service;

import com.te.java.springboot.backend.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto saveStudentDetais(StudentDto studentDto);

    StudentDto getStudentDetails(Integer stdId);

    StudentDto updateStudentDetails(Integer stdId, StudentDto studentDto);

    boolean deleteStudentDetails(Integer stdId);


    public abstract List<StudentDto> findAllStudent();

}
