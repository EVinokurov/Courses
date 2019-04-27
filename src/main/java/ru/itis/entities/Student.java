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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sName;
    private String thName;
    private String login;
    private String password;
    private String groupe;
    private int courseNumber;  //на каком курсе учится
    @OneToMany(mappedBy = "student")
    private Set<CourseApply> courseApply;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "student")
    private User user;

    public Role getRole() {
        return role;
    }
}
