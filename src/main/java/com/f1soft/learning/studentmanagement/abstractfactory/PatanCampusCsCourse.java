package com.f1soft.learning.studentmanagement.abstractfactory;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatanCampusCsCourse implements Course{
    @Override
    public List<String> courseList() {
        return Arrays.asList("Software Developer","Network Administrator","Database Administrator");
    }
}
