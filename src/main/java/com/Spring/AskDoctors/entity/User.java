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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    private String name;
    private String username;
    private String password;
    private String speciality;
    private String description;
    private boolean isLogged;
    private boolean isAdmin;
    private boolean isTest;

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

    public int get_id() {
        return _id;
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
}