package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.user.User;
import ru.itis.user.UserRepository;

@Service
@Component(value = "customUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = usersRepository.findOneByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("user not found by login <" + login + ">"));
        return new UserDetailsImpl(user);
    }
}
