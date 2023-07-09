package com.example.EcommerceAPI.controllers;


import com.example.EcommerceAPI.models.User;
import com.example.EcommerceAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userObj=userService.createUser(user);
        return new ResponseEntity<>(userObj,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
        Optional<User> getUser=userService.getUserById(userId);
        return getUser.map(value->new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
