package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {

        return new ResponseEntity<User>(userService.updateUser(id, userDetails), HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {

            User user = userService.getUser(id);
            userService.deleteById(id);


    }


    }


