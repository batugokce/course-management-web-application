package com.bgokce.coursemanagementwebapplication.usecases.addpeopletocourse;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.*;
import com.bgokce.coursemanagementwebapplication.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class AddPeopleServiceTest {

    @Mock
    StudentRepository studentRepository;
    @Mock
    CourseRepository courseRepository;
    @Mock
    InstructorRepository instructorRepository;
    @Mock
    AssistantRepository assistantRepository;
    @Mock
    EnrollmentRepository enrollmentRepository;
    @Mock
    TeachRepository teachRepository;
    @Mock
    SupportRepository supportRepository;
    @InjectMocks
    AddPeopleService addPeopleService;

    @Test
    void enrollCourseTest() {
        Course course = CommonFunctions.createCourse();
        Student student = CommonFunctions.createStudent();

        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        when(enrollmentRepository.existsById(any())).thenReturn(false);
        ServiceResponse response = addPeopleService.enrollCourse(1L,1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.ENROLLMENT_IS_SUCCESSFUL, response.getMessage());
    }

    @Test
    void enrollCourseNullTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = addPeopleService.enrollCourse(1L,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void enrollCourseAlreadyExistsTest() {
        Course course = CommonFunctions.createCourse();
        Student student = CommonFunctions.createStudent();

        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        when(enrollmentRepository.existsById(any())).thenReturn(true);

        ServiceResponse response = addPeopleService.enrollCourse(1L,1L);

        assertEquals(ResponseMessages.WARNING, response.getType());
        assertEquals(ResponseMessages.ENROLLMENT_EXISTS_ALREADY, response.getMessage());
    }

    @Test
    void addInstructorTest() {
        Course course = CommonFunctions.createCourse();
        Instructor instructor = CommonFunctions.createInstructor();
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(instructor));
        when(teachRepository.existsById(any())).thenReturn(false);

        ServiceResponse response = addPeopleService.addInstructorToCourse(1L,1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.INSTRUCTOR_ADDED_SUCCESSULLY, response.getMessage());
    }

    @Test
    void addInstructorNullTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = addPeopleService.addInstructorToCourse(1L,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void addInstructorAlreadyExistsTest() {
        Course course = CommonFunctions.createCourse();
        Instructor instructor = CommonFunctions.createInstructor();

        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(instructor));
        when(teachRepository.existsById(any())).thenReturn(true);

        ServiceResponse response = addPeopleService.addInstructorToCourse(1L,1L);

        assertEquals(ResponseMessages.WARNING, response.getType());
        assertEquals(ResponseMessages.INSTRUCTOR_EXISTS_ALREADY, response.getMessage());
    }

    @Test
    void addAssistantTest() {
        Course course = CommonFunctions.createCourse();
        Assistant assistant = CommonFunctions.createAssistant();
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(assistantRepository.findById(anyLong())).thenReturn(Optional.of(assistant));
        when(supportRepository.existsById(any())).thenReturn(false);

        ServiceResponse response = addPeopleService.addAssistantToCourse(1L,1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.ASSISTANT_ADDED_SUCCESSULLY, response.getMessage());
    }

    @Test
    void addAssistantNullTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(assistantRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = addPeopleService.addAssistantToCourse(1L,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void addAssistantAlreadyExistsTest() {
        Course course = CommonFunctions.createCourse();
        Assistant assistant = CommonFunctions.createAssistant();

        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(assistantRepository.findById(anyLong())).thenReturn(Optional.of(assistant));
        when(supportRepository.existsById(any())).thenReturn(true);

        ServiceResponse response = addPeopleService.addAssistantToCourse(1L,1L);

        assertEquals(ResponseMessages.WARNING, response.getType());
        assertEquals(ResponseMessages.ASSISTANT_EXISTS_ALREADY, response.getMessage());
    }
}