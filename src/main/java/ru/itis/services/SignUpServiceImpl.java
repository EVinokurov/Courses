package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.entities.Student;
import ru.itis.entities.Teacher;
import ru.itis.forms.SignUpForm;
import ru.itis.repository.StudentRepository;
import ru.itis.repository.TeacherRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        if (form.getIsStudent()) {
            Student student = Student.builder()
                    .password(passwordEncoder.encode(form.getPassword()))
                    .name(form.getName())
                    .sName(form.getSName())
                    .thName(form.getThName())
                    .login(form.getLogin())
                    .groupe(form.getGroupe())
                    .build();
            studentRepository.save(student);
        }else{
            Teacher teacher = Teacher.builder()
                    .password(passwordEncoder.encode(form.getPassword()))
                    .name(form.getName())
                    .sName(form.getSName())
                    .thName(form.getThName())
                    .login(form.getLogin())
                    .build();
            teacherRepository.save(teacher);
        }
    }
}
