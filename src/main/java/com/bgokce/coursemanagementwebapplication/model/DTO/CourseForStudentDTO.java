package com.bgokce.coursemanagementwebapplication.model.DTO;

import com.bgokce.coursemanagementwebapplication.model.Announcement;
import com.bgokce.coursemanagementwebapplication.model.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
public class CourseForStudentDTO {

    private final Long courseId;

    private final String  courseName;

    private final String courseCode;

    private final String semesterNo;

    private final String type;

    private final Boolean isEnrolled;

    private final Set<PersonDTO> instructors;

    private final Set<PersonDTO> assistants;

    private final Set<Exam> exams;

    private final Set<Announcement> announcements;
}
