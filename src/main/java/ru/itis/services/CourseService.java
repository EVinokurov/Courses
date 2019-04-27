package ru.itis.services;

import ru.itis.entities.Course;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    void addCourse(Course course);
    void deleteCourse(Long id);
    void updateCourse(Course course);
    Course getCourseById(Long id);
    String getFile(String path);
}
