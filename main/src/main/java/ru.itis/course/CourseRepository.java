package ru.itis.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAll();

    Optional<Course> findByName(String name);

    Optional<Course> findBySection(String section);

    Optional<Course> findByRating(boolean rating);

    List<Course> findAllByOpenForApplicationsIsTrueAndDeadlineBefore(Date date);
}
