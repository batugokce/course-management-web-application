package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "course_seq")
public class Course extends BaseEntity {

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "COURSE_CODE")
    private String courseCode;

    @Column(name = "SEMESTER_NO")
    private String semesterNo;
}
