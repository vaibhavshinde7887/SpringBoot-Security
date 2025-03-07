package com.telusko.springSrecurity.Repo;


import com.telusko.springSrecurity.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username); // This is used to find the user by the username



    // how it work ?
    // For security user for database
    //First we add dependency like data GPA and connect to the Postgres database
    // then we have configure the security configuration
    //By default it will using same authentication provider we are seeing let me provide the custom authentication provider Which is the Dow authentication provider
    // for this we have passed password encoder and set user detail service our own user detail service
    // then we have to create the user detail service which will be used to authenticate the user and implement the user detail interface to get the user details
    //Then we have to create our own service class and this say ok you just have to implement one method which is load user by user name and add dependency injections
    // for that we have add Prince user principal model in that model we have implement user name password and other things
    // then we have to create the user model and then we have to create the user repository

}
