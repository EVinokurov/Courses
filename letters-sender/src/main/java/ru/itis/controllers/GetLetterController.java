package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.services.LetterService;

@RestController
public class GetLetterController {

    private LetterService letterService;

    @Autowired
    public GetLetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @PostMapping("/confirm")
    public void getStringFromServer(@RequestBody String letter) {
        System.out.println(letter);
        letterService.save(letter);
    }

}
