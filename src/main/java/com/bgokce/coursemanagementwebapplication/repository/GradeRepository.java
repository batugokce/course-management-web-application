package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.compositekeys.Grade;
import com.bgokce.coursemanagementwebapplication.model.compositekeys.GradePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradePK> {

    @Query("FROM Grade AS g WHERE g.examId = :examId")
    List<Grade> getGradesByExamId(Long examId);
}
