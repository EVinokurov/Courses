package ru.itis.services;

import ru.itis.entities.Teacher;


public interface TeacherService {

    Teacher getTeacherById(Long id);

    Teacher save(Teacher teacher);
}
