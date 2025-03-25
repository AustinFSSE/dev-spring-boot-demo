package dev.alm.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {

        return "fancy-login";
    }
    @GetMapping("/access-denied")
    public String accessDeniedPage() {

        return "access-denied";
    }
}
