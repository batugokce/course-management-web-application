package com.bgokce.coursemanagementwebapplication.usecases.manageexam;

import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exam")
public class ManageExamController {

    private final ManageExamService manageExamService;

    @PostMapping("/create/{courseId}")
    public ResponseEntity<ServiceResponse> createExam(@RequestBody Exam exam, @PathVariable Long courseId) {
        ServiceResponse response = manageExamService.createExam(exam, courseId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{examId}")
    public ResponseEntity<ServiceResponse> createExam(@PathVariable Long examId) {
        ServiceResponse response = manageExamService.deleteExam(examId);
        return ResponseEntity.ok().body(response);
    }
}
