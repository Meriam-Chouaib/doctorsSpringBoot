package com.Spring.AskDoctors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name="user")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
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
}