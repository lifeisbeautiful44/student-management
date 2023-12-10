package com.f1soft.learning.studentmanagement.service;

import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;

import java.sql.SQLException;
import java.util.List;


public interface StudentService {

    boolean findStudentById(int studentId) throws SQLException;
    ApiResponse<String> saveStudent(StudentDto studentDto) throws SQLException;
    ApiResponse<List<String>> findStudentWithSubjects(int student_Id) throws SQLException;
}
