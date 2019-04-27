package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.entities.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String login){
        User user = new User();
        user.setLogin(login);
        return user;
    }
}
