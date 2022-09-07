package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.entity.Article;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.ArticleRepository;
import com.Spring.AskDoctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
