package com.bgokce.coursemanagementwebapplication.model.compositekekys;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentPK implements Serializable {

    //@Column(name = "COURSE_ID")
    private Long courseId;

    //@Column(name = "STUDENT_ID")
    private Long studentId;

    public int hashCode() {
        return (int)(courseId + 1);
    }

    public boolean equals(Object object) {
        if (object instanceof EnrollmentPK) {
            EnrollmentPK otherId = (EnrollmentPK) object;
            return (otherId.courseId == this.courseId)
                    && (otherId.studentId.equals(this.studentId));
        }
        return false;
    }
}
