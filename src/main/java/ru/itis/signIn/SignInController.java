package ru.itis.signIn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

    @GetMapping
    public String getSignInPage(HttpServletRequest request, ModelMap model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", "error");
        }
        return "sign_in";
    }

    @PostMapping
    public String signInUser(SignInForm signInForm) {
        return "redirect:/hello";
    }
}
