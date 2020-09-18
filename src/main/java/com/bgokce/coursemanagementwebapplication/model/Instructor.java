package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.model.compositekekys.Teach;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "instructor_seq")
public class Instructor extends PersonEntity {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
    private Set<Teach> coursesTeaching = new HashSet<>();
}
