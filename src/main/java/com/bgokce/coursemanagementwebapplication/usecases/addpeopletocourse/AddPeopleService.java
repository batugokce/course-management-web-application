package com.bgokce.coursemanagementwebapplication.usecases.addpeopletocourse;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.*;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.*;
import com.bgokce.coursemanagementwebapplication.repository.*;
import liquibase.pro.packaged.S;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPeopleService {

    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final AssistantRepository assistantRepository;
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

        boolean isEnrolledBefore = enrollmentRepository.existsById(new EnrollmentPK(courseId,studentId));
        if (isEnrolledBefore) {
            return new ServiceResponse(ResponseMessages.WARNING, ResponseMessages.ENROLLMENT_EXISTS_ALREADY, null);
        }

        Enrollment enrollment = new Enrollment(courseId,studentId,course,student);
        enrollmentRepository.save(enrollment);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ENROLLMENT_IS_SUCCESSFUL, student);
    }

    public ServiceResponse addInstructorToCourse(Long courseId, Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null || instructor == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }

        boolean isAddedBefore = teachRepository.existsById(new TeachPK(courseId,instructorId));
        if (isAddedBefore) {
            return new ServiceResponse(ResponseMessages.WARNING, ResponseMessages.INSTRUCTOR_EXISTS_ALREADY, null);
        }

        Teach teach = new Teach(courseId, instructorId, course, instructor);
        teachRepository.save(teach);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.INSTRUCTOR_ADDED_SUCCESSULLY, instructor);
    }

    public ServiceResponse addAssistantToCourse(Long courseId, Long assistantId) {
        Assistant assistant = assistantRepository.findById(assistantId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null || assistant == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }

        boolean isAddedBefore = supportRepository.existsById(new SupportPK(courseId,assistantId));
        if (isAddedBefore) {
            return new ServiceResponse(ResponseMessages.WARNING, ResponseMessages.ASSISTANT_EXISTS_ALREADY, null);
        }

        Support support = new Support(courseId, assistantId, course, assistant);
        supportRepository.save(support);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ASSISTANT_ADDED_SUCCESSULLY, assistant);
    }
}
