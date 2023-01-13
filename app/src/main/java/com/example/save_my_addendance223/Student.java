package com.example.save_my_addendance223;

/**
 * Author  : Mohit
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
