package com.Spring.AskDoctors.controllers;

import com.Spring.AskDoctors.Exception.ApiRequestException;
import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.Article;
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

    @PostMapping("save")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
       
        if(article.getMessage()==null || article.getTitle()==null ){
            throw new ApiRequestException("Enter the values please!");
        } 
        else
       return new ResponseEntity<Article>(articleService.saveArticle(article), HttpStatus.CREATED);
    
    }

   @GetMapping("list")
   public ResponseEntity<List<Article>> getAll() {
    if(articleService.getAll()==null){
        throw new ApiRequestException("oops cannot get all articles!");
    }
    else if (articleService.getAll().isEmpty()){
        throw new ApiRequestException("The list is empty!");

    }
    else{
        return new ResponseEntity<List<Article>>(articleService.getAll(), HttpStatus.OK);
    }
    

   }

    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        if(articleService.getArticle(id)==null){
            throw new ApiRequestException("There is no user with this id!");

        }
        else return new ResponseEntity<Article>(articleService.getArticle(id), HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") int id,
                                           @Valid @RequestBody Article articleDetails) throws ResourceNotFoundException {

        if(articleDetails.getMessage()==null || articleDetails.getTitle()==null ){
            throw new ApiRequestException("Enter the values please!");
        } else if(articleService.getArticle(id) == null){
            throw new ApiRequestException("This user not found in the list!");
        }

        else return new ResponseEntity<Article>( articleService.updateArticle(id,articleDetails), HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<List<Article>> deleteArticle(@PathVariable("id") int id) {
        Article article = articleService.getArticle(id);
        if(article == null){
            throw new ApiRequestException("This user not found in the list!");
        }

        else {articleService.deleteById(id);
            return new ResponseEntity<List<Article>>(articleService.getAll(), HttpStatus.OK);
        }
         
    }

}
