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
public class GradePK implements Serializable {

    private Long examId;

    private Long studentId;

    public int hashCode() {
        return (int)(examId * studentId + 1);
    }

    public boolean equals(Object object) {
        if (object instanceof GradePK) {
            GradePK otherId = (GradePK) object;
            return (otherId.examId.equals(this.examId))
                    && (otherId.studentId.equals(this.studentId));
        }
        return false;
    }
}
