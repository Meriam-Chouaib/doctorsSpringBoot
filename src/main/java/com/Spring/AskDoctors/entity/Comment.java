package com.Spring.AskDoctors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="comment")
@Entity

public class Comment {
    @Column(name="id_comment")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name="subject_comment")
    private String subject;

    @Column(name="date_comment")
    private Date date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

 
    public int getId() {
        return id;
    }



  /*
       public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_comment", referencedColumnName = "id_article", insertable = false, updatable = false)

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Article article;*/

}
