package com.f1soft.learning.studentmanagement.converter;

import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.entity.Student;

public class StudentMapper {

    public static Student mapStudentDtoToEntity(StudentDto studentDto)
    {
        Student student = new Student();

        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());

        return student;
    }
}
