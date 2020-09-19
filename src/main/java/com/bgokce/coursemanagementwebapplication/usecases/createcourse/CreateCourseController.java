package com.bgokce.coursemanagementwebapplication.usecases.createcourse;

import com.bgokce.coursemanagementwebapplication.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CreateCourseController {

    private final CreateCourseService createCourseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return createCourseService.createCourse(course);
    }
}
