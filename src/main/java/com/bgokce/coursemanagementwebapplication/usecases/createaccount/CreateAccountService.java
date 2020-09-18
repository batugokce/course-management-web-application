package com.bgokce.coursemanagementwebapplication.usecases.createaccount;

import com.bgokce.coursemanagementwebapplication.model.Authority;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.bgokce.coursemanagementwebapplication.repository.AuthorityRepository;
import com.bgokce.coursemanagementwebapplication.repository.PersonEntityRepository;
import com.bgokce.coursemanagementwebapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountService {

    private final PersonEntityRepository personEntityRepository;
    private final AuthorityRepository authorityRepository;
    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        Authority authority = authorityRepository.findByAuthority("STUDENT");
        student.getAuthorities().add(authority);
        Student returnedStudent =  studentRepository.save(student);
        return student;
    }
}
