package com.bgokce.coursemanagementwebapplication;

import com.bgokce.coursemanagementwebapplication.model.Authority;
import com.bgokce.coursemanagementwebapplication.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class CourseManagementWebApplication {

	private final AuthorityRepository authorityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementWebApplication.class, args);
	}

	@PostConstruct
	private void initialize(){
		Authority authority = authorityRepository.findById(1L).orElse(null);
		if (authority == null){
			authorityRepository.save(new Authority("STUDENT"));
			authorityRepository.save(new Authority("INSTRUCTOR"));
			authorityRepository.save(new Authority("ASSISTANT"));
			authorityRepository.save(new Authority("ADMIN"));
			//personService.createAdmin("admin","admin");
		}
	}

}
