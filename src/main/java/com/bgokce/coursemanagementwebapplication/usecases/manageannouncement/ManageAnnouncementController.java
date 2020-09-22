package com.bgokce.coursemanagementwebapplication.usecases.manageannouncement;

import com.bgokce.coursemanagementwebapplication.model.Announcement;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/announcement")
public class ManageAnnouncementController {

    private final ManageAnnouncementService manageAnnouncementService;

    @PostMapping("/create/{courseId}")
    public ResponseEntity<ServiceResponse> createAnnouncement(@RequestBody Announcement announcement, @PathVariable Long courseId) {
        ServiceResponse response = manageAnnouncementService.createAnnouncement(announcement, courseId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{announcementId}")
    public ResponseEntity<ServiceResponse> deleteAnnouncement(@PathVariable Long announcementId) {
        ServiceResponse response = manageAnnouncementService.deleteAnnouncement(announcementId);
        return ResponseEntity.ok().body(response);
    }
}
