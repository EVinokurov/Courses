package ru.itis.course;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Future;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseForm {

    String name;
    String description;
    int year;
    Long teacher;
    int quota;
    boolean rating;

    @Future
    Date deadline;
    String section;
    MultipartFile file;
}

