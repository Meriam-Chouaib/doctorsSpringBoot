package com.Spring.AskDoctors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.AskDoctors.entity.User;
import com.Spring.AskDoctors.repository.UserRepository;

@Service("userDetailsService")
public class userDetailsService implements UserDetailsService {
    public userDetailsService(){
        
    }

    @Autowired
    private UserRepository usersRepository;

    @Transactional(readOnly = true)
  /*  @Override
    public UserDetails loadUserByUsername(int id) throws UsernameNotFoundException {
        User user = usersRepository.findAll().stream()
        .filter(t -> id == (t.getId()))
        .findFirst()
        .orElse(null);
       return (UserDetails) user;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

}