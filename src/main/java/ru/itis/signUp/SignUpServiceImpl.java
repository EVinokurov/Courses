package ru.itis.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.security.Role;
import ru.itis.student.Student;
import ru.itis.student.StudentService;
import ru.itis.teacher.Teacher;
import ru.itis.teacher.TeacherService;
import ru.itis.user.User;
import ru.itis.user.UserService;

@Service
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;
    private TeacherService teacherService;
    private StudentService studentService;
    private UserService userService;

    @Autowired
    public SignUpServiceImpl(@Lazy PasswordEncoder passwordEncoder, TeacherService teacherService, StudentService studentService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.userService = userService;
    }

    private User signUpUser(SignUpForm form) {
        User user = User.builder()
                .login(form.getLogin())
                .hashPassword(passwordEncoder.encode(form.getHashPassword()))
                .role(Role.getRoleByOrdinal(form.getRole()))
                .build();
        userService.save(user);
        return user;
    }

    @Override
    public void signUpTeacher(SignUpForm form) {
        Teacher teacher = Teacher.builder()
                .fName(form.getFName())
                .sName(form.getSName())
                .thName(form.getThName())
                .user(signUpUser(form))
                .build();
        teacherService.save(teacher);
    }

    @Override
    public void signUpStudent(SignUpForm form) {
        Student student = Student.builder()
                .fName(form.getFName())
                .sName(form.getSName())
                .thName(form.getThName())
                .groupNumber(form.getGroupNumber())
                .courseNumber(form.getCourseNumber())
                .user(signUpUser(form))
                .build();
        studentService.save(student);
    }
}
