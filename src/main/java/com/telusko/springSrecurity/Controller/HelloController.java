package com.telusko.springSrecurity.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {



    @GetMapping("/")
    public String boost(HttpServletRequest request){ // Request is used to get the session id
        return "Hi Vaibhav Shinde " + request.getSession().getId(); // this will return the session id
    }
}
