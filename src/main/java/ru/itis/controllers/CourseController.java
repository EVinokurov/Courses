package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.entities.Course;
import ru.itis.services.CourseService;
import ru.itis.services.TeacherService;

import javax.servlet.ServletContext;
import java.util.List;


@Controller
public class CourseController {

    CourseService courseService;
    TeacherService teacherService;
    ServletContext context;

    @Autowired
    public CourseController(CourseService courseService, TeacherService teacherService, ServletContext context) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.context = context;
    }

    /*  @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
        public String getCoursePage(@PathVariable int id, ModelMap model){
            model.addAttribute("course", courseService.getCourseById(id).get());
            return "coursePage";
        }

        @RequestMapping(value = "/course/{id}", method =RequestMethod.GET, params = "download")
        @ResponseBody
        public void downloadFilesToClient(HttpServletRequest request,
                                          HttpServletResponse response, @PathVariable int id) {
            String fileName = courseService.getCourseById(id).get().getPresentation_path();
            String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/files/courses/");
            Path file = Paths.get(dataDirectory, fileName);
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                try {
                    Files.copy(file, response.getOutputStream());
                    response.getOutputStream().flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        //Get create post page
        @RequestMapping(method = RequestMethod.GET, value = "/create_course")
        public String createCoursePage() {
            return "allPosts";
        }

        //Get update post page
        @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
        public String getEditPage(@PathVariable int id,ModelMap modelMap) {
            modelMap.addAttribute("course", courseService.getCourseById(id).get());
            return "redact";
        }

        //Redirect to update page
        @RequestMapping(method = RequestMethod.GET, value = "/posts", params = "id")
        public String RedirectEditPage(@RequestParam int id){
            return "redirect:/edit/" + id;
        }

        //Update course
        @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
        public String updateCourse(@PathVariable("id") int id, Course course){
            System.out.println(course.getId() + " " + course.getName());
            courseService.updateCourse(course);
            return "redirect:/posts";
        }


        //Delete course
        @RequestMapping(method = RequestMethod.POST, value = "/posts", params = "id")
        public String deleteCourse(@RequestParam(value = "id", required = false) int id) {
            courseService.deleteCourse(id);
            return "redirect:/posts";
        }
    */
 /*   //Add course
    @PostMapping("/create_course")
    public String createCourse(@RequestParam("name") String name, @RequestParam("teacher") int teacher,
                               @RequestParam("year") int year, @RequestParam("rating") boolean rating,
                               @RequestParam("section") String section, @RequestParam("quota") int quota,
                                @RequestParam("deadline") Date deadline, @RequestParam("description") String descript,
                               @RequestParam(value = "file", required = false) MultipartFile multipartFile, HttpServletRequest request) {
        String pathForDB = FileService.getFileToDB(multipartFile, request, name);
        courseService.addCourse(new Course(name, descript, year, teacherService.getTeacherById(teacher).get(), quota, rating, deadline, section, pathForDB));
        return "redirect:/posts";
    }

    //Edit String to Date format
    @InitBinder
    public void initBinder(WebDataBinder wb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        wb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/
    //Get all posts
    @GetMapping("/posts")
    public String getAllPosts(ModelMap model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "posts";
    }
}
