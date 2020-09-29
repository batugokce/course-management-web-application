package com.bgokce.coursemanagementwebapplication.mapper;

import com.bgokce.coursemanagementwebapplication.model.Course;
import com.bgokce.coursemanagementwebapplication.model.DTO.CourseForStudentDTO;
import com.bgokce.coursemanagementwebapplication.model.DTO.PersonDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseMapper {

    public static Set<CourseForStudentDTO> mapToCourseForStudentDTOSet(Set<Course> courses, Long studentId) {
        return courses.stream().map(item -> mapToCourseForStudentDTO(item, studentId)).collect(Collectors.toSet());
    }

    public static CourseForStudentDTO mapToCourseForStudentDTO(Course course, Long studentId) {
        Set<PersonDTO> instructors = course.getInstructorsTeaching()
                .stream()
                .map(item -> new PersonDTO(item.getInstructor().getNameSurname()))
                .collect(Collectors.toSet());
        Set<PersonDTO> assistants = course.getAssistantsSupporting()
                .stream()
                .map(item -> new PersonDTO(item.getAssistant().getNameSurname()))
                .collect(Collectors.toSet());
        Boolean isEnrolled = course.getStudentsEnrolled().stream()
                .anyMatch(item -> item.getStudentId().equals(studentId));

        return new CourseForStudentDTO(course.getId(), course.getCourseName(), course.getCourseCode(), course.getSemesterNo(), course.getType(),
                isEnrolled, instructors, assistants, course.getExams(), course.getAnnouncements());
    }
}
