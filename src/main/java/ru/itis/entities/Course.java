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
    private String name;    //Название курса
    private String description; //Описание курса
    private int year;   //Год курса - номер года обучения студентов, которые могут на него записаться

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;    //Преподаватель курса
    private int quota;  //  Квота курса. Сколько человек может набрать преподаватель
    private boolean rating; //Принимает по рейтингу или нет(по собесу)
    @Temporal(TemporalType.DATE)
    private Date deadline;  //Дедлайн подачи заявок
    private String section; //Блок курса. Например: научный
    private String presentation_path;   //хранит путь к файлам презентации
    @OneToMany(mappedBy = "course")
    private Set<CourseApply> courseApply;
}


