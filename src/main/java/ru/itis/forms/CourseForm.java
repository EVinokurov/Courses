package ru.itis.forms;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.util.Date;

public class CourseForm {
    String name;    //Название курса
    String description; //Описание курса
    int year;   //Год курса - номер года обучения студентов, которые могут на него записаться
    int teacher;    //Преподаватель курса
    int quota;  //  Квота курса. Сколько человек может набрать преподаватель
    boolean rating; //Принимает по рейтингу или нет(по собесу)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deadline;  //Дедлайн подачи заявок
    String section; //Блок курса. Например: научный


    public CourseForm(String name, String description, int year, int teacher, int quota, boolean rating, Date deadline, String section) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.teacher = teacher;
        this.quota = quota;
        this.rating = rating;
        this.deadline = deadline;
        this.section = section;
    }

    public CourseForm() {
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

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
