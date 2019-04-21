package ru.itis.services;

import ru.itis.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher getTeacherById(Long id);
    List<Teacher> getAll();
}
