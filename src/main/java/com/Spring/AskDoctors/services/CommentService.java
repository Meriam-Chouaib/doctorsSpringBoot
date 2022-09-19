package com.Spring.AskDoctors.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Spring.AskDoctors.entity.Article;
import com.Spring.AskDoctors.entity.Comment;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.helper.ApiResponse;
import com.Spring.AskDoctors.repository.CommentRepository;
import java.time.LocalDate;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;
    
    public  ApiResponse AddCommentToArticle(int idArticle,int idUser,String subject) {

        Article article = (Article) articleService.getArticle(idArticle).getData();
        User user = (User) userService.deleteById(idUser).getData();
        List<Comment> comments = article.getComments();

        Comment comment = new Comment();
        //comment.setId_user(idUser);
      
       // comment.setId_article(idArticle);
        comment.setSubject(subject);
        LocalDate date =  LocalDate.now();
        comment.setDate(date);
        comments.add(comment);
        article.setComments(comments);

       // commentRepo.save(comment);
        
        return new ApiResponse(HttpStatus.OK.value(),article, 0, "the comment added successfully");

      /*  if(article != null && user != null){
      
        if (comment.getSubject() == null ) {
            //throw new ApiRequestException("Enter the values please!!");
            return new ApiResponse(HttpStatus.OK.value(),"", 1, "Enter the values please!!");
        }
        return new ApiResponse(HttpStatus.OK.value(), commentRepo.save(comment), null, "comment Added successfully!!");
      
    }else{
        return new ApiResponse(HttpStatus.OK.value(), "", null, "Check the user and the post if exists!!");
    }*/
    }

     /*********  get the list of articles  **********/

     public ApiResponse getAll() {
        if (!commentRepo.findAll().isEmpty())
            return new ApiResponse(HttpStatus.OK.value(), commentRepo.findAll(), null, "List of articles success!");

        else {

            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), commentRepo.findAll(), 1, "oops cannot get the articles!");
        }


    }
    
}