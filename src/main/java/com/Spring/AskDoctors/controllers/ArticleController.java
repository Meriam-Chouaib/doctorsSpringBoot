package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.Exception.ApiRequestException;
import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.Article;
import com.Spring.AskDoctors.helper.ApiResponse;
import com.Spring.AskDoctors.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/articles/")
public class ArticleController {

  @Autowired
 private ArticleService articleService;

 //**** Add Article ****/

    @PostMapping("save")
    public ApiResponse saveArticle(@RequestBody Article article) { 
       return articleService.saveArticle(article);
    }
 /**** get all Articles ****/
   @GetMapping("list")
   public ApiResponse getAll() {
        return articleService.getAll();
   }

    /**** Delete Article ****/
   @GetMapping("delete/{id}")
   public ApiResponse deleteArticle(@PathVariable("id") int id) {
      return articleService.deleteById(id);
   }

   /***** Get article by id ******/

    @GetMapping("{id}")
    public ApiResponse getArticleById(@PathVariable int id) {
       return articleService.getArticle(id);
    }

    /****** Update Article *****/
    @PutMapping("update/{id}")
    public ApiResponse updateArticle(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody Article articleDetails) throws ResourceNotFoundException {
        return articleService.updateArticle(id,articleDetails);
      
    }



}
