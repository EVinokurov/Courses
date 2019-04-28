package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.SignInForm;
import ru.itis.services.SignInService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {

    private SignInService signInService;

    @GetMapping("/sign-in")
    public String getSignInPage(HttpServletRequest request, ModelMap model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", "error");
        }
        return "sign_in";
    }

    @PostMapping("/sign-in")
    public String signInUser(SignInForm signInForm) {
        signInService.signIn(signInForm);
        return "redirect:/hello";
    }
}
