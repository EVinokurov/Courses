package ru.itis.teacher;

import java.util.List;

public interface TeacherService {

    Teacher getTeacherById(Long id);

    Teacher save(Teacher teacher);

    List<Teacher> getAll();
}
