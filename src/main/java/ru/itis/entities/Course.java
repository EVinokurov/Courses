package ru.itis.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int year;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
    private int quota;
    private boolean rating;

    @Temporal(TemporalType.DATE)
    private Date deadline;
    private String section;
    private String presentation_path;
    private boolean openForApplications;

    @OneToMany(mappedBy = "course")
    private Set<CourseApply> courseApply;
}


