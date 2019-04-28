package ru.itis.services;

import ru.itis.entities.Student;
import ru.itis.repository.StudentRepository;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    static StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public static Student save(Student student) {
        return studentRepository.save(student);
    }
}
