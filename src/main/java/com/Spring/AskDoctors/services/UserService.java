package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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

    public User updateUser(int id, User userDetails) throws
            ResourceNotFoundException {

            User user = getUser(id);


        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setDescription(userDetails.getDescription());
        user.setPicture(userDetails.getPicture());

        final User updatedUser = saveUser(user);
        return updatedUser;
    }
}
