package com.bgokce.coursemanagementwebapplication.usecases.managecourse;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class ManageCourseController {

    private final ManageCourseService manageCourseService;

    @GetMapping("/get/{courseId}")
    public ResponseEntity<ServiceResponse> getCourse(@PathVariable Long courseId) {
        ServiceResponse response = manageCourseService.getCourse(courseId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course) {
        return manageCourseService.createCourse(course);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<ServiceResponse> deleteCourse(@PathVariable Long courseId) {
        ServiceResponse response = manageCourseService.deleteCourse(courseId);
        return ResponseEntity.ok().body(response);
    }
}
