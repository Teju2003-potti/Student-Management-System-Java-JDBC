package com.sms;

public class Student {

    private int id;
    private String name;
    private String email;
    private String course;
    private int marks;

    // Constructor WITHOUT id (used when adding student)
    public Student(String name, String email, String course, int marks) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    // Constructor WITH id (used when reading from database)
    public Student(int id, String name, String email, String course, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public int getMarks() {
        return marks;
    }
}
