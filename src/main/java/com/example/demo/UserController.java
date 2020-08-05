package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

    @PostMapping("/users")
    public UsersResponse createNewUser(@RequestBody NewUserRequest request){
        //Validate input
        //Create new user into database => Repository (Responsibility)
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        //return new UsersResponse(0, request.getName() + request.getAge());
        return new UsersResponse(user.getId(), user.getName() + user.getAge());
    }

}
