package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherById(Long id);

    List<Teacher> findAll();
}
