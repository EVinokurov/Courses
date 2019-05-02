package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.itis.entities.Course;

import java.util.Date;
@Service
public class CheckDeadlineServiceImpl implements CheckDeadlineService {

    private CourseService courseService;

    @Autowired
    public CheckDeadlineServiceImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    //every day at 12 pm
    //cron = "0 0 12 * * ?"
    @Scheduled(fixedDelay = 30000)
    @Override
    public void checkDeadline() {
        System.out.println("TIME!");
        for (Course course :
                courseService.getAllCourses()) {
            if (course.getDeadline().before(new Date())) {
                course.setOpenForApplications(false);
                courseService.updateCourse(course);
            }
        }
    }
}
