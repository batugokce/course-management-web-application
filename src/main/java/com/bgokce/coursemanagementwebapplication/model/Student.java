package com.bgokce.coursemanagementwebapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Enrollment> coursesTaken = new HashSet<>();
}
