package com.bgokce.coursemanagementwebapplication.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeDTO {

    private final Long studentId;

    private final Integer point;

    public GradeDTO(@JsonProperty("studentId") Long studentId,
                    @JsonProperty("point") Integer point) {
        this.studentId = studentId;
        this.point = point;
    }
}
