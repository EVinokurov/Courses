package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.entities.User;
import ru.itis.forms.SignInForm;

@Service
public class SignInServiceImpl implements SignInService {

    @Override
    public void signIn(SignInForm form) {
        User user = User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .build();
    }
}
