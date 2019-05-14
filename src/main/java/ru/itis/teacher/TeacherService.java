package ru.itis.teacher;

import ru.itis.user.EditProfileForm;

import java.util.List;

public interface TeacherService {

    Teacher getTeacherById(Long id);

    Teacher save(Teacher teacher);

    Teacher save(EditProfileForm form);

    List<Teacher> getAll();
}
