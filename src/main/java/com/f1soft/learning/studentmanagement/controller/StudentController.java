package com.f1soft.learning.studentmanagement.controller;


import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.dto.SubjectDto;
import com.f1soft.learning.studentmanagement.entity.Subject;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import com.f1soft.learning.studentmanagement.service.StudentService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

   @PostMapping
    public ResponseEntity<ApiResponse<String>> saveStudent(@RequestBody  StudentDto studentDto) throws SQLException {
        System.out.println("entered");
        ApiResponse<String> apiResponse =   studentService.saveStudent(studentDto);
      return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<List<String>>> findStudentWithSubject(@PathVariable("id")int studentId) throws SQLException {
        ApiResponse<List<String>> apiResponse =  studentService.findStudentWithSubjects(studentId);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


}
