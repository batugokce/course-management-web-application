package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Teach;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.TeachPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachRepository extends JpaRepository<Teach, TeachPK> {
}
