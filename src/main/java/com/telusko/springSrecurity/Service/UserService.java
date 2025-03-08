package com.telusko.springSrecurity.Service;


import com.telusko.springSrecurity.Model.Users;
import com.telusko.springSrecurity.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // This is used to encode the password of the user
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword())); // This is used to encode the password of the user
        repo.save(user);
        return user;
    }

    // if u want to check hoe encode and bcrypt password then u can go the website name is BCrypt password generator
}
