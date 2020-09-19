package com.bgokce.coursemanagementwebapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse {
    private String type;

    private String message;

    private Object body;
}
