package ru.itis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
@Service
public class FileService {


    public static String getFileToDB(MultipartFile multipartFile, HttpServletRequest request, String name){
        String orgName = multipartFile.getOriginalFilename();
        String filePath = request.getServletContext().getRealPath("WEB-INF/files/courses/" + name + "/" + orgName);
        File dest = new File(filePath);
        try {
            multipartFile.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return Paths.get(name,orgName).toString();
    }
}
