package com.bgokce.coursemanagementwebapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TeachPK.class)
public class Teach implements Serializable {

    @Id
    private Long courseId;

    @Id
    private Long instructorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Instructor instructor;
}
