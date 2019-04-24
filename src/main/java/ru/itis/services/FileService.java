package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.entities.Course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final String UPLOADED_FOLDER = "C://files//courses/";

    public void chacngePresentationPath(long id, MultipartFile file, Course course,
                                        String previousPath) {
        if (!file.isEmpty()) {
            String filepath = uploadCoursesFiles(file, course.getName());
            course.setPresentation_path(filepath);
        } else {
            course.setPresentation_path(previousPath);
        }
    }

    public String uploadCoursesFiles(MultipartFile file, String name) {
        if (!file.isEmpty()) {
            String uploadedCoursesFolder = "/" + name + "/";
            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                File dir = new File(UPLOADED_FOLDER + uploadedCoursesFolder);
                if (!dir.exists()) dir.mkdirs();
                Path path = Paths.get(UPLOADED_FOLDER + uploadedCoursesFolder + file.getOriginalFilename());
                Files.write(path, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return uploadedCoursesFolder + file.getOriginalFilename();
        } else {
            return null;
        }

    }

    public void downloadFileToClient(String fileName, HttpServletResponse response) {
        String path = UPLOADED_FOLDER + fileName;
        Path file = Paths.get(path);
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
}
