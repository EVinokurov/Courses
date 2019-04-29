package ru.itis.services;

import ru.itis.entities.Course;
import ru.itis.forms.CourseForm;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();


    void addCourse(CourseForm course);

    void deleteCourse(Long id);

    void updateCourse(Course course);

    Course getCourseById(Long id);

    String getFile(String path);
}
