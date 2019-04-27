package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.entities.User;

@Service
public interface UserService {
    User getUser(String login);
}
