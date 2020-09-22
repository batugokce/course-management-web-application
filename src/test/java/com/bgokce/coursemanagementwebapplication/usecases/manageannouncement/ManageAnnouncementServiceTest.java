package com.bgokce.coursemanagementwebapplication.usecases.manageannouncement;

import com.bgokce.coursemanagementwebapplication.CommonFunctions;
import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Announcement;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.repository.AnnouncementRepository;
import com.bgokce.coursemanagementwebapplication.usecases.managecourse.ManageCourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManageAnnouncementServiceTest {

    @Mock
    AnnouncementRepository announcementRepository;
    @Mock
    ManageCourseService manageCourseService;
    @InjectMocks
    ManageAnnouncementService manageAnnouncementService;

    Announcement announcement;

    @BeforeEach
    void setUp() {
        announcement = CommonFunctions.createAnnouncement();
    }

    @Test
    void getAnnouncementSuccessTest() {
        when(announcementRepository.findById(anyLong())).thenReturn(Optional.of(announcement));

        ServiceResponse response = manageAnnouncementService.getAnnouncement(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.RECORD_FOUND, response.getMessage());
    }

    @Test
    void getAnnouncementNullTest() {
        when(announcementRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = manageAnnouncementService.getAnnouncement(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void createAnnouncementSuccessTest() {
        Course course = CommonFunctions.createCourse();
        when(manageCourseService.getCourse(any())).thenReturn(new ServiceResponse(
                ResponseMessages.SUCCESS,
                ResponseMessages.RECORD_FOUND,
                course
        ));

        ServiceResponse response = manageAnnouncementService.createAnnouncement(announcement,1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.ANNOUNCEMENT_CREATED_SUCCESSFULLY, response.getMessage());
    }

    @Test
    void createAnnouncementNullTest() {
        when(manageCourseService.getCourse(any())).thenReturn(new ServiceResponse(
                ResponseMessages.ERROR,
                ResponseMessages.RECORD_NOT_FOUND,
                null
        ));

        ServiceResponse response = manageAnnouncementService.createAnnouncement(announcement,1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }

    @Test
    void deleteAnnouncementSuccessTest() {
        when(announcementRepository.findById(anyLong())).thenReturn(Optional.of(announcement));

        ServiceResponse response = manageAnnouncementService.deleteAnnouncement(1L);

        assertEquals(ResponseMessages.SUCCESS, response.getType());
        assertEquals(ResponseMessages.RECORD_DELETED, response.getMessage());
    }

    @Test
    void deleteAnnouncementNullTest() {
        when(announcementRepository.findById(anyLong())).thenReturn(Optional.empty());

        ServiceResponse response = manageAnnouncementService.deleteAnnouncement(1L);

        assertEquals(ResponseMessages.ERROR, response.getType());
        assertEquals(ResponseMessages.RECORD_NOT_FOUND, response.getMessage());
    }
}