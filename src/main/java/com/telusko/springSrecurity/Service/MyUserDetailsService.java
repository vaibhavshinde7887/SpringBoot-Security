package com.telusko.springSrecurity.Service;

import com.telusko.springSrecurity.Model.UserPrincipal;
import com.telusko.springSrecurity.Model.Users;
import com.telusko.springSrecurity.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{ // we use this for authentication and authorization of the user in the application from the database
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // This method is used to load the user by the username and if the user is not found then it will throw the exception
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found"); // This is used to throw the exception if the user is not found
        }

        return new UserPrincipal(user);// This is used to return the user principal object
    }
}
