package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")   //GET is HTTP GET method.
    public UsersResponse[] getAllUser(){    //add [ ] because we wanna return array.
        UsersResponse[] usersResponses = new UsersResponse[2];
        usersResponses[0] = new UsersResponse();
        usersResponses[1] = new UsersResponse();
        return usersResponses;
    }
}
