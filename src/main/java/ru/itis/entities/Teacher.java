package ru.itis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.security.Role;

import javax.persistence.*;
import java.util.Set;

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
    private String username;
    private String passwordHash;
    @OneToOne(mappedBy = "teacher")
    private Course course;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    //private String avatar_path;


    public Teacher(String name, String username, String password_hash, String description) {
        this.name = name;
        this.username = username;
        this.passwordHash = password_hash;
        this.description = description;
    }
}
