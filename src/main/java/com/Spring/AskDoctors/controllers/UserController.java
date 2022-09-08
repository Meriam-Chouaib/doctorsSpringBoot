package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.helper.ApiResponse;
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

    /**************** Add user  **************/

    @PostMapping("save")
    public ApiResponse saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**************** Get the list of users  **************/

    @GetMapping("list")
    public ApiResponse getAll() {
        return userService.getAll();
    }

        /*****************  get user by id ***************/


    @GetMapping("{id}")
    public ApiResponse getUserById(@PathVariable int id) {
        return userService.getUser(id);

    }
        /*****************  Update user ***************/

    @PutMapping("{id}")
    public ApiResponse updateUser(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {

        return userService.updateUser(id, userDetails);
    }

     /*****************  delete user ***************/


    @GetMapping("delete/{id}")
    public ApiResponse deleteUser(@PathVariable("id") int id) {

      return  userService.deleteById(id);


    }


}


