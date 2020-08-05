package com.example.demo;

import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    //public List<UsersResponse> getAllUser(
    public PagingResponse getAllUser(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name = "inter_per_page", defaultValue = "10") int itemPerPage) { //name is on the URL variable

        //monitoring
        System.out.println("page value: " + page);
        System.out.println("item_per_page value: " + itemPerPage);

        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);

        List<UsersResponse> usersResponsesList = new ArrayList<>();
        usersResponsesList.add(new UsersResponse(1, "User 1"));
        usersResponsesList.add(new UsersResponse(2, "User 2"));
        usersResponsesList.add(new UsersResponse(3, "User 3"));

        pagingResponse.setUsersResponse(usersResponsesList);

        return pagingResponse;
    }

    @GetMapping("/users/{id}") // { } is path variable --> get this value from typing url on browser.
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id, "User " + id);
    }
}
