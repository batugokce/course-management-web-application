package com.bgokce.coursemanagementwebapplication;

import com.bgokce.coursemanagementwebapplication.model.*;
import com.bgokce.coursemanagementwebapplication.model.DTO.GradeDTO;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Grade;

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

    public static Announcement createAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setTitle("test başlığı");
        announcement.setText("test içeriği");
        announcement.setCreated(LocalDateTime.now());
        announcement.setId(1L);
        return announcement;
    }

    public static Grade createGrade(Long studentId, Integer point) {
        Grade grade = new Grade();
        grade.setPoint(point);
        grade.setStudentId(studentId);
        return grade;
    }

    public static GradeDTO createGradeDTO(Long studentId, Integer point) {
        return new GradeDTO(studentId, point);
    }
}
