package ru.itis.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.entities.Admin;
import ru.itis.entities.Student;
import ru.itis.entities.Teacher;

import java.util.Collection;
import java.util.Collections;


public class UserDetailsImpl implements UserDetails {
    private Student student;
    private Teacher teacher;
    private Admin admin;


    /*public UserDetailsImpl(User user) {
        this.user = user;
    }*/

    public UserDetailsImpl(Long id, String role, String login) {
        if (role.equals(Role.STUDENT)) {
            this.student = Student.builder()
                    .id(id)
                    .role(Role.valueOf(role))
                    .login(login)
                    .build();
        } else {
            if (role.equals(Role.TEACHER)) {
                this.teacher = Teacher.builder()
                        .id(id)
                        .role(Role.valueOf(role))
                        .login(login)
                        .build();
            } else {
                if (role.equals(Role.ADMIN)) {
                    this.admin = Admin.builder()
                            .id(id)
                            .login(login)
                            .role(Role.valueOf(role))
                            .build();
                }
            }
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(.getRole().toString());
        return Collections.singletonList(authority);
    }


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
