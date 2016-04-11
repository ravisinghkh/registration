package com.auth.controller.registration;

import com.auth.controller.resource.UserResource;
import com.auth.domain.entity.User;
import com.auth.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ravink on 4/7/2016.
 */
@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public UserResource registerForm(){
        UserResource userResource = new UserResource();
        return userResource;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody UserResource userResource){
        User user = new User();
        user.setUsername(userResource.getUsername());
        user.setPassword(passwordEncoder.encode(userResource.getPassword()));
        userRepository.save(user);
        return new ResponseEntity("Registration Successful", HttpStatus.OK);
    }
}
