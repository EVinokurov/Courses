package ru.itis.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLetterController {

    @PostMapping(value = "/confirm")
    public void getStringFromServer(String text){
        System.out.println(text);
    }

}
