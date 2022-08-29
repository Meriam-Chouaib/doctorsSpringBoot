package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }


@GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
     return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);

    }



}
