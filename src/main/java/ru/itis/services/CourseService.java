package ru.itis.services;

import ru.itis.entities.Course;
import ru.itis.forms.CourseForm;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();
    void addCourse(Course course);
    void deleteCourse(Long id);
    void updateCourse(Course course);
    Course getCourseById(Long id);
    String getFile(String path);
}
