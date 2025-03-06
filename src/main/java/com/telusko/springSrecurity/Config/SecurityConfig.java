package com.telusko.springSrecurity.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // This is a configuration file for Spring Security Where we can define the rules for the security
@EnableWebSecurity // This is used to enable the web security , dont go with the default security go with the which i have defined here

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()). // This is used to disable the csrf token

                authorizeHttpRequests(request -> request.anyRequest().authenticated()). // This is used to authorize the request no one
                                                                                       // can access the data without the authentication token
                 httpBasic(Customizer.withDefaults()). // This is used to enable the basic authentication and
                                                       // give form login implementation for postman
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build(); // it is used to create the session
                                                                                                                        // and it is stateless
       // for all the methods here we have to use the lambda expression
       // for all the methods here you have to implement sartan interface and  define the method and pass the object here


        // Why Do We Use Spring Security Configuration?
        //Spring Security Configuration is used to customize authentication and authorization in a Spring Boot application.
        // By default, Spring Security applies basic authentication with a generated password,
        // but real-world applications need more control.

    }
}
