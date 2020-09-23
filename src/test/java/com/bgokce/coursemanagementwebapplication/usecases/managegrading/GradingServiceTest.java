package com.bgokce.coursemanagementwebapplication.usecases.managegrading;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.DTO.GradeDTO;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Grade;
import com.bgokce.coursemanagementwebapplication.repository.EnrollmentRepository;
import com.bgokce.coursemanagementwebapplication.repository.ExamRepository;
import com.bgokce.coursemanagementwebapplication.repository.GradeRepository;
import com.bgokce.coursemanagementwebapplication.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GradingServiceTest {

    @Mock
    GradeRepository gradeRepository;
    @Mock
    ExamRepository examRepository;
    @Mock
    StudentRepository studentRepository;
    @Mock
    EnrollmentRepository enrollmentRepository;
    @InjectMocks
    GradingService gradingService;

    Grade grade;
    GradeDTO gradeDTO;
    Exam exam;
    Course course;
    Student student;

    @BeforeEach
    void setUp() {
        grade = CommonFunctions.createGrade(1L, 100);
        gradeDTO = CommonFunctions.createGradeDTO(1L,100);
        exam = CommonFunctions.createExam();
        course = CommonFunctions.createCourse();
        exam.setOwnerCourse(course);
        student = CommonFunctions.createStudent();
    }

    @Test
    void addGradesAsListEmptyListTest() {
        ServiceResponse response = gradingService.addGradesAsList(new ArrayList<>(), 1L);

        assertEquals(ResponseMessages.WARNING, response.getType());
        assertEquals(ResponseMessages.GRADE_LIST_IS_NULL, response.getMessage());
    }

    @Test
    void addGradesAsListNullExamTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = gradingService.addGradesAsList(List.of(gradeDTO), 1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void addGradesAsListNotMatchingTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.of(exam));
        when(enrollmentRepository.countStudentsEnroller(anyLong(),anyList())).thenReturn(0);

        ServiceResponse response = gradingService.addGradesAsList(List.of(gradeDTO), 1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.STUDENT_NOT_ENROLLED_THE_COURSE, response.getMessage());
    }

    @Test
    void addGradesAsListEmptyStudentListTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.of(exam));
        when(enrollmentRepository.countStudentsEnroller(anyLong(),anyList())).thenReturn(1);
        when(studentRepository.findAllById(anyList())).thenReturn(new ArrayList<>());
        ServiceResponse response = gradingService.addGradesAsList(List.of(gradeDTO), 1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.SOME_STUDENT_RECORDS_NOT_FOUND, response.getMessage());
    }

    @Test
    void addGradesAsListSuccessTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.of(exam));
        when(enrollmentRepository.countStudentsEnroller(anyLong(),anyList())).thenReturn(1);
        when(studentRepository.findAllById(anyList())).thenReturn(List.of(student));

        ServiceResponse response = gradingService.addGradesAsList(List.of(gradeDTO), 1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.GRADES_ADDED_SUCCESSFULY, response.getMessage());
    }

    @Test
    void getPointsEmptyListTest() {
        when(gradeRepository.getGradesByExamId(anyLong())).thenReturn(new ArrayList<>());

        ServiceResponse response = gradingService.getPoints(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void getPointsSuccessTest() {
        when(gradeRepository.getGradesByExamId(anyLong())).thenReturn(List.of(grade));

        ServiceResponse response = gradingService.getPoints(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.RECORD_FOUND, response.getMessage());
    }
}