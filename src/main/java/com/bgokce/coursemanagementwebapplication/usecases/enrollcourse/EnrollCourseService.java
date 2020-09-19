package com.bgokce.coursemanagementwebapplication.usecases.enrollcourse;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.repository.CourseRepository;
import com.bgokce.coursemanagementwebapplication.repository.StudentRepository;
import liquibase.pro.packaged.N;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollCourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public ServiceResponse enrollCourse(Long courseId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null || student == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }

        Enrollment enrollment = new Enrollment(courseId,studentId,course,student);
        student.getCoursesTaken().add(enrollment);
        Student returnedStudent = studentRepository.save(student);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ENROLLMENT_IS_SUCCESSFUL, returnedStudent);
    }

}
