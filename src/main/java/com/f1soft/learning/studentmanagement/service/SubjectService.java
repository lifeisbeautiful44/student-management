package com.f1soft.learning.studentmanagement.service;

import com.f1soft.learning.studentmanagement.dto.SubjectDto;
import com.f1soft.learning.studentmanagement.platform.response.ApiResponse;

import java.sql.SQLException;

public interface SubjectService {

    ApiResponse<String> saveSubject(SubjectDto subjectDto) throws SQLException;


}
