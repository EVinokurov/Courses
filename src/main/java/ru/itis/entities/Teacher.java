package ru.itis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.security.Role;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sName;
    private String thName;

    private String login;
    private String password;

    @OneToOne(mappedBy = "teacher")
    private Course course;
    private String description;

    @OneToOne(mappedBy = "teacher")
    private User user;
    @Enumerated(value = EnumType.STRING)
    private Role role;


    public Teacher(String name, String login, String password_hash, String description) {
        this.name = name;
        this.login = login;
        this.password = password_hash;
        this.description = description;
    }
}
