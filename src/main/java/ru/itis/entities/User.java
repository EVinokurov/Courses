package ru.itis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.security.Role;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private Role role;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "id")
    private Teacher teacher;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "id")
    private Admin admin;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;

}
