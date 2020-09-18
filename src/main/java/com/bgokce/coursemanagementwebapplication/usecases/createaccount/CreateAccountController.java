package com.bgokce.coursemanagementwebapplication.usecases.createaccount;

import com.bgokce.coursemanagementwebapplication.model.Student;
import lombok.RequiredArgsConstructor;
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
    public Student createStudent(@RequestBody Student student) {
        return createAccountService.createStudent(student);
    }
}
