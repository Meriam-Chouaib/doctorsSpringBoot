package com.Spring.AskDoctors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Column(name="id_user")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name_user")
    private String name;

    @Column(name="username_user")
    private String username;

    @Column(name="password_user")

    private String password;

    @Column(name="speciality_user")

    private String speciality;
    @Column(name="description_user")

    private String description;

    @Column(name="isLogged_user")
    private boolean isLogged;
    @Column(name="isAdmin_user")

    private boolean isAdmin;

    @Column(name="isTest_user")
    private boolean isTest;
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

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setTest(boolean test) {
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

    public boolean isLogged() {
        return isLogged;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isTest() {
        return isTest;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}