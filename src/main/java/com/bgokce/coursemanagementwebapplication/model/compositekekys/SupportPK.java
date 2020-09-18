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
public class SupportPK implements Serializable {

    private Long courseId;

    private Long assistantId;

    public int hashCode() {
        return (int)(courseId + 1);
    }

    public boolean equals(Object object) {
        if (object instanceof EnrollmentPK) {
            SupportPK otherId = (SupportPK) object;
            return (otherId.courseId == this.courseId)
                    && (otherId.assistantId.equals(this.assistantId));
        }
        return false;
    }
}