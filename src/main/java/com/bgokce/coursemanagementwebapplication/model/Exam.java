package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.common.BaseEntity;
import liquibase.pro.packaged.S;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "exam_seq")
public class Exam extends BaseEntity {
    private String type;

    private LocalDateTime startDate;

    private String location;

    @ManyToOne
    @JoinColumn(name = "COURSE")
    private Course ownerCourse;
}
