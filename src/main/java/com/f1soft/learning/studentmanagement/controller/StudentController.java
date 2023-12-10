package com.f1soft.learning.studentmanagement.controller;


import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import com.f1soft.learning.studentmanagement.platform.response.RestClient;
import com.f1soft.learning.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RestClient restClient;

   @PostMapping
    public ResponseEntity<ApiResponse<String>> saveStudent(@RequestBody  StudentDto studentDto) throws SQLException, URISyntaxException, IOException, InterruptedException {

       restClient.callRestClient(studentDto);
       ApiResponse<String> apiResponse =   studentService.saveStudent(studentDto);
      return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<List<String>>> findStudentWithSubject(@PathVariable("id")int studentId) throws SQLException {
        ApiResponse<List<String>> apiResponse =  studentService.findStudentWithSubjects(studentId);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }





}
