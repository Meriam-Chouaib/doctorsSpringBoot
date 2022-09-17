package com.Spring.AskDoctors.repository;

import com.Spring.AskDoctors.entity.User;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //void deleteAllUsers();
    
}