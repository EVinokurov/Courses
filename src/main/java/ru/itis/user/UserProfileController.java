package ru.itis.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.course.Course;
import ru.itis.course.CourseApply;
import ru.itis.student.Student;
import ru.itis.student.StudentService;
import ru.itis.teacher.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.security.Role.STUDENT;

@Controller
public class UserProfileController {

    private final String attributeUser = "user";
    private UserService userService;
    private StudentService studentService;
    private TeacherService teacherService;

    @Autowired
    public UserProfileController(UserService userService, StudentService studentService, TeacherService teacherService) {
        this.userService = userService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/profile")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        //получить пользователя
        User user = userService.getUserByAuthentication(authentication);
        if (user.getRole().equals(STUDENT)) {
            //получить Лист курсов, для которых у данного студента сть заявка
            List<Course> courses = user.getStudent().getCourseApply().stream()
                    .map(CourseApply::getCourse)
                    .collect(Collectors.toList());
            //добавить в ModelMap студента и Лист курсов
            model.addAttribute(attributeUser, user.getStudent());
            model.addAttribute("course", courses);
            return "profile-student";
        } else {
            //получить Лист студентов, для которых есть заявка на курс данного преподавателя
            List<Student> students = user.getTeacher().getCourse().getCourseApply().stream()
                    .map(CourseApply::getStudent)
                    .collect(Collectors.toList());
            //добавить в ModelMap учителя и Лист студентов
            model.addAttribute(attributeUser, user.getTeacher());
            model.addAttribute("students", students);
            return "profile-teacher";
        }
    }

    @GetMapping("/edit-profile")
    public String getEditPage(ModelMap model, Authentication authentication) {
        User user = userService.getUserByAuthentication(authentication);
        if (user.getRole().equals(STUDENT)) {
            model.addAttribute(attributeUser, user.getStudent());
            return "edit-student-profile";
        } else {
            model.addAttribute(attributeUser, user.getTeacher());
            return "edit-teacher-profile";
        }
    }

    @PostMapping("/edit-profile")
    public String editProfile(Authentication authentication, EditProfileForm form) {
        User user = userService.getUserByAuthentication(authentication);
        if (user.getRole().equals(STUDENT)) {
            studentService.save(form);
            return "profile-student";
        } else {
            teacherService.save(form);
            return "profile-teacher";
        }
    }
}
