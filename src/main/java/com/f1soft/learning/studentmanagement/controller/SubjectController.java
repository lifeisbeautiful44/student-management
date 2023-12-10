package com.f1soft.learning.studentmanagement.controller;


import com.f1soft.learning.studentmanagement.dto.SubjectDto;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import com.f1soft.learning.studentmanagement.service.StudentService;
import com.f1soft.learning.studentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectSerivce;
    @PostMapping
    public ResponseEntity<ApiResponse<String>> saveSubject(@RequestBody  SubjectDto subjectDto) throws SQLException {

       ApiResponse apiResponse =  subjectSerivce.saveSubject(subjectDto);
       return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
