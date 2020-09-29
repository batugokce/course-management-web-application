package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course as c left join fetch c.exams where c.id = :courseId")
    Course getCourseWithExams(Long courseId);

    @Query("select c from Course as c left join fetch c.exams " +
            "                         left join fetch c.announcements" +
            "                         left join fetch c.instructorsTeaching as teach" +
            "                         left join fetch teach.instructor" +
            "                         left join fetch c.assistantsSupporting as assist" +
            "                         left join fetch assist.assistant" +
            "                         left join fetch c.studentsEnrolled as en" +
            "                         left join fetch en.student")
    Set<Course> getAllCourses();
}
