package com.f1soft.learning.studentmanagement.service;

import com.f1soft.learning.studentmanagement.converter.StudentMapper;
import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.entity.Student;
import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import com.f1soft.learning.studentmanagement.platform.dbconnection.DataBaseConnection;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private Connection con = DataBaseConnection.getInstance().getConnection();

    public boolean findStudentById(int studentId) throws SQLException {

        String findStudentByID = "select * from student where STUDENT_ID = ?";
        PreparedStatement stmt = con.prepareStatement(findStudentByID);
        stmt.setInt(1, studentId);

        ResultSet resultSet = stmt.executeQuery();
        return resultSet.next();

    }



    public ApiResponse<String> saveStudent(StudentDto studentDto) throws SQLException {
        Student studentDetails = StudentMapper.mapStudentDtoToEntity(studentDto);

        String insertStudentDetails = "insert into student(NAME,ADDRESS) values(?,?)";

        PreparedStatement stmt = con.prepareStatement(insertStudentDetails);
            stmt.setString(1, studentDetails.getName());
            stmt.setString(2, studentDetails.getAddress());
            int rowsAffected = stmt.executeUpdate();
            return new ApiResponse<>(200, "success", "Student has been successfully saved");

    }

    public ApiResponse<List<String>> findStudentWithSubjects(int student_Id) throws SQLException {
        validate(student_Id);
        String findStudentWithSubjects = " select st.NAME as STUDENT_NAME,st.ADDRESS,sub.NAME as SUBJECT_NAME FROM student st " +
                                         "INNER JOIN subject sub ON st.STUDENT_ID = sub.STUDENT_ID " +
                                         "WHERE sub.STUDENT_ID = ?";
        PreparedStatement stmt =  con.prepareStatement(findStudentWithSubjects) ;
            stmt.setInt(1,student_Id);
            List<String> subjects = new ArrayList<>();
            ResultSet resultSet =   stmt.executeQuery();

            while (resultSet.next()) {
                subjects.add(resultSet.getString("SUBJECT_NAME"));
            }

            return new ApiResponse<>(200,"success",subjects);

    }

    private void validate(int studentId) throws SQLException {
        boolean studentExist = findStudentById(studentId);
        System.out.println(studentExist);
        if(!studentExist)
        {
            throw new StudentApiException(400,"No student With id has been found");
        }
    }
}