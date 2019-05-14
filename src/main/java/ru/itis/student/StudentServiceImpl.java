package ru.itis.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.user.EditProfileForm;

import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student save(EditProfileForm form) {
        Student student = Student.builder()
                .fName(form.getFName())
                .sName(form.getSName())
                .thName(form.getThName())
                .groupNumber(form.getGroupNumber())
                .courseNumber(form.getCourseNumber())
                .build();
        return studentRepository.save(student);
    }
}
