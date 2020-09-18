package com.bgokce.coursemanagementwebapplication.model.compositekeys;

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
public class TeachPK implements Serializable {

    private Long courseId;

    private Long instructorId;

    public int hashCode() {
        return (int)(courseId + 1);
    }

    public boolean equals(Object object) {
        if (object instanceof EnrollmentPK) {
            TeachPK otherId = (TeachPK) object;
            return (otherId.courseId == this.courseId)
                    && (otherId.instructorId.equals(this.instructorId));
        }
        return false;
    }
}
