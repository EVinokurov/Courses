package ru.itis.services;

import ru.itis.forms.SignUpForm;

public interface SignUpService {

    void signUpTeacher(SignUpForm form);

    void signUpStudent(SignUpForm form);
}
