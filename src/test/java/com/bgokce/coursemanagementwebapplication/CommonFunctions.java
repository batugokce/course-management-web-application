package com.bgokce.coursemanagementwebapplication;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.Student;

import java.time.LocalDateTime;

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

    public static Exam createExam() {
        Exam exam = new Exam();
        exam.setLocation("bmb1, bmb2");
        exam.setStartDate(LocalDateTime.now().plusDays(3));
        exam.setType("final");
        return exam;
    }
}
