package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

    @Query("SELECT COUNT(e) FROM Enrollment AS e WHERE e.courseId = :courseId AND e.studentId IN :idList ")
    Integer countStudentsEnroller(Long courseId, List<Long> idList);
}
