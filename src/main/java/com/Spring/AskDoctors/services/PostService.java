package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.entity.Post;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.PostRepository;
import com.Spring.AskDoctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;
    public Post  savePost(Post post) {

        return postRepo.save(post);
    }

    public List<Post> getAll() {
        return postRepo.findAll();
    }


}
