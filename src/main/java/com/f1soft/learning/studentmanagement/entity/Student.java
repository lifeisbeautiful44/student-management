package com.f1soft.learning.studentmanagement.entity;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String address;
    private List<Subject> subjects;

    public Student() {
    }

    public Student(int id, String name, String address, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
