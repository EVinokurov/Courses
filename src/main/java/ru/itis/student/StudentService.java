package ru.itis.student;

import ru.itis.user.EditProfileForm;

import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long id);

    Student save(Student student);

    Student save(EditProfileForm form);
}
