package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (student_id < 0 || student_id >= students.size()) {
            throw new StudentNotFoundException(String.format("Student with id %d not found", student_id));
        }
        return students.get(student_id);
    }

    // add an exception handler user @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity <StudentErrorResponse> handleException(StudentNotFoundException e) {

        // create a StudentErrorResponse

        StudentErrorResponse response = new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // add another exception handler... ot catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity <StudentErrorResponse> handleException(Exception e) {
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}













