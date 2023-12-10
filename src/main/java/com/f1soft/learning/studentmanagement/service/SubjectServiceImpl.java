package com.f1soft.learning.studentmanagement.service;


import com.f1soft.learning.studentmanagement.converter.SubjectMapper;
import com.f1soft.learning.studentmanagement.dto.SubjectDto;
import com.f1soft.learning.studentmanagement.entity.Subject;
import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import com.f1soft.learning.studentmanagement.platform.dbconnection.DataBaseConnection;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class SubjectServiceImpl implements SubjectService {

    private Connection con = DataBaseConnection.getInstance().getConnection();
    @Autowired
    private StudentService studentService;


    public ApiResponse<String> saveSubject(SubjectDto subjectDto) throws SQLException {
        validate(subjectDto);
        Subject subject = SubjectMapper.mapSubjectDtoToEntity(subjectDto);

        String saveSubjectSQL = "INSERT INTO subject (NAME, STUDENT_ID) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(saveSubjectSQL) ;
            stmt.setString(1, subject.getName());
            stmt.setInt(2, subject.getStudent_id());
           int rowsAffected =  stmt.executeUpdate();
           String message = subjectDto.getName().toUpperCase() + " has been successfully saved.";

           return new ApiResponse(200,"success",message);

    }

    private void validate(SubjectDto subjectDto) throws SQLException {
      boolean studentExist =   studentService.findStudentById(subjectDto.getStudent_id());
        System.out.println(studentExist);
      if(!studentExist)
      {
        throw new StudentApiException(400,"No student With id has been found");
      }
    }
}
