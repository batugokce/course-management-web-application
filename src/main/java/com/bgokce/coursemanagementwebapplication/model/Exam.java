package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import liquibase.pro.packaged.S;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "exam_seq")
public class Exam extends BaseEntity {
    private String type;

    private LocalDateTime startDate;

    private String location;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE")
    private Course ownerCourse;
}
