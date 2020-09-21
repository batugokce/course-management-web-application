package com.bgokce.coursemanagementwebapplication.usecases.addpeopletocourse;

import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AddPeopleController {

    private final AddPeopleService addPeopleService;

    @PostMapping("/enroll/{courseId}/{studentId}")
    public ResponseEntity<ServiceResponse> enrollCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return ResponseEntity.ok().body(addPeopleService.enrollCourse(courseId,studentId));
    }

    @PostMapping("/teach/{courseId}/{instructorId}")
    public ResponseEntity<ServiceResponse> addInstructorToCourse(@PathVariable Long courseId, @PathVariable Long instructorId) {
        ServiceResponse response = addPeopleService.addInstructorToCourse(courseId, instructorId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/support/{courseId}/{assistantId}")
    public ResponseEntity<ServiceResponse> addAssistantToCourse(@PathVariable Long courseId, @PathVariable Long assistantId) {
        ServiceResponse response = addPeopleService.addAssistantToCourse(courseId, assistantId);
        return ResponseEntity.ok().body(response);
    }
}
