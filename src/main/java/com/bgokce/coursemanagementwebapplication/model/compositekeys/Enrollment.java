package com.bgokce.coursemanagementwebapplication.model.compositekeys;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.Student;
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
@IdClass(EnrollmentPK.class)
@EntityListeners(AuditingEntityListener.class)
public class Enrollment implements Serializable {

    @Id
    private Long courseId;

    @Id
    private Long studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Student student;
}
