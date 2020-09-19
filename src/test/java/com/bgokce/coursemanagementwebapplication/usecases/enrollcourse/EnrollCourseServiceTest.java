package com.bgokce.coursemanagementwebapplication.usecases.enrollcourse;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.repository.CourseRepository;
import com.bgokce.coursemanagementwebapplication.repository.StudentRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnrollCourseServiceTest {

    @Mock
    StudentRepository studentRepository;
    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    EnrollCourseService enrollCourseService;

    @Captor
    ArgumentCaptor<Student> studentArgumentCaptor;

    @Test
    void enrollCourseTest() {
        Course course = CommonFunctions.createCourse();
        Student student = CommonFunctions.createStudent();

        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        when(studentRepository.save(studentArgumentCaptor.capture())).thenReturn(student);

        ServiceResponse response = enrollCourseService.enrollCourse(1L,1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.ENROLLMENT_IS_SUCCESSFUL, response.getMessage());
        assertEquals(1,studentArgumentCaptor.getValue().getCoursesTaken().size());
    }

    @Test
    void enrollCourseFailTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = enrollCourseService.enrollCourse(1L,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }
}