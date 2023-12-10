package com.f1soft.learning.studentmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SubjectDto {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private int student_id;

    public SubjectDto() {
    }

    public SubjectDto(String name, int student_id) {
        this.name = name;
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "SubjectDto{" +
                "name='" + name + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
