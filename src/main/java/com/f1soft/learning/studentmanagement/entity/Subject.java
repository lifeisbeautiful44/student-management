package com.f1soft.learning.studentmanagement.entity;

public class Subject {
    private int id;
    private String name;

    private int student_id;

    public Subject() {
    }

    public Subject(int id, String name, int student_id) {
        this.id = id;
        this.name = name;
        this.student_id = student_id;
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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
