package com.bgokce.coursemanagementwebapplication.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LoginResponseDTO {

    @NotBlank
    private final String jwt;

    @NotBlank
    private final String type;

    public LoginResponseDTO(@JsonProperty("jwt") String jwt,
                    @JsonProperty("type") String type) {
        this.jwt = jwt;
        this.type = type;
    }
}
