package com.luv2code.restcrud.rest;

import com.luv2code.restcrud.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(exp.getMessage());
        error.setStutus(HttpStatus.NOT_FOUND.value());
        error.setTimestap(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // handle another exception to catch all
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(exp.getMessage());
        error.setStutus(HttpStatus.BAD_REQUEST.value());
        error.setTimestap(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
