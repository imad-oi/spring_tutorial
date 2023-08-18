package com.luv2code.restcrud.rest;

import com.luv2code.restcrud.entity.Student;
import com.luv2code.restcrud.exception.StudentNotFoundException;
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
    public List<Student> loadStudents() {
        students = new ArrayList<>();

        students.add(new Student("imad", "oissafe"));
        students.add(new Student("amine", "oissafe"));
        students.add(new Student("ayoub", "oissafe"));

        return students;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students /{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        // check the studentId against the list size

        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id  not found - " + studentId);
        }

        return students.get(studentId);
    }

}
