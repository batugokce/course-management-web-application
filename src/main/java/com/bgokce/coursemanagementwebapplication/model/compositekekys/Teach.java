package com.bgokce.coursemanagementwebapplication.model.compositekekys;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
