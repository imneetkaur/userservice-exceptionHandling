package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveNewUser(@RequestBody User user) throws UserAlreadyExistsException,UserNotFoundException {
        ResponseEntity responseEntity = null;
        userService.addNewUser(user);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<User>>((List<User>) userService.getAllUsers(), HttpStatus.FOUND);
        return responseEntity;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") int id) throws UserNotFoundException {
        ResponseEntity responseEntity;

        User user = userService.findUserById(id);
        responseEntity = new ResponseEntity<User>(user, HttpStatus.FOUND);
        return responseEntity;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        userService.deleteUserById(id);
        return responseEntity;
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteAllUsers() {
        ResponseEntity responseEntity;
        userService.deleteAllUsers();
        responseEntity = new ResponseEntity("Successfully Deleted all Users", HttpStatus.GONE);
        return responseEntity;
    }
}
