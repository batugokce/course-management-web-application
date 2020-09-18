package com.bgokce.coursemanagementwebapplication.configuration;

import com.bgokce.coursemanagementwebapplication.model.Authority;
import com.bgokce.coursemanagementwebapplication.model.PersonEntity;
import com.bgokce.coursemanagementwebapplication.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //PersonEntity p = personRepository.findByUsername(username);
        PersonEntity p = new PersonEntity();
        p.setUsername("admin");
        p.setPassword("admin");
        Authority authority = new Authority("USER");
        p.getAuthorities().add(authority);
        System.out.println(p.getPassword());
        return p;
    }
}
