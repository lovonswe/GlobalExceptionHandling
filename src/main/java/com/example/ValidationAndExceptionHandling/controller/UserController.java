package com.example.ValidationAndExceptionHandling.controller;

import com.example.ValidationAndExceptionHandling.dto.UserRequest;
import com.example.ValidationAndExceptionHandling.entity.User;
import com.example.ValidationAndExceptionHandling.exception.UserNotFoundException;
import com.example.ValidationAndExceptionHandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        User user = service.saveUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>  getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = service.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
