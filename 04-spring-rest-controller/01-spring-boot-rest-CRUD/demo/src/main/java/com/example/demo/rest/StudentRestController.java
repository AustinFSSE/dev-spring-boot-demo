package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>(List.of(
                new Student(1, "John", "Doe"),
                new Student(2, "Mary", "Sue"),
                new Student(3, "Jane", "Doe")
        ));

    }

    @GetMapping("/students")
    public List <Student> getStudents() {
        return students;
    }
    @GetMapping("/students/{student_id}")
    public Student getStudent(@PathVariable int student_id) {
        return students.get(student_id);
    }
}
