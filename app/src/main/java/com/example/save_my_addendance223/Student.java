package com.example.save_my_addendance223;

/**
 * Author  : Mohit
 * Date    : 1:30 PM
 **/

public class Student {
    int id;
    String name;
    String rollNumber;
    int attendancePercent;
    String gender;

    public Student(String name, String rollNumber, int attendancePercent, String gender) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.attendancePercent = attendancePercent;
        this.gender = gender;
    }

    public Student(int id, String name, String rollNumber, int attendancePercent, String gender) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.attendancePercent = attendancePercent;
        this.gender = gender;
    }

    public Student() {
    }
}
