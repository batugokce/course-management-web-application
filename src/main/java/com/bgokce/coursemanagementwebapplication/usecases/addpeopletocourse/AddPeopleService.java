package com.bgokce.coursemanagementwebapplication.usecases.addpeopletocourse;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPeopleService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final TeachRepository teachRepository;
    private final SupportRepository supportRepository;

    public ServiceResponse enrollCourse(Long courseId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null || student == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }

        Enrollment enrollment = new Enrollment(courseId,studentId,course,student);
        enrollmentRepository.save(enrollment);

        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ENROLLMENT_IS_SUCCESSFUL, student);
    }

}
