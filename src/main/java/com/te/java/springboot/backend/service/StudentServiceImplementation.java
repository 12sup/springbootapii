package com.te.java.springboot.backend.service;

import com.te.java.springboot.backend.dto.StudentDto;
import com.te.java.springboot.backend.entity.Student;
import com.te.java.springboot.backend.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto saveStudentDetais(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        Student saveStudent = studentRepository.save(student);
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }

    @Override
    public StudentDto getStudentDetails(Integer stdId) {
        Optional<Student> optional = studentRepository.findById(stdId);
        if (optional.isPresent()) {
            Student student = optional.get();
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            return studentDto;
        }

        return null;
    }

    @Override
    public StudentDto updateStudentDetails(Integer stdId, StudentDto studentDto) {
        Optional<Student> student = studentRepository.findById(stdId);
        if (student.isPresent()) {
            Student student1 = student.get();
            BeanUtils.copyProperties(studentDto, student1);
            Student saveStudent = studentRepository.save(student1);
            StudentDto studentDto1 = new StudentDto();
            BeanUtils.copyProperties(student1, studentDto1);
            return studentDto1;
        }


        return null;
    }

    @Override
    public boolean deleteStudentDetails(Integer stdId) {
        Optional<Student> optional = studentRepository.findById(stdId);
        Student student = optional.get();
        if (student != null) {
            studentRepository.delete(student);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        studentList.stream().forEach(student -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }


}