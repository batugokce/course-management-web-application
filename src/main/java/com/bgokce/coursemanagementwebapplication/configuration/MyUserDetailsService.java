package com.bgokce.coursemanagementwebapplication.configuration;

import com.bgokce.coursemanagementwebapplication.model.Authority;
import com.bgokce.coursemanagementwebapplication.model.PersonEntity;
import com.bgokce.coursemanagementwebapplication.repository.PersonEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final PersonEntityRepository personEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonEntity p = personEntityRepository.findByUserNameWithAuthorities(username);
        return p;
    }
}
