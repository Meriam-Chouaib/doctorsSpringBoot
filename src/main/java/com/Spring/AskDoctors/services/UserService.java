package com.Spring.AskDoctors.services;

import com.Spring.AskDoctors.Exception.ResourceNotFoundException;
import com.Spring.AskDoctors.helper.ApiResponse;
import com.Spring.AskDoctors.springJWT.models.User;
import com.Spring.AskDoctors.springJWT.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    private static List<User> users = new ArrayList<>();

    /*********  Add user  **********/

    public ApiResponse saveUser(User user) {
        user.setAdmin(false);
        if (user.getName() == null || user.getUsername() == null || user.getPassword() == null || user.getPicture() == null ) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "", 1, "Enter the values please!!");
        }
        return new ApiResponse(HttpStatus.OK.value(), userRepo.save(user), null, "User Added successfully!!");

    }

    /*********  get the list of users  **********/

    public ApiResponse getAll() {
        if (!userRepo.findAll().isEmpty())
            return new ApiResponse(HttpStatus.OK.value(), userRepo.findAll(), null, "List of users success!");

        else {

            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), userRepo.findAll(), 1, "oops cannot get the users!");
        }
    }

        /*****************  get user by id ***************/


    public ApiResponse getUser(Long id) {
        User user = userRepo.findAll().stream()
                .filter(t -> id == (t.getId()))
                .findFirst()
                .orElse(null);
                if (user != null) {
                    return new ApiResponse(HttpStatus.OK.value(), user, null, "the user number "+id+" is available!");
        
                } else return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "There is no user with this id!");
        
    }


            /*****************  AuthUser ***************/


            public String authUser(String username) {
            
                  User user = userRepo.findAll().stream()
                  .filter(t -> username == (t.getUsername()))
                  .findFirst()
                  .orElse(null);
                        return username +"from list" +user.getUsername();
                        
                       // if (user != null) {
                        //    return user;

                          //  return new ApiResponse(HttpStatus.OK.value(), user, null, "the username "+username+" is connected!");

                       // } else return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "There is no user with this id!");

                //    } else return null;

            }
        /*****************  Update user ***************/


    public ApiResponse updateUser(Long id, User userDetails) throws ResourceNotFoundException {

        User user = (User)getUser(id).getData();
  
        if (this.getUser(id).getData() == null) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "There is no user with this id!");
        } else if (userDetails.getName()== null || userDetails.getUsername() == null|| userDetails.getDescription() == null || user.getPicture() == null ) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "Enter the values please!");
        } else {
            user.setName(userDetails.getName());
            user.setUsername(userDetails.getUsername());
            user.setDescription(userDetails.getDescription());
            user.setPicture(userDetails.getPicture());
            
            return new ApiResponse(HttpStatus.OK.value(), saveUser(user).getData(), null, "The user number "+id+" updated successfully :D");
        }
    }
    
     /*****************  delete user ***************/

    public ApiResponse deleteById(Long id) throws ResourceNotFoundException {

        User user = (User) this.getUser(id).getData();
        if (user != null) {
            userRepo.deleteById(id);
            return new ApiResponse(HttpStatus.OK.value(), this.getAll().getData(), null, "the article number " + id + " deleted successfully!");
        } else {
            return new ApiResponse(HttpStatus.FOUND.value(), user, 1, "Failed to delete the article number " + id);

        }

      


    }

 
    public ApiResponse getAllDoctors () throws Exception {
        List<User> doctors = new ArrayList<>();

     
     for (User user : userRepo.findAll()) {
       if(user.getSpeciality()!=null){
        doctors.add(user);
       }
    }
     
        if (!doctors.isEmpty())
            return new ApiResponse(HttpStatus.OK.value(), doctors, null, "List of Doctors success!");

        else {

            return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, 1, "oops cannot get the users!");
        }
    }
}
