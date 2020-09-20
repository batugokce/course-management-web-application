package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course as c left join fetch c.exams where c.id = :courseId")
    Course getCourseWithExams(Long courseId);
}
