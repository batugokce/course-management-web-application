package com.bgokce.coursemanagementwebapplication.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "student_seq")
@AllArgsConstructor
@NoArgsConstructor
public class Student extends PersonEntity {

    @Column(name = "ROLE_NAME")
    private String xxx;
}
