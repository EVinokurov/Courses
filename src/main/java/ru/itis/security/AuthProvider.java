package ru.itis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.entities.User;
import ru.itis.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * 17.11.2017
 * AuthProvider
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    UserRepository usersRepository;

    @Autowired
    public AuthProvider(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    @Qualifier(value = "customUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // получаем имя пользователя
        String username = authentication.getName();
        // получаем пароль
        String password = authentication.getCredentials()
                .toString();

        // находите пользователя по логину
        Optional<User> userOptional = usersRepository.findOneByLogin(username);
        // если пользователь найден
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // если пароль пользователя не совпал с тем, который ввели
            if (!passwordEncoder.matches(password, user.getHashPassword())) {
                throw new BadCredentialsException("Wrong password or login");
            }
        } else {
            throw new BadCredentialsException("Wrong password or login");
        }
        // сюда попадем, если заходит либо пользователь с нормальным паролем
        // загружаем details пользователя по имени
        UserDetails details = userDetailsService.loadUserByUsername(username);
        // получаем его права ADMIN либо USER
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
        // возвращаем созданную аутентификацию дальше
        return new UsernamePasswordAuthenticationToken(details, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}