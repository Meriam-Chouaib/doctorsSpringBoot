package com.Spring.AskDoctors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.Spring.AskDoctors.entity.User;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="article")
@Entity
public class Article implements Serializable{

    @Column(name="id_article")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }



    @Column(name="title_article")

    private String title;

    @Column(name="message_article")

    private String message;

    @Column(name="date_article")

    private Date date;

    @Column(name="picture_article")
    private String picture;


    @Column(name="liked_article")

    private Boolean liked;

    @Column(name="disliked_article")

    private Boolean disliked;
    @Column(name="likes_article")

    private int likes;

    @Column(name="dislikes_article")
    private int dislikes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_article", referencedColumnName = "id_user", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore*/

    @ManyToOne
    //(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    //@JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public User user;

 
    public User getUser() {
        return user;
    }


    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean isLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Boolean isDisliked() {
        return disliked;
    }

    public void setDisliked(Boolean disliked) {
        this.disliked = disliked;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }


}
