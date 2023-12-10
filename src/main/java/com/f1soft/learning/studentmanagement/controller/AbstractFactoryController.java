package com.f1soft.learning.studentmanagement.controller;


import com.f1soft.learning.studentmanagement.abstractfactory.Course;
import com.f1soft.learning.studentmanagement.abstractfactory.UniversityFactory;
import com.f1soft.learning.studentmanagement.dto.UniversityFactoryDto;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
public class AbstractFactoryController {


    @GetMapping("/courses")
    public ResponseEntity<ApiResponse<List<String>>> getListOfCourse(@RequestBody UniversityFactoryDto factoryDto)
    {
      UniversityFactory universityFactory = UniversityFactory.getUniversityFactory(factoryDto.getScore());
      Course course =  universityFactory.getCourses(factoryDto.getStream());
      List<String> courseList = course.courseList();

      return new ResponseEntity<>(new ApiResponse<>(200,"success",courseList), HttpStatus.OK);
    }

}
