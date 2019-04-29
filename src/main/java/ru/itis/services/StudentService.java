package ru.itis.services;

import ru.itis.entities.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudentById(Long id);

    Student save(Student student);
}
