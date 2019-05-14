package ru.itis.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.security.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return userRepository.findOneByLogin(principal.getUsername()).get();
    }
}
