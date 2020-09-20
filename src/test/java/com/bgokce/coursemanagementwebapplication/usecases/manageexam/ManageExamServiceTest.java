package com.bgokce.coursemanagementwebapplication.usecases.manageexam;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.repository.CourseRepository;
import com.bgokce.coursemanagementwebapplication.repository.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManageExamServiceTest {

    @Mock
    ExamRepository examRepository;
    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    ManageExamService manageExamService;

    @Captor
    ArgumentCaptor<Exam> examArgumentCaptor;

    Exam exam;

    @BeforeEach
    void setUp() {
        exam = CommonFunctions.createExam();
    }

    @Test
    void createExamSuccessTest() {
        Course course = CommonFunctions.createCourse();
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));

        ServiceResponse response = manageExamService.createExam(exam,1L);

        verify(examRepository).save(examArgumentCaptor.capture());
        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.EXAM_CREATED_SUCCESSFULLY, response.getMessage());
        assertEquals(course,examArgumentCaptor.getValue().getOwnerCourse());
    }

    @Test
    void createExamNullTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = manageExamService.createExam(exam,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void deleteExamSuccessTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.of(exam));

        ServiceResponse response = manageExamService.deleteExam(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        verify(examRepository).delete(any());
    }

    @Test
    void deleteExamNullTest() {
        when(examRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = manageExamService.deleteExam(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
    }
}