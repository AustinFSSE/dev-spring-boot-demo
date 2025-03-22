package dev.alm.thymeleafmvcdemo.controller;

import dev.alm.thymeleafmvcdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // injection into List<String> countries from app.props file which is used in the student-form.html
    @Value("${countries}")
    private List <String> countries;
    @Value("${languages}")
    private List <String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        model.addAttribute("countries", countries);

        model.addAttribute("languages", languages);

        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {

        System.out.println(student);

        return "student-confirmation";
    }
}
