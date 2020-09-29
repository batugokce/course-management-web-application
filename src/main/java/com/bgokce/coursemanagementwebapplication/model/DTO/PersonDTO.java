package com.bgokce.coursemanagementwebapplication.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PersonDTO {
    private final String nameSurname;
}
