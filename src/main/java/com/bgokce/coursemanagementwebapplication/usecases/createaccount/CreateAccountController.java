package com.bgokce.coursemanagementwebapplication.usecases.createaccount;

import com.bgokce.coursemanagementwebapplication.model.Assistant;
import com.bgokce.coursemanagementwebapplication.model.Instructor;
import com.bgokce.coursemanagementwebapplication.model.ServiceResponse;
import com.bgokce.coursemanagementwebapplication.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/createAccount")
public class CreateAccountController {

    private final CreateAccountService createAccountService;

    @PostMapping("/student")
    public ResponseEntity<ServiceResponse> createStudent(@RequestBody Student student) {
        ServiceResponse response = createAccountService.createStudent(student);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/instructor")
    public ResponseEntity<ServiceResponse> createInstructor(@RequestBody Instructor instructor) {
        ServiceResponse response = createAccountService.createInstructor(instructor);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/assistant")
    public ResponseEntity<ServiceResponse> createStudent(@RequestBody Assistant assistant) {
        ServiceResponse response = createAccountService.createAssistant(assistant);
        return ResponseEntity.ok().body(response);
    }
}
