package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.Post;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.services.PostService;
import com.Spring.AskDoctors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/posts/")
public class PostController {

  @Autowired
 private PostService postService;

    @PostMapping("save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
    }

   @GetMapping("list")
   public ResponseEntity<List<Post>> getAll() {
       return new ResponseEntity<List<Post>>(postService.getAll(), HttpStatus.OK);
   }
//
//
//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById(@PathVariable int id) {
//        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
//
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id,
//                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
//
//        return new ResponseEntity<User>( userService.updateUser(id,userDetails), HttpStatus.OK);
//    }
}
