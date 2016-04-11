package com.auth.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.auth.controller.registration.RegistrationController;
import com.auth.controller.resource.IndexResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class IndexController {


    @RequestMapping("/index")
    public HttpEntity<IndexResource> index() {

        IndexResource index = new IndexResource("welcome");
        index.add(linkTo(methodOn(IndexController.class).index()).withSelfRel());
        index.add(linkTo(methodOn(RegistrationController.class).registerForm()).withRel("register"));
        return new ResponseEntity<IndexResource>(index, HttpStatus.OK);
    }
}