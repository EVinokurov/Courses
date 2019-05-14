package ru.itis.student;

import lombok.*;
import ru.itis.course.CourseApply;
import ru.itis.user.User;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String sName;
    private String thName;
    private String groupNumber;
    private int courseNumber;

    @OneToMany(mappedBy = "student")
    private Set<CourseApply> courseApply;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
