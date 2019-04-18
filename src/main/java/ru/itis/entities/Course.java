package ru.itis.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;  //Дедлайн подачи заявок
    private String section; //Блок курса. Например: научный
    private String presentation_path;   //хранит путь к файлам презентации

    @OneToMany(mappedBy = "course")
    private Set<CourseApply> courseApply;


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPresentation_path() {
        return presentation_path;
    }

    public void setPresentation_path(String presentation_path) {
        this.presentation_path = presentation_path;
    }

    public Course(String name, String description, int year, Teacher teacher, int quota, boolean rating, Date deadline, String section, String presentation_path) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.teacher = teacher;
        this.quota = quota;
        this.rating = rating;
        this.deadline = deadline;
        this.section = section;
        this.presentation_path = presentation_path;
    }


}


