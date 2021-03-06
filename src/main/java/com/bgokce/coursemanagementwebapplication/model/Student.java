package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "student_seq")
@AllArgsConstructor
@NoArgsConstructor
public class Student extends PersonEntity {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Enrollment> coursesTaken = new HashSet<>();
}
