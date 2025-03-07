package com.telusko.springSrecurity.Controller;


import com.telusko.springSrecurity.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>( // adding the students to the list manually
            List.of(
                    new Student(1, "Navin", 60),
                    new Student(2, "Kiran", 65)
            ));


    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) { // Request is used to get the session id/ csrf token
        return (CsrfToken) request.getAttribute("_csrf");


    }

//
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }


    //This is Like You Generate a Token and then you can use that token to access the data
}
