package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

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
