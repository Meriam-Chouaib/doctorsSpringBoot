package com.Spring.AskDoctors.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Spring.AskDoctors.entity.Article;
import com.Spring.AskDoctors.entity.Comment;
import com.Spring.AskDoctors.helper.ApiResponse;
import com.Spring.AskDoctors.services.CommentService;

@RestController
@RequestMapping("/api/comments/{idUser}/article/{idArticle}/")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping("save")
    public ApiResponse AddComm(@PathVariable("idArticle") int idArticle,@PathVariable("idUser") int idUser,@Valid @RequestBody String subject) { 
         
       return commentService.AddCommentToArticle(idArticle,idUser,subject);
       
    }

     /**** get all Comments ****/
   @GetMapping("list")
   public ApiResponse getAll() {
        return commentService.getAll();
   }

    @GetMapping("hello")
    public String helloworld(@RequestBody String name,@PathVariable("idArticle") int idArticle, @PathVariable("idUser") int idUser) {
        return "hello"+name+"user:"+idUser+"idArticle: "+idArticle;
    }
}