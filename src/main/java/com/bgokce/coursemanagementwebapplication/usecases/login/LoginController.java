package com.bgokce.coursemanagementwebapplication.usecases.login;

import com.bgokce.coursemanagementwebapplication.configuration.MyUserDetailsService;
import com.bgokce.coursemanagementwebapplication.model.Authority;
import com.bgokce.coursemanagementwebapplication.model.DTO.LoginDTO;
import com.bgokce.coursemanagementwebapplication.model.PersonEntity;
import com.bgokce.coursemanagementwebapplication.utilities.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final MyUserDetailsService myUserDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO personDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(personDTO.getUsername(),personDTO.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Wrong id or pw",e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(
                personDTO.getUsername()
        );

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok().body(jwt);

    }
}
