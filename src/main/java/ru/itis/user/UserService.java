package ru.itis.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUser(String login);

    User save(User user);

    User getUserByAuthentication(Authentication authentication);
}
