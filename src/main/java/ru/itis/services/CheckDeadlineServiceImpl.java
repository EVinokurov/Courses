package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckDeadlineServiceImpl implements CheckDeadlineService {

    private CourseService courseService;

    @Autowired
    public CheckDeadlineServiceImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    @Override
    public void closeCoursesForApplicationsWithOverDueDeadline() {
        Date date = new Date();
        courseService.findAllCoursesByDeadlineBefore()
                .forEach(
                        course -> {
                            if (course.getDeadline().before(date)) {
                                course.setOpenForApplications(false);
                                courseService.updateCourse(course);
                            }
                        });
    }
}
