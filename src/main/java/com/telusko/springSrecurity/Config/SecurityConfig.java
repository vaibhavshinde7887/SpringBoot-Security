package com.telusko.springSrecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // This is a configuration file for Spring Security Where we can define the rules for the security
@EnableWebSecurity // This is used to enable the web security , dont go with the default security go with the which i have defined here

public class SecurityConfig {



    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()). // This is used to disable the csrf token

                authorizeHttpRequests(request -> request.anyRequest().authenticated()). // This is used to authorize the request no on can access the data without the authentication token
                httpBasic(Customizer.withDefaults()). // This is used to enable the basic authentication and give form login implementation for postman
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build(); // it is used to create the session
        // and it is stateless
        // for all the methods here we have to use the lambda expression
        // for all the methods here you have to implement sartan interface and  define the method and pass the object here


        // Why Do We Use Spring Security Configuration?
        //Spring Security Configuration is used to customize authentication and authorization in a Spring Boot application.
        // By default, Spring Security applies basic authentication with a generated password,
        // but real-world applications need more control.

    }

//    @Bean
//    public UserDetailsService userDetailsService() { // This method is use for create the user and store the user in the database manually
//        UserDetails user1 = User // This is used to create the user
//                .withDefaultPasswordEncoder() // This is used to encode the password in the default format no one can see the password
//                .username("kiran")
//                .password("k@123")
//                .roles("USER") // this is optional you can define the role of the user
//                .build(); // This is used to build the user
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("harsh")
//                .password("h@123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2); // This is used to store the user in the memory/ database
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // This is used to create the authentication provider using the DaoAuthenticationProvider
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // This is used to encode the password in the default format no one can see the password
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); // This is used to encode the password in the BCrypt format no one can see the password
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }
}
