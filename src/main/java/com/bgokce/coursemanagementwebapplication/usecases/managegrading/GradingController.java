package com.bgokce.coursemanagementwebapplication.usecases.managegrading;

import com.bgokce.coursemanagementwebapplication.model.DTO.GradeDTO;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grade")
@RequiredArgsConstructor
public class GradingController {

    private final GradingService gradingService;

    @PostMapping("/add/{examId}")
    public ResponseEntity<ServiceResponse> addGradesAsList(@RequestBody List<GradeDTO> grades, @PathVariable Long examId) {
        ServiceResponse response = gradingService.addGradesAsList(grades, examId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get/{examId}")
    public ResponseEntity<ServiceResponse> getGrades(@PathVariable Long examId) {
        ServiceResponse response = gradingService.getPoints(examId);
        return ResponseEntity.ok().body(response);
    }
}
