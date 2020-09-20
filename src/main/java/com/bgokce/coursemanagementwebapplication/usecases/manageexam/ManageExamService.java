package com.bgokce.coursemanagementwebapplication.usecases.manageexam;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.repository.CourseRepository;
import com.bgokce.coursemanagementwebapplication.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManageExamService {

    private final ExamRepository examRepository;
    private final CourseRepository courseRepository;

    public ServiceResponse createExam(Exam exam, Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }
        exam.setOwnerCourse(course);
        examRepository.save(exam);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.EXAM_CREATED_SUCCESSFULLY, null);
    }

    public ServiceResponse deleteExam(Long examId) {
        Exam exam = examRepository.findById(examId).orElse(null);

        if (exam == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }

        examRepository.delete(exam);
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.EXAM_DELETED_SUCCESSFULLY, null);
    }

}
