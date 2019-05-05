package ru.itis.course;

import java.util.Date;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void addCourse(CourseForm course);

    void deleteCourse(Long id);

    void updateCourse(Course course);

    Course getCourseById(Long id);

    String getFile(String path);

    List<Course> findAllByCoursesOpenForApplicationsAndDeadlineBefore(Date date);

    void closeCoursesForApplicationsWithOverDueDeadline();
}
