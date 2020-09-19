package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Enrollment;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
