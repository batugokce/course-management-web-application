package com.bgokce.coursemanagementwebapplication.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "student_seq")
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends PersonEntity {
}
