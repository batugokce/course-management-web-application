package com.bgokce.coursemanagementwebapplication.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LoginDTO {

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;

    public LoginDTO(@JsonProperty("username") String username,
                    @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
