package ru.itis.forms;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseForm {

    String name;    //Название курса
    String description; //Описание курса
    int year;   //Год курса - номер года обучения студентов, которые могут на него записаться
    Long teacher;    //Преподаватель курса
    int quota;  //  Квота курса. Сколько человек может набрать преподаватель
    boolean rating; //Принимает по рейтингу или нет(по собесу)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Date deadline;  //Дедлайн подачи заявок
    String section; //Блок курса. Например: научный
    MultipartFile file;

    public Long getTeacher() {
        return teacher;
    }
}

