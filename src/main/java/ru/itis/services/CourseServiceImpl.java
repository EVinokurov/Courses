package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.itis.entities.Course;
import ru.itis.forms.CourseForm;
import ru.itis.repository.CourseRepository;
import ru.itis.repository.TeacherRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseServiceImpl implements CourseService {


    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;
    private FileService fileService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, TeacherRepository teacherRepository, FileService fileService) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.fileService = fileService;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(CourseForm courseForm) {
        String filePath = fileService.uploadCoursesFiles(courseForm.getFile(), courseForm.getName());
        Course newCourse = Course.builder()
                .name(courseForm.getName())
                .description(courseForm.getDescription())
                .year(courseForm.getYear())
                .teacher(teacherRepository.findTeacherById(courseForm.getTeacher()).orElseThrow(NoSuchElementException::new))
                .quota(courseForm.getQuota())
                .rating(courseForm.isRating())
                .deadline(courseForm.getDeadline())
                .section(courseForm.getSection())
                .presentation_path(filePath)
                .openForApplications(true)
                .build();
        courseRepository.save(newCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public String getFile(String path) {
        return path;
    }
}
