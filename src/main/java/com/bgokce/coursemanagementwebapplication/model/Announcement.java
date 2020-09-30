package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "idgen", sequenceName = "ann_seq")
public class Announcement extends BaseEntity {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE")
    private Course ownerCourse;

}
