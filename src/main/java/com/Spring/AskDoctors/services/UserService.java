package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

//    public UserServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }
    

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getUser(int id) {
        User user = userRepo.findAll().stream()
                .filter(t -> id==(t.get_id()))
                .findFirst()
                .orElse(null);
        return user;
    }

}
