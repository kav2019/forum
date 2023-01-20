package com.kovhov.forum.forum.model.Posts;

import com.kovhov.forum.forum.model.User.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class Post {

    public Post() {
    }

    public Post(long id, String title, String textPost, Date dateCreate, String author) {
        this.id = id;
        this.title = title;
        this.textPost = textPost;
        this.dateCreate = dateCreate;
        this.author = author;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;
//    private TextPost textPost;

    @Column(name = "textpost")
    private String textPost;

    @Column(name = "datecreate")
    private Date dateCreate;

    @Column(name = "author")
    private String author;

    public String displatenDate(){
        return new SimpleDateFormat("dd-MM-yyyy").format(dateCreate);
    }

    public String returnTitleToDisplay(){
        return author + " " + displatenDate();
    }
}
