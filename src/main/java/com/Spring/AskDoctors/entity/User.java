package com.Spring.AskDoctors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.HashSet;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.Spring.AskDoctors.springJWT.models.Role;


//@Table(name="user")
@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "name") 
    })
public class User {

    @Column(name="id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
          joinColumns = @JoinColumn(name = "id_user"), 
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
     
  
    public User(String username, String name, String password) {
      this.username = username;
      this.name = name;
      this.password = password;
    }

    @Column(name="name_user")
    private String name;

    @NotBlank
    @Column(name="username_user")
    private String username;

    @Column(name="password_user")
    @NotBlank
    private String password;

    @Column(name="speciality_user")

    private String speciality;
    @Column(name="description_user")

    private String description;

    @Column(name="isLogged_user")
    private Boolean isLogged;
    @Column(name="isAdmin_user")

    private Boolean isAdmin;

    @Column(name="isTest_user")
    private Boolean isTest;
    @Column(name="picture_user")
    private String picture;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isLogged() {
        return isLogged;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public Boolean isTest() {
        return isTest;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<Role> getRoles() {
        return roles;
      }
    
      public void setRoles(Set<Role> roles) {
        this.roles = roles;
      }
}