package com.bgokce.coursemanagementwebapplication.model.compositekekys;

import com.bgokce.coursemanagementwebapplication.model.Assistant;
import com.bgokce.coursemanagementwebapplication.model.Course;
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
@IdClass(SupportPK.class)
public class Support implements Serializable {

    @Id
    private Long courseId;

    @Id
    private Long assistantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assistantId" , updatable = false, insertable = false, referencedColumnName = "id")
    private Assistant assistant;
}