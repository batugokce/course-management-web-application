package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Support;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.SupportPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepository extends JpaRepository<Support, SupportPK> {
}
