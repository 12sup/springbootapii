package com.te.java.springboot.backend.controller;


import com.te.java.springboot.backend.dto.StudentDto;
import com.te.java.springboot.backend.responce.GeneralResponce;
import com.te.java.springboot.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/saveEmployee")
    public ResponseEntity<GeneralResponce> saveStudentData(@RequestBody StudentDto studentDto) {
        StudentDto dto = studentService.saveStudentDetais(studentDto);
        return ResponseEntity.ok().body(new GeneralResponce(HttpStatus.OK, "data save", "null", dto));
    }

    @GetMapping(path = "/getEmployee/{studentId}")
    public ResponseEntity<GeneralResponce> getStudentDetails(@PathVariable("studentId") Integer stdId) {
        StudentDto dto = studentService.getStudentDetails(stdId);
        if (dto != null) {
            return ResponseEntity.ok().body(new GeneralResponce(HttpStatus.OK, "data found", null, dto));
        }

        return ResponseEntity.badRequest().body(new GeneralResponce(HttpStatus.OK, "data not found", null, null));
    }

    @PutMapping(path = "/updateStudent/{stdId}")
    public ResponseEntity<GeneralResponce> updateStudentsDetails(@PathVariable("stdId") Integer stdId, @RequestBody StudentDto studentDto) {
        StudentDto updateStudent = studentService.updateStudentDetails(stdId, studentDto);
        return ResponseEntity.ok().body(new GeneralResponce(HttpStatus.OK, "data updated", null, updateStudent));
    }

    @DeleteMapping(path = "deleteEmployee/{studentId}")
    public ResponseEntity<GeneralResponce> deleteStudentDetails(@PathVariable("studentId") Integer stdId) {
        boolean deletePerson = studentService.deleteStudentDetails(stdId);
        if (deletePerson) {
            return ResponseEntity.ok().body(new GeneralResponce(HttpStatus.OK, "data deleted", "null", "deletePerson"));
        }
        return ResponseEntity.badRequest().body(new GeneralResponce(HttpStatus.OK, "null", "data not deleted", null));
    }

    @GetMapping("/findAll")
    public ResponseEntity<GeneralResponce> findAllEmployee() {
        List<StudentDto> studentsList = studentService.findAllStudent();
        if (studentsList != null) {
            return ResponseEntity.ok().body(new GeneralResponce(HttpStatus.OK, "get all employee", null, studentsList));
        }
        return ResponseEntity.badRequest().body(new GeneralResponce(HttpStatus.BAD_REQUEST, "null", "data not found", null));
    }


}


