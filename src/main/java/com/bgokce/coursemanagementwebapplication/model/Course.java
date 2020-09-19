package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.common.BaseEntity;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Support;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.Teach;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "TYPE")
    private String type;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Enrollment> studentsEnrolled = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Teach> instructorsTeaching = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Support> assistantsSupporting = new HashSet<>();

    @OneToMany(mappedBy = "ownerCourse")
    private Set<Exam> exams = new HashSet<>();
}
