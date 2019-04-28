package ru.itis.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {
    @GetMapping("/hello")
    public String getSignUpPage() {
        return "hello";
    }
}
