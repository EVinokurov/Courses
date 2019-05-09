package ru.itis.signUp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.FormLetter;
import ru.itis.email.LetterService;
import ru.itis.security.Role;
import ru.itis.security.UserState;
import ru.itis.student.Student;
import ru.itis.student.StudentService;
import ru.itis.teacher.Teacher;
import ru.itis.teacher.TeacherService;
import ru.itis.user.User;
import ru.itis.user.UserService;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;
    private TeacherService teacherService;
    private StudentService studentService;
    private UserService userService;
    private LetterService letterService;

    @Autowired
    public SignUpServiceImpl(PasswordEncoder passwordEncoder, TeacherService teacherService,
                             StudentService studentService, UserService userService, LetterService letterService) {
        this.passwordEncoder = passwordEncoder;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.userService = userService;
        this.letterService = letterService;
    }

    private User signUpUser(SignUpForm form) {
        String confirmString = UUID.randomUUID().toString();
        User user = User.builder()
                .login(form.getLogin())
                .hashPassword(passwordEncoder.encode(form.getHashPassword()))
                .role(Role.getRoleByOrdinal(form.getRole()))
                .confirmString(confirmString)
                .state(UserState.UNCONFIRMED)
                .build();
        userService.save(user);
        letterService.sendConfirmLetter(form.getLogin(), confirmString);
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
