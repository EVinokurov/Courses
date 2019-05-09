package ru.itis.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUser(String login);

    User save(User user);
}
