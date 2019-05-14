package ru.itis.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.teacher.TeacherService;
import ru.itis.utils.FileService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CourseController {

    private CourseService courseService;
    private TeacherService teacherService;
    private FileService fileService;

    @Autowired
    public CourseController(CourseService courseService, TeacherService teacherService, FileService fileService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.fileService = fileService;
    }

    public static final String COURSE_ATTRIBUTE_NAME = "course";

    @GetMapping(value = "/course/{id}")
    public String getCoursePage(@PathVariable long id, ModelMap model) {
        model.addAttribute(COURSE_ATTRIBUTE_NAME, courseService.getCourseById(id));
        return "oneCoursePage";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable long id, ModelMap modelMap) {
        modelMap.addAttribute(COURSE_ATTRIBUTE_NAME, courseService.getCourseById(id));
        return "editPage";
    }

    @GetMapping(value = "/courses", params = "id")
    public String RedirectEditPage(@RequestParam long id) {
        return "redirect:/edit/" + id;
    }

    @PostMapping(value = "/edit/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String previous_path = courseService.getCourseById(id).getPresentation_path();
        fileService.chacngePresentationPath(id, file, course, previous_path);
        courseService.updateCourse(course);
        return "redirect:/courses";
    }

    @PostMapping(value = "/courses", params = "id")
    public String deleteCourse(@RequestParam(value = "id") long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    @GetMapping(value = "/course/{id}", params = "download")
    @ResponseBody
    public void downloadFilesToClient(HttpServletResponse response, @PathVariable Long id) {
        String fileName = courseService.getCourseById(id).getPresentation_path();
        fileService.downloadFileToClient(fileName, response);
    }

    @GetMapping("/new")
    public String createCoursePage(ModelMap model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "newCourse";
    }

    @PostMapping("/new")
    public String createCourse(@Valid CourseForm courseForm, BindingResult bindingResult, ModelMap model) {
        courseService.addCourse(courseForm);
        return "redirect:/courses";
    }

    @InitBinder
    public void initBinder(WebDataBinder wb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        wb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping("/courses")
    public String getAllPosts(ModelMap model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "posts";
    }
}
