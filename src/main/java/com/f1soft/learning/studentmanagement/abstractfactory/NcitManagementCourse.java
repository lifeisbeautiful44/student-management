package com.f1soft.learning.studentmanagement.abstractfactory;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NcitManagementCourse implements Course {
    @Override
    public List<String> courseList() {
        return Arrays.asList("Business Environment Strategy","Fundamentals of Marketing","Entrepreneurship and Enterprise Development");
    }
}
