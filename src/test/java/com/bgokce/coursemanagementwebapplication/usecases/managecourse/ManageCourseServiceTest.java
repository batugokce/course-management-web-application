package com.bgokce.coursemanagementwebapplication.usecases.managecourse;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.repository.CourseRepository;
import com.bgokce.coursemanagementwebapplication.usecases.manageannouncement.ManageAnnouncementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManageCourseServiceTest {

    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    ManageCourseService manageCourseService;

    Course course;

    @BeforeEach
    void setUp() {
        course = CommonFunctions.createCourse();
    }

    @Test
    void createCourse() {
        manageCourseService.createCourse(course);

        verify(courseRepository).save(course);
    }

    @Test
    void getCourseSuccessTest() {
        when(courseRepository.getCourseWithExams(anyLong())).thenReturn(course);

        ServiceResponse response = manageCourseService.getCourse(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.RECORD_FOUND, response.getMessage());
    }

    @Test
    void getCourseNullTest() {
        when(courseRepository.getCourseWithExams(anyLong())).thenReturn(null);

        ServiceResponse response = manageCourseService.getCourse(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void deleteCourseSuccessTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));

        ServiceResponse response = manageCourseService.deleteCourse(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.RECORD_DELETED, response.getMessage());
        verify(courseRepository).delete(course);
    }

    @Test
    void deleteCourseNullTest() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = manageCourseService.deleteCourse(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }
}