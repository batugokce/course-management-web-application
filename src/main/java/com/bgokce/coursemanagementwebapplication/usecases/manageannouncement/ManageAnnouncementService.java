package com.bgokce.coursemanagementwebapplication.usecases.manageannouncement;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Announcement;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.repository.AnnouncementRepository;
import com.bgokce.coursemanagementwebapplication.usecases.managecourse.ManageCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageAnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final ManageCourseService manageCourseService;

    public ServiceResponse getAnnouncement(Long announcementId) {
        Announcement announcement = announcementRepository.findById(announcementId).orElse(null);

        if (announcement == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.RECORD_FOUND, announcement);
    }

    public ServiceResponse createAnnouncement(Announcement announcement, Long courseId) {
        ServiceResponse responseCourse = manageCourseService.getCourse(courseId);

        if (responseCourse.getType().equals(ResponseMessages.ERROR)) {
            return responseCourse;
        }

        announcement.setOwnerCourse((Course) responseCourse.getBody());
        announcementRepository.save(announcement);

        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ANNOUNCEMENT_CREATED_SUCCESSFULLY, announcement);
    }

    public ServiceResponse deleteAnnouncement(Long announcementId) {
        ServiceResponse response = this.getAnnouncement(announcementId);

        if (response.getType().equals(ResponseMessages.ERROR)) {
            return response;
        }

        announcementRepository.delete((Announcement) response.getBody());
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.RECORD_DELETED, null);
    }
}
