package com.bgokce.coursemanagementwebapplication.usecases.managegrading;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.DTO.GradeDTO;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Grade;
import com.bgokce.coursemanagementwebapplication.repository.EnrollmentRepository;
import com.bgokce.coursemanagementwebapplication.repository.ExamRepository;
import com.bgokce.coursemanagementwebapplication.repository.GradeRepository;
import com.bgokce.coursemanagementwebapplication.repository.StudentRepository;
import com.bgokce.coursemanagementwebapplication.usecases.manageexam.ManageExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class GradingService {

    private final GradeRepository gradeRepository;
    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    public ServiceResponse addGradesAsList(List<GradeDTO> gradeDTOList, Long examId) {
        ServiceResponse response = checkParameters(gradeDTOList, examId);
        if (response.getType().equals(ResponseMessages.WARNING) || response.getType().equals(ResponseMessages.ERROR)) {
            return response;
        }
        Exam exam = (Exam) response.getBody();

        ServiceResponse responseWithinStudentMap =  checkStudentListFromDatabase(gradeDTOList,exam);
        if (responseWithinStudentMap.getType().equals(ResponseMessages.ERROR)) {
            return responseWithinStudentMap;
        }

        Map<Long, Student> map = (Map<Long, Student>) responseWithinStudentMap.getBody();

        List<Grade> grades = gradeDTOList
                .stream()
                .map(item -> new Grade(examId,item.getStudentId(),exam,map.get(item.getStudentId()),item.getPoint()))
                .collect(Collectors.toList());

        gradeRepository.saveAll(grades);

        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.GRADES_ADDED_SUCCESSFULY, null);
    }

    public ServiceResponse checkParameters(List<GradeDTO> gradeDTOList, Long examId) {
        if (gradeDTOList.size() == 0) {
            return new ServiceResponse(ResponseMessages.WARNING, ResponseMessages.GRADE_LIST_IS_NULL, null);
        }

        Exam exam = examRepository.findById(examId).orElse(null);

        if (exam == null) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }
        return new ServiceResponse(ResponseMessages.SUCCESS,null,exam);
    }

    public ServiceResponse checkStudentListFromDatabase(List<GradeDTO> gradeDTOList, Exam exam) {
        List<Long> ids = gradeDTOList.stream().map(GradeDTO::getStudentId).collect(Collectors.toList());
        Integer numberCheck = enrollmentRepository.countStudentsEnroller(exam.getOwnerCourse().getId(),ids);

        if (numberCheck != ids.size()){
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.STUDENT_NOT_ENROLLED_THE_COURSE, null);
        }

        List<Student> studentList = studentRepository.findAllById(ids);

        if (studentList.isEmpty() || studentList.size() != gradeDTOList.size()) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.SOME_STUDENT_RECORDS_NOT_FOUND, null);
        }
        Map<Long, Student> map =  prepareStudentMap(studentList);
        return new ServiceResponse(ResponseMessages.SUCCESS, null, map);
    }

    public Map<Long, Student> prepareStudentMap(List<Student> studentList) {
        Map<Long , Student> map = new HashMap<>();
        studentList.forEach(item -> map.put(item.getId(),item));
        return map;
    }

    public ServiceResponse getPoints(Long examId) {
        List<Grade> grades = gradeRepository.getGradesByExamId(examId);
        if (grades.isEmpty()) {
            return new ServiceResponse(ResponseMessages.ERROR, ResponseMessages.RECORD_NOT_FOUND, null);
        }
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.RECORD_FOUND, grades);
    }
}
