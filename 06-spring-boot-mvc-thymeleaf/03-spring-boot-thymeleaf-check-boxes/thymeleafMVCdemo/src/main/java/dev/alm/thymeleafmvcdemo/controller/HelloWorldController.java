package dev.alm.thymeleafmvcdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showform")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm() {
        return "helloworld-form-input-display";
    }

    @RequestMapping("/processformV2")
    public String processFormV2(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentname");

        name = name.toUpperCase();

        String result = "Hello " + name + "!";

        model.addAttribute("message", result);

        return "helloworld-form-input-display";
    }

    @PostMapping("/processformV3")
    public String processFormV3(@RequestParam("studentname") String name, Model model) {

        name = name.toUpperCase();

        String result = "Hello from v3 " + name + "!";

        model.addAttribute("message", result);

        return "helloworld-form-input-display";
    }
}
