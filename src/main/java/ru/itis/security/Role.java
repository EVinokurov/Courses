package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.entities.Admin;
import ru.itis.entities.Student;
import ru.itis.entities.Teacher;
import ru.itis.entities.User;
import ru.itis.forms.SignUpForm;
import ru.itis.services.AdminServiceImpl;
import ru.itis.services.StudentServiceImpl;
import ru.itis.services.TeacherServiceImpl;

public enum Role {
    ADMIN {
        @Autowired
        AdminServiceImpl adminService;

        @Override
        public void saveAddictionalInfo(SignUpForm form, User user) {
            Admin admin = Admin.builder()
                    .user(user)
                    .build();
            adminService.save(admin);
        }
    },
    TEACHER {
        @Autowired
        TeacherServiceImpl teacherService;

        @Override
        public void saveAddictionalInfo(SignUpForm form, User user) {
            Teacher teacher = Teacher.builder()
                    .fName(form.getFName())
                    .sName(form.getSName())
                    .thName(form.getThName())
                    .user(user)
                    .build();

            teacherService.save(teacher);
        }
    },
    STUDENT {
        @Autowired
        StudentServiceImpl studentService;

        @Override
        public void saveAddictionalInfo(SignUpForm form, User user) {
            Student student = Student.builder()
                    .fName(form.getFName())
                    .sName(form.getSName())
                    .thName(form.getThName())
                    .group(form.getGroup())
                    .user(user)
                    .courseNumber(form.getCourseNumber())
                    .build();
            studentService.save(student);

        }
    };

    public static Role getRoleByOrdinal(int id) {
        return Role.values()[id];
    }

    public abstract void saveAddictionalInfo(SignUpForm form, User user);
}
