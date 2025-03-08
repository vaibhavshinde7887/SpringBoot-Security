package com.telusko.springSrecurity.Controller;


import com.telusko.springSrecurity.Model.Users;
import com.telusko.springSrecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) { // This is used to register the user in the application and it will return the user object
        return service.register(user);

    }
}
