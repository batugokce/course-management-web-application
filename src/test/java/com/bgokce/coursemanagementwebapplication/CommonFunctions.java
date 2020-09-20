package com.bgokce.coursemanagementwebapplication;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Student;

public class CommonFunctions {

    public static Course createCourse(){
        Course course = new Course();
        course.setCourseCode("ceng331");
        course.setCourseName("logic design");
        course.setSemesterNo("20201");
        course.setType("must");
        course.setId(1L);
        return course;
    }

    public static Student createStudent(){
        Student student = new Student();
        student.setUsername("username");
        student.setPassword("password");
        student.setNameSurname("name surname");
        student.setId(1L);
        return student;
    }
}
