package com.bgokce.coursemanagementwebapplication.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "admin_seq")
public class Admin extends PersonEntity {
}
