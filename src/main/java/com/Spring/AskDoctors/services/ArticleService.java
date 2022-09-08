package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.entity.Article;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.ArticleRepository;
import com.Spring.AskDoctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Spring.AskDoctors.Exception.ResourceNotFoundException;


import java.util.List;
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepo;
    public Article  saveArticle(Article article) {

        return articleRepo.save(article);
    }

    public List<Article> getAll() {
        return articleRepo.findAll();
    }

    public Article getArticle(int id) {
        Article article = articleRepo.findAll().stream()
                .filter(t -> id==(t.getId()))
                .findFirst()
                .orElse(null);
        return article;
    }

    public Article updateArticle(int id, Article articleDetails) throws ResourceNotFoundException {

        Article article = getArticle(id);


        article.setTitle(articleDetails.getTitle());
        article.setMessage(articleDetails.getMessage());
        article.setPicture(articleDetails.getPicture());


        final Article updateArticle = saveArticle(article);
        return updateArticle;
    }
    public void deleteById(int id)throws ResourceNotFoundException{
        articleRepo.deleteById(id);
    }


}
