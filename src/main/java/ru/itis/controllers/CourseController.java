package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.itis.entities.Course;
import ru.itis.forms.CourseForm;
import ru.itis.services.CourseService;
import ru.itis.services.CourseServiceImpl;
import ru.itis.services.FileService;
import ru.itis.services.TeacherService;
import ru.itis.utils.MediaTypeUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    FileService fileService;

     @GetMapping(value = "/course/{id}")
      public String getCoursePage(@PathVariable long id, ModelMap model){
          model.addAttribute("course", courseService.getCourseById(id));
          return "course";
      }

      //Get update post page
      @GetMapping(value = "/edit/{id}")
      public String getEditPage(@PathVariable long id,ModelMap modelMap) {
          modelMap.addAttribute("course", courseService.getCourseById(id));
          return "redact";
      }

      //Redirect to update page
      @GetMapping(value = "/posts", params = "id")
      public String RedirectEditPage(@RequestParam long id){
          return "redirect:/edit/" + id;
      }


      //Update course
      @PostMapping(value = "/edit/{id}")
      public String updateCourse(@PathVariable("id") long id, Course course, @RequestParam(value = "file", required = false) MultipartFile file){
         fileService.chacngePresentationPath(id, file, course);
          courseService.updateCourse(course);
          return "redirect:/posts";
      }
      //Delete course
      @PostMapping(value = "/posts", params = "id")
      public String deleteCourse(@RequestParam(value = "id", required = false) long id) {
          courseService.deleteCourse(id);
          return "redirect:/posts";
      }


    @GetMapping(value = "/course/{id}", params = "download")
    @ResponseBody
    public void downloadFilesToClient(HttpServletResponse response, @PathVariable Long id) {
        String fileName = courseService.getCourseById(id).getPresentation_path();
        fileService.downloadFileToClient(fileName, response);
    }


    //Get create post page
    @GetMapping("/create_course")
    public String createCoursePage(ModelMap model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "newCourse";
    }

    //Create course
    @PostMapping("/create_course")
    public String createCourse(@RequestParam("name") String name, @RequestParam("teacher") Long teacher,
                               @RequestParam("year") int year, @RequestParam("rating") boolean rating,
                               @RequestParam("section") String section, @RequestParam("quota") int quota,
                               @RequestParam("deadline") Date deadline, @RequestParam("description") String descript,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String filePath = fileService.uploadCoursesFiles(file, name);
        courseService.addCourse(new Course(name, descript, year, teacherService.getTeacherById(teacher), quota, rating, deadline, section, filePath));
        return "redirect:/posts";
    }


    //Edit String to Date format
    @InitBinder
    public void initBinder(WebDataBinder wb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        wb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    //Get all posts
    @GetMapping("/posts")
    public String getAllPosts(ModelMap model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "posts";
    }
}
