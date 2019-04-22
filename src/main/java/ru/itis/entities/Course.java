package ru.itis.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
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
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Set<CourseApply> getCourseApply() {
        return courseApply;
    }

    public void setCourseApply(Set<CourseApply> courseApply) {
        this.courseApply = courseApply;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

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
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date deadline;  //Дедлайн подачи заявок
    private String section; //Блок курса. Например: научный
    private String presentation_path;   //хранит путь к файлам презентации

    @OneToMany(mappedBy = "course")
    private Set<CourseApply> courseApply;


    public Long getId() {
        return id;
    }

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

    public Course(String name, String description, int year, Teacher teacher, int quota, boolean rating, Date deadline, String section) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.teacher = teacher;
        this.quota = quota;
        this.rating = rating;
        this.deadline = deadline;
        this.section = section;
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


