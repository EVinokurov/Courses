package ru.itis.student;

import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long id);

    Student save(Student student);
}
