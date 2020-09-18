package com.bgokce.coursemanagementwebapplication.model;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Support;
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
@SequenceGenerator(name = "idgen", sequenceName = "assistant_seq")
public class Assistant extends PersonEntity {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant")
    private Set<Support> coursesSupported = new HashSet<>();
}
