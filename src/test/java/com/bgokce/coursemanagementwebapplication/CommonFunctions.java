package com.bgokce.coursemanagementwebapplication;

import com.bgokce.coursemanagementwebapplication.model.*;

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

    public static Instructor createInstructor(){
        Instructor instructor = new Instructor();
        instructor.setUsername("username");
        instructor.setPassword("password");
        instructor.setNameSurname("name surname");
        instructor.setId(1L);
        return instructor;
    }

    public static Assistant createAssistant(){
        Assistant assistant = new Assistant();
        assistant.setUsername("username");
        assistant.setPassword("password");
        assistant.setNameSurname("name surname");
        assistant.setId(1L);
        return assistant;
    }

    public static Exam createExam() {
        Exam exam = new Exam();
        exam.setLocation("bmb1, bmb2");
        exam.setStartDate(LocalDateTime.now().plusDays(3));
        exam.setType("final");
        return exam;
    }
}
