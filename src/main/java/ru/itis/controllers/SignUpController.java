package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.SignUpForm;
import ru.itis.services.SignUpService;

@Controller
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/sign-up")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign-up-teacher")
    public String signUpTeacher(SignUpForm form) {
        signUpService.signUpTeacher(form);
        return "redirect:/hello";
    }

    @PostMapping("/sign-up-student")
    public String signUpStudent(SignUpForm form) {
        signUpService.signUpStudent(form);
        return "redirect:/hello";
    }
}
