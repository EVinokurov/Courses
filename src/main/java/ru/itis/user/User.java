package ru.itis.user;

import lombok.*;
import ru.itis.security.Role;
import ru.itis.student.Student;
import ru.itis.teacher.Teacher;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String hashPassword;
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "id")
    private Teacher teacher;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;
}
