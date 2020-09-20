package com.bgokce.coursemanagementwebapplication.usecases.manageenrollment;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public void createEnrollment(Course course, Student student) {
        Enrollment enrollment = new Enrollment(course.getId(),student.getId(),course,student);

        enrollmentRepository.save(enrollment);
    }

}
