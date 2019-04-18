package ru.itis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String username;
    private String passwordHash;
    @OneToOne(mappedBy = "teacher")
    private Course course;
    private String description;
    //private String avatar_path;


    public Teacher(String name, String username, String password_hash, String description) {
        this.name = name;
        this.username = username;
        this.passwordHash = password_hash;
        this.description = description;
    }
}
