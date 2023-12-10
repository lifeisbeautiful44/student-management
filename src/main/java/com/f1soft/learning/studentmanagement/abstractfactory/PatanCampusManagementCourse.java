package com.f1soft.learning.studentmanagement.abstractfactory;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatanCampusManagementCourse implements Course{
    @Override
    public List<String> courseList() {
        return Arrays.asList("Business Studies","Micro Economics","Fundamental of Financial Management");
    }
}
