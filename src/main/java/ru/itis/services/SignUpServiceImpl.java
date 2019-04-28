package ru.itis.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.entities.User;
import ru.itis.forms.SignUpForm;
import ru.itis.security.Role;

@Service
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .login(form.getLogin())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Role.getRoleByOrdinal(form.getRole()))
                .build();
        user.getRole().saveAddictionalInfo(form, user);
    }

}
