package com.bgokce.coursemanagementwebapplication.model.compositekeys;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import com.bgokce.coursemanagementwebapplication.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(GradePK.class)
public class Grade {

    @JsonIgnore
    @Id
    private Long examId;

    @Id
    private Long studentId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Exam exam;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Student student;

    @Column(name = "POINT")
    private Integer point;
}
