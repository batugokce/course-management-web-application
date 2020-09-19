package com.bgokce.coursemanagementwebapplication.usecases.enrollcourse;

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
public class EnrollCourseController {

    private final EnrollCourseService enrollCourseService;

    @PostMapping("/enroll/{courseId}/{studentId}")
    public ResponseEntity<ServiceResponse> enrollCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return ResponseEntity.ok().body(enrollCourseService.enrollCourse(courseId,studentId));
    }
}
