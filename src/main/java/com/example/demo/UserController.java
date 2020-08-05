package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    // @GetMapping("/users")   //GET is HTTP GET method.
    /*
    public UsersResponse[] getAllUser(){    //add [ ] because we wanna return array.
        UsersResponse[] usersResponses = new UsersResponse[2];
        usersResponses[0] = new UsersResponse(1, "User 1");
        usersResponses[1] = new UsersResponse(2, "User 2");
        return usersResponses;
    }
     */

    @GetMapping("/users")   //GET is HTTP GET method.
    public List<UsersResponse> getAllUser(){
        List<UsersResponse> usersResponsesList = new ArrayList<>();
        usersResponsesList.add(new UsersResponse(1, "User 1"));
        usersResponsesList.add(new UsersResponse(2, "User 2"));
        usersResponsesList.add(new UsersResponse(3, "User 3"));
        return usersResponsesList;
    }

    @GetMapping("/users/{id}") // { } is path variable --> get this value from typing url on browser.
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id, "User " + id);
    }
}
