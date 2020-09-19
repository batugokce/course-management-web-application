package com.bgokce.coursemanagementwebapplication.usecases.createaccount;

import com.bgokce.coursemanagementwebapplication.common.ResponseMessages;
import com.bgokce.coursemanagementwebapplication.model.*;
import com.bgokce.coursemanagementwebapplication.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAccountService {

    private final AuthorityRepository authorityRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final AssistantRepository assistantRepository;

    public ServiceResponse createStudent(Student student) {
        Authority authority = authorityRepository.findByAuthority("STUDENT");
        student.getAuthorities().add(authority);
        Student returnedStudent =  studentRepository.save(student);
        log.info("A student named " + student.getNameSurname() + " is created.");
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ACCOUNT_CREATED_SUCCESSFULLY,returnedStudent);
    }

    public ServiceResponse createInstructor(Instructor instructor) {
        Authority authority = authorityRepository.findByAuthority("INSTRUCTOR");
        instructor.getAuthorities().add(authority);
        Instructor returnedInstructor =  instructorRepository.save(instructor);
        log.info("An instructor named " + instructor.getNameSurname() + " is created.");
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ACCOUNT_CREATED_SUCCESSFULLY,returnedInstructor);
    }

    public ServiceResponse createAssistant(Assistant assistant) {
        Authority authority = authorityRepository.findByAuthority("ASSISTANT");
        assistant.getAuthorities().add(authority);
        Assistant returnedAssistant =  assistantRepository.save(assistant);
        log.info("An assistant named " + assistant.getNameSurname() + " is created.");
        return new ServiceResponse(ResponseMessages.SUCCESS, ResponseMessages.ACCOUNT_CREATED_SUCCESSFULLY,returnedAssistant);
    }


}
